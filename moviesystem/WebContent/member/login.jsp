<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib  prefix="c" 
            uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인</title>

</head>
<body>
	<h4 align="center">로그인</h4>
	
	<table align="center">
	
		<form action="/moviesystem/MemberService" method="post">
		<input type="hidden" name="method" value="login"/>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userid" ></td>
			<td>
			<input type="submit" value="로그인" >
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw" ></td>
			<td>
			<input type="reset" value="취소"/>
			</td>
		</tr>

		<tr>
			<td>
			<a href="/moviesystem/MemberService?method=addMemberForm">
			<font size=2 >회원가입 |</font>
			</a></td>
			<td>
			<a href="/moviesystem/MemberService?method=findIdForm">
			<font size=2 >아이디/
			</a><a href="/moviesystem/MemberService?method=findPwForm">비밀번호</a> 찾기</font>
			</td>
		</tr>
			</form>		
			</table>
</body>
</html>