package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.tb_commentDAO;

@WebServlet("/DeleteCommentCon")
public class DeleteCommentCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String comment_seq = request.getParameter("comment_seq");
		int commentSEQ = Integer.parseInt(comment_seq);
//		
//		tb_commentDAO dao2 = new tb_commentDAO();
//		String article_seq = dao2.selectArticle(commentSEQ);
//		
		tb_commentDAO dao = new tb_commentDAO();
		int cnt = dao.deleteComment(commentSEQ);
		
		
		if(cnt>0) {
			System.out.println("댓글 삭제 성공");
			response.sendRedirect("list.jsp");
			
		}
	}

}
