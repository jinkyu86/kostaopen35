<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 게시물 조회</title>
</head>
<body>
<h1 align="center">회원조회</h1>
<table border="1" align="center">
	<tr>
		<td>번호</td>
		<td>${MEMBER.userNum }</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td>${MEMBER.userid}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${MEMBER.name}</td>
	</tr>
	<tr>	
		<td>이메일</td>
		<td>${MEMBER.email}</td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td>${MEMBER.phone}</td>
	</tr>
	<tr>
		<td>우편번호</td>
		<td>${MEMBER.zipcode}</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>${MEMBER.addr}</td>
	</tr>
	<tr>
		<td>회원가입일</td>
		<td>${MEMBER.regDate}</td>
	</tr>
	<tr>
		<td>회원상태</td>
		<td>${MEMBER.memState}</td>
	</tr>
</table>
<p align="center">
<a href="/moviesystem/MemberService?method=editMemberForm&userid=${MEMBER.userid}">
회원정보 수정</a></p>
<p align="center">
<a href="/moviesystem/MemberService?method=dropMemberForm&userid=${MEMBER.userid}">
회원탈퇴</a></p>
</body>
</html>