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

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body>
	<%
	tb_userVO vo = (tb_userVO) session.getAttribute("loginVO");
	String article_seq = request.getParameter("article_seq");
	int articleSEQ = Integer.parseInt(article_seq);
	
	
	tb_communityDAO dao = new tb_communityDAO();
	tb_communityVO voList = dao.selectOne(articleSEQ);
	
	tb_commentDAO daoReply = new tb_commentDAO();
	ArrayList<tb_commentVO> al = daoReply.selectAll();
	
	System.out.println("디비에서 불러온 아이피 : " + voList.getUser_ip());
	
	
	 if(!vo.getUser_id().equals(voList.getUser_id())){
		 dao.updateViews(articleSEQ);
		
	} 
	 
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
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="index.jsp">
				<div class="sidebar-brand-icon rotate-n-0">
					<img src="img/ㄴㅇ.png"><br>

				</div>

				<div class="sidebar-brand-text mx-3">Messiah</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link" href="index.jsp">
					<i class="fas fa-fw fa-tachometer-alt"></i> <span>메인화면</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Interface</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link" href="buttons.jsp">
					<i class="fas fa-fw fa-cogs"></i> <span>높이조절</span>
			</a></li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<!-- <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>기능</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Custom Utilities:</h6>
                        <a class="collapse-item" href="utilities-color.html">Colors</a>
                        <a class="collapse-item" href="utilities-border.html">Borders</a>
                        <a class="collapse-item" href="utilities-animation.html">Animations</a>
                        <a class="collapse-item" href="utilities-other.html">Other</a>
                    </div>
                </div>
            </li> -->

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Addons</div>

			<!-- Nav Item - Pages Collapse Menu -->
			

			<!-- Nav Item - Charts -->
			<li class="nav-item"><a class="nav-link" href="charts.jsp">
					<i class="fas fa-fw fa-chart-area"></i> <span>차트</span>
			</a></li>

			<!-- Nav Item - Tables -->
			<li class="nav-item"><a class="nav-link" href="tables.jsp">
					<i class="fas fa-fw fa-table"></i> <span>사용자테이블</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="list.jsp"> <i
					class="fas fa-fw fa-table"></i> <span>게시판</span></a></li>

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

			<!-- Sidebar Message -->


		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Search -->
					<form
						class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
						<div class="input-group">
							<input type="text" class="form-control bg-light border-0 small"
								placeholder="Search for..." aria-label="Search"
								aria-describedby="basic-addon2">
							<div class="input-group-append">
								<button class="btn btn-primary" type="button">
									<i class="fas fa-search fa-sm"></i>
								</button>
							</div>
						</div>
					</form>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>

						<!-- Nav Item - Alerts -->
						<li class="nav-item dropdown no-arrow mx-1"><a
							class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <!-- Counter - Alerts -->
								<span class="badge badge-danger badge-counter">3+</span>
						</a> <!-- Dropdown - Alerts -->
							<div
								class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="alertsDropdown">
								<h6 class="dropdown-header">Alerts Center</h6>
								<a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-primary">
											<i class="fas fa-file-alt text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 12, 2019</div>
										<span class="font-weight-bold">A new monthly report is
											ready to download!</span>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-success">
											<i class="fas fa-donate text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 7, 2019</div>
										$290.29 has been deposited into your account!
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-warning">
											<i class="fas fa-exclamation-triangle text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 2, 2019</div>
										Spending Alert: We've noticed unusually high spending for your
										account.
									</div>
								</a> <a class="dropdown-item text-center small text-gray-500"
									href="#">Show All Alerts</a>
							</div></li>

						<!-- Nav Item - Messages -->
						<li class="nav-item dropdown no-arrow mx-1"><a
							class="nav-link dropdown-toggle" href="#" id="messagesDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-envelope fa-fw"></i>
								<!-- Counter - Messages --> <span
								class="badge badge-danger badge-counter">7</span>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="messagesDropdown">
								<h6 class="dropdown-header">Message Center</h6>
								<a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle" src="img/undraw_profile_1.svg"
											alt="...">
										<div class="status-indicator bg-success"></div>
									</div>
									<div class="font-weight-bold">
										<div class="text-truncate">Hi there! I am wondering if
											you can help me with a problem I've been having.</div>
										<div class="small text-gray-500">Emily Fowler · 58m</div>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle" src="img/undraw_profile_2.svg"
											alt="...">
										<div class="status-indicator"></div>
									</div>
									<div>
										<div class="text-truncate">I have the photos that you
											ordered last month, how would you like them sent to you?</div>
										<div class="small text-gray-500">Jae Chun · 1d</div>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle" src="img/undraw_profile_3.svg"
											alt="...">
										<div class="status-indicator bg-warning"></div>
									</div>
									<div>
										<div class="text-truncate">Last month's report looks
											great, I am very happy with the progress so far, keep up the
											good work!</div>
										<div class="small text-gray-500">Morgan Alvarez · 2d</div>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle"
											src="https://source.unsplash.com/Mv9hjnEUHR4/60x60" alt="...">
										<div class="status-indicator bg-success"></div>
									</div>
									<div>
										<div class="text-truncate">Am I a good boy? The reason I
											ask is because someone told me that people say this to all
											dogs, even if they aren't good...</div>
										<div class="small text-gray-500">Chicken the Dog · 2w</div>
									</div>
								</a> <a class="dropdown-item text-center small text-gray-500"
									href="#">Read More Messages</a>
							</div></li>

						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small"><%=vo.getUser_nick()%></span>
								<img class="img-profile rounded-circle"
								src="img/undraw_profile.svg">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="profile.jsp"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
								</a> 
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="LogoutCon" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->
				<div class="container-fluid">
					<!-- Page Heading -->
					<h1 class="h3 mb-4 text-gray-800">게시물</h1>

				</div>
				
					
					
							<div></div>
							<table style= "width: 80%;
											height: 300px;
											margin-left: 10%; 
											margin-right: 10%; 
											border-top: 2px solid blue; 
											border-bottom : 1px solid gray;
											">
								
								<tr>
									<th><h2><%=voList.getArticle_title()%> </h2></th>
									
								</tr>
								<tr style = "border-bottom : 2px solid gray; height : 20px;">
									<td style="width : 80%"><%=db_user_nick %>&nbsp;&nbsp;(<%=voList.getUser_id()%>) &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<%=voList.getArticle_date()%></td>
								
								
									<td>추천수 : <%=voList.getArticle_likes()%></td>
								
									<td>조회수 : <%=voList.getArticle_cnt()%></td>
								</tr>
								<tr>
									<td style="text-align: center; height : auto;" colspan="2" ><%if(voList.getArticle_file() != null){
																								%><img src="http://<%=voList.getUser_ip() %>:8081/smartChair/FileUpload/<%=voList.getArticle_file() %>"
																								<%}else{ %>
																								<%} %>
									}
									style = "width : 300px; height : 300px;"><br><br>
									<br><pre><%=voList.getArticle_content()%></pre></td>
								</tr>
							</table><br><br>
							<div class="like-content" style = "display: inline-block;
															    width: 100%;
															   
															    font-size: 18px;
															    text-align: center;">
															    
															    
															    
															    
															    
															    
															    
															    
															    
								<!-- 댓글작성 -->
	<div class="card mb-2">
		<div class="card-body">
			<p>댓글</p>
			<ul class="list-group list-group-flush">
				<li class="list-group-item">
					<textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
					<button type="button" class="btn btn-dark mt-3"onclick="addReply()">댓글작성</button>
				</li>
			</ul>
			<ul class="list-group list-group-flush" id="reply">

				
			<%
  			for(int i = al.size()-1; i>=0;i--){
 			 %>
			
				<li class="list-group-item"><span><%=al.get(i).getUser_id()%> : <%=al.get(i).getComment_content()%></span></li>
			
			<%
			} 
			%>
			</ul>
		</div>
	</div>
	

  
								  <button class="btn-secondary like-review">
								    <i class="fa fa-heart" aria-hidden="true"></i> Like
								  </button>
								<button type="reset" class="ml-2 btn btn-primary" onclick = "location.href = 'list.jsp'">돌아가기</button>
								  
							</div>
							<div style = "text-align : center;">
							</div>
							</div>
						
						<div class="btnSet">
						</div>
						<br>
						<br>
						<br>
						<br>
						<br>
					
				<script>


function addReply(){
	let ta = document.querySelector('textarea')
	let replyDiv = document.querySelector('#reply')
	
	//JSON({키 : 실제값}) 형식 데이터 만들기
	let data = {'boardnum' : <%=num %>, 'reply' : ta.value}
	
	let xhr = new XMLHttpRequest()
	
	//요청방식, 요청경로
	xhr.open('post', 'replyService')
	//전송데이터의 형식
	xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8')
	//요청 & 전송할 데이터
	xhr.send(JSON.stringify(data))
	
	xhr.onreadystatechange = function(){
		
		if (xhr.readyState === XMLHttpRequest.DONE) { //요청성공
            if (xhr.status === 200) { //응답성공	                    	
            	console.log("응답성공")
            	console.log(xhr.responseText) //응답데이터 확인 (responseXML)
            	if(xhr.responseText === "success"){
            		//history.go(0);
            		var newli = document.createElement("li");
                    replyDiv.insertBefore(newli, replyDiv.firstChild);
                    replyDiv.firstChild.setAttribute("class","list-group-item")
                    replyDiv.firstChild.innerHTML += "<span><%=member.getId()%> : " +ta.value + "</span>"
                    ta.value="";
            	} else {
            	}
            } else {
                console.log("응답실패")
            }
        } else {
            console.log("요청실패")
        }
		
	}
}				    
</script>

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
</body>
</html>