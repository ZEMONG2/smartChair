package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.memberVO;

public class memberDAO {

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
	
	public int join(String email, String pw, String name) {
		int cnt = 0;
		try {
			connect();

			String sql = "insert into USER_INFO values(?, ?, ?)";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			
			cnt = psmt.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();

		}
		
		return cnt;
	}

	public memberVO login(String email, String pw) {
		memberVO vo = null;
		try {
			connect();

			String sql = "select * from message_member where email = ? and pw = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			
			if (rs.next()) {				
				String dbEmail = rs.getString(1);
				String dbPw = rs.getString(2);
				String dbName = rs.getString(3);
				vo = new memberVO(dbEmail, dbName);

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
	

	
}
