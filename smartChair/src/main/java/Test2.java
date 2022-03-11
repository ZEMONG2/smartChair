
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.tb_poseDAO;
import vo.tb_heightVO;
import vo.tb_poseVO;
import vo.tb_userVO;

/**
 * Servlet implementation class Test2
 */
@WebServlet("/Test2")
public class Test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String res = "";
	static String s = "";
	static int cnt = 0;
	HttpServletResponse response;
	tb_heightVO vo2 = new tb_heightVO();
	tb_poseVO vo = new tb_poseVO();
	tb_poseDAO dao = new tb_poseDAO();
	String sc;
	String product = "sc";
	long start_time;
	long end_time;
	Date date = new Date();
	Calendar cal = Calendar.getInstance(); // 추상클래스이므로 static method로 객체를 할당받는다.
	String date2 = Integer.toString(cal.get(Calendar.YEAR)) + Integer.toString(cal.get(Calendar.MONTH))
			+ Integer.toString(cal.get(Calendar.DAY_OF_MONTH));

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		response.setCharacterEncoding("UTF-8");
		// tb_heightVO vo2 = new tb_heightVO();
		// res = vo2.getRes();

		String led = request.getParameter("res");

	
		if (led != null && led != "") {
			s = led;
		}
		doGet(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("에러");
		PrintWriter out = response.getWriter();
		String sensor = request.getParameter("sensor");
		if (sensor != null) {
			if ((sensor.equals("LB") || sensor.equals("LC") || sensor.equals("LT") || sensor.equals("RB")
					|| sensor.equals("RC") || sensor.equals("RT")) ) {
				s = "4";
			}else if (sensor.equals("5")) {
				s = "5";
			}
			
		}
		if (s.equals("1")) {
			sc = "UP";
		} else if (s.equals("2")) {
			sc = "DOWN";
		} else if (s.equals("3")) {
			sc = "STOP";
		} else if(s.equals("4")&&cnt == 0) {
			sc = "DOWN";
			cnt++;
			System.out.println("cntDown : " + cnt);
		} else if(s.equals("5")&&cnt == 1) {
			sc = "UP";
			cnt--;
			System.out.println("cntUp : " + cnt);
		} 
		
		System.out.println("sensor: " + sensor + ", sc: " + sc +", s : "+s);
		System.out.println();

		out.print(sc);
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"utf-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width,height=device-height, initial-scale=1, shrink-to-fit=no, user-scalable = yes\">\r\n"
				+ "    <meta name=\"description\" content=\"\">\r\n"
				+ "    <meta name=\"author\" content=\"\">\r\n"
				+ "\r\n"
				+ "    <title>MESSIAH - DeskControl</title>\r\n"
				+ "\r\n"
				+ "    \r\n"
				+ "    <link href=\"vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n"
				+ "    <link\r\n"
				+ "        href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\"\r\n"
				+ "        rel=\"stylesheet\">\r\n"
				+ "\r\n"
				+ "   \r\n"
				+ "    <link href=\"css/sb-admin-2.css\" rel=\"stylesheet\">\r\n"
				+ "   \r\n"
				+ "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n"
				+ "    ");
		out.print("</head>");
		out.print("<body id=\"page-top\">");
		
				
		out.print("<div id=\"wrapper\">\r\n"
				+ "\r\n"
				+ "        \r\n"
				+ "        <ul class=\"navbar-nav bg-gradient-primary sidebar sidebar-dark accordion\" id=\"accordionSidebar\">\r\n"
				+ "\r\n"
				+ "           \r\n"
				+ "            <a class=\"sidebar-brand d-flex align-items-center justify-content-center\" href=\"index.jsp\">\r\n"
				+ "                <div class=\"sidebar-brand-icon rotate-n-0\">\r\n"
				+ "                    <img src=\"img/logo.png\" ><br>\r\n"
				+ "                   \r\n"
				+ "                </div>\r\n"
				+ "                \r\n"
				+ "                <div class=\"sidebar-brand-text mx-3\">Messiah</div>\r\n"
				+ "            </a>\r\n"
				+ "\r\n"
				+ "           \r\n"
				+ "            <hr class=\"sidebar-divider my-0\">\r\n"
				+ "\r\n"
				+ "            <li class=\"nav-item active\">\r\n"
				+ "                <a class=\"nav-link\" href=\"index.jsp\">\r\n"
				+ "                    <i class=\"fas fa-fw fa-tachometer-alt\"></i>\r\n"
				+ "                    <span>메인화면</span></a>\r\n"
				+ "            </li>\r\n"
				+ "\r\n"
				+ "            <hr class=\"sidebar-divider\">\r\n"
				+ "\r\n"
				+ "            <div class=\"sidebar-heading\">\r\n"
				+ "                Interface\r\n"
				+ "            </div>\r\n"
				+ "\r\n"
				+ "            <li class=\"nav-item\">\r\n"
				+ "                <a class=\"nav-link\" href=\"buttons.jsp\">\r\n"
				+ "                    <i class=\"fas fa-fw fa-cogs\"></i>\r\n"
				+ "                    <span>높이조절</span></a>\r\n"
				+ "            </li>\r\n"
				+ "\r\n"
				+ "           \r\n"
				+ "\r\n"
				+ "            <hr class=\"sidebar-divider\">\r\n"
				+ "\r\n"
				+ "            <div class=\"sidebar-heading\">\r\n"
				+ "                Addons\r\n"
				+ "            </div>\r\n"
				+ "\r\n"
				+ "            \r\n"
				+ "\r\n"
				+ "            <li class=\"nav-item\">\r\n"
				+ "                <a class=\"nav-link\" href=\"charts.jsp\">\r\n"
				+ "                    <i class=\"fas fa-fw fa-chart-area\"></i>\r\n"
				+ "                    <span>차트</span></a>\r\n"
				+ "            </li>\r\n"
				+ "\r\n");
				          
				out.print(            "<li class=\"nav-item\">\r\n"
				+ "                <a class=\"nav-link\" href=\"tables.jsp\">\r\n"
				+ "                    <i class=\"fas fa-fw fa-table\"></i>\r\n"
				+ "                    <span>사용자테이블</span></a>\r\n"
				+ "            </li>\r\n");
				       
				          
				out.print( "            <li class=\"nav-item\">\r\n"
				+ "                <a class=\"nav-link\" href=\"list.jsp\">\r\n"
				+ "                    <i class=\"fas fa-fw fa-table\"></i>\r\n"
				+ "                    <span>게시판</span></a>\r\n"
				+ "            </li>\r\n"
				+ "\r\n"
				+ "            <hr class=\"sidebar-divider d-none d-md-block\">\r\n"
				+ "\r\n"
				+ "            <div class=\"text-center d-none d-md-inline\">\r\n"
				+ "                <button class=\"rounded-circle border-0\" id=\"sidebarToggle\"></button>\r\n"
				+ "            </div>\r\n"
				+ "\r\n"
				+ "            \r\n"
				+ "\r\n"
				+ "        </ul>\r\n"
				+ "\r\n"
				+ "        <div id=\"content-wrapper\" class=\"d-flex flex-column\">\r\n"
				+ "\r\n"
				+ "            <div id=\"content\">\r\n"
				+ "\r\n"
				+ "                <nav class=\"navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow\">\r\n"
				+ "\r\n"
				+ "                    <button id=\"sidebarToggleTop\" class=\"btn btn-link d-md-none rounded-circle mr-3\">\r\n"
				+ "                        <i class=\"fa fa-bars\"></i>\r\n"
				+ "                    </button>\r\n"
				+ "\r\n"
				+ "                    <form\r\n"
				+ "                        class=\"d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search\">\r\n"
				+ "                        <div class=\"input-group\">\r\n"
				+ "                            <input type=\"text\" class=\"form-control bg-light border-0 small\" placeholder=\"Search for...\"\r\n"
				+ "                                aria-label=\"Search\" aria-describedby=\"basic-addon2\">\r\n"
				+ "                            <div class=\"input-group-append\">\r\n"
				+ "                                <button class=\"btn btn-primary\" type=\"button\">\r\n"
				+ "                                    <i class=\"fas fa-search fa-sm\"></i>\r\n"
				+ "                                </button>\r\n"
				+ "                            </div>\r\n"
				+ "                        </div>\r\n"
				+ "                    </form>\r\n"
				+ "\r\n"
				+ "                    <ul class=\"navbar-nav ml-auto\">\r\n"
				+ "\r\n"
				+ "                        <li class=\"nav-item dropdown no-arrow d-sm-none\">\r\n"
				+ "                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"searchDropdown\" role=\"button\"\r\n"
				+ "                                data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n"
				+ "                                <i class=\"fas fa-search fa-fw\"></i>\r\n"
				+ "                            </a>\r\n"
				+ "                            <div class=\"dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in\"\r\n"
				+ "                                aria-labelledby=\"searchDropdown\">\r\n"
				+ "                                <form class=\"form-inline mr-auto w-100 navbar-search\">\r\n"
				+ "                                    <div class=\"input-group\">\r\n"
				+ "                                        <input type=\"text\" class=\"form-control bg-light border-0 small\"\r\n"
				+ "                                            placeholder=\"Search for...\" aria-label=\"Search\"\r\n"
				+ "                                            aria-describedby=\"basic-addon2\">\r\n"
				+ "                                        <div class=\"input-group-append\">\r\n"
				+ "                                            <button class=\"btn btn-primary\" type=\"button\">\r\n"
				+ "                                                <i class=\"fas fa-search fa-sm\"></i>\r\n"
				+ "                                            </button>\r\n"
				+ "                                        </div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                </form>\r\n"
				+ "                            </div>\r\n"
				+ "                        </li>\r\n"
				+ "\r\n"
				+ "                        <li class=\"nav-item dropdown no-arrow mx-1\">\r\n"
				+ "                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"alertsDropdown\" role=\"button\"\r\n"
				+ "                                data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n"
				+ "                                <i class=\"fas fa-bell fa-fw\"></i>\r\n"
				+ "                                <span class=\"badge badge-danger badge-counter\">3+</span>\r\n"
				+ "                            </a>\r\n"
				+ "                            <div class=\"dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in\"\r\n"
				+ "                                aria-labelledby=\"alertsDropdown\">\r\n"
				+ "                                <h6 class=\"dropdown-header\">\r\n"
				+ "                                    Alerts Center\r\n"
				+ "                                </h6>\r\n"
				+ "                                <a class=\"dropdown-item d-flex align-items-center\" href=\"#\">\r\n"
				+ "                                    <div class=\"mr-3\">\r\n"
				+ "                                        <div class=\"icon-circle bg-primary\">\r\n"
				+ "                                            <i class=\"fas fa-file-alt text-white\"></i>\r\n"
				+ "                                        </div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                    <div>\r\n"
				+ "                                        <div class=\"small text-gray-500\">December 12, 2019</div>\r\n"
				+ "                                        <span class=\"font-weight-bold\">A new monthly report is ready to download!</span>\r\n"
				+ "                                    </div>\r\n"
				+ "                                </a>\r\n"
				+ "                                <a class=\"dropdown-item d-flex align-items-center\" href=\"#\">\r\n"
				+ "                                    <div class=\"mr-3\">\r\n"
				+ "                                        <div class=\"icon-circle bg-success\">\r\n"
				+ "                                            <i class=\"fas fa-donate text-white\"></i>\r\n"
				+ "                                        </div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                    <div>\r\n"
				+ "                                        <div class=\"small text-gray-500\">December 7, 2019</div>\r\n"
				+ "                                        $290.29 has been deposited into your account!\r\n"
				+ "                                    </div>\r\n"
				+ "                                </a>\r\n"
				+ "                                <a class=\"dropdown-item d-flex align-items-center\" href=\"#\">\r\n"
				+ "                                    <div class=\"mr-3\">\r\n"
				+ "                                        <div class=\"icon-circle bg-warning\">\r\n"
				+ "                                            <i class=\"fas fa-exclamation-triangle text-white\"></i>\r\n"
				+ "                                        </div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                    <div>\r\n"
				+ "                                        <div class=\"small text-gray-500\">December 2, 2019</div>\r\n"
				+ "                                        Spending Alert: We've noticed unusually high spending for your account.\r\n"
				+ "                                    </div>\r\n"
				+ "                                </a>\r\n"
				+ "                                <a class=\"dropdown-item text-center small text-gray-500\" href=\"#\">Show All Alerts</a>\r\n"
				+ "                            </div>\r\n"
				+ "                        </li>\r\n"
				+ "\r\n"
				+ "                        <li class=\"nav-item dropdown no-arrow mx-1\">\r\n"
				+ "                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"messagesDropdown\" role=\"button\"\r\n"
				+ "                                data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n"
				+ "                                <i class=\"fas fa-envelope fa-fw\"></i>\r\n"
				+ "                                <span class=\"badge badge-danger badge-counter\">7</span>\r\n"
				+ "                            </a>\r\n"
				+ "                            <div class=\"dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in\"\r\n"
				+ "                                aria-labelledby=\"messagesDropdown\">\r\n"
				+ "                                <h6 class=\"dropdown-header\">\r\n"
				+ "                                    Message Center\r\n"
				+ "                                </h6>\r\n"
				+ "                                <a class=\"dropdown-item d-flex align-items-center\" href=\"#\">\r\n"
				+ "                                    <div class=\"dropdown-list-image mr-3\">\r\n"
				+ "                                        <img class=\"rounded-circle\" src=\"img/undraw_profile_1.svg\"\r\n"
				+ "                                            alt=\"...\">\r\n"
				+ "                                        <div class=\"status-indicator bg-success\"></div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                    <div class=\"font-weight-bold\">\r\n"
				+ "                                        <div class=\"text-truncate\">Hi there! I am wondering if you can help me with a\r\n"
				+ "                                            problem I've been having.</div>\r\n"
				+ "                                        <div class=\"small text-gray-500\">Emily Fowler · 58m</div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                </a>\r\n"
				+ "                                <a class=\"dropdown-item d-flex align-items-center\" href=\"#\">\r\n"
				+ "                                    <div class=\"dropdown-list-image mr-3\">\r\n"
				+ "                                        <img class=\"rounded-circle\" src=\"img/undraw_profile_2.svg\"\r\n"
				+ "                                            alt=\"...\">\r\n"
				+ "                                        <div class=\"status-indicator\"></div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                    <div>\r\n"
				+ "                                        <div class=\"text-truncate\">I have the photos that you ordered last month, how\r\n"
				+ "                                            would you like them sent to you?</div>\r\n"
				+ "                                        <div class=\"small text-gray-500\">Jae Chun · 1d</div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                </a>\r\n"
				+ "                                <a class=\"dropdown-item d-flex align-items-center\" href=\"#\">\r\n"
				+ "                                    <div class=\"dropdown-list-image mr-3\">\r\n"
				+ "                                        <img class=\"rounded-circle\" src=\"img/undraw_profile_3.svg\"\r\n"
				+ "                                            alt=\"...\">\r\n"
				+ "                                        <div class=\"status-indicator bg-warning\"></div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                    <div>\r\n"
				+ "                                        <div class=\"text-truncate\">Last month's report looks great, I am very happy with\r\n"
				+ "                                            the progress so far, keep up the good work!</div>\r\n"
				+ "                                        <div class=\"small text-gray-500\">Morgan Alvarez · 2d</div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                </a>\r\n"
				+ "                                <a class=\"dropdown-item d-flex align-items-center\" href=\"#\">\r\n"
				+ "                                    <div class=\"dropdown-list-image mr-3\">\r\n"
				+ "                                        <img class=\"rounded-circle\" src=\"https://source.unsplash.com/Mv9hjnEUHR4/60x60\"\r\n"
				+ "                                            alt=\"...\">\r\n"
				+ "                                        <div class=\"status-indicator bg-success\"></div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                    <div>\r\n"
				+ "                                        <div class=\"text-truncate\">Am I a good boy? The reason I ask is because someone\r\n"
				+ "                                            told me that people say this to all dogs, even if they aren't good...</div>\r\n"
				+ "                                        <div class=\"small text-gray-500\">Chicken the Dog · 2w</div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                </a>\r\n"
				+ "                                <a class=\"dropdown-item text-center small text-gray-500\" href=\"#\">Read More Messages</a>\r\n"
				+ "                            </div>\r\n"
				+ "                        </li>\r\n"
				+ "\r\n"
				+ "                        <div class=\"topbar-divider d-none d-sm-block\"></div>\r\n"
				+ "\r\n"
				+ "                        <li class=\"nav-item dropdown no-arrow\">\r\n"
				+ "                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"userDropdown\" role=\"button\"\r\n"
				+ "                                data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n"
				+ "                                <span class=\"mr-2 d-none d-lg-inline text-gray-600 small\">");
				
			
				
				out.print("</span>\r\n"
				+ "                                <img class=\"img-profile rounded-circle\"\r\n"
				+ "                                    src=\"img/undraw_profile.svg\">\r\n"
				+ "                            </a>\r\n"
				+ "                            <div class=\"dropdown-menu dropdown-menu-right shadow animated--grow-in\"\r\n"
				+ "                                aria-labelledby=\"userDropdown\">\r\n"
				+ "                                <a class=\"dropdown-item\" href=\"profile.jsp\">\r\n"
				+ "                                    <i class=\"fas fa-user fa-sm fa-fw mr-2 text-gray-400\"></i>\r\n"
				+ "                                    Profile\r\n"
				+ "                                </a>\r\n"
				+ "                                \r\n"
				+ "                                <div class=\"dropdown-divider\"></div>\r\n"
				+ "                                <a class=\"dropdown-item\" href=\"LogoutCon\" data-toggle=\"modal\" data-target=\"#logoutModal\">\r\n"
				+ "                                    <i class=\"fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400\"></i>\r\n"
				+ "                                    Logout\r\n"
				+ "                                </a>\r\n"
				+ "                            </div>\r\n"
				+ "                        </li>\r\n"
				+ "\r\n"
				+ "                    </ul>\r\n"
				+ "\r\n"
				+ "                </nav>\r\n"
				+ "\r\n"
				+ "                <div class=\"container-fluid\">\r\n"
				+ "\r\n"
				+ "                    <h1 class=\"h3 mb-4 text-gray-800\">높낮이 조절</h1>\r\n"
				+ "\r\n"
				+ "                     <div class=\"row\">\r\n"
				+ "                        <div class=\"col-xl-3 col-md-6 mb-4\">\r\n"
				+ "                            <div class=\"card border-left-primary shadow h-100 py-2\">\r\n"
				+ "                                <div class=\"card-body\">\r\n"
				+ "                                    <div class=\"row no-gutters align-items-center\">\r\n"
				+ "                                        <div class=\"col mr-2\">\r\n"
				+ "                                            <div class=\"text-xs font-weight-bold text-primary text-uppercase mb-1\">\r\n"
				+ "                                                사용자 이름</div>\r\n"
				+ "                                            <div class=\"h5 mb-0 font-weight-bold text-gray-800\">");
				
				
				
				
				
				
				out.print("</div>\r\n"
				+ "                                        </div>\r\n"
				+ "                                        <div class=\"col-auto\">\r\n"
				+ "                                            <i class=\"fas fa-user fa-2x text-gray-300\"></i>\r\n"
				+ "                                        </div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                </div>\r\n"
				+ "                            </div>\r\n"
				+ "                        </div>\r\n"
				+ "\r\n"
				+ "                        <div class=\"col-xl-3 col-md-6 mb-4\">\r\n"
				+ "                            <div class=\"card border-left-success shadow h-100 py-2\">\r\n"
				+ "                                <div class=\"card-body\">\r\n"
				+ "                                    <div class=\"row no-gutters align-items-center\">\r\n"
				+ "                                        <div class=\"col mr-2\">\r\n"
				+ "                                            <div class=\"text-xs font-weight-bold text-success text-uppercase mb-1\">\r\n"
				+ "                                                일일 앉아있던 시간</div>\r\n"
				+ "                                            <div class=\"h5 mb-0 font-weight-bold text-gray-800\">8시간</div>\r\n"
				+ "                                        </div>\r\n"
				+ "                                        <div class=\"col-auto\">\r\n"
				+ "                                            <i class=\"fas fa-clock fa-2x text-gray-300\"></i>\r\n"
				+ "                                        </div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                </div>\r\n"
				+ "                            </div>\r\n"
				+ "                        </div>\r\n"
				+ "\r\n"
				+ "                        <div class=\"col-xl-3 col-md-6 mb-4\">\r\n"
				+ "                            <div class=\"card border-left-info shadow h-100 py-2\">\r\n"
				+ "                                <div class=\"card-body\">\r\n"
				+ "                                    <div class=\"row no-gutters align-items-center\">\r\n"
				+ "                                        <div class=\"col mr-2\">\r\n"
				+ "                                            <div class=\"text-xs font-weight-bold text-info text-uppercase mb-1\">주간 평균 앉아있던 시간\r\n"
				+ "                                            </div>\r\n"
				+ "                                            <div class=\"row no-gutters align-items-center\">\r\n"
				+ "                                                <div class=\"col-auto\">\r\n"
				+ "                                                    <div class=\"h5 mb-0 mr-3 font-weight-bold text-gray-800\">8시간</div>\r\n"
				+ "                                                </div>\r\n"
				+ "                                                <div class=\"col\">\r\n"
				+ "                                                    \r\n"
				+ "                                                </div>\r\n"
				+ "                                            </div>\r\n"
				+ "                                        </div>\r\n"
				+ "                                        <div class=\"col-auto\">\r\n"
				+ "                                            <i class=\"fas fa-clock fa-2x text-gray-300\"></i>\r\n"
				+ "                                        </div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                </div>\r\n"
				+ "                            </div>\r\n"
				+ "                        </div>\r\n"
				+ "\r\n"
				+ "                        <div class=\"col-xl-3 col-md-6 mb-4\">\r\n"
				+ "                            <div class=\"card border-left-warning shadow h-100 py-2\">\r\n"
				+ "                                <div class=\"card-body\">\r\n"
				+ "                                    <div class=\"row no-gutters align-items-center\">\r\n"
				+ "                                        <div class=\"col mr-2\">\r\n"
				+ "                                            <div class=\"text-xs font-weight-bold text-warning text-uppercase mb-1\">\r\n"
				+ "                                               일간 정자세로 앉아있던 시간</div>\r\n"
				+ "                                            <div class=\"h5 mb-0 font-weight-bold text-gray-800\">2시간</div>\r\n"
				+ "                                        </div>\r\n"
				+ "                                        <div class=\"col-auto\">\r\n"
				+ "                                            <i class=\"fas fa-exclamation-triangle fa-2x text-gray-300\"></i>\r\n"
				+ "                                        </div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                </div>\r\n"
				+ "                            </div>\r\n"
				+ "                        </div>\r\n"
				+ "                    </div>\r\n"
				+ "                    <div class=\"row\">\r\n"
				+ "\r\n"
				+ "                        <div class=\"col-lg-6\">\r\n"
				+ "\r\n"
				+ "                            <div class=\"card shadow mb-4\">\r\n"
				+ "                                <div class=\"card-header py-3\">\r\n"
				+ "                                    <h6 class=\"m-0 font-weight-bold text-primary\">현재 책상 높이</h6>\r\n"
				+ "                                </div>\r\n"
				+ "                                <div class=\"card-body text-center \">\r\n"
				+ "                                    <h2>현재 책상 높이 : 70cm</h2>\r\n"
				+ "                                </div>\r\n"
				+ "                            </div>\r\n"
				+ "\r\n"
				+ "                            <div class=\"card shadow mb-4\">\r\n"
				+ "                                <div class=\"card-header py-3\">\r\n"
				+ "                                    <h6 class=\"m-0 font-weight-bold text-primary\">높이 조작 높이조절</h6>\r\n"
				+ "                                </div>\r\n"
				+ "                                <div class=\"card-body \">\r\n"
				+ "                                    <a href=\"Upbutton\" class=\"btn btn-primary btn-icon-split btn-lg\">\r\n"
				+ "                                        <span class=\"icon text-white-50\">\r\n"
				+ "                                            <i class=\"fas fa-arrow-up\"></i>\r\n"
				+ "                                        </span>\r\n"
				+ "                                        <span class=\"text\">책상 높이 증가</span>\r\n"
				+ "                                    </a><br><br>\r\n"
				+ "                                    <a href=\"Downbutton\" class=\"btn btn-primary btn-icon-split btn-lg\">\r\n"
				+ "                                        <span class=\"icon text-white-50\">\r\n"
				+ "                                            <i class=\"fas fa-arrow-down\"></i>\r\n"
				+ "                                        </span>\r\n"
				+ "                                        <span class=\"text\">책상 높이 감소</span>\r\n"
				+ "                                    </a><br><br>\r\n"
				+ "                                   <a href=\"Stopbutton\" class=\"btn btn-warning btn-icon-split btn-lg\">\r\n"
				+ "                                        <span class=\"icon text-white-50\">\r\n"
				+ "                                            <i class=\"fas fa-exclamation-triangle\"></i>\r\n"
				+ "                                        </span>\r\n"
				+ "                                        <span class=\"text\">책상 높이 정지</span>\r\n"
				+ "                                    </a><br><br>\r\n"
				+ "                                   \r\n"
				+ "                                   \r\n"
				+ "                                    \r\n"
				+ "\r\n"
				+ "                                </div>\r\n"
				+ "                            </div>\r\n"
				+ "\r\n"
				+ "                        </div>\r\n"
				+ "\r\n"
				+ "                        <div class=\"col-lg-6\">\r\n"
				+ "\r\n"
				+ "                            <div class=\"card shadow mb-4\">\r\n"
				+ "                                <div class=\"card-header py-3\">\r\n"
				+ "                                    <h6 class=\"m-0 font-weight-bold text-primary\">신장에 따른 바람직한 책상의 높이</h6>\r\n"
				+ "                                </div>\r\n"
				+ "                                <div class=\"card-body\">\r\n"
				+ "                                    <table border=\"1px\" width = \"100%\" >\r\n"
				+ "                                        <tr bgcolor = \"reduce\" align=\"center\">\r\n"
				+ "                                            <th>신장</th>\r\n"
				+ "                                            <th>책상높이</th>\r\n"
				+ "                                            <th>의자높이</th>\r\n"
				+ "                                        </tr>\r\n"
				+ "\r\n"
				+ "                                        <tr align=\"center\">\r\n"
				+ "                                            <td>112 ~ 126cm</td> \r\n"
				+ "                                            <td>53cm</td> \r\n"
				+ "                                            <td>35cm</td> \r\n"
				+ "\r\n"
				+ "                                        </tr>\r\n"
				+ "\r\n"
				+ "                                        <tr align=\"center\">\r\n"
				+ "                                            <td>127 ~ 135cm</td> \r\n"
				+ "                                            <td>56cm</td> \r\n"
				+ "                                            <td>37cm</td> \r\n"
				+ "\r\n"
				+ "                                        </tr>\r\n"
				+ "\r\n"
				+ "                                        <tr align=\"center\">\r\n"
				+ "                                            <td>136 ~ 143cm</td> \r\n"
				+ "                                            <td>59cm</td> \r\n"
				+ "                                            <td>37cm</td> \r\n"
				+ "\r\n"
				+ "                                        </tr>\r\n"
				+ "\r\n"
				+ "                                        <tr align=\"center\">\r\n"
				+ "                                            <td>144 ~ 152cm</td> \r\n"
				+ "                                            <td>63cm</td> \r\n"
				+ "                                            <td>42cm</td> \r\n"
				+ "\r\n"
				+ "                                        </tr>\r\n"
				+ "\r\n"
				+ "                                        <tr align=\"center\">\r\n"
				+ "                                            <td>153 ~ 160cm</td> \r\n"
				+ "                                            <td>66cm</td> \r\n"
				+ "                                            <td>44cm</td> \r\n"
				+ "\r\n"
				+ "                                        </tr>\r\n"
				+ "\r\n"
				+ "                                        <tr align=\"center\">\r\n"
				+ "                                            <td>161 ~ 168cm</td> \r\n"
				+ "                                            <td>69cm</td> \r\n"
				+ "                                            <td>47cm</td> \r\n"
				+ "\r\n"
				+ "                                        </tr>\r\n"
				+ "\r\n"
				+ "                                        <tr align=\"center\">\r\n"
				+ "                                            <td>169 ~ 177cm</td> \r\n"
				+ "                                            <td>72cm</td> \r\n"
				+ "                                            <td>50cm</td> \r\n"
				+ "\r\n"
				+ "                                        </tr>\r\n"
				+ "\r\n"
				+ "                                        <tr align=\"center\">\r\n"
				+ "                                            <td>178 ~ 186cm</td> \r\n"
				+ "                                            <td>75cm</td> \r\n"
				+ "                                            <td>52cm</td> \r\n"
				+ "\r\n"
				+ "                                        </tr>\r\n"
				+ "\r\n"
				+ "                                        <tr align=\"center\">\r\n"
				+ "                                            <td>187 ~ 194cm</td> \r\n"
				+ "                                            <td>79cm</td> \r\n"
				+ "                                            <td>54cm</td> \r\n"
				+ "\r\n"
				+ "                                        </tr>\r\n"
				+ "\r\n"
				+ "                                        <tr align=\"center\">\r\n"
				+ "                                            <td>195 ~ 202cm</td> \r\n"
				+ "                                            <td>82cm</td> \r\n"
				+ "                                            <td>56cm</td> \r\n"
				+ "\r\n"
				+ "                                        </tr>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "                                    </table>\r\n"
				+ "                                   \r\n"
				+ "                                </div>\r\n"
				+ "                            </div>\r\n"
				+ "\r\n"
				+ "                        </div>\r\n"
				+ "\r\n"
				+ "                    </div>\r\n"
				+ "\r\n"
				+ "                </div>\r\n"
				+ "\r\n"
				+ "            </div>\r\n"
				+ "            <footer class=\"sticky-footer bg-white\">\r\n"
				+ "                <div class=\"container my-auto\">\r\n"
				+ "                    <div class=\"copyright text-center my-auto\">\r\n"
				+ "                        <span>Copyright &copy; Your Website 2020</span>\r\n"
				+ "                    </div>\r\n"
				+ "                </div>\r\n"
				+ "            </footer>\r\n"
				+ "\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "    </div>\r\n"
				+ "\r\n"
				+ "    <a class=\"scroll-to-top rounded\" href=\"#page-top\">\r\n"
				+ "        <i class=\"fas fa-angle-up\"></i>\r\n"
				+ "    </a>\r\n"
				+ "\r\n"
				+ "    <div class=\"modal fade\" id=\"logoutModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\"\r\n"
				+ "        aria-hidden=\"true\">\r\n"
				+ "        <div class=\"modal-dialog\" role=\"document\">\r\n"
				+ "            <div class=\"modal-content\">\r\n"
				+ "                <div class=\"modal-header\">\r\n"
				+ "                    <h5 class=\"modal-title\" id=\"exampleModalLabel\">Ready to Leave?</h5>\r\n"
				+ "                    <button class=\"close\" type=\"button\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n"
				+ "                        <span aria-hidden=\"true\">×</span>\r\n"
				+ "                    </button>\r\n"
				+ "                </div>\r\n"
				+ "                <div class=\"modal-body\">Select \"Logout\" below if you are ready to end your current session.</div>\r\n"
				+ "                <div class=\"modal-footer\">\r\n"
				+ "                    <button class=\"btn btn-secondary\" type=\"button\" data-dismiss=\"modal\">Cancel</button>\r\n"
				+ "                    <a class=\"btn btn-primary\" href=\"login.jsp\">Logout</a>\r\n"
				+ "                </div>\r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n"
				+ "    </div>\r\n"
				+ "\r\n"
				+ "    <script src=\"vendor/jquery/jquery.min.js\"></script>\r\n"
				+ "    <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n"
				+ "\r\n"
				+ "    <script src=\"vendor/jquery-easing/jquery.easing.min.js\"></script>\r\n"
				+ "\r\n"
				+ "    <script src=\"js/sb-admin-2.min.js\"></script>");
		out.print("</body>");
		out.print("</html>");
//		out.flush();
//		out.close();

//      out.print("{\"led\":"+led+"}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void ret() {
		try {
			response.sendRedirect("buttons.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}