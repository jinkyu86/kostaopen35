<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<!DOCTYPE html> 
<html>
	<head>
		<meta charset="euc-kr"/> 	
		<meta name="viewport" 
				content="width=device-width, initial-scale=1.0, 
							maximum-scale=1.0, minimum-scale=1.0, 
							user-scalable=no"/>
		
		<link rel="shortcut icon" href="../image/icon.png">
		<link rel="apple-touch-icon" href="../image/icon.png">
		
		<link href="framework/jquery.mobile-1.0.css" rel="stylesheet" type="text/css" />
		<script src="framework/jquery-1.6.4.js"></script>
		<script src="framework/jquery.mobile-1.0.js"></script>
		
	</head>
	<body>
		<div data-role="page">

			<jsp:include page="/common/mHeader.jsp"></jsp:include>
			
			<div data-role="content" >
				<ul data-role="listview">
					<li data-role="list_divider">${MOVIE.mname}</li>
					<li>
						<img src="/moviesystem/movieimg/${MOVIE.poster}" style="width:220px;height:260px;" alt="${MOVIE.poster}">
						<label for="genre">장르 : </label>
						${MOVIE.genre}<br/>
						<label for="launchDate">개봉일 : </label>
						<fmt:formatDate value="${MOVIE.launchDate}" pattern="yyyy-MM-dd"/><br/>
						<label for="mprice">가격 : </label>
						${MOVIE.mprice}
					</li>
					<li><input type="button" value="예매"/></li>
					<li>${MOVIE.content}</li>
				</ul>
				<ul data-role="listview" style="margin-top:1%">
					<li data-role="list-divider">상영시간 표</li>
					<c:forEach var="scrList" items="${SCREENTIME_LIST}">
						<li>${scrList.time}</li>
					</c:forEach>
				</ul>
			</div>
			
			<div data-role="footer" data-position="fixed">
				<h3>Kosta JAVA 6 Team</h3>
			</div>
			
		</div>
	</body>
</html>