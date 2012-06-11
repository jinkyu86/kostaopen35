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
				<h1>내 정보</h1>
			</div>
			<div data-role="content">	
				<form action="/bookchange/MemberService" method="post">
	  			<input type="hidden" name="method" value="viewMember">
	 			<input type="hidden" name="email" value="${sessionScope.LOGIN_EMAIL.email}">
	 			<div data-role="collapsible">
					<h3>Email</h3>
					<p>${MEMBER.email}</p>
				</div>
				<div data-role="collapsible">
					<h3>주소</h3>
					<p>${MEMBER.address}</p>
				</div>
				<div data-role="collapsible">
					<h3>핸드폰번호</h3>
					<p>${MEMBER.tel}}</p>
				</div>
				</form>
			</div>
			<div data-role="footer" data-position="fixed" >
				<div data-role="navbar" class="nav-glyphish-example">
					<ul>
						<li><a href="#" data-icon="plus">정보수정</a></li>
						<li><a href="#" data-icon="plus">회원탈퇴</a></li>
					</ul>
				</div>
			</div>
		</div>
	</body>
</html>