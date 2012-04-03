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





<form action="/moviesystem/ReservationService" method="post">
	<input type="hidden" name="method" value ="addReservation"/>
	<input type="hidden"name="mnum"value="${mnum}"readOnly="readOnly"/>
	<input type="hidden"name="scrnum"value="${scrnum}"readOnly="readOnly"/> 

		<table border="1" align="center">

			<tr>
				
				<td>아이디</td>
				<td>
				
				<input type="text"name="userid"value="${member.userid}"
					readOnly="readOnly"/> 
				
				
				</td>
				
			</tr>
			
			<tr>
				
			<td>영화명</td>
				<td>
				<input type="text"name="mname"value="${mname}"
					readOnly="readOnly"/>

				</td>
			</tr>
			
			
			<tr>
			<td>시간</td>
				<td>
				<input type="text"name="time"value="${time}"
					readOnly="readOnly"/> 
				</td>
				
			</tr>
			
			
			
			<tr>
				<td>수량</td>
				<td><input type="text" name="resQty"></td>
			</tr>

			
			<tr>
				<td>
					<input type="submit" value="예약"/>
				</td>
				<td>
					<input type="reset" value="취소"/>
				</td>
			</tr>
		</table>
	
	</form>








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