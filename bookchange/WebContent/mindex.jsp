<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>
	<head>
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
	</head>
	<body>
		<div data-role="page">
			<div data-role="header">
				<a href="#" data-icon="arrow-l">이전</a>
				<h1>Book List</h1>
				<a href="#" data-icon="arrow-r">다음</a>
			</div>
			<div data-role="content">
				<ul data-role="listview">
					<c:forEach var="board" items="${BOARD_LIST}">
						<li><a href="#"><img src="/bookchange/bookimg/${board.boardPhoto}"/>${board.boardWant}</a></li>
					</c:forEach>
				</ul>
			</div>
			<c:choose>
			<c:when test="${sessionScope.LOGIN_EMAIL==null}">
			<div data-role="footer" data-position="fixed" >
				<div data-role="navbar" class="nav-glyphish-example">
					<ul>
						<li><a href="#" data-icon="plus">로그인</a></li>
						<li><a href="#" data-icon="plus">회원가입</a></li>
					</ul>
				</div>
			</div>
			</c:when>
			<c:otherwise>
			<div data-role="footer" data-position="fixed" >
				<div data-role="navbar" class="nav-glyphish-example">
					<ul>
						<li><a href="#" data-icon="plus">로그아웃</a></li>
						<li><a href="#" data-icon="plus">내 정보</a></li>
						<li><a href="#" data-icon="plus">물품등록</a></li>
						<li><a href="#" data-icon="plus">교환정보</a></li>
					</ul>
				</div>
			</div>
			</c:otherwise>
			</c:choose>
		</div>
	</body>
</html>