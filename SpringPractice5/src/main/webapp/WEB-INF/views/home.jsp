<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<ul>
			<c:choose>
			<c:when test="${empty sessionScope.loginId }">
				<!-- 로그인 전 -->
				<li>
					<a href="/user/joinForm">회원 가입</a>
				</li>
				<li>
					<a href="/user/logInForm">로그인</a>
				</li>
			</c:when>
			
			<c:otherwise>
				<!-- 로그인 후 -->
				<li>
					<h1>${sessionScope.loginName }님 환영합니데이.</h1>
				</li>
				
				<li>
					<a href="/user/logOut">로그아웃</a>
				</li>
			</c:otherwise>
			</c:choose>
			
			
		</ul>
	</body>
</html>
