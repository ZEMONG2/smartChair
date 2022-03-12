package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
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
   public void pose_date(String pose_type, String product_num) {
      int cnt = 0;
      
      try {
         connect();
         
         String sql = "insert into tb_pose values(tb_pose_seq.nextval, ?, sysdate, ?)";
        
            psmt = conn.prepareStatement(sql);
           
            psmt.setString(1, pose_type);
            psmt.setString(2, product_num);
             cnt = psmt.executeUpdate();

         if(cnt>0) {
            System.out.println("방석센서 값 디비저장성공 ");
         }
         

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();

      }
      
   }
  
        public ArrayList<tb_poseVO> pose_data() { //검색 조건 추가하기 
           
        ArrayList al = new ArrayList();
   //   tb_poseVO vo = null;
      try {
         connect();
         
         String sql = "select * from tb_pose";

         psmt = conn.prepareStatement(sql);
      

         rs = psmt.executeQuery();
      
         while (rs.next()) {
           int pose_seq = rs.getInt(1);
         String pose_type = rs.getString(2);
         String reg_date = rs.getString(3);
         String db_product_num = rs.getString(4);
         tb_poseVO vo = new tb_poseVO(pose_seq, pose_type, reg_date, db_product_num);
         al.add(vo);
         } 
      
      
      
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();
      }
      return al;
   }
        public ArrayList<tb_poseVO> pose_type(String nowTime) { //검색 조건 추가하기 
        	ArrayList al = new ArrayList();
        
          try {
             connect();
             
             String sql = "select pose_type, count(*)  from tb_pose WHERE TO_CHAR(REG_DATE, 'YYYYMMDD') = ? group by pose_type";

             psmt = conn.prepareStatement(sql);
          
             psmt.setString(1, nowTime);
             rs = psmt.executeQuery();
          
             while (rs.next()) {
             String pose_type = rs.getString(1);
             int count = rs.getInt(2);
             tb_poseVO vo = new tb_poseVO(pose_type, count);
             al.add(vo);
             } 
          
          
          
          } catch (Exception e) {
             e.printStackTrace();
          } finally {
             close();
          }
          return al;
       } 
        
        public ArrayList<tb_poseVO> pose_type2(int chartMonth) { //검색 조건 추가하기 
        	ArrayList al = new ArrayList();
        
          try {
             connect();
             
             String sql = "select pose_type, count(*)  from tb_pose WHERE TO_CHAR(REG_DATE, 'YYYYMM') = ? group by pose_type";

             psmt = conn.prepareStatement(sql);
          
             psmt.setInt(1, chartMonth);
             rs = psmt.executeQuery();
          
             while (rs.next()) {
             String pose_type = rs.getString(1);
             int count = rs.getInt(2);
             tb_poseVO vo = new tb_poseVO(pose_type, count);
             al.add(vo);
             } 
          
          
          
          } catch (Exception e) {
             e.printStackTrace();
          } finally {
             close();
          }
          return al;
       } 
        
        
        
        
}


   