<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>예매하기</title>
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$.getJSON('/moviesystem/ReservationService',
			{"movies" : "1"},
			function(data){
				$("#time").empty();
				//data에 들어있는 json객체의 수 리턴
				//alert(data);
				var length = data.length;
				for(var i=0; i<length; i++){
					alert(data[i].scrnum);
					var option = "<option value="+ data[i].scrnum +">"+ data[i].time +"</option>";
					
					$("#time").append(option);
				}
		});
		
		$("#movies").change(function(){
			var movies = $("#movies").val();
			$.getJSON('/moviesystem/ReservationService',
				{"movies" : movies},
				function(data){
					//이이디가 model인 객체의 내용 삭제
				$("#time").empty();
					//data에 들어있는 json객체의 수 리턴
				var length = data.length;
				for(var i=0; i<length; i++){
					var option = "<option value="+ data[i].scrnum +">"+ data[i].time +"</option>";
					$("#time").append(option);
				}
			});
		});		
	});
</script>
</head>
<body>
<h1 align="center">예매하기</h1>
	<form action="/moviesystem/ReservationService" method="post">
	<input type="hidden" name="method" value ="addReservation"/>
		<table>

			<tr>
				
				<td>아이디</td>
				<td>
				
				<input type="text"name="userid"value="${userid}"
					readOnly="readOnly"/> 
				
				
				</td>
				
			</tr>
			
			<tr>
				
				<td>영화명</td>
				<td>
					<select name="movies" id="movies">
					
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
				<td><select name="time"id="time"></select></td>
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
					<input type="reset" calue="취소"/>
				</td>
			</tr>
		</table>
	
	</form>
</body>
</html>