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

				//1. email �� �ޱ�(getParameter���)
				request.setCharacterEncoding("euc-kr");
				
				String nick = request.getParameter("nick");
				
				//2. memberDAO email�� ����� �� �ִ� �̸������� Ȯ�����ִ� �޼��� (idCheck())
				//��ȯ�� : �ִ� ���̵�� true /���� ���̵�� false
				tb_userDAO dao = new tb_userDAO();
				String check = dao.nickCheck(nick);
				
				
				//3. console�� true/false(��ȯ��) ���
				PrintWriter out = response.getWriter();
				out.print(check);
			
				
			
			
			}

		

	}


