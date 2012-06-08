<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html> 
<html> 
	<head>
				<title>회원조회</title>
		<meta charset="euc-kr"/> 	
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
				<div data-role="controlgroup" data-type="horizontal" >
					<a href="/moviesystem/mmember/mloginForm.action" data-role="button" >Login</a>
					<a href="/moviesystem/mmember/maddMemberForm.action" data-role="button">Join</a>
				</div>
			</div><!-- end header 1-->
			
			<div data-role="header">
				<div data-role="navbar">
					<ul>
						<li><a href="#">Movie</a></li>
						<li><a href="#">Reservation</a></li>
						<li><a href="/moviesystem/mgood/mViewGoodList.action" class="ui-btn-active">Shopping</a></li>
					</ul>
				</div>
			</div><!-- end header2 -->
			<div data-role="content">				
				<div data-role="collapsible-set">
					<div data-role="collapsible">
						<h3>회원번호</h3>
						<p>${MEMBER.userNum}</p>
					</div>
					
					<div data-role="collapsible" data-collapsed="true">
						<h3>이름</h3>
						<p>${MEMBER.name}</p>
					</div>
					<div data-role="collapsible" data-collapsed="true">
						<h3>아이디</h3>
						<p>${MEMBER.userid}</p>
					</div>
					<div data-role="collapsible" data-collapsed="true">
						<h3>비밀번호</h3>
						<p>${MEMBER.pw}</p>
					</div>
					<div data-role="collapsible" data-collapsed="true">
						<h3>이메일</h3>
						<p>${MEMBER.email}</p>
					</div>
					<div data-role="collapsible" data-collapsed="true">
						<h3>전화번호</h3>
						<p>${MEMBER.phone}</p>
					</div>		
					<div data-role="collapsible" data-collapsed="true">
						<h3>우편번호</h3>
						<p>${MEMBER.zipcode}</p>
					</div>		
					<div data-role="collapsible" data-collapsed="true">
						<h3>주소</h3>
						<p>${MEMBER.addr}</p>
					</div>												
				</div>
			</div>
			
		</div>
	</body>
</html>