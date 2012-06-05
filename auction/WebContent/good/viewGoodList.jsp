<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<html lang="en">
<head>
<title>viewGoodList</title>
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
			<p>
				<font color="black" style="font-size: 27px">경매사이트</font>
			</p>

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
		<table border="1" align="center">
	<tr>
		<th colspan="2"><h3>물품 목록</h3></th>
		<tr>
			<th>번호</th>
			<th>이름</th>
		</tr>
	<c:forEach var="GOOD" items="${GOOD_LIST}">
<tr>
	<td>${GOOD.gNum}</td>
	<td>
		<a href="/auction/viewGood.action?gNum=${GOOD.gNum}">
		${GOOD.gName}
		</a>
	</td>
</tr>
</c:forEach>
</table>
<p align="center">
	${PAGE_LINK_TAG}
</p>
<p align="center">
	<a href="/auction/addGoodForm.action">
		<img src="/auction/menu/addGood.jpg"/>
	</a>
   <a href="/auction/viewAuctionList.action">
   		<img src="/auction/menu/viewAuctionList.jpg"/>
   	</a> 
</p>
		</p>
	</section>			
</body>
</html>