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
		
		<script type="text/javascript">
		 	<c:if test="${SUCCESS!=null}">
 			alert("${SUCCESS}");
			</c:if>
		</script>
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
			<h2>Betting</h2>
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
			<a href="/betting/mViewMatchListToVistor.action" data-role="button" >경기일정</a>
			<a href="/betting/mTodayBettingList.action" data-role="button" >오늘의 베팅</a>
			<a href="/betting/mViewMemberRankingListForm.action" data-role="button" >랭킹</a>
			<c:if test="${sessionScope.LOGIN_MEMBER.id=='kosta100' }">
				<a href="/betting/mViewMatchList.action" data-role="button" >경기관리</a>
				<a href="/betting/mViewMemberList.action" data-role="button" data-ajax="false">맴버관리</a>
			</c:if>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" data-iconpos="top">
				<ul>
					<c:choose>
						<c:when test="${sessionScope.LOGIN_MEMBER==null}">
						<li><a href="/betting/mAddMemberForm.action" data-icon="plus" data-ajax="false">회원가입</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/betting/mEditMemberForm.action" data-icon="info" data-ajax="false">회원정보수정</a></li>
						<li><a href="/betting/mViewMemberBetDataByIDList.action" data-icon="search">나의 베팅정보</a></li>
					</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>