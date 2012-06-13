<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html> 
<html> 
	<head>
		<title>물품 관리 페이지</title>
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
					<ul data-role="listview"  data-split-icon="delete">
						<c:forEach var="good" items="${GOOD_LIST}" varStatus="i">	
							<li>
							
								<a href="/moviesystem/mEditGoodForm.action?gnum=${good.gnum}">
									
									<img src="/moviesystem/gphoto/${good.photo}">
									
									<h3> 
										물품번호 : ${good.gnum} <br/>
										상 품 명 : ${good.gname} <br/>
										가     격 : ${good.gprice}
									</h3>
									</img>
								</a>
								
								<a href="/moviesystem/mDeleteGood.action?gnum=${good.gnum}">..</a>
	
							</li>

						</c:forEach>
					</ul><br/>
					
					<a href="/moviesystem/mAddGoodForm.action" type="button"    rel="external"  data-ajax="false">물건추가</a>
			</div><!-- end content -->
			
			<div data-role="footer" data-position="fixed">
				<div data-role="navbar" >
					<ul>
						<c:if test="${page!=1}">
						<li><a href="/moviesystem/mViewManageGoodList.action?page=${page-1}" data-icon="arrow-l">Prev</a></li>
						</c:if>
						<c:if test="${page<maxPage }">
						<li><a href="/moviesystem/mViewManageGoodList.action?page=${page+1}" data-icon="arrow-r" >Next</a></li>
						</c:if>
					</ul>
				</div>
			</div><!-- end footer -->
		
		</div><!-- end page -->
	</body>
</html>
