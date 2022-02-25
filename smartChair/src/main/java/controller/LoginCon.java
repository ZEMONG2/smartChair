package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.tb_userDAO;
import vo.tb_userVO;


@WebServlet("/LoginCon")
public class LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		Cookie cookie = null;
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String id_remb = request.getParameter("id_remb");
		
		tb_userDAO dao = new tb_userDAO();
		tb_userVO vo = dao.login(user_id,user_pw);
		
		if(id_remb != null && id_remb.trim().equals("on")) {
			cookie = new Cookie("id", java.net.URLEncoder.encode(user_id));
			cookie.setMaxAge(60*60*24*30);
			response.addCookie(cookie);
		}else{
			cookie = new Cookie("id", null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		if(vo!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginVO", vo);
			
			System.out.println("로그인 성공");
			response.sendRedirect("index.jsp");
		}else {
			System.out.println("로그인 실패");
			response.sendRedirect("loginF.jsp");
		}
		
		
	}

}
