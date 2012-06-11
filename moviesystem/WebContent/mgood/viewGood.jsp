<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html> 
<html> 
	<head>
		<title>물건조회</title>
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
			</div><!-- end header -->
			
			<div data-role="header">
				<div data-role="navbar">
					<ul>
						<li><a href="#">Movie</a></li>
						<li><a href="#">Reservation</a></li>
						<li><a href="/moviesystem/mgood/mViewGoodList.action" class="ui-btn-active">Shopping</a></li>
					</ul>
				</div>
			</div>

			<div data-role="content">
				<ul data-role="listview" data-insert="true">
					<li>
						<img src="./gphoto/${GOOD.photo}" />
						<form action="/moviesystem/mAddCartList.action"  method="post" >
							<label for="qty">수량 : </label>
							<input name="qty" type="number" min="1" max="100" step="1" value="1" />
							<input type="submit" value="장바구니 담기" data-inline="true"/>
							<input type="hidden"name="gnum" value="${GOOD.gnum}"/>
						</form>
					</li>
					<li data-role="list-divider">상품명</li>
					<li>${GOOD.gname}</li>
					<li data-role="list-divider">가격</li>
					<li>${GOOD.gprice}</li>
					<li data-role="list-divider">상품설명</li>
					<li>${GOOD.detail}</li>
				</ul>
			</div><!-- end content -->

			<div data-role="footer" data-position="fixed">
				
			</div><!-- end footer -->		
				
		</div><!-- end page -->
	</body>
</html>
