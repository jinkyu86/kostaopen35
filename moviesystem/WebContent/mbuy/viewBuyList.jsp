<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<!DOCTYPE html> 
<html> 
	<head>
		<title>구매리스트</title>
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
		
		<link rel="stylesheet" href="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.css" />
		<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
		<script src="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.js"></script>
		
		 -->
	</head> 

	<body>
		<div data-role="page" >
			<jsp:include page="/common/mHeader.jsp"></jsp:include>

			<div data-role="content">
				
					<ul data-role="listview" data-inset="true">
						<li data-role="list-divider">
							<table width=100% style="table-layout:fixed">
								<tr>
									<th width=40%>상품명</th>
									<th width=10%>개수</th>
									<th width=20%>가격</th>
									<th width=30%>구매일</th>
								</tr>
							</table>
						</li>

					<c:forEach var="buy" items="${BUY_LIST}" varStatus="i">	
						<li>
						<table  width=100% style="table-layout:fixed">
							<tr>
								<td width=40%>${buy.good.gname}</td>
								<td width=10%>${buy.qty}</td>
								<td width=20%>${buy.good.gprice*buy.qty}</td>
								<td width=30%><fmt:formatDate value="${buy.buyDate }"pattern="yyyy. MM.dd"/></td>
							</tr>
							</table>
						</li>
						</c:forEach>
					</ul>
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
	
	<!--  
	<div data-role="page" id="popup">

		<div data-role="header" data-theme="e">
			<h3>My Page</h3>
		</div>

		<div data-role="content" data-theme="d">	
			<a href="/moviesystem/mbuy/mCancelBuyListForm.action" data-role="button" data-direction="reverse" data-theme="b">Cancel Buy</a>	
			<a href="/moviesystem/mbuy/mViewCanceledBuyList.action" data-role="button" data-direction="reverse" data-theme="b">Canceled Buy List</a>	
		</div>
	
		<div data-role="footer">
		</div>
	</div>
	-->
	</body>
</html>
