package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;



import vo.tb_communityVO;

public class tb_communityDAO {
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
   
   public int inputCommunity(String article_title, String article_content, String article_file,String user_id, String user_ip){
      int cnt = 0;
      try {
         connect();
         System.out.println("체크1");
         String sql = "INSERT INTO tb_community (article_seq, article_title, article_content, article_file, article_date, user_id, user_ip) values(tb_community_seq.nextval,?,?,?,sysdate,?,?)";
         
         psmt = conn.prepareStatement(sql);
         
            System.out.println("체크2");
            psmt.setString(1, article_title);
            psmt.setString(2, article_content);
            psmt.setString(3, article_file);
            psmt.setString(4, user_id);
            psmt.setString(5, user_ip);
            cnt = psmt.executeUpdate();


      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();

      }
      
      return cnt;
   
   }
   
   public int inputCommunity2(String article_title, String article_content,String user_id, String user_ip){
      int cnt = 0;
      try {
         connect();
         System.out.println("체크1");
         String sql = "INSERT INTO tb_community (article_seq, article_title, article_content, article_date, user_id, user_ip) values(tb_community_seq.nextval,?,?,sysdate,?,?)";
         
         psmt = conn.prepareStatement(sql);
         
            System.out.println("체크2");
            psmt.setString(1, article_title);
            psmt.setString(2, article_content);
            psmt.setString(3, user_id);
            psmt.setString(4, user_ip);
            cnt = psmt.executeUpdate();

         
         

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();

      }
      
      return cnt;
   }
   public ArrayList<tb_communityVO> outputCommunity(){
      ArrayList<tb_communityVO> al = new ArrayList<tb_communityVO>();
      
      try {
         connect();
         
         String sql = "Select * from tb_community order by article_seq";
         
         psmt = conn.prepareStatement(sql);
         rs = psmt.executeQuery();
         while(rs.next()) {
            int article_seq2 = rs.getInt(1);
            String article_title2 = rs.getString(2);
            String article_content2 = rs.getString(3);
            String article_file2 = rs.getString(4);
            Date article_date2 = rs.getDate(5);
            String user_id2 = rs.getString(6);
            int article_cnt2 = rs.getInt(7);
            int article_likes2 = rs.getInt(8);
            String user_ip2 = rs.getString(9);
            tb_communityVO vo = new tb_communityVO(article_seq2, article_title2, article_content2, article_file2, article_date2, user_id2, article_cnt2, article_likes2, user_ip2);
            al.add(vo);
         }
         

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();

      }
      
      return al;
   }
   
   public tb_communityVO selectOne(int articleSEQ) {
      tb_communityVO voList =null;
      try {
         connect();
         String sql = "Select * from tb_community where article_seq = ?";
         psmt = conn.prepareStatement(sql);
         psmt.setInt(1, articleSEQ);
         rs = psmt.executeQuery();
         if(rs.next()) {
            int article_seq2 = rs.getInt(1);
            String article_title2 = rs.getString(2);
            String article_content2 = rs.getString(3);
            String article_file2 = rs.getString(4);
            Date article_date2 = rs.getDate(5);
            String user_id2 = rs.getString(6);
            int article_cnt2 = rs.getInt(7);
            int article_likes2 = rs.getInt(8);
            String user_ip2 = rs.getString(9);
            voList = new tb_communityVO(article_seq2, article_title2, article_content2, article_file2, article_date2, user_id2, article_cnt2, article_likes2, user_ip2);
            System.out.println("게시물정보 가져오기 체크");
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();

      }
      
      return voList;
   }
   
   public void updateViews(int articleSEQ) {
      
      try {
         connect();
         
         String sql = "update tb_community set article_cnt = article_cnt+1 where article_seq = ?";
         psmt = conn.prepareStatement(sql);
         psmt.setInt(1, articleSEQ);
            psmt.executeUpdate();

            System.out.println("뷰증가");
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();

      }
      
   }
public int deleteArticle(int articleSEQ) {
      int cnt = 0;
      try {
         connect();
         
         String sql = "delete from tb_community where article_seq = ?";
         psmt = conn.prepareStatement(sql);
         psmt.setInt(1, articleSEQ);
            cnt = psmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();

      }
      return cnt;
   }
   

   
   
public void updateLikesUp(int articleSEQ) {
      
      try {
         connect();
         
         String sql = "update tb_community set article_likes = article_likes+1 where article_seq = ?";
         psmt = conn.prepareStatement(sql);
         psmt.setInt(1, articleSEQ);
            psmt.executeUpdate();

            System.out.println("추천증가");
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close();

      }
      
   }

public void updateLikesDown(int articleSEQ) {
   
   try {
      connect();
      
      String sql = "update tb_community set article_likes = article_likes-1 where article_seq = ?";
      psmt = conn.prepareStatement(sql);
      psmt.setInt(1, articleSEQ);
         psmt.executeUpdate();

         System.out.println("추천감소");
   } catch (Exception e) {
      e.printStackTrace();
   } finally {
      close();

   }
   
}
   
}