package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteCon")
public class DeleteCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "campus_d_2_0216";
			String password = "smhrd2";
			
			conn = DriverManager.getConnection(url, user, password);
			
			sql = "Select user_pw from tb_user where user_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				rs.getString(1);
				String dbpw = rs.getString("user_pw");
			if(user_pw.equals(dbpw)) {
				sql = "delete from tb_user where user_id = ?";
				 psmt=conn.prepareStatement(sql);
			     psmt.setString(1, user_id);
			     
			     psmt.executeUpdate();
			     System.out.println("회원삭제 성공");
			     System.out.println(user_id + "\t" + user_pw);
			     response.sendRedirect("login.jsp");
			}else {
				System.out.println("비밀번호 틀림");
			}
			
			}else {
				System.out.println("아이디가 존재하지 않음");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
				conn.close();
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
			
		}
	
	
	}

}
