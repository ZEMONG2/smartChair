package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

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
    String s="";
    String product = "sc";
    long start_time;
    long end_time;
    Date date = new Date();	
    Calendar cal = Calendar.getInstance(); //추상클래스이므로 static method로 객체를 할당받는다.
    String date2 = Integer.toString(cal.get(Calendar.YEAR))+Integer.toString(cal.get(Calendar.MONTH))+Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
	int cnt = 0;
	 String res="";
//	   String s = "";
	  
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		a ="0";
//		vo.setPose_type(a); 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		   response.setContentType("text/html; charset=UTF-8");
//		      if(request.getParameter("sensor") != null){
//		      s =request.getParameter("sensor");
//		      }
//		      System.out.println(s);
//		      response.setCharacterEncoding("UTF-8");
//		      PrintWriter out = response.getWriter();
//		      
//		      sensor = request.getParameter("sensor");
//		      if(s.equals("N")){
//		      res = s;
//		      }else if(s.equals("LC")) {
//		    	  res = "{\"sensor\":"+3+"}";
//		      }else  {
//		       	  res = "{\"sensor\":"+3+"}";
//		      }
//		      out.print(res);
		      
//		      out.print("{\"led\":"+led+"}");
//		   }

//			      response.setContentType("text/html; charset=UTF-8"); 
//	      response.setCharacterEncoding("UTF-8");
//	      PrintWriter out = response.getWriter();
//	      if(request.getParameter("sensor") != null){
//			System.out.println("값X");
//		      s =request.getParameter("sensor");
//		      } 
//	      	res = "{\"sensor\":"+3+"}";
//		out.print(res);
//	      System.out.println("현재 받아온 값 : "+s);
//	      if(!s.equals("0")) {//초기값이 아닐시
//	    	  if(vo.getPose_type().equals(s)) {
//	    		  if(cnt==0) {
//	    			  start_time = date.getTime(); //현재 시간 측정
//	    			  System.out.println("앉기 시작");
//	    			  vo.setPose_type(s);//시작 타입 포즈 저장
//	    		  }
//	    		  cnt++;
//	    	  }else {
//	    		  long end = date.getTime();
//	    				 
//
//	    		  end_time = date.getTime();//끝시간 측정
//	    		  vo.setPose_time(end_time-start_time);//유지 시간 저장
//	    		  dao.pose_date(vo.getPose_type(),vo.getPose_time(),product,date2);//db 저장
//	    		  vo.setPose_type(s);//변경된 경우 이므로 타입 다시 저장
//	    		  start_time = (int) System.currentTimeMillis(); //변경된 자세 시작 시간 측정
//	    			  
//	    	  }
//	      }
	}
	      


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		doGet(request, response);
	}

}
