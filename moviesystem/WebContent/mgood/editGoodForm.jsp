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

		<!-- 
		<link href="http://code.jquery.com/mobile/latest/jquery.mobile.min.css" 
			rel="stylesheet" type="text/css" />
		<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
		<script src="http://code.jquery.com/mobile/latest/jquery.mobile.min.js"></script>
	 	-->	
	 	 
		<link href="../framework/jquery.mobile-1.0.css" rel="stylesheet" type="text/css" />
		<script src="../framework/jquery-1.6.4.js"></script>
		<script src="../framework/jquery.mobile-1.0.js"></script>
		

	</head> 

	<body>
		<div data-role="page">
		
			<jsp:include page="/common/mHeader.jsp"></jsp:include>
			
			<div data-role="content">
			<form action="/moviesystem/mEditGood.action" method="post">
			
				<div data-role="fieldcontain">
					<img src="/moviesystem/gphoto/${GOOD.photo}" width=50 height=50/>
				</div>
					
				<div data-role="fieldcontain">	
					<label for="gname">상품명 : </label>
					<input type="text" id="gname" name="gname" required value="${GOOD.gname}" data-mini="true"/>
				</div>
				
				<div data-role="fieldcontain">	
					<label for="gprice">가격 : </label>
					<input type="number" id="gprice" name="gprice" min="1" max="1000000" value="${GOOD.gprice}" data-mini="true" required/>
				</div>
				
				<div data-role="fieldcontain">	
					<label for="photo">이미지 : </label>
					<input type="text" id="photo" name="photo"  value="${GOOD.photo}" data-mini="true"/>
				</div>
				
				<div data-role="fieldcontain">	
					<label for="detail">상품설명 : </label>
					<textarea id="detail" data-mini="true" name="detail" >${GOOD.detail}</textarea>
				</div>
				<input type="hidden" name="gnum" value="${GOOD.gnum}"/>
				<input type="submit" data-role="button" value="정보수정" />
			</form>
			
			

			</div><!-- end content -->

		</div><!-- end page -->
	</body>
</html>