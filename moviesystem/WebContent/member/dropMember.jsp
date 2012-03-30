<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원탈퇴</title>
</head>
<body>
	<h1 align="center">회원탈퇴</h1>
	<table align="center">
		<form action="/moviesystem/MemberService" method="post">
		<input type="hidden" name="method"  value="dropMember"/>
		  <tr>
		  	<td>회원아이디</td>
		  	<td><input type="text" name="userid"  value="${MEMBER.userid}" readOnly="readOnly"/></td>
		  </tr>
		  <tr>
		  	<td>회원이름</td>
		  	<td><input type="text" name="name" value="${MEMBER.name}"  readOnly="readOnly"/> </td>
		  </tr>
		  <tr>
			  <td>탈퇴이유</td>
			  <td><textarea></textarea></td>
		  </tr>
		  <tr>
		  	<td>
		  	<input type="submit" value="회원탈퇴"/>
		  	</td>
		  	</tr>
		</form>
	</table>
</body>
</html>