package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import vo.tb_userVO;


public class tb_userDAO {

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
	
	public int join(String user_id, String user_pw, String user_name, String user_nick) {
		int cnt = 0;
		String db_user_id = "";
		try {
			connect();
			
			String sql = "insert into tb_user values(?, ?, ?, ?, sysdate,'N')";
			String sql2 ="select * from tb_user";
			
			psmt = conn.prepareStatement(sql2);
			rs = psmt.executeQuery();
			if (rs.next()) {				
				db_user_id = rs.getString(1);
			}
				
			if(!db_user_id.equals(user_id)) {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, user_id);
				psmt.setString(2, user_pw);
				psmt.setString(3, user_name);
				psmt.setString(4, user_nick);
				cnt = psmt.executeUpdate();

			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();

		}
		
		return cnt;
	}
	
	public tb_userVO login(String user_id, String user_pw) {
		tb_userVO vo = null;
		try {
			connect();
			
			String sql = "select * from tb_user where user_id = ? and user_pw = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			psmt.setString(2, user_pw);
			rs = psmt.executeQuery();
			
			if (rs.next()) {				
				String db_user_id = rs.getString(1);
				String db_user_name = rs.getString(3);
				String db_user_nick = rs.getString(4);
				vo = new tb_userVO(db_user_id, db_user_name, db_user_nick);

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
	
	public int reset(String user_id, String user_nick, String user_pw) {
		
		int cnt = 0;
		try {
			connect();

			String sql2 = "update tb_user set user_pw = ? where user_id = ? and user_nick = ?";
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, user_pw);
			psmt.setString(2, user_id);
			psmt.setString(3, user_nick);
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
/*public int modify(String user_id, String user_pw, String user_name, String user_nick) {
		
		int cnt = 0;
		try {
			connect();

			String sql = "update tb_user set user_pw = ?, user_name = ?, user_nick = ? where user_id = ?";
			psmt = conn.prepareStatement(sql);
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
	
public ArrayList<tb_userVO> profile() {
	
	ArrayList<tb_userVO> al = new ArrayList<tb_userVO>();
	
	try {
		connect();
		String sql = "select u_email, u_nick from user_info";

		psmt = conn.prepareStatement(sql);
		
		rs = psmt.executeQuery();
		
		while (rs.next()) {
			String dbEmail = rs.getString(1);
			String dbNick = rs.getString(2);
			tb_userVO vo = new tb_userVO(dbEmail, dbNick);
			al.add(vo);				
		}

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close();
	}
	return al;
}
*/	
	}
	

