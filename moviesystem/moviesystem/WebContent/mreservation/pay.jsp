<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
				
						<li data-role="list-divider">
						영화
						</li>
						<li>
						<h3>${reservation.movie.mname}</h3>
						</li>
						<li data-role="list-divider">
						상영시간
						</li>
						<li>
						<h3>${reservation.screenTime.time}</h3>
						</li>
						<li data-role="list-divider">
						수량
						</li>
						<li>
						<h3>${reservation.resQty}</h3>
						</li>
						<li data-role="list-divider">
						좌석
						</li>
						<li>
						<c:forEach var="SeatNumList" items="${SeatNumList}">
 		
							(${SeatNumList})
	
						</c:forEach>
						</li>
						<li data-role="list-divider">
						가격
						</li>
						<li>
						<h3>${reservation.totalPrice}</h3>
						</li>
				</ul>
			</div>
			<table border="0" align="center">
	<tr>
		<td>결제하기</td>
		<td><a href="/moviesystem/InsertReservation.action">
		<input type="button" value="확인"/>
		</a></td>
	</tr>
</table>

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


<table border="1" align="center">
	<tr>
		<th>영화</th>
		<th>상영시간</th>
		<th>수량</th>
		<th>좌석</th>
		<th>가격</th>
	</tr>
	
    <tr>
		<td>${reservation.movie.mname}</td>
		<td>
		<%-- <a href="/20120305/StudentService?method=viewStudent&studno=${student.studno}">--%>
		${reservation.screenTime.time}
		</td>
		<td>${reservation.resQty}</td>
		
		<td>
		
		
					<c:forEach var="SeatNumList" items="${SeatNumList}">
 		
							(${SeatNumList})
	
					</c:forEach>	
		
		
		</td>
	
		<td>${reservation.totalPrice}</td>
	</tr>
</table>

<table border="0" align="center">
	<tr>
		<td>결제하기</td>
		<td><a href="/moviesystem/InsertReservation.action">
		<input type="button" value="확인"/>
		</a></td>
	</tr>
</table>




</body>
</html>
  --> 