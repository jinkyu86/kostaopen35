<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 가입</title>
</head>
<body>
	<h4 align="center">회원가입</h4>
	<table align="center">
	  
	  <form action="/bookchange/MemberService"method="post">
		  <input type="hidden" name="method" value="addMember">
	  
			    <tr>
				<td>이메일</td>
				<td><input type="text"name="email"/></td>
				</tr>
				<tr>
				<td>비밀번호</td>
				<td><input type="text"name="pw"/></td>
				</tr>
				<tr>
				<td>주소</td>
				<td><input type="text"name="address"/></td>
				</tr>
				<tr>
				<td>전화번호</td>
				<td><input type="text"name="tel"/></td>
				</tr>
				<tr>
				<td colspan="2" align="center">
				<input type="submit" value="가입"/></td>
				</tr>
			</form>
				
	</table>
	
		
	</body>
</html>