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

@WebServlet("/ModifyCon")
public class ModifyCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		memberVO vo = (memberVO)session.getAttribute("loginVO");
	
		String email = vo.getEmail();
		String nick = request.getParameter("nick");
		String pw = request.getParameter("pw");
		memberDAO dao = new memberDAO();
		int cnt = dao.reset(email,nick,pw);
		
		if(cnt>0) {
			System.out.println("회원정보수정 성공");
			response.sendRedirect("index.jsp");
		}else {
			System.out.println("회원정보수정 실패");
			response.sendRedirect("modify.html");
		}
		
		
	}

}
