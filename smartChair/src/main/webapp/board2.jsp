<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="vo.tb_userVO"%>
<%@page import="dao.tb_communityDAO"%>
<%@page import="dao.tb_userDAO"%>
<%@page import="vo.tb_communityVO"%>
<%@page import="dao.tb_commentDAO"%>
<%@page import="vo.tb_commentVO"%>
  <%@page import="java.net.InetAddress"%>
   <%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width,height=device-height, initial-scale=1, shrink-to-fit=no, user-scalable = yes">
<meta name="description" content="">
<meta name="author" content="">

<title>MESSIAH - List</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.css" rel="stylesheet">
<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body style = "
	
        height: 100vh;
        background-image: url('images/bg.jpg');
        background-repeat : no-repeat;
        background-size : cover;
      
" >
	<%
	tb_userVO vo = (tb_userVO) session.getAttribute("loginVO");
	String article_seq = request.getParameter("article_seq");
	int articleSEQ = Integer.parseInt(article_seq);
	
	
	tb_communityDAO dao = new tb_communityDAO();
	tb_communityVO voList = dao.selectOne(articleSEQ);
	
	tb_commentDAO daoReply = new tb_commentDAO();
	ArrayList<tb_commentVO> al = daoReply.selectAll(articleSEQ);
	
	System.out.println("디비에서 불러온 아이피 : " + voList.getUser_ip());
	
	
	 tb_userDAO dao2 = new tb_userDAO();
	 String db_user_nick = dao2.articleNick(articleSEQ);
		
	 String user_ip=request.getRemoteAddr();
	 if(user_ip.equalsIgnoreCase("0:0:0:0:0:0:0:1")){
	     InetAddress inetAddress=InetAddress.getLocalHost();
	     user_ip=inetAddress.getHostAddress();
	 }
	 System.out.println("클라이언트IP 주소2: "+user_ip);
	 
	%>



	<!-- Page Wrapper -->
	
	<div id="wrapper">

		<!-- Sidebar -->
		
				<div class="container-fluid">
					<!-- Page Heading -->

				
							<div></div>
							<table style= "width: 80%;
											height: 300px;
											margin-left: 10%; 
											margin-right: 10%; 
											margin-top : 10%;
											border-top: 3px solid white; 
											border-bottom : 3px solid white;
											color : white;
											">
								
								<tr>
									<th><h2><%=voList.getArticle_title()%> </h2></th>
									
								</tr>
								<tr style = "border-bottom : 3px solid white; height : 20px;">
									<td style="width : 80%"><%=db_user_nick %>&nbsp;&nbsp;(<%=voList.getUser_id()%>) &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<%=voList.getArticle_date()%></td>
								
								
									<td>추천수 : <%=voList.getArticle_likes()%></td>
								
									<td>조회수 : <%=voList.getArticle_cnt()%></td>
								</tr>
								<tr>
									<td style="text-align: center; height : auto;" colspan="3"><%if(voList.getArticle_file() != null){
																								%><img src="http://<%=voList.getUser_ip() %>:8081/smartChair/FileUpload/<%=voList.getArticle_file() %>"style = "width : 300px; height : 300px;"><br><br>
																								<%}else{ %>
																								<%} %>
									
									
									<br><pre style = "color : white; font-size : 20px;" ><%=voList.getArticle_content()%></pre></td>
								</tr>
							</table><br><br>
							<div class="like-content" style = "display: inline-block;
															    width: 100%;
															   color : white;
															    font-size: 18px;
															    text-align: center;">
											    

								 
								  </div>
							</div>
							<div style = "text-align : center;">
							</div>
							</div>
							
							
							<table style = "width : 78%; border-bottom : 3px solid white; margin:auto; ">
			<tr style = "border-bottom : 3px solid white; color : white; text-align : center;">
				<th>댓글</th>
				<th>작성자 | 작성시간</th>
				<th style = "text-align : center;">삭제</th>
			
			</tr>
			<%
  			for(int i = al.size()-1; i>=0;i--){
 			 %>
			
			<tr style = " border-bottom : 3px solid white; height : 60px; text-align : left; color : white;">
				<td style = "font-color : white;">&nbsp;&nbsp;&nbsp;&nbsp;<%=al.get(i).getComment_content()%></td>
				<td style = "text-align : center; font-color : white;"><%=al.get(i).getUser_id()%>&nbsp;&nbsp;|&nbsp;&nbsp; <%=al.get(i).getComment_date()%></td>
				<td style = "text-align : center; font-color : white;">
				<%if(al.get(i).getUser_id().equals(vo.getUser_id())){%>
									         		<a href="DeleteCommentCon?comment_seq=<%=al.get(i).getComment_seq() %>">삭제</a>
									         	<%}%>
				
				
				</td>
			</tr>
			<%
			} 
			%>
			
			</table>
			<br><br>
							<div style = "text-align : center;">
								<button type="reset" class="ml-2 btn btn-primary" onclick = "window.history.back()">돌아가기</button>
							</div>
					<div id="bg"></div>	
						
		

				<script type="text/javascript"
					src="js/need_check.js?v=<%=new java.util.Date().getTime()%>"></script>
				<script type="text/javascript" src="js/file_attach.js"></script>
				
				<!-- 좋아요 버튼 -->
				<script>
				$(function(){
					$(document).one('click', '.like-review', function(e) {
					$(this).html('<i class="fa fa-heart" aria-hidden="true"></i> You liked this');
					$(this).children('.fa-heart').addClass('animate-like');
					});
					});
				
				</script>
				
				<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			<script src="vendor/jquery/jquery.min.js"></script>
    
   			<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
				
</body>
</html>