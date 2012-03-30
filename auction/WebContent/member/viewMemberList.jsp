<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib  prefix="c" 
             uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 리스트</title>
</head>
<body>
<table border="1" align="center">
	<tr>
		<th>회원아이디</th>
		<th>비밀번호</th>
		<th>이메일</th>
		<th>이름</th>
		<th>코인</th>
		<th>E머니</th>
	</tr>
	<c:forEach var="member" items="${MEMBER_LIST}">
	<tr>
	<td>${member.userid}</td> 
	<td>${member.pw}</td>
	<td>${member.email}</td>
	<td>${member.name}</td>
	<td>${member.coin}</td>
	<td>${member.emoney}</td>
	</tr>
	</c:forEach>

	
</table>
<p align="center">
	${PAGE_LINK_TAG}
</p>
<p align="center">
	<a href="/auction/MemberService?method=addMemberForm">회원추가</a>
</p>
</body>
</html>
