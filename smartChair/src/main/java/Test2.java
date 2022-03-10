
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.tb_poseDAO;
import vo.tb_heightVO;
import vo.tb_poseVO;

/**
 * Servlet implementation class Test2
 */
@WebServlet("/Test2")
public class Test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String res = "";
	static String s = "";
	static int cnt = 0;
	HttpServletResponse response;
	tb_heightVO vo2 = new tb_heightVO();
	tb_poseVO vo = new tb_poseVO();
	tb_poseDAO dao = new tb_poseDAO();
	String sc;
	String product = "sc";
	long start_time;
	long end_time;
	Date date = new Date();
	Calendar cal = Calendar.getInstance(); // 추상클래스이므로 static method로 객체를 할당받는다.
	String date2 = Integer.toString(cal.get(Calendar.YEAR)) + Integer.toString(cal.get(Calendar.MONTH))
			+ Integer.toString(cal.get(Calendar.DAY_OF_MONTH));

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		response.setCharacterEncoding("UTF-8");
		// tb_heightVO vo2 = new tb_heightVO();
		// res = vo2.getRes();

		String led = request.getParameter("res");

	
		if (led != null && led != "") {
			s = led;
		}
		doGet(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("에러");
		PrintWriter out = response.getWriter();
		String sensor = request.getParameter("sensor");
		if (sensor != null) {
			if ((sensor.equals("LB") || sensor.equals("LC") || sensor.equals("LT") || sensor.equals("RB")
					|| sensor.equals("RC") || sensor.equals("RT")) ) {
				s = "4";
			}else if (sensor.equals("5")) {
				s = "5";
			}
			
		}
		if (s.equals("1")) {
			sc = "UP.";
		} else if (s.equals("2")) {
			sc = "DOWN";
		} else if (s.equals("3")) {
			sc = "STOP";
		} else if(s.equals("4")&&cnt == 0) {
			sc = "DOWN";
			cnt++;
			System.out.println("cntDown : " + cnt);
		} else if(s.equals("5")&&cnt == 1) {
			sc = "UP";
			cnt--;
			System.out.println("cntUp : " + cnt);
		} 
		
		System.out.println("sensor: " + sensor + ", sc: " + sc +", s : "+s);
		System.out.println();

		out.print(sc);
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("<a href = 'buttons.jsp'>돌아가기</a>");
		out.print("</body>");
		out.print("</html>");
//		out.flush();
//		out.close();

//      out.print("{\"led\":"+led+"}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void ret() {
		try {
			response.sendRedirect("buttons.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}