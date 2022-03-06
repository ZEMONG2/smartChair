package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.tb_poseDAO;
import vo.tb_poseVO;

/**
 * Servlet implementation class ArduinoCon
 */
@WebServlet("/ArduinoCon")

public class ArduinoCon extends HttpServlet {
    tb_poseVO vo = new tb_poseVO();
    tb_poseDAO dao = new tb_poseDAO();
    String a;
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		a ="0";
		vo.setPose_type(a); 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		response.getWriter().append("Served at: ").append(request.getContextPath());//웹 연결
	      String s =request.getParameter("sensor"); //센서 값 받아오기 
	      System.out.println("현재 받아온 값 : "+s);
	      if(!s.equals("0")) {
	    	  if(vo.getPose_type().equals(s)) {
	    		  System.out.println("앉기 시작");
	    		  vo.setPose_type(s);
	    		  vo.setPose_start_dt(null);
	    	  }else {
	    		  vo.setPose_end_dt(null);
	    		  dao.date(값넣기);
	    		 
	    		  
	    	  }
	      }
	      
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		doGet(request, response);
	}

}
