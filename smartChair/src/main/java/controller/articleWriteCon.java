package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.tb_communityDAO;
import vo.tb_userVO;


@WebServlet("/articleWriteCon")
public class articleWriteCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		tb_userVO vo = (tb_userVO)session.getAttribute("loginVO");
		
		String user_id = vo.getUser_id(); 
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String file = request.getParameter("file");
		
		System.out.println(file);
		tb_communityDAO dao = new tb_communityDAO();
		int cnt = dao.inputCommunity(title, content, file, user_id);
			
		
		if(cnt>0) {
			System.out.println("게시물 작성 성공");
			
			response.sendRedirect("list.jsp");
		}
		
		
		
		
	}

}
