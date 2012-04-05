<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<p align="center" var=member >
<a href="/moviesystem/ReservationService?method=viewReservationListById">
예약 정보 조회
</a>
</p>

<p align="center" var=member >
<a href="/moviesystem/ReservationService?method=viewSeatListByScrnum&count=${count}">
좌석선택
</a>
</p>

<p align="center" var=member >
<a href="/moviesystem/ReservationService?method=addReservationForm">
예약 하기
</a>
</p>


<p align="center" var=member >
<a href="/moviesystem/ScreenTimeService?method=viewScreenTimeListBymnum&mnum=${movie.mnum}">
건축학계론=${movie.mnum}
</a>
</p>



<form action="/moviesystem/ReservationService" method="post">
	<input type="hidden" name="method" value ="viewSeatListByScrnum"/>
	<input type="hidden"name="mnum"value="${mnum}"readOnly="readOnly"/>
	<input type="hidden"name="scrnum"value="${scrnum}"readOnly="readOnly"/> 

		<table border="1" align="center">

			<tr>
				
				<td>아이디</td>
				<td>
				
				<input type="text"name="userid"value="${LOGIN_MEMBER.userid}"
					readOnly="readOnly"/> 
				
				
				</td>
				
			</tr>
			
			<tr>
				
			<td>영화명</td>
				<td>
				<input type="text"name="mnum1"value="1"
					readOnly="readOnly"/>

				</td>
			</tr>
			
			
			<tr>
			<td>시간</td>
				<td>
				<input type="text"name="scrnum1"value="4"
					readOnly="readOnly"/> 
				</td>
				
			</tr>
			
			
			
			<tr>
			
				<td><label >수량</label></td>
				<td><select name="resQty" id="resQty">
				<option value="1">       
							1
				</option>
				<option value="2">       
							2
				</option>
				<option value="3">       
							3
				</option>
				<option value="4">       
							4
				</option>
				<option value="5">       
							5
				</option>
				
				</select></td>
			
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







<%-- &userid=${member.userid}--%>
</body>
</html>