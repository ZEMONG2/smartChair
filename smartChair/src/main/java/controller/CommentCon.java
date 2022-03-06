package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import dao.tb_commentDAO;
import vo.tb_userVO;


@WebServlet("/CommentCon")
public class CommentCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		tb_userVO vo = (tb_userVO)session.getAttribute("loginVO");
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer(); //읽어온 데이터 저장
		String line = null; // 버퍼안에 데이터 읽을때 사용(임시저장)
		String user_id = vo.getUser_id();
		BufferedReader reader = request.getReader(); // 요청데이터 읽을때 사용
		while((line = reader.readLine()) != null) { // 읽을 데이터가 있을때 반복 수행
			sb.append(line); // 읽어온 데이터를 sb(stringbuffer)에 추가			
		}
		
		JsonParser parser = new JsonParser(); // 파싱(문자열 -> JSON)
		JsonElement element = parser.parse(sb.toString()); //버퍼데이터 문자열로 변경후 JSON으로 변경
		
		int article_seq = element.getAsJsonObject().get("article_seq").getAsInt(); // 키값이 id인 데이터
		String comment = element.getAsJsonObject().get("reply").getAsString(); // 키값이 pw인 데이터
		
		System.out.println("게시물번호 : " + article_seq);
		System.out.println("댓글 : " + comment);
		
		
		//로그인 가능할 경우 콘솔창에 : 로그인성공 출력 (페이지이동 x)
		//로그인 불가능할 경우 콘솔창에 : 로그인실패 출력 (페이지이동 x)
		tb_commentDAO dao = new tb_commentDAO();
		int cnt = dao.insertReply(article_seq, comment, user_id);
		
		
		
		if (cnt > 0) {
			out.print("success");
		}else {
			out.print("fail");
		}
		
		
		
		
	}

}
