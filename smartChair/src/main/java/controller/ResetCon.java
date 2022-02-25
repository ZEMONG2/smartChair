package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.tb_userDAO;


@WebServlet("/ResetCon")
public class ResetCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String user_pw = request.getParameter("user_pw");
		tb_userDAO dao = new tb_userDAO();
		int cnt = dao.reset(user_id,user_name,user_pw);
		
		if(cnt>0) {
			System.out.println("재설정 성공");
			response.sendRedirect("login.html");
		}else {
			System.out.println("재설정 실패");
			response.sendRedirect("login.html");
		}
		
		
	}

}
