<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>viewGood</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<td width="200">���� ��ȣ</td>
			<td>${GOOD.gNum }</td>
		</tr>
		<tr>
			<td >���� �̸�</td>
			<td>${GOOD.gName }</td>
		</tr>
		<tr>
			<td>�� ����</td>
			<td>${GOOD.detail }</td>
		</tr>
		<tr>
			<td>�̹���</td>
			<td><img width=src="/auction/gphoto/${GOOD.img }"></td>
		</tr>
	</table>
	 <p align="center">
		 <a href="/auction/GoodService?method=editGoodForm&bNum=${GOOD.gNum}">��ǰ���� ����</a>
		 </p>
		 <p align="center">
		 <a href="/auction/GoodService?method=removeGood&bNum=${GOOD.gNum}">��ǰ ����</a>
	 </p>
</body>
</html>