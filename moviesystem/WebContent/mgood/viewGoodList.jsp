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
		<div data-role="page">
			<jsp:include page="/common/mHeader.jsp"></jsp:include>
			
			<div data-role="content">
					<table align="center"  width=100%>
						<tr>		
							<form action="/moviesystem/mSearchGoodList.action" method="post">
								
								<td width=50%><input type="text" name="keyword"/></td>
								<td width=10%></td>
								<td width=40%><input type="submit" value="상품검색"/></td>
							</form>
						</tr>
					</table><br/>
			
					<ul data-role="listview">
						<c:forEach var="good" items="${GOOD_LIST}">	
							<li>
								<a href="/moviesystem/mViewGood.action?gnum=${good.gnum}">
									<img src="/moviesystem/gphoto/${good.photo}" width=100 height=100>
									<h5>${good.gname}</h5>
									</img>
								</a>
							</li>
						</c:forEach>
					</ul>
			</div><!-- end content -->

			<div data-role="footer" data-position="fixed">
				<div data-role="navbar" >
					<ul>
						<c:if test="${page!=1}">
						<li><a href="/moviesystem/mViewGoodList.action?page=${page-1}" data-icon="arrow-l">Prev</a></li>
						</c:if>
						<li><a href="/moviesystem/mViewCartList.action" data-icon="star" >CartList</a></li>
						<c:if test="${page<maxPage }">
						<li><a href="/moviesystem/mViewGoodList.action?page=${page+1}" data-icon="arrow-r" >Next</a></li>
						</c:if>
					</ul>
				</div>
			</div><!-- end footer -->
					
		</div><!-- end page -->
	</body>
</html>
