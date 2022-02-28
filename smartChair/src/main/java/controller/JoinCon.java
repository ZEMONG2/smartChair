package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.tb_userDAO;

@WebServlet("/JoinCon")
public class JoinCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_name = request.getParameter("user_name");
		String user_nick = request.getParameter("user_nick");
		String user_tel = request.getParameter("user_tel");
		String user_gender = request.getParameter("gender");
		String user_birthday = request.getParameter("user_birthday");
		System.out.println(user_tel);
		System.out.println(user_gender);
		System.out.println(user_birthday);
		tb_userDAO dao = new tb_userDAO();
		int cnt = dao.join(user_id, user_pw, user_name, user_nick, user_tel, user_gender, user_birthday);
		
		if (cnt > 0) {
			System.out.println("회원가입 성공");
			response.sendRedirect("login.jsp");
		}else {
			System.out.println("회원가입 실패");
			response.sendRedirect("register.html");
		}
	}


}
