<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Member List</title>
</head>
<body>
	<h2 align="center">멤버 리스트</h2>
	<table border="1" align="center">
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>PW</th>
			<th>Email</th>
			<th>미네랄</th>
		</tr>

		<c:forEach var="member" items="${MEMBER}">

			<tr>
				<td><a
					href="/betting/MemberService?method=viewMember&ID=${member.id}">
						${member.id} </a></td>

				<td>${member.name}</td>
				<td>${member.pw}</td>
				<td>${member.email}</td>
				<td>${member.mineral}</td>
			</tr>

		</c:forEach>
	</table>
	<p align="center">${PAGE_LINK_TAG }</p>
	</p>
</body>
</html>