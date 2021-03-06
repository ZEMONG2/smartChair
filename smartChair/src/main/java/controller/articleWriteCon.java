package controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.tb_communityDAO;
import vo.tb_userVO;


@WebServlet("/articleWriteCon")
public class articleWriteCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		tb_userVO vo = (tb_userVO)session.getAttribute("loginVO");
		ServletContext context = getServletContext();
		String saveDir = context.getRealPath("FileUpload");
		System.out.println(saveDir);
		int maxSize = 3 * 1024 * 1024 ;
		String encoding ="euc-kr";
		//String path = "http://172.30.1.38:8081/smartChair/FileUpload/";
		boolean isMulti = ServletFileUpload.isMultipartContent(request);
		if(isMulti) {
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		
			tb_communityDAO dao = new tb_communityDAO();
			String article_file ="";
			String user_id = vo.getUser_id(); 
			String article_title = multi.getParameter("title");
			String article_content = multi.getParameter("content");
			if(multi.getFilesystemName("file") != null) {
				article_file = URLEncoder.encode(multi.getFilesystemName("file"));
				System.out.println("파일명 : " +article_file);
			}
			
		
			System.out.println("아이디 : " +user_id);
			System.out.println("제목 : " +article_title);
			System.out.println("내용 : "+article_content);
			
			
			
			 String user_ip=request.getRemoteAddr();
			 if(user_ip.equalsIgnoreCase("0:0:0:0:0:0:0:1")){
			     InetAddress inetAddress=InetAddress.getLocalHost();
			     user_ip=inetAddress.getHostAddress();
			 }
			 System.out.println("클라이언트IP 주소: "+user_ip);
			
			
			try {
				if(article_file != null) {
				int cnt = dao.inputCommunity(article_title, article_content, article_file, user_id, user_ip);
				String moveUrl = "";
				if(cnt > 0) {
					System.out.println("저장완료");
				moveUrl = "listCreateS.jsp";
				}else {
					System.out.println("저장실패");
					moveUrl = "listCreateF.jsp";
					
				}
				response.sendRedirect(moveUrl);
				}else {
					int cnt = dao.inputCommunity2(article_title, article_content, user_id, user_ip);
					String moveUrl = "";
					if(cnt > 0) {
						System.out.println("저장완료");
					moveUrl = "listCreateS.jsp";
					}else {
						System.out.println("저장실패");
						moveUrl = "listCreateF.jsp";
						
					}
					response.sendRedirect(moveUrl);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
		}else {
			System.out.println("일반 전송 폼 입니다.");
		}

	}

}
