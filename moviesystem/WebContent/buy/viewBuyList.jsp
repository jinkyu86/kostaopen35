<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>구매리스트</title>
</head>
<body>

<table border="1" align="center">
	<tr>
		<th>구매번호</th>
		<th>이미지</th>
		<th>상품명</th>
		<th>단가</th>
		<th>개수</th>	
		<th>총가격</th>
		<th>기타</th>	
		
	</tr>
	
	<c:forEach var="buy" items="${BUY_LIST}">
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
		<form action="/moviesystem/BuyService" method="post">
			<input type="hidden" name="method" value="editBuyList"/>
			<input type="hidden" name="buynum" value="${buy.buynum}"/>
		<td>
			<input type="text" name="qty" value="${buy.qty}"/>
			<br/>
			<input type="submit" value="변경"/>
		</td>	
			<input type="hidden" name="Price"  value="${buy.good.gprice}"/>
			</form>
		<td>
			${buy.good.gprice*buy.qty}
		</td>
		<form action="/moviesystem/BuyService" method="post">
			<input type="hidden" name="method"value="removeBuyList"/>
			<input type="hidden" name="buynum"value="${buy.buynum}"/>
			<td>
				<input type="submit" value="삭제"/>
			</td>
		</form>

		
	</tr>
	</c:forEach>
</table>
<table border="0" align="center"  width="400">
<tr>
<form action="/moviesystem/BuyService" method="post">
	<input type="hidden" name="method" value="completeBuy"/>	
	<input type="submit" value="결제하기" />
</form>
</tr>
<tr>
<p>
	<a href="/moviesystem/GoodService?method=viewGoodList">쇼핑하러가기</a>
</p>
</tr>
</table>
</body>
</html>