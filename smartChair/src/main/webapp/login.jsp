<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
Cookie[] cookie = request.getCookies();
String id = "";
if(cookie != null){
	for(int i = 0; i < cookie.length; i++){
		if(cookie[i].getName().trim().equals("id")){
			System.out.println(cookie[i].getValue());
			id = cookie[i].getValue();
		}
	}
}
%>
<!-- �ȳ��ϼ��� �� -->
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>MESSIAH - Login</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
	
	<!-- content�� �ڽ��� OAuth2.0 Ŭ���̾�ƮID�� �ֽ��ϴ�. -->
	<meta name ="google-signin-client_id" content="550625028058-b9ek518s1t810btgk5qfrjddmf8e9o05.apps.googleusercontent.com">
</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image"><img src="img/desk2.jpg" ></div>
                              
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                                    </div>
                                    <form class="user" action = "LoginCon" method="post">
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user"
                                                id="exampleInputEmail" aria-describedby="emailHelp"
                                                placeholder="Enter Email Address..." name = "user_id" value="<%=id %>">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="exampleInputPassword" placeholder="Password" name = "user_pw">
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input"
                                                id="customCheck" name = "id_remb" <%if(id.length() > 1) out.println("checked"); %>>
                                               <label class="custom-control-label" for="customCheck">
                                                Remember Me
                                                </label>
                                            </div>
                                        </div>
                                        <input type="submit" class="btn btn-primary btn-user btn-block" value="Login">
                                        <hr>
                                        <a href="javascript:void(0)" id = "GgCustomLogin" class="btn btn-google btn-user btn-block">
                                            <i class="fab fa-google fa-fw"></i> Login with Google
                                        </a>
                                       
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="forgot-password.html">Forgot Password?</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="register.html">Create an Account!</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>
    
	<script>

//ó�� �����ϴ� �Լ�
function init() {
	gapi.load('auth2', function() {
		gapi.auth2.init();
		options = new gapi.auth2.SigninOptionsBuilder();
		options.setPrompt('select_account');
        // �߰��� Oauth ���� ���� �߰� �� ���� �������� �߰�
		options.setScope('email profile openid https://www.googleapis.com/auth/user.birthday.read');
        // �ν��Ͻ��� �Լ� ȣ�� - element�� �α��� ��� �߰�
        // GgCustomLogin�� li�±׾ȿ� �ִ� ID, ���� ������ options�� �Ʒ� ����,���н� �����ϴ� �Լ���
		gapi.auth2.getAuthInstance().attachClickHandler('GgCustomLogin', options, onSignIn, onSignInFailure);
	})
}

function onSignIn(googleUser) {
	var access_token = googleUser.getAuthResponse().access_token
	$.ajax({
    	// people api�� �̿��Ͽ� ������ �� ������Ͽ� ���� ���õ����� �����´�.
		url: 'https://people.googleapis.com/v1/people/me'
        // key�� �ڽ��� API Ű�� �ֽ��ϴ�.
		, data: {personFields:'birthdays', key:'AIzaSyDJXdDpD6yd-gWxr34i_u3RQ5cctDNisRE', 'access_token': access_token}
		, method:'GET'
	})
	.done(function(e){
        //�������� �����´�.
		var profile = googleUser.getBasicProfile();
		console.log(profile)
	})
	.fail(function(e){
		console.log(e);
	})
}
function onSignInFailure(t){		
	console.log(t);
}
</script>
	<!-- //���� api ����� ���� ��ũ��Ʈ -->
<script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>

</body>

</html>