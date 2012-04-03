<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
		<td>${reservation.seatnum}</td>
		<td>${reservation.totalPrice}</td>
	</tr>
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