<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ�� ����</title>
</head>
<body>
	<h4 align="center">ȸ������</h4>
	<table align="center">
	  
	  <form action="/bookchange/MemberService"method="post">
		  <input type="hidden" name="method" value="addMember">
	  
			    <tr>
				<td>�̸���</td>
				<td><input type="text"name="email"/></td>
				</tr>
				<tr>
				<td>��й�ȣ</td>
				<td><input type="text"name="pw"/></td>
				</tr>
				<tr>
				<td>�ּ�</td>
				<td><input type="text"name="address"/></td>
				</tr>
				<tr>
				<td>��ȭ��ȣ</td>
				<td><input type="text"name="tel"/></td>
				</tr>
				<tr>
				<td colspan="2" align="center">
				<input type="submit" value="����"/></td>
				</tr>
			</form>
				
	</table>
	
		
	</body>
</html>