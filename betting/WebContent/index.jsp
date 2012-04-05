<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<html lang="en">
<head>
<title>BETTING</title>
<link rel="stylesheet" href="styles.css" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
	<ul>
		<div ALIGN="right">
			<a href="/betting/MemberService?method=loginForm" onfocus=blur()><font
				color=black>로그인</font></a>/<a
				href="/betting/MemberService?method=addMemberForm" onfocus=blur()><font
				color=black>회원가입</font></a>
		</div>
		<header>
			<p>
				<font  color="white" style="font-size: 30px">2012 프로야구 베팅</font>
			</p>

			<c:choose>
				<c:when test="${sessionScope.LOGIN_MEMBER==null}">
				</c:when>
				<c:otherwise>
					<p align="right">
						${sessionScope.LOGIN_MEMBER.name} 로그인 되었습니다. <br /> <a
							href="/betting/MemberService?method=logout"> 로그아웃 </a>
							 <a
							href="/betting/MemberService?method=editMemberForm"> 정보수정</a>
							 <a
							href="/betting/MemberBetDataService?method=viewMemberBetDataByIDList"> 나의 배팅 정보</a>
					</p>
				</c:otherwise>
			</c:choose>
		</header>
		<nav>
			<!-- top nav -->
			<div class="menu">
				<ul>
					<li><a href="/betting/MatchService?method=viewMatchList">경기
							일정</a></li>
					<li><a href="/betting/BettingService?method=todayBettingList">
							오늘의 베팅 </a></li>
					<li><a
						href="/betting/MemberService?method=viewMemberRankingListForm">랭킹</a>
					</li>
				</ul>
			</div>
		</nav>
		<!-- end of top nav -->
		<section id="content"></section>
		</li>
	</ul>
</body>
</html>