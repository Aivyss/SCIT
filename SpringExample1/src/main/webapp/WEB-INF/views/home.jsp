<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript">
		function goToBoard() {
			location.href = "board/list";
		}
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="/main">go to main</a>
<a href="/user/join">go to join</a>

<input type="button" value="게시판으로 이동" onclick="goToBoard();">

<img alt="고양이" src="/resources/images/images.jpg">

</body>
</html>
