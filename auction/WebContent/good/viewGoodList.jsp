<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>viewGoodList</title>
</head>
<body background="/auction/gphoto/seo.jpg">
<table border="1" align="center">
	<tr>
		<th colspan="2"><h3>물품 목록</h3></th>
		<tr>
			<th>번호</th>
			<th>이름</th>
		</tr>
	<c:forEach var="GOOD" items="${GOOD_LIST}">
<tr>
	<td>${GOOD.gNum}</td>
	<td>
		<a href="/auction/viewGood.action?gNum=${GOOD.gNum}">
		${GOOD.gName}
		</a>
	</td>
</tr>
</c:forEach>
</table>
<p align="center">
	${PAGE_LINK_TAG}
</p>
<p align="center">
	<a href="/auction/addGoodForm.action">
		<img src="/auction/menu/addGood.jpg"/>
	</a>
   <a href="/auction/viewAuctionList.action">
   		<img src="/auction/menu/viewAuctionList.jpg"/>
   	</a> 
</p>
</body>
</html>