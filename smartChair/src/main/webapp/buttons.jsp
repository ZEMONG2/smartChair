<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
        <%@page import="vo.tb_userVO"%>
        <%@page import="vo.tb_poseVO"%>
	<%@page import="java.util.ArrayList"%>
	<%@page import="dao.tb_poseDAO"%>
	<%@page import="java.util.Date"%>
	<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,height=device-height, initial-scale=1, shrink-to-fit=no, user-scalable = yes">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>MESSIAH - DeskControl</title>

    
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

   
    <link href="css/sb-admin-2.css" rel="stylesheet">
   
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
</head>

<body id="page-top">
<%
tb_userVO vo = (tb_userVO)session.getAttribute("loginVO");
SimpleDateFormat today = new SimpleDateFormat("yyyyMMdd");
Date now = new Date();
String nowTime = today.format(now);

tb_poseDAO dao = new tb_poseDAO();
ArrayList<tb_poseVO> al = dao.pose_type(nowTime);
int right = al.get(0).getCount();
int back = al.get(1).getCount();
int left = al.get(2).getCount();
int common = al.get(3).getCount();
int total = (right + back + left + common)/56;
int commonTime = common/35;
ArrayList<tb_poseVO> al2 = dao.pose_type2();
int jan = al2.get(0).getCount();
int feb = al2.get(1).getCount();
int mar = al2.get(2).getCount();
int apr = al2.get(3).getCount();
int may = al2.get(4).getCount();
int jun = al2.get(5).getCount();
int jul = al2.get(6).getCount();
int aug = al2.get(7).getCount();
int sep = al2.get(8).getCount();
int oct = al2.get(9).getCount();
int nov = al2.get(10).getCount();
int dec = al2.get(11).getCount();


ArrayList<tb_poseVO> al3 = dao.pose_type3();
int mon = al3.get(0).getCount()*2/60;
int tue = al3.get(1).getCount()*2/60;
int wed = al3.get(2).getCount()*2/60;
int thu = al3.get(3).getCount()*2/60;
int fri = al3.get(4).getCount()*2/60;
int sat = al3.get(5).getCount()*2/60;
int sun = al3.get(6).getCount()*2/80;
int total2 = (mon+tue+wed+thu+fri+sat+sun);
%>
    
    <div id="wrapper">

        
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

           
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
                <div class="sidebar-brand-icon rotate-n-0">
                    <img src="img/logo.png" ><br>
                   
                </div>
                
                <div class="sidebar-brand-text mx-3">Messiah</div>
            </a>

           
            <hr class="sidebar-divider my-0">

            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>메인화면</span></a>
            </li>

            <hr class="sidebar-divider">

            <div class="sidebar-heading">
                Interface
            </div>

            <li class="nav-item">
                <a class="nav-link" href="buttons.jsp">
                    <i class="fas fa-fw fa-cogs"></i>
                    <span>높이조절</span></a>
            </li>

           

            <hr class="sidebar-divider">

            <div class="sidebar-heading">
                Addons
            </div>

            

            <li class="nav-item">
                <a class="nav-link" href="charts.jsp">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>차트</span></a>
            </li>

            <% if(vo.getAdmin_yesno().equals("Y")){ %>
            <li class="nav-item">
                <a class="nav-link" href="tables.jsp">
                    <i class="fas fa-fw fa-table"></i>
                    <span>사용자테이블</span></a>
            </li>
            <% }else{%>
            <%}%>
            <li class="nav-item">
                <a class="nav-link" href="list.jsp">
                    <i class="fas fa-fw fa-table"></i>
                    <span>게시판</span></a>
            </li>

            <hr class="sidebar-divider d-none d-md-block">

            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

            

        </ul>

        <div id="content-wrapper" class="d-flex flex-column">

            <div id="content">

                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>

                    <ul class="navbar-nav ml-auto">

                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
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
                            </div>
                        </li>

                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-bell fa-fw"></i>
                                <span class="badge badge-danger badge-counter">3+</span>
                            </a>
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="alertsDropdown">
                                <h6 class="dropdown-header">
                                    Alerts Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-primary">
                                            <i class="fas fa-file-alt text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 12, 2019</div>
                                        <span class="font-weight-bold">A new monthly report is ready to download!</span>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-success">
                                            <i class="fas fa-donate text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 7, 2019</div>
                                        $290.29 has been deposited into your account!
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-warning">
                                            <i class="fas fa-exclamation-triangle text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 2, 2019</div>
                                        Spending Alert: We've noticed unusually high spending for your account.
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                            </div>
                        </li>

                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-envelope fa-fw"></i>
                                <span class="badge badge-danger badge-counter">7</span>
                            </a>
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="messagesDropdown">
                                <h6 class="dropdown-header">
                                    Message Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="img/undraw_profile_1.svg"
                                            alt="...">
                                        <div class="status-indicator bg-success"></div>
                                    </div>
                                    <div class="font-weight-bold">
                                        <div class="text-truncate">Hi there! I am wondering if you can help me with a
                                            problem I've been having.</div>
                                        <div class="small text-gray-500">Emily Fowler · 58m</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="img/undraw_profile_2.svg"
                                            alt="...">
                                        <div class="status-indicator"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">I have the photos that you ordered last month, how
                                            would you like them sent to you?</div>
                                        <div class="small text-gray-500">Jae Chun · 1d</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="img/undraw_profile_3.svg"
                                            alt="...">
                                        <div class="status-indicator bg-warning"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">Last month's report looks great, I am very happy with
                                            the progress so far, keep up the good work!</div>
                                        <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60"
                                            alt="...">
                                        <div class="status-indicator bg-success"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">Am I a good boy? The reason I ask is because someone
                                            told me that people say this to all dogs, even if they aren't good...</div>
                                        <div class="small text-gray-500">Chicken the Dog · 2w</div>
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
                            </div>
                        </li>

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=vo.getUser_nick()%></span>
                                <img class="img-profile rounded-circle"
                                    src="img/undraw_profile.svg">
                            </a>
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="profile.jsp">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="LogoutCon" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>

                <div class="container-fluid">

                    <h1 class="h3 mb-4 text-gray-800">높낮이 조절</h1>

                     <div class="row">
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                사용자 이름</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><%=vo.getUser_nick()%></div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-user fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                일일 앉아있던 시간</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><%=total %>시간</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-clock fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-info shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">주간 평균 앉아있던 시간
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"><%=total2 %>시간</div>
                                                </div>
                                                <div class="col">
                                                    
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-clock fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-warning shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                               일간 정자세로 앉아있던 시간</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><%=commonTime %>시간</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-exclamation-triangle fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">

                        <div class="col-lg-6">


                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">높이 조작 높이조절</h6>
                                </div>
                                <div class="card-body ">
                                    <a href="Upbutton" class="btn btn-primary btn-icon-split btn-lg">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-arrow-up"></i>
                                        </span>
                                        <span class="text">책상 높이 증가</span>
                                    </a><br><br>
                                    <a href="Downbutton" class="btn btn-primary btn-icon-split btn-lg">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-arrow-down"></i>
                                        </span>
                                        <span class="text">책상 높이 감소</span>
                                    </a><br><br>
                                   <a href="Stopbutton" class="btn btn-warning btn-icon-split btn-lg">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-exclamation-triangle"></i>
                                        </span>
                                        <span class="text">책상 높이 정지</span>
                                    </a><br><br>
                                   
                                   
                                    

                                </div>
                            </div>

                        </div>

                        <div class="col-lg-6">

                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">신장에 따른 바람직한 책상의 높이</h6>
                                </div>
                                <div class="card-body">
                                <table class="table table-striped">
									  <thead>
									    <tr align = "center">
									      <th scope="col">신장</th>
									      <th scope="col">책상높이</th>
									      <th scope="col">의자높이</th>
									    </tr>
									  </thead>
									  <tbody>
									    

                                        <tr align="center">
                                            <td>112 ~ 126cm</td> 
                                            <td>53cm</td> 
                                            <td>35cm</td> 

                                        </tr>

                                        <tr align="center">
                                            <td>127 ~ 135cm</td> 
                                            <td>56cm</td> 
                                            <td>37cm</td> 

                                        </tr>

                                        <tr align="center">
                                            <td>136 ~ 143cm</td> 
                                            <td>59cm</td> 
                                            <td>37cm</td> 

                                        </tr>

                                        <tr align="center">
                                            <td>144 ~ 152cm</td> 
                                            <td>63cm</td> 
                                            <td>42cm</td> 

                                        </tr>

                                        <tr align="center">
                                            <td>153 ~ 160cm</td> 
                                            <td>66cm</td> 
                                            <td>44cm</td> 

                                        </tr>

                                        <tr align="center">
                                            <td>161 ~ 168cm</td> 
                                            <td>69cm</td> 
                                            <td>47cm</td> 

                                        </tr>

                                        <tr align="center">
                                            <td>169 ~ 177cm</td> 
                                            <td>72cm</td> 
                                            <td>50cm</td> 

                                        </tr>

                                        <tr align="center">
                                            <td>178 ~ 186cm</td> 
                                            <td>75cm</td> 
                                            <td>52cm</td> 

                                        </tr>

                                        <tr align="center">
                                            <td>187 ~ 194cm</td> 
                                            <td>79cm</td> 
                                            <td>54cm</td> 

                                        </tr>

                                        <tr align="center">
                                            <td>195 ~ 202cm</td> 
                                            <td>82cm</td> 
                                            <td>56cm</td> 

                                        </tr>
									  </tbody>
									</table>
                                   <!--  <table border="1px" width = "100%" border-radius = "10%">
                                        <tr bgcolor = "reduce" align="center">
                                            <th>신장</th>
                                            <th>책상높이</th>
                                            <th>의자높이</th>
                                        </tr>

                                        <tr align="center">
                                            <td>112 ~ 126cm</td> 
                                            <td>53cm</td> 
                                            <td>35cm</td> 

                                        </tr>

                                        <tr align="center">
                                            <td>127 ~ 135cm</td> 
                                            <td>56cm</td> 
                                            <td>37cm</td> 

                                        </tr>

                                        <tr align="center">
                                            <td>136 ~ 143cm</td> 
                                            <td>59cm</td> 
                                            <td>37cm</td> 

                                        </tr>

                                        <tr align="center">
                                            <td>144 ~ 152cm</td> 
                                            <td>63cm</td> 
                                            <td>42cm</td> 

                                        </tr>

                                        <tr align="center">
                                            <td>153 ~ 160cm</td> 
                                            <td>66cm</td> 
                                            <td>44cm</td> 

                                        </tr>

                                        <tr align="center">
                                            <td>161 ~ 168cm</td> 
                                            <td>69cm</td> 
                                            <td>47cm</td> 

                                        </tr>

                                        <tr align="center">
                                            <td>169 ~ 177cm</td> 
                                            <td>72cm</td> 
                                            <td>50cm</td> 

                                        </tr>

                                        <tr align="center">
                                            <td>178 ~ 186cm</td> 
                                            <td>75cm</td> 
                                            <td>52cm</td> 

                                        </tr>

                                        <tr align="center">
                                            <td>187 ~ 194cm</td> 
                                            <td>79cm</td> 
                                            <td>54cm</td> 

                                        </tr>

                                        <tr align="center">
                                            <td>195 ~ 202cm</td> 
                                            <td>82cm</td> 
                                            <td>56cm</td> 

                                        </tr>


                                    </table> -->
                                   
                                </div>
                            </div>

                        </div>

                    </div>

                </div>

            </div>
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>

        </div>

    </div>

    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.jsp">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <script src="js/sb-admin-2.min.js"></script>

</body>

</html>