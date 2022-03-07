<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Dimension by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<%@page import="vo.tb_communityVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.tb_communityDAO"%>
<%@page import="vo.tb_userVO"%>
<html>
	<head>
		<title>MESSIAH - Main</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<style>
	ul {
    text-align: center;
    display: inline-block;
    border: 1px solid #ccc;
    border-right: 0;
}

ul li {
    text-align: center;
    float: left;
}

ul li a {
    display: block;
    font-size: 14px;
    padding: 9px 12px;
    border-right: solid 1px #ccc;
    box-sizing: border-box;
    text-align : center;
}

ul li.on {
    background: #eda712;
}

ul li.on a {
    color: #fff;
}
	</style>
	<body class="is-preload">
	
	<%
tb_userVO vo = (tb_userVO)session.getAttribute("loginVO");

tb_communityDAO dao = new tb_communityDAO();
ArrayList<tb_communityVO> al = dao.outputCommunity();
%>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<div class="logo">
							<span class="icon fa-gem"></span>
						</div>
						<div class="content">
							<div class="inner">
								<h1>MESSIAH</h1>
								<p>저희 MESSIAH가 당신의 허리와 목을 지켜드립니다.</p>
							</div>
						</div>
						<nav>
							<ul>
								<li><a href="#intro">INTRO</a></li>
								<li><a href="login.jsp">LOGIN</a></li>
								<li><a href="register.html">SIGNUP</a></li>
								<li><a href="#content">COMMUNITY</a></li>
								
							</ul>
						</nav>
					</header>

				<!-- Main -->
					<div id="main">

						<!-- Intro -->
							<article id="intro">
								<h2 class="major">Intro</h2>
								<span class="image main"><img src="images/pic01.jpg" alt="" /></span>
								<p>제품 자세 설명 란 </p>
								<p>제품 자세 설명 란 </p>
							</article>
							
							<article id="content" style = "width: 1200px;">
								<h2 class="major">Community</h2>
								<span class="image main"><img src="images/pic01.jpg" alt="" /></span>
								<div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                
                                    <thead>
                                    
                                         <tr>
								            <th style = "width : 5%; text-align : center;">번호</th>
								            <th style = "width : 20%; text-align : center;">제목</th>
								            <th style = "width : 15%; text-align : center;">작성자</th>
								            <th style = "width : 10%; text-align : center;">작성날짜</th>
								            <th style = "width : 5%; text-align : center;">추천</th>
								            <th style = "width : 5%; text-align : center;">조회</th>
								          </tr>
                                    </thead>
                                    <tfoot>
                                         <tr>
								            <th style = "text-align : center;">번호</th>
								            <th style = "text-align : center;">제목</th>
								            <th style = "text-align : center;">작성자</th>
								            <th style = "text-align : center;">작성날짜</th>
								            <th style = "text-align : center;">추천</th>
								            <th style = "text-align : center;">조회</th>
								          </tr>
                                    </tfoot>
                                    <tbody>
                                        <%
									        for(int i =0;i<al.size();i++){
									        	
									        
									        %>
									         <tr style = "text-align : center;">
									         	<td><%=al.get(i).getArticle_seq() %></td>
									         	<td><a href="board2.jsp?article_seq=<%=al.get(i).getArticle_seq() %>"><%=al.get(i).getArticle_title() %></a></td>
									         	<td><%=al.get(i).getUser_id() %></td>
									         	<td><%=al.get(i).getArticle_date() %></td>
									         	<td><%=al.get(i).getArticle_likes() %></td>
									         	<td><%=al.get(i).getArticle_cnt() %></td>
									         </tr>
									         <%} %>
                                    </tbody>
                                    
                                </table>
                            
								
                            </div>
                        </div>
							</article>

					</div>

				<!-- Footer -->
					<footer id="footer">
						<p class="copyright">&copy; Untitled. Design: HTML5 UP.</p>
					</footer>

			</div>

		<!-- BG -->
			<div id="bg"></div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			<script src="vendor/jquery/jquery.min.js"></script>
    
   			<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>
   			
   			
	</body>
</html>
