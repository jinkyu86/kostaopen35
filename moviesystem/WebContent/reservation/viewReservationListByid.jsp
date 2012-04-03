<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ReservationListById</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.jsp"></script>
</head>
<body>
<table width="90%" align="center">
	<!-- 상단 메뉴 시작 -->
	<tr>
		<td colspan="2">
			<jsp:include page="/common/top.jsp"></jsp:include>
		</td>
	</tr>
	<!-- 상단 메뉴 끝 -->
	
	<tr>
		<!-- 좌측 메뉴 시작 -->
		<td valign="top" style="width:20%">
			<jsp:include page="/member/MypagLeft.jsp"></jsp:include>
		</td>
		<!-- 좌측 메뉴 끝 -->
		
		<!-- 본문 내용 시작 -->
		<td align="center">



<table border="1" align="center">
	<tr>
		<th>영화</th>
		<th>상영시간</th>
		<th>좌석</th>
		<th>수량</th>
		<th>예매날짜</th>
		<th>결제상태</th>
		<th>결제</th>

		
	</tr>

<c:forEach var="reservation" items="${RESERVATION_LIST}">
 		
		<tr>
		<td>
			<c:choose>
									<c:when test="${fn:length(reservation.movie.mname)>9}">
										${fn:substring(reservation.movie.mname, 0, 8)}
									</c:when>
									<c:otherwise>
										${reservation.movie.mname}
									</c:otherwise>
			</c:choose>
			
		</td>
		<td>
		<a href="/moviesystem/ReservationService?method=viewReservationByResNumForm&resnum=${reservation.resnum}&select=${0}">
		${reservation.screenTime.time}
		</a>
		</td>
		<td>${reservation.seatnum}</td>
		<td>${reservation.resQty}</td>
		<td>${reservation.resDate}</td>
		<td>
		${reservation.payState}
		</td>
		
		<c:choose>
			<c:when test="${reservation.payState=='결제대기' }">
				<td><a href="/moviesystem/ReservationService?method=viewReservationByResNumForm&resnum=${reservation.resnum}&select=${1}">
				<input type="button" value="결제"/>
				</a></td>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${reservation.payState=='결제완료' }">
				<td><a href="/moviesystem/ReservationService?method=viewReservationByResNumForm&resnum=${reservation.resnum}&select=${2}">
				<input type="button" value="취소"/>
				</a></td>
			</c:when>
		</c:choose>	
		
		
		
		
		</tr>
</c:forEach>		
		

</table>


<p align="center">
	${PAGE_LINK_TAG}
</p>



		</td>
	</tr>
	<!-- 본문 내용 끝 -->
	<!-- 하단 내용 시작 -->
	<tr>
		<td colspan="2">
			<jsp:include page="/common/footer.jsp"></jsp:include>
		</td>
	</tr>
	<!-- 하단 내용 끝 -->
</table>

</body>
</html>