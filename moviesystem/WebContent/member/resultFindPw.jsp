<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib  prefix="c" 
            uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>비밀번호찾기 결과 조회</title>
</head>
<body>
	<h1 align="center">비밀번호찾기 결과</h1>
	<table align="center">
		
		<tr>
			
			<td><h2>${MEMBER.userid}님의 비밀번호는<font color="blue"> ${MEMBER.pw}</font>입니다.</h2></td>
		</tr>
	
			
	</table>
	<p align="center">
	<a href="/moviesystem/MemberService?method=loginForm">로그인</a></p>
</body>
</html>