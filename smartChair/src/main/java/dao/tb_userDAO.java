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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public int join(String user_id, String user_pw, String user_name, String user_nick, String user_tel,
			String user_gender, String user_birthday, String product_num) {
		int cnt = 0;
		String db_user_id = "";
		try {
			connect();

			String sql = "insert into tb_user values(?, ?, ?, ?, ?, ?, ?, sysdate,?,'N')";
			String sql2 = "select * from tb_user";

			psmt = conn.prepareStatement(sql2);
			rs = psmt.executeQuery();
			if (rs.next()) {
				db_user_id = rs.getString(1);
			}

			if (!db_user_id.equals(user_id)) {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, user_id);
				psmt.setString(2, user_pw);
				psmt.setString(3, user_name);
				psmt.setString(4, user_nick);
				psmt.setString(5, user_tel);
				psmt.setString(6, user_gender);
				psmt.setString(7, user_birthday);
				psmt.setString(8, product_num);
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
				String db_user_pw = rs.getString(2);
				String db_user_name = rs.getString(3);
				String db_user_nick = rs.getString(4);
				String db_user_tel = rs.getString(5);
				String db_user_gender = rs.getString(6);
				String db_user_birthday = rs.getString(7);
				Date db_user_joindate = rs.getDate(8);
				String db_product_num = rs.getString(9);
				String db_admin_yesno = rs.getString(10);
				vo = new tb_userVO(db_user_id, db_user_pw, db_user_name, db_user_nick, db_user_tel, db_user_gender,
						db_user_birthday, db_user_joindate, db_product_num, db_admin_yesno);

			} else {
				System.out.println("???????????? ?????? ??????");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	public String selectId(int articleSEQ) {
		String user_id = "";
		try {
			
			String sql2 = "select user_id from tb_community where article_seq = ?";
			System.out.println("????????? ??????");
			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, articleSEQ);
			rs = psmt.executeQuery();
			if (rs.next()) {
				user_id = rs.getString(1);
			}
			System.out.println("????????? ????????? : "+ user_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return user_id;
	}
	
	public String articleNick(int articleSEQ) {
		String user_id = "";
		String user_nick = "";
		try {
			connect();
			
			user_id = selectId(articleSEQ);
			String sql = "select user_nick from tb_user where user_id = ?";
			

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			rs = psmt.executeQuery();
			System.out.println("?????? 1 : " + user_id);

			if (rs.next()) {

				System.out.println("??????2");

				user_nick = rs.getString(1);
				System.out.println("????????? ?????? : " + user_nick);
				
			} else {
				System.out.println("???????????? ?????? ??????");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return user_nick;
		
	}

	public int reset(String user_id, String user_name, String user_pw) {

		int cnt = 0;
		try {
			connect();

			String sql2 = "update tb_user set user_pw = ? where user_id = ? and user_name = ?";
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, user_pw);
			psmt.setString(2, user_id);
			psmt.setString(3, user_name);
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public int modify(String user_id, String user_pw, String user_tel, String user_nick, String sess_nick) {

		int cnt = 0;
		try {
			connect();
			
			if(user_nick.equals(sess_nick)) {
				String sql = "update tb_user set user_pw = ?, user_tel = ? where user_id = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, user_pw);
				psmt.setString(2, user_tel);
				psmt.setString(3, user_id);
				cnt = psmt.executeUpdate();
			}else if(!user_nick.equals(sess_nick)) {
				String sql = "update tb_user set user_pw = ?, user_tel = ?, user_nick = ? where user_id = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, user_pw);
				psmt.setString(2, user_tel);
				psmt.setString(3, user_nick);
				psmt.setString(4, user_id);
				cnt = psmt.executeUpdate();
			}

		

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public ArrayList<tb_userVO> selectAll() {

		ArrayList<tb_userVO> al = new ArrayList<tb_userVO>();

		try {
			connect();
			String sql = "select * from tb_user";

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String db_user_id = rs.getString(1);
				String db_user_name = rs.getString(3);
				String db_user_nick = rs.getString(4);
				String db_user_tel = rs.getString(5);
				String db_user_gender = rs.getString(6);
				String db_user_birthday = rs.getString(7);
				Date db_user_joindate = rs.getDate(8);
				String db_product_num = rs.getString(9);
				String db_admin_yesno = rs.getString(10);
				tb_userVO vo = new tb_userVO(db_user_id, db_user_name, db_user_nick, db_user_tel, db_user_gender,
						db_user_birthday, db_user_joindate, db_product_num, db_admin_yesno);
				al.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return al;
	}

	/*
	 * public tb_userVO profile(String user_id) { tb_userVO vo = null; try {
	 * connect();
	 * 
	 * String sql = "select * from tb_user where user_id = ?";
	 * 
	 * psmt = conn.prepareStatement(sql); psmt.setString(1, user_id); rs =
	 * psmt.executeQuery();
	 * 
	 * if (rs.next()) { String db_user_id = rs.getString(1); String db_user_pw =
	 * rs.getString(2); String db_user_name = rs.getString(3); String db_user_nick =
	 * rs.getString(4); Date db_user_joindate = rs.getDate(5); vo = new
	 * tb_userVO(db_user_id, db_user_name, db_user_nick, db_user_joindate);
	 * 
	 * }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { close(); } return
	 * vo; }
	 */
	public String idCheck(String email) {
		String check = "";
		try {
			connect();

			String sql = "select user_id from tb_user where user_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);

			rs = psmt.executeQuery();

			if (rs.next()) {
				check = "true";
			} else {
				check = "false";
			}
			if (email == "") {
				check = "empty";
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close();

		}
		return check;

	}

	public String nickCheck(String nick) {
		String check = "";
		try {
			connect();

			String sql = "select user_nick from tb_user where user_nick = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, nick);

			rs = psmt.executeQuery();

			if (rs.next()) {
				check = "true";
			} else {
				check = "false";
			}
			if (nick == "") {
				check = "empty";
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close();

		}
		return check;

	}
	
	public String productCheck(String product_num) {
		String check = "";
		try {
			connect();

			String sql = "select product_num from tb_user where product_num = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, product_num);

			rs = psmt.executeQuery();

			if (rs.next()) {
				check = "true";
			} else {
				check = "false";
			}
			if (product_num == "") {
				check = "empty";
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close();

		}
		return check;

	}
}
