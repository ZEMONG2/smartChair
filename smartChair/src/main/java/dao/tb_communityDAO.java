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
	
	public int inputCommunity(String article_title, String article_content, String article_file,String user_id){
		int cnt = 0;
		try {
			connect();
			
			System.out.println("체크1");
			String sql = "INSERT INTO tb_community (article_title, article_content, article_file, article_date, user_id) values(?,?,?,sysdate,?)";
			
			psmt = conn.prepareStatement(sql);
			
				System.out.println("체크2");
				psmt.setString(1, article_title);
				psmt.setString(2, article_content);
				psmt.setString(3, article_file);
				psmt.setString(4, user_id);
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
				double article_seq2 = rs.getDouble(1);
				String article_title2 = rs.getString(2);
				String article_content2 = rs.getString(3);
				String article_file2 = rs.getString(4);
				Date article_date2 = rs.getDate(5);
				String user_id2 = rs.getString(6);
				double article_cnt2 = rs.getDouble(7);
				double article_likes2 = rs.getDouble(8);
				tb_communityVO vo = new tb_communityVO(article_seq2, article_title2, article_content2, article_file2, article_date2, user_id2, article_cnt2, article_likes2);
				al.add(vo);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();

		}
		
		return al;
	}
	
	public tb_communityVO selectOne(double article_seq) {
		tb_communityVO voList =null;
		try {
			connect();
			String sql = "Select * from tb_community where article_seq = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setDouble(1, article_seq);
			rs = psmt.executeQuery();
			if(rs.next()) {
				double article_seq2 = rs.getDouble(1);
				String article_title2 = rs.getString(2);
				String article_content2 = rs.getString(3);
				String article_file2 = rs.getString(4);
				Date article_date2 = rs.getDate(5);
				String user_id2 = rs.getString(6);
				double article_cnt2 = rs.getDouble(7);
				double article_likes2 = rs.getDouble(8);
				voList = new tb_communityVO(article_seq2, article_title2, article_content2, article_file2, article_date2, user_id2, article_cnt2, article_likes2);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();

		}
		
		return voList;
	}
	
	public void updateViews(double article_seq) {
		
		try {
			connect();
			
			System.out.println("체크1");
			String sql = "update tb_community set article_cnt = article_cnt+1 where article_seq = ?";
			psmt = conn.prepareStatement(sql);
			
				
				psmt.setDouble(1, article_seq);
				
				psmt.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();

		}
		
	}
	
}
