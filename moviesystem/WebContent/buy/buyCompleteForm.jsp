<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>결재완료창</title>
</head>
<body>
<h1 align="center">결제가 완료되었습니다.</h1>

<table border="1" align="center">
	<tr>
		<th>구매번호</th>
		<th>이미지</th>
		<th>상품명</th>
		<th>단가</th>
		<th>개수</th>	
		<th>총가격</th>
	</tr>
	
	<c:forEach var="buy" items="${COMPLETE_BUY_LIST}">
	<tr>
		<td>
			${buy.buynum}
		</td>
		<td>
			<img src="/moviesystem/gphoto/${buy.good.photo}" width="100" height="100"/>
		</td>
		<td>
			${buy.good.gname}
		</td>
		<td>
			${buy.good.gprice}
		</td>

		<td>
			${buy.qty}
		</td>	
		<td>
			${buy.good.gprice*buy.qty}
		</td>
	</tr>
	</c:forEach>
</table>

<p align="center">
	<a href="/moviesystem/GoodService?method=viewGoodList">더 쇼핑하러가기</a>
	<!-- 홈으로 가기로 변경 -->
</p>
</body>
</html>