package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.sql.DATE;
import vo.tb_communityVO;
import vo.tb_poseVO;
import vo.tb_userVO;

public class tb_poseDAO {

   PreparedStatement psmt = null;
   Connection conn = null;
   ResultSet rs = null;
   public void connect() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
         String user = "campus_d_2_0216";
         String password = "smhrd2";
         conn = DriverManager.getConnection(url, user, password);
         
      }catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public void close() {
      try {
         if(rs != null) {
         rs.close();
         }
         if(psmt != null) {
         psmt.close();
         }
         if(conn != null) {
         conn.close();
         }
      } catch (Exception e2) {
         e2.printStackTrace();
      }
   }
   public int pose_date(String pose_type, long pose_time, String pose_system, String date) {
      int cnt = 0;
      
      try {
         connect();
         
         String sql = "insert into tb_pose values(tb_pose_seq, ?, ?, ?, ?)";
         
         rs = psmt.executeQuery();
         
            psmt = conn.prepareStatement(sql);
           
            psmt.setString(1, pose_type);
            psmt.setDouble(2, pose_time);
            psmt.setString(3, pose_system);
            psmt.setString(4,date);
             cnt = psmt.executeUpdate();

         
         

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();

      }
      
      return cnt;
   }
        public ArrayList<tb_poseVO> pose_type(String sc) { //검색 조건 추가하기 
        	
        ArrayList al = new ArrayList();
   //   tb_poseVO vo = null;
      try {
         connect();
         
         String sql = "select pose_seq, pose_type, pose_time, reg_date from tb_pose where sc = sc";

         psmt = conn.prepareStatement(sql);
         psmt.setString(1, sc);

         rs = psmt.executeQuery();
      
         if (rs.next()) {
        	int article_seq2 = rs.getInt(1);
			String pose_type = rs.getString(2);
			long pose_time = rs.getLong(3);
			String reg_date = rs.getString(4);
			tb_poseVO vo = new tb_poseVO( pose_type, pose_time, reg_date);
			al.add(vo);
         } else {
            System.out.println("일치하는 회원 없음");
         }
      
      
      
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return al;
   }
}


   
