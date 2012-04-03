<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>구매리스트</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.jsp"></script>
</head>


<body>
<table width="90%" align="center">
	<!-- 상단 메뉴 시작 -->
	<tr>
		<td colspan="2">
			<jsp:include page="/common/top.jsp"></jsp:include>
		</td>
	</tr>
	<!-- 상단 메뉴 끝 -->
</table>
<table border="i" align="center">
	<h1>전체 구매 물건 조회</h1>
	<tr>
		<th width="100">구매 번호</th>
		<th>물건이름</th>
		<th>개수</th>
		<th>가격</th>
		<th>총가격</th>
		<th>구매일</th>
	</tr>
	<c:forEach var="buy" items="${BUY_LIST}">
	<tr>
		<td>${buy.buynum}</td>
		<td>${buy.good.gname}</td>
		<td>${buy.qty}</td>
		<td>${buy.good.gprice}</td>
		<td>${buy.good.gprice*buy.qty}</td>
		<td><fmt:formatDate value="${buy.buyDate }"pattern="yyyy년 MM월dd일 hh시mm분ss초"/></td>
	</tr>
	</c:forEach>
</table>
<p align="center">
	${PAGE_LINK_TAG}
</p>
</body>
</html>