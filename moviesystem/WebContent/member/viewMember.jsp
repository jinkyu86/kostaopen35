<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ�� �Խù� ��ȸ</title>
</head>
<body>
<h1 align="center">ȸ����ȸ</h1>
<table border="1" align="center">
	<tr>
		<td>��ȣ</td>
		<td>${MEMBER.userNum }</td>
	</tr>
	<tr>
		<td>���̵�</td>
		<td>${MEMBER.userid}</td>
	</tr>
	<tr>
		<td>�̸�</td>
		<td>${MEMBER.name}</td>
	</tr>
	<tr>	
		<td>�̸���</td>
		<td>${MEMBER.email}</td>
	</tr>
	<tr>
		<td>��ȭ��ȣ</td>
		<td>${MEMBER.phone}</td>
	</tr>
	<tr>
		<td>�����ȣ</td>
		<td>${MEMBER.zipcode}</td>
	</tr>
	<tr>
		<td>�ּ�</td>
		<td>${MEMBER.addr}</td>
	</tr>
	<tr>
		<td>ȸ��������</td>
		<td>${MEMBER.regDate}</td>
	</tr>
	<tr>
		<td>ȸ������</td>
		<td>${MEMBER.memState}</td>
	</tr>
</table>
<p align="center">
<a href="/moviesystem/MemberService?method=editMemberForm&userid=${MEMBER.userid}">
ȸ������ ����</a></p>
<p align="center">
<a href="/moviesystem/MemberService?method=dropMemberForm&userid=${MEMBER.userid}">
ȸ��Ż��</a></p>
</body>
</html>