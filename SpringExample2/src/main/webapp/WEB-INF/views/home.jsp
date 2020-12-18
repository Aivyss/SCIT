<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Home</title>
	
		<script type="text/javascript">
			function idCheck() {
				var id = document.getElementById("testId").value;
				location.href = "/idCheck?id="+id;
			}

			function formCheck() {
				// 必ず名前は入力すること。
				// 年齢は必ず入力することそして数字だけ、1～３文字で。
				// 住所も必ず入力すること
				var name = document.getElementById("id").value;
				var age = document.getElementByid("age").value;
				var address = document.getElementById("address").value;
				var flag = true;

				// name check
				if (name == null || name.length == 0) {
					alert("名前は必ず入力してください。");
					flag = false;
				} else if (name.length < 2 || name.legnth > 4) {
					alert("名前は2～4文字でございます。");
					flag = false;
				}

				// age check
				if (age == null || age.length == 0) {
					alert("You should input age");
					flag = false;
				} else if (isNaN(age)) {
					alert("You can input number type only");
					flag = false;
				} else if (age.length < 1 || age.length > 3) {
					alert("just range in 1~3");
					flag = false;					
				}

				// address check
				if (address = null || age.length == 0) {
					alert("You should input address");
					flag = false;
				}
				
				return flag;
			}

			
		</script>
	</head>
	
	<body>
		<h1>
			Hello world!  
		</h1>
		
		<P>  The time on the server is ${serverTime}. </P>
		
		<!-- 쿼리스트링 방식 
		
		요청주소?+보내려는 데이터 변수명1=값1&변수명2=값2... -->
		<a href="/index?num=10&str=테스트">Index page로 이동</a>
		
		<input type="text" id="testId" onsubmit="return formCheck();">
		<input type="button" value="중복검사" onclick="idCheck();">
		<form action="input" method="post">
			<div>
				名: <input type="text" id="name" name="name"> <br>
				年齢: <input type="number" id="age" name="age"> <br>
				住所: <input type="text" id="address" name="address"> <br>
				性別: 남성 <input type="radio" name="gender" value="true"> 여성 <input type="radio" name="gender" value="false">
			</div>
			
			<div>
				<h1> 취미 </h1>
				<input type="checkbox" name="hobby" value="0"> 미드
				<input type="checkbox" name="hobby" value="1"> 게임 
				<input type="checkbox" name="hobby" value="2"> 여행 <br>
				<input type="checkbox" name="hobby" value="3"> 독서
				<input type="checkbox" name="hobby" value="4"> 드라이빙
				<input type="checkbox" name="hobby" value="5"> 코딩
				<input type="submit" value="送信">
			</div>
		</form>
	</body>
</html>
