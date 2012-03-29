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
		<th>교환원하는책</th>
		<th>교환할책</th>
	</tr>
	<c:forEach  var="change"  items="${CHANGE_LIST }">	
	<tr>
		<td>${change.change_date}</td>
		<td>${change.condition.condition_ing}</td>
		<td>${change.agreeboard.board_title}</td>		
		<td>${change.demandboard.board_title}</td>
	</tr>
	</c:forEach>
	<%--} --%>
</table>
<p align="center">
	${PAGE_LINK_TAG}
</p>
</body>
</html>
