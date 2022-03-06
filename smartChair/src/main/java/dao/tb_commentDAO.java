package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import vo.tb_commentVO;

public class tb_commentDAO {

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
	
	
	public ArrayList<tb_commentVO> selectAll() {

		ArrayList<tb_commentVO> al = new ArrayList<tb_commentVO>();

		try {
			connect();
			String sql = "select * from tb_comment";

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
		

			while (rs.next()) {
				int db_comment_seq = rs.getInt(1);
				int db_article_seq = rs.getInt(2);
				String db_comment_content = rs.getString(3);
				Date db_comment_date = rs.getDate(4);
				String db_user_id = rs.getString(5);
				tb_commentVO voReply = new tb_commentVO(db_comment_seq, db_article_seq, db_comment_content, db_comment_date, db_user_id);
				al.add(voReply);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return al;
	}

	
	
	
	
	
}
