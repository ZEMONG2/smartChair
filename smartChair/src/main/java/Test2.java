

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
      if(request.getParameter("sensor") != null){
      s =request.getParameter("sensor");
      }
      System.out.println(s);
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      
//      sensor = request.getParameter("sensor");
      if(s.equals("N")){
      res = "{\"sensor\":"+2+"}";
      }else if(s.equals("LC")) {
    	  res = "{\"sensor\":"+3+"}";
      }else  {
       	  res = "{\"sensor\":"+3+"}";
      }
      out.print(res);
      
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