<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>랭킹</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th>랭킹</th>
			<th>ID</th>
			<th>미네랄</th>

		</tr>
		<c:forEach var="member" items="${MEMBER_LIST}">

			<tr>
				<td>${member.rank}</td>
				<td>${member.id}</td>
				<td>${member.mineral}</td>
			</tr>

		</c:forEach>
	</table>
	<p align="center">${PAGE_LINK_TAG }</p>

</body>
</html>