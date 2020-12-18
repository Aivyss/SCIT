<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>글쓰기 폼</title>
		<script type="text/javascript">
			function formCheck() {
				//알아서 유효성 검사

				return true;
			}
		</script>
	</head>
	
	<body>
		<form action="/board/write" method="post" onsubmit="return formCheck();">
			글 제목: <input type="text" id="title" name="title"> <br>
			글 내용: <textarea id="content" name="content"></textarea> <br>
			<input type="submit" value="글쓰기">		
		</form>
	</body>
</html>