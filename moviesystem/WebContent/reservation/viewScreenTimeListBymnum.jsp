<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="kr.or.kosta.moviesystem.reservation.Reservation" %>
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
	<!-- 상단 메뉴 시작 -->
	<tr>
		<td>
			<jsp:include page="/common/top.jsp"></jsp:include>
		</td>
	</tr>
	<!-- 상단 메뉴 끝 -->
	
	<tr>		
		<!-- 본문 내용 시작 -->
<td>


<table border="1" align="center">
	<tr>
		<th>영화</th>
		<th>상영시간</th>


		
	</tr>

<c:forEach var="screenTime" items="${SCREENTIME_LIST}">
 		
		<tr>
		<td>${screenTime.movie.mname}</td>
		<td>

		<a href="/moviesystem/ReservationService?method=addReservationByTimeForm&scrnum=${screenTime.scrnum}&time=${screenTime.time}&mnum=${screenTime.movie.mnum}&mname=${screenTime.movie.mname}">
		${screenTime.time}
		</a>
		</td>
	
		
		</tr>
</c:forEach>		
		

</table>






</td>
	</tr>
	<!-- 본문 내용 끝 -->
	<!-- 하단 내용 시작 -->
	<tr>
		<td>
			<jsp:include page="/common/footer.jsp"></jsp:include>
		</td>
	</tr>
	<!-- 하단 내용 끝 -->
</table>
</body>
</html>