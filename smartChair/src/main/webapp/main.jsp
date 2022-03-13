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
								<p>저희 MESSIAH가 당신의 척추건강을 지켜드립니다.</p>
							</div>
						</div>
						<nav>
							<ul>
								<li><a href="#intro">INTRO</a></li>
								<li><a href="login.jsp">LOGIN</a></li>
								<li><a href="register.html">SIGNUP</a></li>
								<li><a href="#content">ARTICLE</a></li>
								
							</ul>
						</nav>
					</header>

				<!-- Main -->
					<div id="main">

						<!-- Intro -->
							<article id="intro">
								<h2 class="major">Intro</h2>
								<span class="image main"><iframe width="560" height="315" src="https://www.youtube.com/embed/5ch94AaPZRQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></span>
								<h2> MESSIAH</h2>
								<p> 저희 MESSIAH는 자세교정과 책상의 높이조절을 동시에 할 수 있는 제품입니다. 자세교정용 압력센서를 통해 사용자의 앉은자세를 체크하고 의자에 앉아 책상의 높이를 조절하고 책상의 
									디스플레이에서도 바로 책상 높이를 제어할 수 있습니다. 사용자에게 자신의 앉은자세 정보를 웹페이지에서 한눈에 보기 쉽게 제공하고 또한 웹페이지에서도
									책상의 높이를 조절할 수 있습니다. 이번기회에 MESSIAH를 사용함으로 당신의 안좋은 자세를 교정해보세요.
							</p>
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
