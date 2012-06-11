<%@ page language="java" 
contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib  prefix="c" 
             uri="http://java.sun.com/jsp/jstl/core" %>
             
<!DOCTYPE html> 
<html> 
	<head>
		<title>Betting</title>
		<meta charset="euc-kr" /> 	
		<meta name="viewport" 
				content="width=device-width, initial-scale=1.0, 
							maximum-scale=1.0, minimum-scale=1.0, 
							user-scalable=no"/>
		
		<link rel="shortcut icon" href="../image/item_image27.png">
		<link rel="apple-touch-icon" href="../image/item_image27.png">

		 
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
			<h2>경기일정</h2>
			<a href="" data-icon="arrow-l" data-rel="back">이전</a>
			<c:choose>
				<c:when test="${sessionScope.LOGIN_MEMBER==null}">
				<a href="/betting/mLoginForm.action" class="ui-btn-right">로그인</a>
				</c:when>
				<c:otherwise>
				<p align="right">${sessionScope.LOGIN_MEMBER.id }님 / 랭킹 : ${RANK }위 / 미네랄 : ${MINERAL}</p>
				<a href="/betting/mLogout.action" class="ui-btn-right">로그아웃</a>
				</c:otherwise>
			</c:choose>
		</div>
		<div data-role="content">
			<ul data-role="listview">
				<c:forEach  var="member"  items="${MEMBER_LIST}">
					<li><a href="/betting/mEditMemberForm.action?ID=${member.id}">
						<h3>ID : ${member.id}</h3>
						<p>이름 : ${member.name}</p>
						<p>이메일 : ${member.email}</p>
					</a></li>
					</c:forEach>
				</ul>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" data-iconpos="top">
				<ul>
				<li><a href="/betting/mViewHome.action" data-icon="home">Home</a></li>
				<c:if test="${page!=1}">
					<li><a href="/betting/mViewMemberList.action?page=${page-1}" data-icon="arrow-l">이전</a></li>
				</c:if>
				<c:if test="${page<maxPage }">
					<li><a href="/betting/mViewMemberList.action?page=${page+1}" data-icon="arrow-r">다음</a></li>
				</c:if>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>