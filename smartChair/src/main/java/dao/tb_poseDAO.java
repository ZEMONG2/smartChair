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
   public int pose_date(String pose_type, long pose_time, String product_num) {
      int cnt = 0;
      
      try {
         connect();
         
         String sql = "insert into tb_pose values(tb_pose_seq.nextval, ?, ?, sysdate, ?)";
        
            psmt = conn.prepareStatement(sql);
           
            psmt.setString(1, pose_type);
            psmt.setDouble(2, pose_time);
            psmt.setString(3, product_num);
             cnt = psmt.executeUpdate();

         
         

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();

      }
      
      return cnt;
   }
        public ArrayList<tb_poseVO> pose_type(String product_num) { //검색 조건 추가하기 
           
        ArrayList al = new ArrayList();
   //   tb_poseVO vo = null;
      try {
         connect();
         
         String sql = "select * from tb_pose where product_num = ?";

         psmt = conn.prepareStatement(sql);
         psmt.setString(1, product_num);

         rs = psmt.executeQuery();
      
         if (rs.next()) {
           int pose_seq = rs.getInt(1);
         String pose_type = rs.getString(2);
         long pose_time = rs.getLong(3);
         String reg_date = rs.getString(4);
         String db_product_num = rs.getString(5);
         tb_poseVO vo = new tb_poseVO(pose_seq, pose_type, pose_time, reg_date, db_product_num);
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


   