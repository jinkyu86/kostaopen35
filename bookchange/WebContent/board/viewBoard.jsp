<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>물건 조회</title>
</head>
<body>
 <h1 align="center">물건명세</h1>
 	<table align="center" border="3">
 		<tr>
 			<td>${BOARD.boardNo}</td>
 			<td>${BOARD.category.categoryName}</td>
 			<td>${BOARD.boardTitle}</td>
 			<td>${BOARD.member.email}</td>
 			<td>${BOARD.condition.conditionIng}</td>
 	 		<td>${BOARD.boardWant}</td>	
 	 		<td>${BOARD.deal.dealWay}</td>
 		</tr>
 		<tr>
 			<td colspan="3"><img src="/bookchange/bookimg/${BOARD.boardPhoto}" height="300" width="200"></td> 			
 	 		<td>${BOARD.boardContent}</td> 	 		
 		</tr>
 		<tr>
 			<td>댓글</td>
 			<td>${QA.email}</td>
 			<td>${QA.qaContent}</td>
 		</tr>
 	</table>
 	<a href="/bookchange/ChangeService?method=addChangeForm&
</body>
</html>