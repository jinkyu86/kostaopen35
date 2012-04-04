<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>경매정보</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script>
	function bid(){
		var ret;
		ret=confirm("정말 입찰하시겠습니까?");
		return ret;
	}
	$(document).ready(function(){
		
		$("#buy").click(function (event){
			var result=confirm("회원탈퇴하시겠습니까?");
		
			if(result==false){
				event.preventDefault();
			}
		});
	});
</script>
</head>
<body>
<script type="text/javascript">
<c:if test="${ERROR!=null}">
	alert("${ERROR}");
</c:if>
</script>
<c:choose>
	<c:when test="${sessionScope.MEMBER==null}">
		<p align="right">
			<a href="/auction/MemberService?method=loginForm">
			로그인
			</a>
		</p>
	</c:when>
	<c:otherwise>
		<p align="right">
			${sessionScope.MEMBER.name }님<br/>
			<a href="/auction/MemberService?method=logout">
			로그아웃
			</a>
		</p>
	</c:otherwise>
</c:choose>
	<table  align="center"  border="1">
	<form action="/auction/BidService" method="post">
	<input type="hidden" name="method" value="addBid"/>
	<input type="hidden" name="aNum" value="${AUCTION.aNum }"/>
		<tr>
		<td align="center">물품사진</td><td align="center">물품명</td><td align="center">즉시구매가격</td>
		<td align="center">입찰가격</td><td align="center">경매시작시간</td>
		<td align="center">경매마감시간</td><c:if test="${AUCTION.sold=='0'}"><td>입찰하기</td></c:if>
		</tr>
		<tr>
			<td align="center"><img src="/auction/gphoto/${AUCTION.good.img}" width="130" height="130"></td>
			<td align="center">${AUCTION.good.gName}</td>
			<td align="center">${AUCTION.imPrice}</td>
			<td align="center">${AUCTION.cuPrice }</td>
			<td align="center">${AUCTION.sTime}</td>
			<td align="center">${AUCTION.eTime }</td>
			<c:if test="${AUCTION.sold=='0'}">
				<td align="center"><input type="submit" value="입찰하기" onclick="return bid()"></td>
			</c:if>
		</tr>
	</form>
	</table>
	<c:if test="${AUCTION.sold=='0'}">
	<p align="center">
		 <p align="center">
		 <a href="/auction/BidService?method=buy&aNum=${AUCTION.aNum }" id="buy">즉시구매하기</a>
	</p>
	</c:if>
	 
<c:if test="${sessionScope.MEMBER.userid=='admin'}">
	 <p align="center">
		 <p align="center">
		 <a href="/auction/AuctionService?method=editAuctionForm&aNum=${AUCTION.aNum}">경매정보 수정</a>
	</p>
	<p align="center">
		 <a href="/auction/AuctionService?method=removeAuction&aNum=${AUCTION.aNum}">경매 삭제</a>
	 </p>
</c:if>

	<p align="center">
		 <p align="center">
		 <a href="/auction/AuctionService?method=viewAuctionList">경매목록 보기</a>
	</p>
	
<table border="1" align="center">
	<tr>
		<th>아이디</th>
		<th>입찰가격</th>
	</tr>
	<c:forEach var="bid" items="${BID_LIST}">	
		<tr>
			<td align="center">${bid.member.userid }</td>
			<td align="center">${bid.bidPrice }</td>
		</tr>
	</c:forEach>
</table>	
</body>
</html>