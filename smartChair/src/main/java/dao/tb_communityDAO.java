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
	
	public int inputCommunity(double article_seq,String article_title, String article_content, String article_file,String user_id){
		int cnt = 0;
		try {
			connect();
			
			String sql = "insert into tb_community values(?,?,?,?,sysdate,?,0,0)";
			
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				psmt = conn.prepareStatement(sql);
				psmt.setDouble(1, article_seq );
				psmt.setString(2, article_title);
				psmt.setString(3, article_content);
				psmt.setString(4, article_file);
				psmt.setString(5, user_id);
				cnt = psmt.executeUpdate();

			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();

		}
		
		return cnt;
	

		
		
	}
	public int outputCommunity(double article_seq,String article_title, String article_content, String article_file,String user_id){
		int cnt = 0;
		try {
			connect();
			
			String sql = "Select * from tb_community";
			
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				psmt = conn.prepareStatement(sql);
				psmt.setDouble(1, article_seq );
				psmt.setString(2, article_title);
				psmt.setString(3, article_content);
				psmt.setString(4, article_file);
				psmt.setString(5, user_id);

			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();

		}
		
		return cnt;
	

		
	}
}
