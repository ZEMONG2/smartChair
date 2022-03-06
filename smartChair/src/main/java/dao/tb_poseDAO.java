package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.sql.DATE;

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
   public boolean pose_date(String pose_type, Date pose_start_dt, Date pose_end_dt, String user_id) {
      boolean cnt = false;
      
      String db_user_id = "";
      try {
         connect();
         
         String sql = "insert into tb_pose values(?, ?, ?, ?)";
         
         rs = psmt.executeQuery();
         
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, pose_type);
            psmt.setDate(2, pose_start_dt);
            psmt.setDate(3, pose_end_dt);
            psmt.setString(4, user_id);
            cnt = psmt.executeUpdate();

         
         

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();

      }
      
      return cnt;
   }

   }

   
}