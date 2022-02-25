package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.tb_userDAO;
import vo.tb_userVO;


@WebServlet("/ModifyCon")
public class ModifyCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		tb_userVO vo = (tb_userVO)session.getAttribute("loginVO");
	
		String user_id = vo.getUser_id();
		String user_pw = request.getParameter("user_pw");
		String user_name = request.getParameter("user_name");
		String user_nick = request.getParameter("user_nick");
		
		tb_userDAO dao = new tb_userDAO();
		int cnt = dao.modify(user_id, user_pw, user_name, user_nick);
		
		if(cnt>0) {
			System.out.println("회원정보수정 성공");
			response.sendRedirect("index.jsp");
		}else {
			System.out.println("회원정보수정 실패");
			response.sendRedirect("modify.html");
		}
		
		
	}

}
