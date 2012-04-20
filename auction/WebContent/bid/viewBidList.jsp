<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>입찰 리스트</title>
</head>
<body>
<table border="1" align="center">
	<tr>
		<th>입찰번호</th>
		<th>물품사진</th>
		<th>물품명</th>
		<th>입찰자</th>
		<th>입찰시간</th>
		<th>입찰가격</th>
	</tr>
	
	<c:forEach var="bid" items="${BID_LIST}">	
	<tr>
		<td align="center">${bid.bidNum }</td>
		<td>
		<a href="/auction/GoodService?method=viewAuction&aNum=${bid.auction.aNum }">
		<img src="/auction/gphoto/${bid.auction.good.img }" height="100" width="100"></td>
		</a>
		<td align="center">${bid.auction.good.gName }</td>
		<td align="center">${bid.member.userid }</td>
		<td align="center">${bid.bidTime }</td>
		<td align="center">${bid.bidPrice }</td>
	</tr>
	</c:forEach>
</table>	
<p align="center">
	${PAGE_LINK_TAG}
<p align="center">
	<a href="/auction/addBid.action">입찰추가</a>
	</p>
</body>
</html>