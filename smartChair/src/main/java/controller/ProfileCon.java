package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.tb_userDAO;
import vo.tb_userVO;

@WebServlet("/ProfileCon")
public class ProfileCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		
		tb_userDAO dao = new tb_userDAO();
		tb_userVO vo = dao.profile(user_id);
		
	}

}
