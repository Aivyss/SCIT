<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
		<head>
			<meta charset="UTF-8">
			<title>[회원가입폼]</title>
			<script type="text/javascript">
				function formCheck() {
					id = document.getElementById("id");
					pw = document.getElementById("pw");
					var phone1 = document.getElementById("phone1").value;
					var phone2 = document.getElementById("phone2").value;
					var phone3 = document.getElementById("phone3").value;

					document.getElementById("phone").value = phone1 + phone2 + phone3;

					// 유효성체크 나중에 해야함
					
					return true;
					
				}
			</script>
		</head>
		
		<body>
			<form action="/user/join" method="post" onsubmit="return formCheck();">
				Id: <input type="text" id="id" name="id"> <br> <!-- id는 자바스크립트 name은 자바가 사용 -->
				
				PW: <input type="text" id="pw" name="pw"> <br>
				
				Phone: <input type=text id=phone1> - <input type=text id=phone2> - <input type=text id=phone3> <br>
				<input type="hidden" id="phone" name="phone">
				
				<input type="submit" value="가입">
			</form>
			
			<form action="">
				<input type="hidden"> <!-- 히든폼으로만 구성된 것도 있다. 정보 넘기기에 활용 -->
			</form>
			
		</body>
</html>