<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html> 
<html> 
	<head>
		<title>장바구니</title>
		<meta charset="UTF-8"/> 	
		<meta name="viewport" 
				content="width=device-width, initial-scale=1.0, 
							maximum-scale=1.0, minimum-scale=1.0, 
							user-scalable=no"/>
		
		<link rel="shortcut icon" href="../image/icon.png">
		<link rel="apple-touch-icon" href="../image/icon.png">

		<link href="http://code.jquery.com/mobile/latest/jquery.mobile.min.css" 
			rel="stylesheet" type="text/css" />
		<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
		<script src="http://code.jquery.com/mobile/latest/jquery.mobile.min.js"></script>
			
		<!--  
		<link href="../framework/jquery.mobile-1.0.css" rel="stylesheet" type="text/css" />
		<script src="../framework/jquery-1.6.4.js"></script>
		<script src="../framework/jquery.mobile-1.0.js"></script>
		-->
	</head> 

	<body>
		<div data-role="page">
			<div data-role="header">
				<div data-role="controlgroup" data-type="horizontal" >
					<a href="#" data-role="button" >Login</a>
					<a href="#" data-role="button">Join</a>
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
			<div data-role="collapsible-set">
				<c:forEach var="buy" items="${sessionScope.CART_LIST}" varStatus="i">	
					<c:choose>
						<c:when test="${i.count eq 1}">
							<div data-role="collapsible">
						</c:when>
						<c:otherwise>
							<div data-role="collapsible" data-collapsed="true">
						</c:otherwise>
					</c:choose>
						<h3>
							${buy.good.gname} ${buy.good.gprice} 원<br/>
							${buy.qty} 개, ${buy.qty*buy.good.gprice} 원
							<img src="./gphoto/${buy.good.photo}" style="width:50px;height:50px" align="right"/>
						</h3>
						<p>
							<form action="/moviesystem/mEditCartList.action" method="post">
								<input name="qty" type="number" min="1" max="100" step="1" value="${buy.qty}" />
								<input type="submit" value="수량변경"/>
								<input type="hidden" name="index"  value="${i.count-1}"/>	
							</form>	
							<form action="/moviesystem/mRemoveCartList.action" method="post">
								<input type="hidden" name="index"  value="${i.count-1}"/>
								<input type="submit" value="삭제"/>
							</form>
						</p>
					</div>
				</c:forEach>
				</div>
				
				<c:if test="${sessionScope.CART_LIST[0] ne null}">
					<form action="/moviesystem/mAddBuy.action" method="post">
						<input type="submit" value="결제하기" />
					</form>
				</c:if>
			</div><!-- end content -->

			<div data-role="footer" data-position="fixed">

			</div><!-- end footer -->		
		</div><!-- end page -->
	</body>
</html>