<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html> 
<html>
	<head>
		<meta charset="euc-kr"/> 	
		<meta name="viewport" 
				content="width=device-width, initial-scale=1.0, 
							maximum-scale=1.0, minimum-scale=1.0, 
							user-scalable=no"/>
		<title>MovieSystem</title>
		<link rel="shortcut icon" href="../image/icon.png">
		<link rel="apple-touch-icon" href="../image/icon.png">
		<link href="http://code.jquery.com/mobile/latest/jquery.mobile.min.css" 
			rel="stylesheet" type="text/css" />
		<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
		<script src="http://code.jquery.com/mobile/latest/jquery.mobile.min.js"></script>
	</head>
	<body>
		<div data-role="page">

			
			<jsp:include page="/common/mHeader.jsp"></jsp:include>
			
			<div data-role="content" style="height:100%">
				<ul data-role="listview">
					<c:forEach var="movieList" items="${MOVIE_LIST}">
						<li><a href="#"><img src="movieimg/${movieList.poster}" style="width:180px;height:220px;"/> 제목 : ${movieList.mname}<br/> 장르 : ${movieList.genre}<br/>개봉일 : <fmt:formatDate value="${movieList.launchDate}" pattern="yyyy-MM-dd"/></a></li>
						
					</c:forEach>
				</ul>
			</div>
			<div data-role="footer">
				<div data-role="navbar">
					<ul>
						<c:if test="${page != 1 }">
							<li><a href="/moviesystem/mviewMovieList.action?page=${page-1}" data-icon="arrow-l">이전</a></li>
						</c:if>
						<c:if test="${page<MaxPage}">
							<li><a href="/moviesystem/mviewMovieList.action?page=${page+1}" data-icon="arrow-r">다음</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<div data-role="footer" data-position="fixde">
				<h3>Kosta JAVA 6 Team</h3>
			</div>
		</div>
	</body>
</html>