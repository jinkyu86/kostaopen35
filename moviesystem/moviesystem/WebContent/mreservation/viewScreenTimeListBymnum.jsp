<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="kr.or.kosta.moviesystem.reservation.Reservation" %>

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
				<h1>List Divider</h1>
			</div>

			<div data-role="content">
				<ul data-role="listview">
				<!-- JSTL의 forEach 태그를 이용해서 for 문을 실행 전체 학생 리스트: ${STUDENT_LIST}
				학생 한명 꺼내서 각 학생들의 학번 studno 이름 name 출력
				student/viewStudentList 참조
				 -->
				 
				 
				 		
						<li data-role="list-divider">
						${mname}
						</li>
						
						<c:forEach  var="screenTime"  items="${SCREENTIME_LIST}">	
						<li><a href="/moviesystem/maddReservationByTimeForm.action?scrnum=${screenTime.scrnum}&time=${screenTime.time}&mnum=${screenTime.movie.mnum}&mname=${screenTime.movie.mname}"">						
							<h3>${screenTime.time}</h3>
						</a>
						</li>
						</c:forEach>
				</ul>
			</div>
			

		</div>
	</body>
</html>



