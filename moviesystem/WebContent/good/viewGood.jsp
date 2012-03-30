<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>물건 조회</title>
</head>
<body>
<h1>${GOOD.gname}</h1>
<form action="/moviesystem/BuyService"method="post">
<table border="1">
	<tr>
		<td rowspan=3><img src="/moviesystem/gphoto/${GOOD.photo}" width="200" height="200"></td>
		<td>상품 가격</td><td>${GOOD.gprice}</td>
	</tr>
	<tr>
		<td>상품 설명</td><td width="500">${GOOD.detail}</td>
	</tr>
	<tr>
		<td>수량</td><td width="500"><input type="text"name="qty"value="1"/></td>
	</tr>
</table>

	<input type="hidden"name="method"value="addBuy"/>
	<input type="hidden"name="gnum"value="${GOOD.gnum}"/>
	<input type="submit" value="구매하기"/>
</form>

</body>
</html>