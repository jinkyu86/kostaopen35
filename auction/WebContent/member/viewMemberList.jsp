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
		<th>회원정보 수정</th>
	</tr>
	<c:forEach var="member" items="${MEMBER_LIST}">
	<tr>
	<form action="/auction/MemberService" method="post">
	<input type="hidden" name="method" value="editMember" />
	<td><label name="userid">${member.userid}</label></td> 
	<td>${member.pw}</td>
	<td>${member.email}</td>
	<td>${member.name}</td>
	<td><input type="text" name="coin" value="${member.coin}"></td>
	<td><input type="text" name="emoney" value="${member.emoney}"></td>
	</tr>
	</form>
	</c:forEach>
	
</table>
</body>
</html>
