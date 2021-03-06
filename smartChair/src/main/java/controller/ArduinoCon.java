package controller;

import java.io.IOException;
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
    String product = "sc";
    long start_time;
    long end_time;
    Date date = new Date();	
    date.getTime();
    Calendar cal = Calendar.getInstance(); //추상클래스이므로 static method로 객체를 할당받는다.
    String date2 = Integer.toString(cal.get(Calendar.YEAR))+Integer.toString(cal.get(Calendar.MONTH))+Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
	int cnt = 0;

	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		vo.setPose_type(a); 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		response.getWriter().append("Served at: ").append(request.getContextPath());//웹 연결
	      String s =request.getParameter("sensor"); //센서 값 받아오기 
	      
	      System.out.println("현재 받아온 값 : "+s);
	      if(!s.equals("0")) {//초기값이 아닐시
	    	  if(vo.getPose_type().equals(s)) {
	    		  if(cnt==0) {
	    			  start_time = date.getTime(); //현재 시간 측정
	    			  System.out.println("앉기 시작");
	    			  vo.setPose_type(s);//시작 타입 포즈 저장
	    		  }
	    		  cnt++;
	    	  }else {

	    		  end_time = date.getTime();//끝시간 측정
	    		  vo.setPose_time(end_time-start_time);//유지 시간 저장
	    		  dao.pose_date(vo.getPose_type(),vo.getPose_time(),product);//db 저장
	    		  vo.setPose_type(s);//변경된 경우 이므로 타입 다시 저장
	    		  start_time = (int) System.currentTimeMillis(); //변경된 자세 시작 시간 측정
	    		  cnt = 0;
	    	  }
	      }
	      
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		doGet(request, response);
	}

}
