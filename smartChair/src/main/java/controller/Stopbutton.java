package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.tb_heightVO;
import vo.tb_userVO;

/**
 * Servlet implementation class Stopbutton
 */
@WebServlet("/Stopbutton")
public class Stopbutton extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	      response.getWriter().append("Served at: ").append(request.getContextPath());
	      HttpSession session = request.getSession();
	      tb_userVO vo = (tb_userVO)session.getAttribute("loginVO");
	      System.out.println("가져온 세션값 : " +vo.getAdmin_yesno());
	      
	       PrintWriter out = response.getWriter();
		      String res = "3";
		      tb_heightVO vo2 = new tb_heightVO();
		      vo2.setRes(res);
		      System.out.println("res값 : " +res );
		      response.sendRedirect("Test2?res="+res+"");
	   }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
