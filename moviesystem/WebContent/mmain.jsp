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
			<div data-role="header">
				<a href="#" data-icon="arrow-l" data-rel="back">이전</a>
				<h1>List Filter</h1>
				<a href="/moviesystem/member/mlogin.jsp">로그인</a>
			</div>
			<div data-role="header">
				<div data-role="navbar" data-iconpos="left">
					<ul>
						<li><a href="mmain.jsp" class="ui-btn-active">영화</a></li>
						<li><a href="mgood.jsp">쇼핑</a></li>
					</ul>
				</div>
			</div>
			<div data-role="content" style="height:100%">
				<ul data-role="listview">
					<li><a href="#"><img src="movieimg/hearo.jpg" style="width:180px;height:220px;"/> 제목 : 해로1<br/> 장르 : 드라마<br/>개봉일 : 2012.05.31</a></li>
					<li><a href="#"><img src="movieimg/hearo.jpg" style="width:180px;height:220px;"/> 제목 : 해로2<br/> 장르 : 드라마<br/>개봉일 : 2012.05.31</a></li>
					<li><a href="#"><img src="movieimg/hearo.jpg" style="width:180px;height:220px;"/> 제목 : 해로3<br/> 장르 : 드라마<br/>개봉일 : 2012.05.31</a></li>
					<li><a href="#"><img src="movieimg/hearo.jpg" style="width:180px;height:220px;"/> 제목 : 해로4<br/> 장르 : 드라마<br/>개봉일 : 2012.05.31</a></li>
					<li><a href="#"><img src="movieimg/hearo.jpg" style="width:180px;height:220px;"/> 제목 : 해로5<br/> 장르 : 드라마<br/>개봉일 : 2012.05.31</a></li>
				</ul>
			</div>
			
			<div data-role="footer" data-position="fixde">
				<h3>Kosta JAVA 6 Team</h3>
			</div>
		</div>
	</body>
</html>