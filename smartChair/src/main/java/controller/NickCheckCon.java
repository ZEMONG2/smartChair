package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.tb_userDAO;


@WebServlet("/NickCheckCon")
public class NickCheckCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				//1. email 값 받기(getParameter사용)
				request.setCharacterEncoding("euc-kr");
				
				String nick = request.getParameter("nick");
				
				//2. memberDAO email이 사용할 수 있는 이메일인지 확인해주는 메서드 (idCheck())
				//반환값 : 있는 아이디면 true /없는 아이디면 false
				tb_userDAO dao = new tb_userDAO();
				String check = dao.nickCheck(nick);
				
				
				//3. console에 true/false(반환값) 출력
				PrintWriter out = response.getWriter();
				out.print(check);
			
				
			
			
			}

		

	}


