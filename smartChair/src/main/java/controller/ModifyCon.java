package controller;

import java.io.IOException;
import java.util.Date;

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
		Date user_joindate = vo.getUser_joindate();
		String admin_yesno = vo.getAdmin_yesno();
		
		tb_userDAO dao = new tb_userDAO();
		int cnt = dao.modify(user_id, user_pw, user_name, user_nick, admin_yesno);
		
		if(cnt>0) {
			System.out.println("회원정보수정 성공");
			vo = new tb_userVO(user_id, user_name, user_nick, user_joindate);
			session.setAttribute("loginVO", vo);
			response.sendRedirect("index.jsp");
		}else {
			System.out.println("회원정보수정 실패");
			response.sendRedirect("modify.html");
		}
		
		
	}

}
