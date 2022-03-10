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
 * Servlet implementation class Upbutton
 */
@WebServlet("/Upbutton")
public class Upbutton extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
    */
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("utf-8");
      response.getWriter().append("Served at: ").append(request.getContextPath());
      HttpSession session = request.getSession();
      tb_userVO vo = (tb_userVO)session.getAttribute("loginVO");
      System.out.println("가져온 세션값 : " +vo.getAdmin_yesno());
      
       PrintWriter out = response.getWriter();
	      String res = "1";
	      tb_heightVO vo2 = new tb_heightVO();
	      vo2.setRes(res);
	      System.out.println("res값 : " +res );
	      response.sendRedirect("Test2?res="+res+"");
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      
   }


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      doGet(request, response);
   }

}