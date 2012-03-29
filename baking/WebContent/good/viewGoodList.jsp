<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1" align="center">
	<th>상품번호</th>
	<th>상품구분</th>
	<th>상품가격</th>
	<th>상품수량</th>
	<th>상품이름</th>
	<th>상품설명</th>
	<th>상품이미지</th>
	<th>옵션</th>
		<c:forEach var="good" items="${GOOD_LIST}">
		<tr>
			<td>${good.goodNum}</td>
			<td>${good.good_division.gName }</td>
			<td>${good.goodPrice }</td>
			<td>${good.qty }</td>
			<td>${good.name }</td>
			<td>${good.explantion }</td>
			<td>
			<img src="/baking/img/${good.good_division.gName}/${good.img}"/>
			</td>
			<td>${good.option }</td>
		</tr>
		</c:forEach>
</table>
</body>
</html>