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


@WebServlet("/DeleteArticleCon")
public class DeleteArticleCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		tb_userVO vo = (tb_userVO)session.getAttribute("loginVO");
		String article_seq = request.getParameter("article_seq");
		int articleSEQ = Integer.parseInt(article_seq);
		String sess_id = vo.getUser_id();
		
		tb_communityDAO dao = new tb_communityDAO();
		int cnt = dao.deleteArticle(articleSEQ);
		
		if(cnt>0) {
			System.out.println("게시글 삭제 성공");
			response.sendRedirect("deleteArticleS.jsp");
		}else {
			System.out.println("게시글 삭제 실패");
			response.sendRedirect("deleteArticleF.jsp");
		}
	}

}
