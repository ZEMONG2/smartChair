package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.sql.DATE;
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
   public int pose_date(int pose_seq, String pose_type, Date pose_start_dt, Date pose_end_dt, String pose_system) {
      int cnt = 0;
      
      try {
         connect();
         
         String sql = "insert into tb_pose values(tb_pose_seq, ?, ?, ?, ?,?)";
         
         rs = psmt.executeQuery();
         
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, pose_seq);
            psmt.setString(1, pose_type);
            psmt.setDate(2, pose_start_dt);
            psmt.setDate(3, pose_end_dt);
            psmt.setString(4, pose_system);
            psmt.setString(5, sql);
             cnt = psmt.executeUpdate();

         
         

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();

      }
      
      return cnt;
   }
        public void pose_type(String sc, String type) {
   //   tb_poseVO vo = null;
      try {
         connect();
         
         String sql = "select sc from tb_pose where tb_pose_type = ?";

         psmt = conn.prepareStatement(sql);
         psmt.setString(1, sc);
         psmt.setString(2, type);
         rs = psmt.executeQuery();
      
         if (rs.next()) {
            
         } else {
            System.out.println("일치하는 회원 없음");
         }
      
      
      
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return vo;
   
   }

   
