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
		String user_pw1 = request.getParameter("user_pw1");
		String user_pw = request.getParameter("user_pw");
		String user_name = vo.getUser_name();
		String user_nick = vo.getUser_nick();
		String user_tel = request.getParameter("user_tel");
		String user_gender = vo.getUser_gender();
		String user_birthday = vo.getUser_birthday();
		Date user_joindate = vo.getUser_joindate();
		String admin_yesno = vo.getAdmin_yesno();
		
		tb_userDAO dao = new tb_userDAO();
		int cnt = dao.modify(user_id, user_pw1, user_tel);
		
		if(cnt>0) {
			System.out.println("회원정보수정 성공");
			vo = new tb_userVO(user_id, user_pw1, user_name, user_nick, user_tel, user_gender, user_birthday, user_joindate, admin_yesno);
			session.setAttribute("loginVO", vo);
			response.sendRedirect("index.jsp");
			System.out.println(user_pw);
			System.out.println(user_pw1);
		}else {
			System.out.println("회원정보수정 실패");
			response.sendRedirect("modify.jsp");
		}
		
		
	}

}
