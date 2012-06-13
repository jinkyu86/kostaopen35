<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="kr.or.kosta.moviesystem.reservation.Reservation" %>

<!DOCTYPE html> 
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

		<!--  
		<link href="http://code.jquery.com/mobile/latest/jquery.mobile.min.css" 
			rel="stylesheet" type="text/css" />
		<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
		<script src="http://code.jquery.com/mobile/latest/jquery.mobile.min.js"></script>
		-->
		
		<link href="../framework/jquery.mobile-1.0.css" 
			rel="stylesheet" type="text/css" />
		<script src="../framework/jquery-1.6.4.js"></script>
		<script src="../framework/jquery.mobile-1.0.js"></script>
	</head> 

	<body>
		<div data-role="page">       
			<jsp:include page="/common/mHeader.jsp"></jsp:include>

			<div data-role="content">
				
				<form id="joinForm" method="post" action="/moviesystem/mviewSeatListByScrnum.action">
				<input type="hidden" name="method" value ="viewSeatListByScrnum"/>
				<input type="hidden"name="mnum"value="${mnum}"/>
				<input type="hidden"name="scrnum"value="${scrnum}"readOnly="readOnly"/> 
					
				
					<table style="width:100%">
						<tr>
							<td>아이디</td>
							<td><input type="text"name="userid"value="${LOGIN_MEMBER.userid}"
					readOnly="readOnly"/></td>
						</tr>
						<tr>
							<td>영화명</td>
							<td><input type="text"name="mname"value="${MOVIE.mname}"
					readOnly="readOnly"/></td>
						</tr>
						<tr>
							<td>시간</td>
							<td><input type="text"name="time"value="${MOVIE.time}"
					readOnly="readOnly"/></td>
						</tr>
					</table>	
						<center>
						<div data-role="fildcontain">
							<label for="amount">수량선택<br></label>
							<input id="resQty" type="range" name="resQty" min="1" max="5" value="1"
							data-theme="e" data-track-theme="b"/>
						</div>	
						</center>
					<table>
					<tr></tr>
					</table>
					<center>
						<div data-role="controlgroup" data-type="horizontal">
							<input type="submit" value="예약하기" data-icon="arrow-r"/>
						</div>
					</center>
				</form>
			</div>
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
<script>

</script>
</head>
<body>



 
<form action="/moviesystem/viewSeatListByScrnum.action" method="post">
	<input type="hidden" name="method" value ="viewSeatListByScrnum"/>
	<input type="hidden"name="mnum"value="${mnum}"/>
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






</body>
</html>

-->