<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>editGood</title>
</head>
<body>
	<h1 align="center">��ǰ ���� ����</h1>
	<form action="/auction/GoodService" method="post">
		<table border="1" align="center">
			<input type="hidden" name="method" value="editGood"/>
			<tr>
				<td>��ǰ��</td>
				<td><input type="text" name="gName" value="${GOOD.gName}" />
				</td>
			</tr>
			<tr>
				<td>�󼼼���</td>
				<td><textarea name="detail" >${GOOD.detail}</textarea></td>
			</tr>
			<tr>
				<td>�̹���</td>
				<td><img src='/auction/gphoto/${GOOD.img}' height="100" width="100">
				<input type="text" name="img"></td>
			</tr>
	</table>
	<center>
		<input type="submit" value="���� ���� ����"/>
		<input type="reset" value="�Է����"/>
	</center>
	</form>
</body>
</html>