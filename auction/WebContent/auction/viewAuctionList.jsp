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
<body background="/auction/gphoto/mina2.jpg">

<script type="text/javascript">
	<c:if test="${ERROR!=null}">
		alert("${ERROR}");
	</c:if>
</script>

<ui>
	<li>
		<c:choose>
			<c:when test="${sessionScope.MEMBER==null}">
				<p align="right">
					<a href="/auction/MemberService?method=loginForm">
					<img src="/auction/menu/login.jpg"/>
					</a></br>
					<a href="/auction/MemberService?method=addMemberForm">
					<img src="/auction/menu/join.jpg"/>
					</a>
				</p>
			</c:when>
		<c:otherwise>
		<p align="right">
			${sessionScope.MEMBER.name }님 안녕<br/>
			<a href="/auction/MemberService?method=logout">
				<img src="/auction/menu/logout.jpg"/>
			</a></br>
			<a href="/auction/MemberService?method=viewMember">
				<img src="/auction/menu/memberInfo.jpg"/>
			</a>
		</p>
		</c:otherwise>
		</c:choose>
	</li>
	<li>
		<p align="center">
			<c:if test="${sessionScope.MEMBER.userid=='admin'}">
				<a href="/auction/GoodService?method=viewGoodList">
					<img src="/auction/menu/viewGoodList.jpg"/>
				</a>
				<a href="/auction/MemberService?method=viewMemberList">
					<img src="/auction/menu/viewMemberList.jpg"/>
				</a>
			</c:if>
				<a href="/auction/BoardService?method=viewBoardList">
					<img src="/auction/menu/viewBoardList.jpg"/>
				</a>
		</p>
	</li>
</ui>

	<table  align="center"  border="1" bgcolor="pink">
	<tr>
		<th colspan="5"><h3>입찰중인 물품리스트</h3></th>
	</tr>
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
	<br/><br/>
	
	<table  align="center"  border="1" bgcolor="pink">
	<tr>
		<th colspan="5"><h3>낙찰된 물품리스트</h3></th>
	</tr>
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
</body>
</html>