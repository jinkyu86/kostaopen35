<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ��Ż���ϱ� ����Է�</title>
</head>
<body>
<form action="/bookchange/MemberService"method="post">
<input type="hidden" name="method" value="removeMember">
<table align="center">	
		
		
		<tr>
		 <td> �̸���</td>
		 <td>${sessionScope.LOGIN_EMAIL.email}</td>
		
		
		<td>��й�ȣ �Է��Ͻÿ�
		
		<input type="hidden" name="email" value="${sessionScope.LOGIN_EMAIL.email}">  
		<input type="text" name="pw" value="${Member.pw}">
		<input type="submit" value="Ȯ��">	
		</td></tr>
</table>
	
</form>
</body>
</html>