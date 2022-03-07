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
								<li><a href="#intro">Intro</a></li>
								<li><a href="login.jsp">LOG IN</a></li>
								<li><a href="register.html">SIGN UP</a></li>
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
							
							<article id="content" style = "width: 1300px;">
								<h2 class="major">community</h2>
								<span class="image main"><img src="images/pic01.jpg" alt="" /></span>
								<div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                
                                    <thead>
                                    
                                         <tr>
								            <th style = "width : 5%; text-align : center;">번호</th>
								            <th style = "width : 45%; text-align : center;">제목</th>
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
									         	<td><a href="board.jsp?article_seq=<%=al.get(i).getArticle_seq() %>"><%=al.get(i).getArticle_title() %></a></td>
									         	<td><%=al.get(i).getUser_id() %></td>
									         	<td><%=al.get(i).getArticle_date() %></td>
									         	<td><%=al.get(i).getArticle_likes() %></td>
									         	<td><%=al.get(i).getArticle_cnt() %></td>
									         </tr>
									         <%} %>
                                    </tbody>
                                    
                                </table>
                                <select id="dataPerPage">
							        <option value="10">10개씩보기</option>
							        <option value="15">15개씩보기</option>
							        <option value="20">20개씩보기</option>
								</select>
								<ul id="pagingul">
								
								</ul>
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
    
   			
   			<script>
   			let totalData; //총 데이터 수
   			let dataPerPage; //한 페이지에 나타낼 글 수
   			let pageCount = 10; //페이징에 나타낼 페이지 수
   			let globalCurrentPage=1; //현재 페이지

   			$(document).ready(function () {
   			 //dataPerPage 선택값 가져오기
   			 dataPerPage = $("#dataPerPage").val();
   			 
   			 $.ajax({ // ajax로 데이터 가져오기
   				method: "GET",
   				url: "https://url/data?" + data,
   				dataType: "json",
   				success: function (d) {
   				   //totalData 구하기
   				   totalData = d.data.length;
   			 });
   			 
   			 //글 목록 표시 호출 (테이블 생성)
   			 displayData(1, dataPerPage);
   			 
   			 //페이징 표시 호출
   			 paging(totalData, dataPerPage, pageCount, 1);
   			});
   			
   			function paging(totalData, dataPerPage, pageCount, currentPage) {
   			  console.log("currentPage : " + currentPage);

   			  totalPage = Math.ceil(totalData / dataPerPage); //총 페이지 수
   			  
   			  if(totalPage<pageCount){
   			    pageCount=totalPage;
   			  }
   			  
   			  let pageGroup = Math.ceil(currentPage / pageCount); // 페이지 그룹
   			  let last = pageGroup * pageCount; //화면에 보여질 마지막 페이지 번호
   			  
   			  if (last > totalPage) {
   			    last = totalPage;
   			  }

   			  let first = last - (pageCount - 1); //화면에 보여질 첫번째 페이지 번호
   			  let next = last + 1;
   			  let prev = first - 1;

   			  let pageHtml = "";

   			  if (prev > 0) {
   			    pageHtml += "<li><a href='#' id='prev'> 이전 </a></li>";
   			  }

   			 //페이징 번호 표시 
   			  for (var i = first; i <= last; i++) {
   			    if (currentPage == i) {
   			      pageHtml +=
   			        "<li class='on'><a href='#' id='" + i + "'>" + i + "</a></li>";
   			    } else {
   			      pageHtml += "<li><a href='#' id='" + i + "'>" + i + "</a></li>";
   			    }
   			  }

   			  if (last < totalPage) {
   			    pageHtml += "<li><a href='#' id='next'> 다음 </a></li>";
   			  }

   			  $("#pagingul").html(pageHtml);
   			  let displayCount = "";
   			  displayCount = "현재 1 - " + totalPage + " 페이지 / " + totalData + "건";
   			  $("#displayCount").text(displayCount);


   			  //페이징 번호 클릭 이벤트 
   			  $("#pagingul li a").click(function () {
   			    let $id = $(this).attr("id");
   			    selectedPage = $(this).text();

   			    if ($id == "next") selectedPage = next;
   			    if ($id == "prev") selectedPage = prev;
   			    
   			    //전역변수에 선택한 페이지 번호를 담는다...
   			    globalCurrentPage = selectedPage;
   			    //페이징 표시 재호출
   			    paging(totalData, dataPerPage, pageCount, selectedPage);
   			    //글 목록 표시 재호출
   			    displayData(selectedPage, dataPerPage);
   			  });
   			}
   			
   		//현재 페이지(currentPage)와 페이지당 글 개수(dataPerPage) 반영
   			function displayData(currentPage, dataPerPage) {

   			  let chartHtml = "";

   			//Number로 변환하지 않으면 아래에서 +를 할 경우 스트링 결합이 되어버림.. 
   			  currentPage = Number(currentPage);
   			  dataPerPage = Number(dataPerPage);
   			  
   			  for (
   			    var i = (currentPage - 1) * dataPerPage;
   			    i < (currentPage - 1) * dataPerPage + dataPerPage;
   			    i++
   			  ) {
   			    chartHtml +=
   			      "<tr><td>" +
   			      dataList[i].d1 +
   			      "</td><td>" +
   			      dataList[i].d2 +
   			      "</td><td>" +
   			      dataList[i].d3 +
   			      "</td></tr>";
   			  }
   			  $("#dataTableBody").html(chartHtml);
   			}
   		
   			$("#dataPerPage").change(function () {
   			    dataPerPage = $("#dataPerPage").val();
   			    //전역 변수에 담긴 globalCurrent 값을 이용하여 페이지 이동없이 글 표시개수 변경 
   			    paging(totalData, dataPerPage, pageCount, globalCurrentPage);
   			    displayData(globalCurrentPage, dataPerPage);
   			 });
   			</script>
   			
   			
	</body>
</html>
