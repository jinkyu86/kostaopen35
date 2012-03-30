<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" 
            uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>비밀번호찾기</title>

<script type="text/javascript">
 <c:if test="${ERROR!=null}">
 	alert("${ERROR}");
 </c:if>
 </script>
 
</head>
<body>
	<h4 align="center">아이디 찾기</h4>
	<table align="center">
		<form action="/moviesystem/MemberService" method="post">
		<input type="hidden" name="method" value="findPw"/>
		<tr>
			<td>아이디</td>
			<td> <input type="text" name="userid"/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td> <input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email"/></td>
		<tr>
			<td>
			<input type="submit" value="비밀번호찾기"/></td>
			<td>
			<input type="reset" value="취소"/></td>
		</tr>
	</form>
	</table>
</body>
</html>