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
				<h1>List Divider</h1>
			</div>

			<div data-role="content">
						
				<div data-role="navbar" data-iconpos="left">
					<ul>
						<li><a href="#" data-icon="star">스</a></li>
						<li><a href="#" data-icon="star">크</a></li>
						<li><a href="#" data-icon="star">린</a></li>
					</ul>
					
				</div>
			
				<table border="0" align="center">
					
					<!--  
					<tr>
						
						<th><input type="button" value="백"/></th>
						<th><input type="button" value="원"/></th>
						<th><input type="button" value="영"/></th>
						<th><input type="button" value="화"/></th>
						<th><input type="button" value="관"/></th>
						<th><input type="button" value="스"/></th>
						<th><input type="button" value="크"/></th>
						<th><input type="button" value="린"/></th>
					</tr>
				
				-->
				<c:forEach var="reservation" items="${TotalSeatList}"  varStatus="i">
				 	
						
				 		
				 	    <c:choose>
							<c:when test="${reservation==0 }">		
				 				<td>
				 				<a href="/moviesystem/mSelectSeat.action?seatString=${i.count}">
								${i.count }
								</a>
								</td>
							</c:when>
							<c:otherwise>
								<td>
								x
								</td>
							</c:otherwise>
						</c:choose>
					
						
						<c:choose>
							<c:when test="${i.count%8==0 }">		
								<tr>
				
								</tr>
							</c:when>
				
						</c:choose>
				
				
				</c:forEach>		
						
				
				
				</table>
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
</head>
<body>
<table width="90%" align="center">
	
<table border="1" align="center">
	<tr>
		<th>좌</th>
		<th></th>
		<th></th>
		<th></th>
		<th></th>
		<th></th>
		<th></th>
		<th>석</th>
	</tr>


<c:forEach var="reservation" items="${TotalSeatList}"  varStatus="i">
 	
		
 		
 	    <c:choose>
			<c:when test="${reservation==0 }">		
 				<td>
				<a href="/moviesystem/SelectSeat.action?seatString=${i.count}">
				${i.count }
				</a>
				</td>
			</c:when>
			<c:otherwise>
				<td>
				x
				</td>
			</c:otherwise>
		</c:choose>
	
		
		<c:choose>
			<c:when test="${i.count%8==0 }">		
				<tr>

				</tr>
			</c:when>

		</c:choose>


</c:forEach>		
		


</table>



</body>
</html>
-->

 <!--  <table border="0" padding="3" margin="3">
 	<tr>
 	  <td background="gray" onClick="select()">  </td>
 	  
 </table> -->