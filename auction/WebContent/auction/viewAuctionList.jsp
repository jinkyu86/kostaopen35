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
<title>경매리스트</title>
</head>
<body>

<script type="text/javascript">
	<c:if test="${ERROR!=null}">
		alert("${ERROR}");
	</c:if>
</script>

<c:choose>
	<c:when test="${sessionScope.LOGIN_MEMBER==null}">
		<p align="right">
			<a href="/auction/MemberService?method=loginForm">
			로그인
			</a>
		</p>
	</c:when>
	<c:otherwise>
		<p align="right">
			${sessionScope.LOGIN_MEMBER.name }님 안녕<br/>
			<a href="/auction/MemberService?method=logout">
			로그아웃
			</a><br/>
			<a href="/auction/MemberService?method=viewMember">
			회원정보보기
			</a>
		</p>
	</c:otherwise>
</c:choose>
	<h3 align="center">입찰중인 물품리스트</h3>
	<table  align="center"  border="1">
	<th>사진</th><th>상품명</th><th>가격</th><th>마감시간</th><th>상세보기</th>
	<c:forEach var="auction" items="${AUCTION_LIST}">
	<form action="/auction/AuctionService" method="post">
	<input type="hidden" name="method" value="viewAuction"/>
	<input type="hidden" name="aNum" value="${auction.aNum }"/>
	<tr>
		<td align="center"><img src="/auction/gphoto/${auction.good.img}" width="130" height="130"></td>
		<td align="center">${auction.good.gName}</td>
		<td align="center">
			<h4>즉시구매가 : ${auction.imPrice }<br/></h4>
			${auction.cuPrice }
		</td>
		<td align="center">${auction.eTime }</td>
		<td align="center"><input type="submit" value="참여하기"></td>
	</tr>
	</form>
	</c:forEach>
	</table>
	<p align="center">
	${PAGE_LINK_TAG}
	<br/><br/>
	
	<h3 align="center">낙찰된 물품리스트</h3>
	<table  align="center"  border="1">
	<th>사진</th><th>상품명</th><th>가격</th><th>마감시간</th><th>상세보기</th>
	<c:forEach var="sold" items="${SOLD_LIST}">
	<form action="/auction/AuctionService" method="post">
	<input type="hidden" name="method" value="viewAuction"/>
	<input type="hidden" name="aNum" value="${sold.aNum }"/>
	<tr>
		<td align="center"><img src="/auction/gphoto/${sold.good.img}" width="130" height="130"></td>
		<td align="center">${sold.good.gName}</td>
		<td align="center">${sold.cuPrice }</td>
		<td align="center">${sold.eTime }</td>
		<td align="center"><input type="submit" value="상세보기"></td>
	</tr>
	</form>
	</c:forEach>
	</table>
<c:if test="${sessionScope.LOGIN_MEMBER.userid=='admin'}">
	<p align="center">
		<a href="/auction/AuctionService?method=addAuctionForm">경매추가</a>
		<a href="/auction/AuctionService?method=editAuctionForm">경매수정</a>	
	</p>
</c:if>
	<p align="center">
		<a href="/auction/Boardervice?method=viewBoardList">게시판보기</a>
	</p>
		
</body>
</html>