<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table  align="center"  border="1">
	<tr>
	<td>물품번호</td><td>시작가</td><td>즉구가</td><td>경매번호</td><td>경매시작시간</td>
	<td>경매마감시간</td><td>판매여부</td><td>현재가격</td>
	</tr>
	<tr>
				<td>${AUCTION.good.gNum}</td>
				<td>${AUCTION.sPrice}</td>
				<td>${AUCTION.imPrice}</td>
				<td>${AUCTION.aNum}</td>
				<td>${AUCTION.sTime}</td>
				<td>${AUCTION.eTime}</td>
				<td>${AUCTION.sold}</td>
				<td>${AUCTION.cuPrice}</td>
			</tr>
</table>
			
	 <p align="center">
		 <a href="/auction/AuctionService?method=editAuctionForm&aNum=${GOOD.aNum}">물품정보 수정</a>
	</p>
	<p align="center">
		 <a href="/auction/AuctionService?method=removeAuction&aNum=${GOOD.aNum}">물품 삭제</a>
	 </p>
</body>
</html>