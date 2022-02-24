package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.memberDAO;

@WebServlet("/ResetCon")
public class ResetCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		memberDAO dao = new memberDAO();
		int cnt = dao.reset(email,name,pw);
		
		if(cnt>0) {
			System.out.println("재설정 성공");
			response.sendRedirect("login.html");
		}else {
			System.out.println("재설정 실패");
			response.sendRedirect("login.html");
		}
		
		
	}

}
