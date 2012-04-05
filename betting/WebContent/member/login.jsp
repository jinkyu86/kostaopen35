<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인 페이지</title>
<script type="text/javascript">
	<c:if test="${ERROR!=null}">
		alert("${ERROR}");
	</c:if>
</script>
</head>
<body>
	<h4 align="center">로그인</h4>
	<form action="/betting/MemberService" method="post">
	<input type="hidden" name="method" value="login" />
	<table align="center">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" /></td>
			</tr>
		</table>
		<table border="0" align="center">
			<tr>
				<td><input type="submit" value="로그인" /></td>
				<td><input type="reset" value="취소" /></td>
			</tr>
		</table>
	</form>


</body>
</html>