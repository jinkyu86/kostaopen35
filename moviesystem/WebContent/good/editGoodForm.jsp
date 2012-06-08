<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html> 
<html> 
	<head>
		<title>물건 정보 수정</title>
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
				<div data-role="controlgroup" data-type="horizontal">
					<a href="#" data-role="button" >Logout</a>
					<a href="/moviesystem/mMypage.action" data-role="button">MyPage</a>		
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
			<form action="/moviesystem/mEditGood.action" >
				<ul data-role="listview" data-insert="true">
					<li>
						<img src="../gphoto/${GOOD.photo}" />
						<input type="submit" value="정보수정" />
						<input type="hidden" name="gnum" value="${GOOD.gnum }"/>
					</li>
					<li data-role="list-divider">상품명</li>
					<li><input type="text" name="gname" required value="${GOOD.gname}" data-mini="true"/></li>
					<li data-role="list-divider">가격</li>
					<li><input type="text" name="gprice" value="${GOOD.gprice}" data-mini="true"/> </li>
					<li data-role="list-divider">이미지</li>
					<li><input type="text" name="photo" value="${GOOD.photo}" data-mini="true"/> </li>
					<li data-role="list-divider">상품설명</li>
					<li><textarea data-mini="true" name="detail"  required >${GOOD.detail}</textarea></li>
				</ul><br/>
			</form>
			<form action="/moviesystem/mDeleteGood.action" method="post">
				<input type="hidden" name="gnum" value="${good.gnum}"/>
				<input type="submit" value="삭제" data-inline="true" data-theme="d"/>
			</form>
			</div><!-- end content -->

			<div data-role="footer" data-position="fixed">
				
			</div><!-- end footer -->		
				
		</div><!-- end page -->
	</body>
</html>
