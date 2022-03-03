package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.tb_poseVO;

/**
 * Servlet implementation class ArduinoCon
 */
@WebServlet("/ArduinoCon")

public class ArduinoCon extends HttpServlet {
    tb_poseVO vo = new tb_poseVO();
    String a;
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		a ="a";
		vo.setPose_type(a); 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	      String s =request.getParameter("sensor");
	      System.out.println(s);
	      vo.setPose_type(s);
	      
	      if(a.equals(0)&&vo.getPose_type().equals(s))
	      
	      vo.setPose_start_dt(null);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		doGet(request, response);
	}

}
