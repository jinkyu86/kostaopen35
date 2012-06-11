<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<!DOCTYPE html> 
<html> 
	<head>
		<title>구매취소</title>
		<meta charset="UTF-8"/> 	
		<meta name="viewport" 
				content="width=device-width, initial-scale=1.0, 
							maximum-scale=1.0, minimum-scale=1.0, 
							user-scalable=no"/>
		
		<link rel="shortcut icon" href="../image/icon.png">
		<link rel="apple-touch-icon" href="../image/icon.png">

		<link href="http://code.jquery.com/mobile/latest/jquery.mobile.min.css" rel="stylesheet" type="text/css" />
		<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
		<script src="http://code.jquery.com/mobile/latest/jquery.mobile.min.js"></script>
		
		<!-- 
		<link href="../framework/jquery.mobile-1.0.css" rel="stylesheet" type="text/css" />
		<script src="../framework/jquery-1.6.4.js"></script>
		<script src="../framework/jquery.mobile-1.0.js"></script>
		 -->
	</head> 

	<body>
		<div data-role="page" id="one">
			<div data-role="header">
				<div data-role="controlgroup" data-type="horizontal" >
					<a href="#" data-role="button" >Logout</a>
					<a href="/moviesystem/mmember/mMypage.action" data-role="button">MyPage</a>	
				</div>
			</div><!-- end header 1-->
			
			<div data-role="header">
				<div data-role="navbar">
					<ul>
						<li><a href="#">Movie</a></li>
						<li><a href="#">Reservation</a></li>
						<li><a href="/moviesystem/mgood/mViewGoodList.action" class="ui-btn-active">Shopping</a></li>
					</ul>
				</div>
			</div><!-- end header2 -->

			<div data-role="content">
				<form action="/moviesystem/mCancelBuy.action" method="post">
					<ul data-role="listview" data-inset="true">
						<li data-role="list-divider" >
							<table width=100% style="table-layout:fixed">
								<tr>
									<th width=30%>상품명</th>
									<th width=20%>개수</th>
									<th width=20%>가격</th>
									<th width=20%>구매일</th>
									<th width=30%>선택</th>
								</tr>
							</table>
						</li>	
					<c:forEach var="buy" items="${BUY_LIST}" varStatus="i">	
						<li>
						<table width=100% style="table-layout:fixed">
							<tr>
								<td width=30%>${buy.good.gname}</td>
								<td width=10%>${buy.qty}</td>
								<td width=20%>${buy.good.gprice*buy.qty}</td>
								<td width=20%><fmt:formatDate value="${buy.buyDate }"pattern="yyyy. MM.dd"/></td>
								<td width=20%><input type="checkbox" name="chkbox" value="${buy.buynum}"/></td>
							</tr>
							</table>
						</li>
						</c:forEach>
					</ul>
					<input type="submit" name="delete" value="구매 취소"/>
				</form>
			</div><!-- end content -->

			<div data-role="footer" data-position="fixed">
				<div data-role="navbar" >
					<ul>
						<c:if test="${page!=1}">
						<li><a href="/moviesystem/mbuy/mViewBuyList.action?page=${page-1}" data-icon="arrow-l">Prev</a></li>
						</c:if>
						<c:if test="${page<maxPage }">
						<li><a href="/moviesystem/mbuy/mViewBuyList.action?page=${page+1}" data-icon="arrow-r" >Next</a></li>
						</c:if>
					</ul>
				</div>
				 
			</div><!-- end footer -->		
		</div><!-- end page -->
	</body>
</html>
