<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>전체회원 리스트</title>
</head>
<body>
<%-- table align="right">
	<form action="/moviesystem/MemberService" method="post">
	<input type="hidden" name="method" value="searchMemberList">
		<select name="column">
			<option value="이름">이름</option>
			<option value="이메일">이메일</option>
		</select>
		<input type="text" name="keyword">
		<br/>
		<input type="submit" name="검색"/>
	</form>
	</table>--%>
<table border="i" align="center">
	<tr>
		<th>회원번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>우편번호</th>
		<th>주소</th>
		<th>회원상태</th>
	</tr>
	<c:forEach var="member" items="${MEMBER_LIST}">
	<tr>
		<td>${member.userNum}</td>
		<td><a href="/moviesystem/MemberService?method=viewMember&userid=${member.userid}">
		${member.userid}</a></td>
		<td>${member.name}</td>
		<td>${member.email}</td>
		<td>${member.phone}</td>
		<td>${member.zipcode}</td>
		<td>${member.addr}</td>
		<td>${member.memState}</td>
</c:forEach>
</table>
<p align="center">
	${PAGE_LINK_TAG}
</p>
<p align="center">
<a href="/moviesystem/MemberService?method=addMemberForm">
회원가입</a>
</p>
</body>
</html>