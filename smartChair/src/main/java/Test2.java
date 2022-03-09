

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.tb_heightVO;

/**
 * Servlet implementation class Test2
 */
@WebServlet("/Test2")
public class Test2 extends HttpServlet {
   private static final long serialVersionUID = 1L;
   String res="";
   String s = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
  
   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      response.setContentType("text/html; charset=UTF-8");
//      if(request.getParameter("sensor") != null){
//      s =request.getParameter("sensor");
//      }
      System.out.println(s);
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      tb_heightVO vo2 = new tb_heightVO();
      res = vo2.getRes();
//      sensor = request.getParameter("sensor");
      if(res.equals("0")){
      res = "{\"sensor\":"+0+"}";
      }else if(res.equals("1")) {
    	  res = "{\"sensor\":"+1+"}";
      }else if(res.equals("2")) {
       	  res = "{\"sensor\":"+2+"}";
      }else if(res.equals("3")) {
    	  res = "{\"sensor\":"+3+"}";
      }
      out.print(res);
      response.sendRedirect("buttons.jsp");
      
//      out.print("{\"led\":"+led+"}");
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}