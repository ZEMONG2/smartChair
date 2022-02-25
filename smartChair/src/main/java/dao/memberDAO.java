package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	public int join(String email, String pw, String nick) {
		int cnt = 0;
		String dbEmail = "";
		try {
			connect();
			String sql2 ="select * from user_info";
			String sql = "insert into USER_INFO values(?, ?, ?)";
			
			psmt = conn.prepareStatement(sql2);
			rs = psmt.executeQuery();
			if (rs.next()) {				
				dbEmail = rs.getString(1);
			}
				
			if(!email.equals(dbEmail)) {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, email);
				psmt.setString(2, pw);
				psmt.setString(3, nick);
				cnt = psmt.executeUpdate();

			}
			

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

			String sql = "select * from user_info where u_email = ? and u_pw = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			
			if (rs.next()) {				
				String dbEmail = rs.getString(1);
				String dbPw = rs.getString(2);
				String dbNick = rs.getString(3);
				vo = new memberVO(dbEmail, dbNick);
				

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
	
	public int reset(String email, String nick, String pw) {
		
		int cnt = 0;
		try {
			connect();

			String sql2 = "update user_info set u_pw = ? where u_email = ? and u_nick = ?";
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, pw);
			psmt.setString(2, email);
			psmt.setString(3, nick);
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
public int modify(String email, String nick, String pw) {
		
		int cnt = 0;
		try {
			connect();

			String sql2 = "update user_info set u_pw = ?, u_nick = ? where u_email = ?";
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, pw);
			psmt.setString(2, nick);
			psmt.setString(3, email);			
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
public ArrayList<memberVO> profile() {
	
	ArrayList<memberVO> al = new ArrayList<memberVO>();
	
	try {
		connect();
		String sql = "select u_email, u_nick from user_info";

		psmt = conn.prepareStatement(sql);
		
		rs = psmt.executeQuery();
		
		while (rs.next()) {
			String dbEmail = rs.getString(1);
			String dbNick = rs.getString(2);
			memberVO vo = new memberVO(dbEmail, dbNick);
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
	

