<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<html lang="en">
<head>
<title>AUCTION</title>
<link rel="stylesheet" href="styles.css" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<script type="text/javascript">
 <c:if test="${SUCCESS!=null}">
 alert("${SUCCESS}");
</c:if>
</script>
</head>
<body>
	<ul>
		<header>
			<h1>경매사이트</h1>

			<ui>
			<li><c:choose>
					<c:when test="${sessionScope.MEMBER==null}">
						<p align="right">
							<a href="/auction/loginForm.action"> <font color=black>로그인</font>
							</a>
							<br/>
							 <a href="/auction/addMemberForm.action"> <font color=black>회원가입</font>
							</a>
						</p>
					</c:when>
					<c:otherwise>
						<p align="right">
							${sessionScope.MEMBER.name }님 안녕
							<br/> 
							<a href="/auction/logout.action"> 
							<font color=black>로그 아웃</font>
							</a>
							<br/>
							<a href="/auction/viewMember.action"> 
							<font color=black>회원 정보</font>
							</a>
						</p>
					</c:otherwise>
				</c:choose></li>
			</ui>
		</header>
	</ul>
	<nav>
		<!-- top nav -->
		<div class="menu">
			<ul>
				<li><a href="/auction/home.jsp">홈</a></li>
				<li><a href="/auction/viewAuctionList.action"> <font
						color=white>경매 보기</font>
				</a>
				
					
						<c:if test="${sessionScope.MEMBER.userid=='admin'}">
							<li><a href="/auction/viewGoodList.action"> <font color=white>물품
									관리 목록 보기</font>
							</a></li>
							<li><a href="/auction/viewMemberList.action"> <font color=white>회원
									목록 보기</font>
							</a></li>
						</c:if>
						<li><a href="/auction/viewBoardList.action"> <font color=white>게시물
								목록 보기</font>
						</a></li>
					
				
			</ul>
		</div>
	</nav>
	<!-- end of top nav -->

	<section id="content">
	<p align="center">
	<table  align="center"  border="1" bgcolor="pink" >

	<table  align="center"  border="1" bgcolor="">

	<tr>
		<th colspan="5"><h3>입찰중인 물품리스트</h3></th>
	</tr>
	<th>사진</th><th>상품명</th><th>가격</th><th>마감시간</th><th>상세보기</th>
	<c:forEach var="auction" items="${AUCTION_LIST}">

	<form action="/auction/viewAuction.action" method="post">
	<input type="hidden" name="anum" value="${auction.aNum }"/>
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
	</p>
	<br/><br/>
	<p align="center">
	
	<table  align="center"  border="1">
	<tr>
		<th colspan="5"><h3>낙찰된 물품리스트</h3></th>
	</tr>
	<th>사진</th><th>상품명</th><th>가격</th><th>마감시간</th><th>상세보기</th>
	<c:forEach var="sold" items="${SOLD_LIST}">
	<form action="/auction/viewAuction.action" method="post">
	<input type="hidden" name="anum" value="${sold.aNum }"/>
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
	</p>
	</table>
	</section>			
</body>
</html>
