<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib  prefix="c" 
            uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�α���</title>

</head>
<body>
	<h4 align="center">�α���</h4>
	
	<table align="center">
	
		<form action="/moviesystem/MemberService" method="post">
		<input type="hidden" name="method" value="login"/>
		<tr>
			<td>���̵�</td>
			<td><input type="text" name="userid" ></td>
			<td>
			<input type="submit" value="�α���" >
			</td>
		</tr>
		<tr>
			<td>��й�ȣ</td>
			<td><input type="password" name="pw" ></td>
			<td>
			<input type="reset" value="���"/>
			</td>
		</tr>

		<tr>
			<td>
			<a href="/moviesystem/MemberService?method=addMemberForm">
			<font size=2 >ȸ������ |</font>
			</a></td>
			<td>
			<a href="/moviesystem/MemberService?method=findIdForm">
			<font size=2 >���̵�/
			</a><a href="/moviesystem/MemberService?method=findPwForm">��й�ȣ</a> ã��</font>
			</td>
		</tr>
			</form>		
			</table>
</body>
</html>