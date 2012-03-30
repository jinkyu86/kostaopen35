<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.or.kosta.auction.auction.Auction"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table  align="center"  border="1">
	<tr>
	<td>물품번호</td><td>상세내용</td><td>이미지</td><td>시작가</td><td>즉구가</td><td>경매번호</td><td>경매시작시간</td>
	<td>경매마감시간</td><td>판매여부</td><td>현재가격</td>
	</tr>
	<%-- 
		ArrayList<Auction> auctionList=(ArrayList)request.getAttribute("AUCTION_LIST");
		for(int i=0;i<auctionList.size();i++){
			Auction auction = auctionList.get(i);
	--%>	
	<c:forEach var="auction" items="${AUCTION_LIST}">
	
	<tr>
		<tr>
				<td>${auction.good.gNum}</td>
				<td>${auction.good.detail}</td>
				<td>${auction.good.img}</td>
				<td>${auction.sPrice}</td>
				<td>${auction.imPrice}</td>
				<td><a href="/auction/AuctionService?method=viewAuction&aNum=${auction.aNum}">
				${auction.aNum}</a></td>
				<td>${auction.sTime}</td>
				<td>${auction.eTime}</td>
				<td>${auction.sold}</td>
				<td>${auction.cuPrice}</td>
			</tr>
		</tr>
		<%--} --%>
		</c:forEach>
		</table>
		<p align="center">
		<a href="/auction/AuctionService?method=addAuctionForm">경매추가</a>
		<a href="/auction/AuctionService?method=editAuctionForm">경매수정</a>	
		</p>
		
</body>
</html>