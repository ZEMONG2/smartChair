package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinCon")
public class JoinCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String email = request.getParameter("email");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String pw = request.getParameter("pw");
		
		String name = firstname + lastname;
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(name);
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "campus_d_2_0216";
			String password = "smhrd2";
			conn = DriverManager.getConnection(url, user, password);

			String sql = "insert into USER_INFO values(?, ?, ?)";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			
			int cnt = psmt.executeUpdate();

			if (cnt > 0) {
				response.sendRedirect("login.html");
			}else {
				System.out.println("½ÇÆÐ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

}
