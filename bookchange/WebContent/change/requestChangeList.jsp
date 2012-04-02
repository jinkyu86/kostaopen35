<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>CHANGE LIST</title>
</head>
<body>
<table border="1" align="center">
	<tr>
		<th>신청일자</th>
		<th>교환상태</th>
		<th>My Book</th>
		<th>You Book</th>
		<th>EMAIL</th>
	</tr>
	<c:forEach  var="change"  items="${DEMAND_CHANGE_LIST }">	
	<tr>
		<td>${change.changeDate}</td>
		<td>${change.condition.conditionIng}</td>
		<td>${change.agreeBoard.boardTitle}</td>
		<td>
		<a href="/bookchange/BoardService?method=viewBoard&boardNo=${change.demandBoard.boardNo}">
		${change.demandBoard.boardTitle}</a></td>
		<td>${change.agreeBoard.member.email}</td>
	</tr>
	</c:forEach>
</table>
<p align="center">
	${PAGE_LINK_TAG}
</body>
</html>
