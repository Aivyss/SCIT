<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
	</head>
	
	<body>
		<h1>[ 로그인 폼 ]</h1>
		
		<form action="/user/logIn" method="post">
			ID: <input type="text" name="id"> <br>
			PW: <input type="text" name="pw"> <br>
			아이디 기억하기: <input type="checkbox" name="loginCheck" value="true"> <br>
			
			<input type="submit" value="로그인">
		</form>
	</body>
</html>