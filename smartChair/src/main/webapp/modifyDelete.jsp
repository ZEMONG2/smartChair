<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action = "delete.jsp" method ="post">
		
		<h1>회원 삭제 폼</h1>
		ID입력<input type = "text" name = "user_id" id = "user_id"><br>
		PW입력<input type = "password" name = "user_pw" id = "user_pw"><br>
		<input type = "submit" name = "delete" value = "회원삭제">
	
	
	</form>
</body>
</html>