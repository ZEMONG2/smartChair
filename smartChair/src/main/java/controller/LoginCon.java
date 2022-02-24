package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.memberDAO;
import vo.memberVO;


@WebServlet("/LoginCon")
public class LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		memberDAO dao = new memberDAO();
		memberVO vo = dao.login(email,pw);
		
		if(vo!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginVO", vo);
			
			System.out.println("로그인 성공");
			response.sendRedirect("index.jsp");
		}else {
			System.out.println("로그인 실패");
			response.sendRedirect("login.html");
		}
		
		
	}

}
