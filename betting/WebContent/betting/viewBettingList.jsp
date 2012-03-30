<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Betting List</title>
</head>
<body>
	<body>
	<h2 align="center">���� ����Ʈ</h2>
	<table border="1" align="center">
		<tr>
			<th>���ù�ȣ</th>
			<th>����ȣ</th>
			<th>��</th>
			<th>����</th>
			<th>���÷�</th>
			<th>���� �̳׶�</th>
			<th>��������ð�</th>
		</tr>
		<c:forEach var="betting" items="${BETTING_LIST }">
		<tr>
			<td>${betting.num}</td>
			<td>${betting.match.num}</td>
			
			<td>${betting.match.awayTeam.name}</td>
			<td>${betting.match.homeTeam.name}</td>
			<td>${betting.batRating}</td>
			<td>${betting.seleRating}</td>
			<td>${betting.totMineral}</td>
		</tr>
		</c:forEach>
	</table>
	<p align="center">
		${PAGE_LINK_TAG }
	</p>
</body>
</html>