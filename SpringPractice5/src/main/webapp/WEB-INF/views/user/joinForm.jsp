<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<script type="text/javascript">
			function joinFormCheck() {
				
			}

			function idCheck() {
				const id = document.getElementId("id").value;
				var result = "중복된 아이디";
			}
		</script>
	</head>
	<body>
		<h1>[ 회원 가입 폼 ]</h1>
		<form action="/user/join" method="post" onsubmit="return joinFormCheck()">]
			ID: <input type="text" name="id"> <button id="duplicateCheck" onclick="idCheck()">중복체크</button>
			<br>
			PW: <input type="password" name="pw"> 
			<br>
			NAME: <input type="text" name="name"> 
			<br>
			<input type="submit" value="가입">
		</form>
	
	</body>
</html>