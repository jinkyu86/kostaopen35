<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>예매하기</title>
</head>
<body>
<h1 align="center">예매하기</h1>
	<form action="/moviesystme12/ReservationService" method="post">
	<input type="hidden" name="method" value ="addReservation"/>
		<table>
			<tr>
				<td>영화명</td>
				<td>
					<select name="mname">
					
					<c:forEach var="movie" items="${MOVIE_LIST}">
 		
						<option value="${movie.mnum}">       
							${movie.mname}

						</option>
	
					</c:forEach>	

					</select>
				</td>
			</tr>
			<tr>
				<td>시간</td>
				<td><input type="text" name="studno"></td>
			</tr>
			<tr>
				<td>수량</td>
				<td><input type="text" name="name"></td>
			</tr>

			
			<tr>
				<td>
					<input type="submit" value="학생추가"/>
				</td>
				<td>
					<input type="reset" calue="취소"/>
				</td>
			</tr>
		</table>
	
	</form>
</body>
</html>