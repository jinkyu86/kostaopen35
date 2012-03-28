<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ReservationListById</title>
</head>
<body>
		
<table border="1" align="center">
	<tr>
		<th>영화</th>
		<th>상영시간</th>
		<th>좌석</th>
		<th>예매날짜</th>
	</tr>

<c:forEach var="reservation" items="${RESERVATION_LIST}">
 		
		<tr>
		<td>${reservation.movie.mname}</td>
		<td>
		<%-- 	<a href="/20120305/StudentService?method=viewStudent&studno=${student.studno}">--%>
		${reservation.screenTime.time}
		</td>
		<td>${reservation.seatnum}</td>
		<td>${reservation.resDate}</td>
		</tr>
</c:forEach>		

</table>



</body>
</html>