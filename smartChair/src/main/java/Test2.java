
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.tb_poseDAO;
import vo.tb_heightVO;
import vo.tb_poseVO;
import vo.tb_userVO;

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
   tb_poseDAO dao = new tb_poseDAO();
   String sc;
   String product = "sc";
   String product_num = "00000001";
   String pose_type = "";
   long start_time1=0;
   long start_time2=0;
   long start_time3=0;
   long start_time4=0;
   long pose_time;
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
         if (sensor.equals("LL")||sensor.equals("RR")||sensor.equals("TT")||sensor.equals("BB")) {
            s = "4";
         } else if (sensor.equals("5")) {
            s = "5";
         } else if (sensor.equals("LL")) {
            start_time1 = date.getTime(); // 현재 시간 측정
            pose_type = "LEFT";
            if(start_time3 >0) {
               pose_time = start_time3 - start_time1 ;
            }else if(start_time2 >0) {
               pose_time = start_time2 - start_time1 ;
            }else if(start_time4 >0) {
               pose_time = start_time4 - start_time1 ;
            }
         } else if (sensor.equals("RR")) {
            start_time2 = date.getTime(); // 현재 시간 측정
            pose_type = "RIGHT";
            if(start_time3 >0) {
               pose_time = start_time3 - start_time2 ;
            }else if(start_time4 >0) {
               pose_time = start_time4 - start_time2 ;
            }else if(start_time1 >0) {
               pose_time = start_time1 - start_time2 ;
            }
         } else if (sensor.equals("TT")) {
            start_time3 = date.getTime(); // 현재 시간 측정
            pose_type = "BACK";
            if(start_time4 >0) {
               pose_time = start_time4 - start_time3 ;
            }else if(start_time2 >0) {
               pose_time = start_time2 - start_time3 ;
            }else if(start_time1 >0) {
               pose_time = start_time1 - start_time3 ;
            }
         } else if (sensor.equals("BB")) {
            start_time4 = date.getTime(); // 현재 시간 측정  
            pose_type = "COMMON";
            if(start_time3 >0) {
               pose_time = start_time3 - start_time4 ;
            }else if(start_time2 >0) {
               pose_time = start_time2 - start_time4 ;
            }else if(start_time1 >0) {
               pose_time = start_time1 - start_time4 ;
            }
             
         }
         
          tb_poseDAO dao = new tb_poseDAO();
          dao.pose_date(pose_type,pose_time,product_num);
         
         
         
         start_time1=0;
         start_time2=0;
         start_time3=0;
         start_time4=0;
         System.out.println("현재자세 : " + pose_type);
      }
      if (s.equals("1")) {
         sc = "UP";
      } else if (s.equals("2")) {
         sc = "DOWN";
      } else if (s.equals("3")) {
         sc = "STOP";
      } else if (s.equals("4") && cnt == 0) {
         sc = "DOWN";
         cnt++;
         System.out.println("cntDown : " + cnt);
      } else if (s.equals("5") && cnt == 1) {
         sc = "UP";
         cnt--;
         System.out.println("cntUp : " + cnt);
      }
      
      System.out.println("sensor: " + sensor + ", sc: " + sc + ", s : " + s);
      System.out.println();

      out.print(sc);
      out.print("<html>");
      out.print("<head>");
      out.print("<body>");
      out.print("<a href = 'buttons.jsp'>되돌아가기</a>");
      out.print("</body>");
      out.print("</html>");
//      out.flush();
//      out.close();

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