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
		String sess_pw = vo.getUser_pw();
		String user_pw1 = request.getParameter("user_pw1");
		String user_pw2 = request.getParameter("user_pw2");
		String user_pw = request.getParameter("user_pw");
		String user_nick = request.getParameter("user_nick");
		System.out.println("가져온 닉네임 : "+user_nick);
		String sess_nick = vo.getUser_nick();
		String user_name = vo.getUser_name();
		String user_tel = request.getParameter("user_tel");
		String user_gender = vo.getUser_gender();
		String user_birthday = vo.getUser_birthday();
		Date user_joindate = vo.getUser_joindate();
		String admin_yesno = vo.getAdmin_yesno();
		
	if(user_pw.equals(sess_pw) && user_pw1.equals(user_pw2)) {
		
		System.out.println("세션에 저장된 현비밀번호 : " +sess_pw);
		System.out.println("입력한 현재비밀번호 : " +user_pw);
		tb_userDAO dao = new tb_userDAO();
		int cnt = dao.modify(user_id, user_pw1, user_tel, user_nick, sess_nick);
		
		if(cnt>0) {
			System.out.println("회원정보수정 성공");
			vo = new tb_userVO(user_id, user_pw1, user_name, user_nick, user_tel, user_gender, user_birthday, user_joindate, admin_yesno);
			session.setAttribute("loginVO", vo);
			response.sendRedirect("modifyS.jsp");
			
			System.out.println("변경할 닉네임 : "+user_nick);
			System.out.println("변경할 비밀번호 : "+user_pw1);
		}else {
			System.out.println("회원정보수정 실패");
			response.sendRedirect("modifyF.jsp");
		}
	}else {
		System.out.println("회원정보수정 실패");
		response.sendRedirect("modifyF.jsp");
	}
		
	}

}
