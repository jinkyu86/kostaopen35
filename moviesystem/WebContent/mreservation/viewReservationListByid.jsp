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
			<div data-role="header">
				<h1>예매목록 보기(viewReservationListByid.jsp)</h1>
			</div>

			<div data-role="content">
				<ul data-role="listview">
				<!-- JSTL의 forEach 태그를 이용해서 for 문을 실행 전체 학생 리스트: ${STUDENT_LIST}
				학생 한명 꺼내서 각 학생들의 학번 studno 이름 name 출력
				student/viewStudentList 참조
				 -->
				 	<li data-role="list-divider">
						영화
						</li>
				 	<c:forEach  var="reservation"  items="${RESERVATION_LIST}">	
						
						<li><a href="/moviesystem/mviewReservationTimeForm.action?mname=${reservation.movie.mname}">
										${reservation.movie.mname}
						</a>
						</li>
						</c:forEach>
				</ul>
			</div>
			
			<div data-role="footer" data-position="fixed">
				<div data-role="navbar">
					<ul>
						<c:if test="${page !=1}">
						<li><a href="/moviesystem/mviewReservationListById.action?page=${page-1}" data-icon="arrow-l">이전</a></li>
						</c:if>
						
						<c:if test="${page !=maxPage}">
						<li><a href="/moviesystem/mviewReservationListById.action?page=${page+1}" data-icon="arrow-r">다음</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</body>
</html>




<!--  
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

<table border="1" align="center">
	<tr>
		<th>영화</th>
		
	</tr>

<c:forEach var="reservation" items="${RESERVATION_LIST}">
 		
		<tr>
		<td>
			<c:choose>
									<c:when test="${fn:length(reservation.movie.mname)>9}">
										<a href="/moviesystem/viewReservationTimeForm.action?mname=${reservation.movie.mname}">
										${fn:substring(reservation.movie.mname, 0, 8)}
										</a>
									</c:when>
									<c:otherwise>
										<a href="/moviesystem/viewReservationTimeForm.action?mname=${reservation.movie.mname}">
										${reservation.movie.mname}
										</a>
									</c:otherwise>
			</c:choose>
			
		</td>
		</tr>
</c:forEach>		
		

</table>


<p align="center">
	${PAGE_LINK_TAG}
</p>




</body>
</html>


-->