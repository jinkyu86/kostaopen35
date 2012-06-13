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
				<a href="/bookchange/mviewBoardList.action" data-icon="arrow-l" data-ajax="false">이전</a>
				<h1>교환정보</h1>
			</div>
			<div data-role="content">	
				<ul data-role="listview" data-inset="true">
				 <li><a href="/bookchange/msearchBoardList.action?categoryNo&column=email&keyword=${sessionScope.LOGIN_EMAIL.email}">등록한 책 목록</a></li>
				 <li><a href="/bookchange/mrequestChangeList.action">요구한 신청내역</a></li>
				 <li><a href="/bookchange/macceptChangeList.action">들어온 신청내역</a></li>
				 <li><a href="/bookchange/mmatchChangeList.action">교환진행중인 책</a></li>
				 <li><a href="/bookchange/mmatchChangeResultList.action">교환완료된 책</a></li>
				 <li><a href="/bookchange/BlockService?method=selectMyBlockList">신고하기</a></li>
				</ul>
			</div>
		</div>
	</body>
</html>