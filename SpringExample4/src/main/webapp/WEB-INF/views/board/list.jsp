<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>[게시판 목록 페이지]</title>
		<script type="text/javascript">
			function boardWrite() {
				location.href = "/board/writeForm";
			}
		</script>
	</head>
	
	<body>
		${list } <br>
		<table border="1">
			<tr>
				<th> 번호 </th>
				<th> 글제목 </th>
				<th> 작성자 </th>
				<th> 조회수 </th>
				<th> 등록일 </th>
				<td></td>
			</tr>
			
			<tr>
				<td>1</td>
				<td>
					<a href="/board/read?board_no=1">Spring 수업은 언제 끝남?</a>
				</td>
				<td>김현민</td>
				<td>26</td>
				<td>2020/12/17</td>
			</tr>
		</table>
		<input type="button" value="글쓰기" onclick="boardWrite();">
		
	</body>
</html>