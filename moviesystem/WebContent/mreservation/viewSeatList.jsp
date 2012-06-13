<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html> 
	<head>
		<title>jQuery Mobile</title>
		<meta charset="euc-kr" /> 	
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
		<link href="../framework/jquery.mobile-1.0.css" 
			rel="stylesheet" type="text/css" />
		<script src="../framework/jquery-1.6.4.js"></script>
		<script src="../framework/jquery.mobile-1.0.js"></script>
		-->
		
	</head> 

	<body>
		<div data-role="page">
			<jsp:include page="/common/mHeader.jsp"></jsp:include>

			<div data-role="content">
			<c:forEach var="reservation" items="${RESERVATION_LIST}">
				<ul data-role="listview">
				
						<li data-role="list-divider">
						${reservation.seatnum}
						</li>
						<li>
						<h3>${reservation.payState}</h3>
						<c:choose>
							<c:when test="${reservation.payState=='결제완료' }">
								<a href="/moviesystem/mviewCancelByResNum.action?resnum=${reservation.resnum}">
								<input type="button" value="취소"/>
								</a>
							</c:when>
						</c:choose>
						</li>
				</ul>
			</c:forEach>	
			</div>


		</div>
	</body>
</html>
<!-- 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.jsp"></script>
</head>
<body>
<table width="90%" align="center">
	
<table border="1" align="center">
	<tr>
		<th>좌석</th>
		<th>결제상태</th>
		<th>취소</th>

	</tr>


<c:forEach var="reservation" items="${RESERVATION_LIST}" >
 	
 	<tr>
 		<td>${reservation.seatnum}</td>
 		<td>${reservation.payState}</td>

 		<c:choose>
			<c:when test="${reservation.payState=='결제완료' }">
				<td><a href="/moviesystem/viewCancelByResNum.action?resnum=${reservation.resnum}">
				<input type="button" value="취소"/>
				</a></td>
			</c:when>
		</c:choose>	
 	
 	
 	</tr>
	
</c:forEach>		
		
		
	


</table>




</body>
</html>
 -->