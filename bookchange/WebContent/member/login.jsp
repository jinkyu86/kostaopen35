<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인</title>
</head>
<body>
  <h4 align="center">로그인</h4>
  <table align="center">
  	<form action="/bookchange/MemberService" method="post">
  	<input type="hidden"name="method"value="login">

  	<tr>
  		<td>아이디</td>
  		<td><input type="text" name="email"/></td>
  		</tr>
  		<tr>
  		<td>비밀번호</td>
  		<td><input type="password" name="pw"/></td>
  		<tr>
  		<td><input type="submit" value="로그인"/></td>
  		
  		
  		<td><input type="reset" value="취소"/></td>
  		</tr> 
  		  	</form>
  	<tr>	  
  	
  	<a href="/bookchange/member/addmember.jsp">
  	<td>회원가입</td>
  	</a>
  	</tr>
</table>
</body>
</html>