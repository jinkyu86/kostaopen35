<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������</title>
</head>
<body>
	<table border="2" align="center">
	<form action="/bookchange/MemberService" method="post">
	  <input type="hidden" name="method" value="viewMember">
	  	<input type="hidden" name="email" value="${sessionScope.LOGIN_EMAIL.email}">
		
	<tr>
		<td>�̸���</td>
		<td>�ּ�</td>
		<td>��ȭ��ȣ</td>
		<td>��й�ȣ</td>
	</tr>
	<tr>
		<td>${MEMBER.email}</td>
		<td>${MEMBER.address}</td>
		<td>${MEMBER.tel}</td>		
		<td><input type="password" name="pw" value="${MEMBER.pw}" readonly="readonly"/></td>	
	</tr>
		
		
	</form>
	
	</table>
	<table  align="center">
		<form action="/bookchange/MemberService" method="post">
		<tr>
		<td><a href="/bookchange/BoardService?method=viewBoardList">�Խù�����</a>
		 </td>
		 </tr>
		 </form>
	</table>

	
</body>
</html>