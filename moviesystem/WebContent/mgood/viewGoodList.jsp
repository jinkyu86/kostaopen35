<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html> 
<html> 
	<head>
		<title>물품구매리스트</title>
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
		<div data-role="page" >
		
			<jsp:include page="/common/mHeader.jsp"></jsp:include>

			<div data-role="content" style=width:100%; align="center" >
				<form action="/moviesystem/mSearchGoodList.action" method="post" >
				<div class="ui-grid-a">
					<div class="ui-block-a">
						<input type="text" name="keyword"/>
					</div>
					<div class="ui-block-b">
						<input type="submit" value="상품검색" data-inline="true" data-mini="true"/>
					</div>
				</div>
			</form><br/>
				
			<div class="ui-grid-a" style=width:100%; align="center" >
				<c:forEach var="good" items="${GOOD_LIST}" varStatus="i">	
					<c:choose>
						<c:when test="${i.count%2 eq 1}">
							<div class="ui-block-a">
						</c:when>
						<c:otherwise>
							<div class="ui-block-b">
						</c:otherwise>
					</c:choose>
					
					<a href="/moviesystem/mViewGood.action?gnum=${good.gnum}" data-transition="slide">
						<img src="/moviesystem/gphoto/${good.photo}" width=80 height=80/>
						<h5>
							${good.gname}<br/>
							가격:${good.gprice}
						</h5>
					</a>
				</div>
			</c:forEach>
		</div>  

			<div data-role="footer" data-position="fixed">
				<div data-role="navbar" >
					<ul>
						<c:if test="${page!=1}">
							<li><a href="/moviesystem/mViewGoodList.action?page=${page-1}" data-icon="arrow-l" data-transition="slide">Prev</a></li>
						</c:if>
						<li><a href="/moviesystem/mViewCartList.action" data-icon="star" data-transition="slide">CartList</a></li>
						<c:if test="${page<maxPage }">
							<li><a href="/moviesystem/mViewGoodList.action?page=${page+1}" data-icon="arrow-r" data-transition="slide">Next</a></li>
						</c:if>
					</ul>
				</div>
			</div><!-- end footer -->
	
			</div><!-- end content -->		
		</div><!-- end page -->
	</body>
</html>
