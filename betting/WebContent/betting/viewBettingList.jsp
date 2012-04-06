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
<script type="text/javascript">
 <c:if test="${ERROR!=null}">
  alert("${ERROR}");
 </c:if>
 <c:if test="${SUCCESS!=null}">
 alert("${SUCCESS}");
</c:if>
</script>
</head>
<body>
	<ul>
		<c:choose>
			<c:when test="${sessionScope.LOGIN_MEMBER==null}">
				<div ALIGN="right">
					<a href="/betting/MemberService?method=loginForm" onfocus=blur()><font
						color=black>로그인</font></a>/<a
						href="/betting/MemberService?method=addMemberForm" onfocus=blur()><font
						color=black>회원가입</font></a>
				</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		<header>
			<p>
				<font color="white" style="font-size: 27px">2012 프로야구 베팅</font>
			</p>

			
		</header>
		<nav>
			<!-- top nav -->
			<div class="menu">
				<ul>
										<li><a
						href="/betting/index.jsp">홈</a></li>
					<li><a
						href="/betting/MatchService?method=viewMatchListToVistor">경기
							일정</a></li>
					<li><a href="/betting/BettingService?method=todayBettingList">
							오늘의 베팅 </a></li>
					<li><a
						href="/betting/MemberService?method=viewMemberRankingListForm">랭킹</a>
					</li>


					<c:choose>
						<c:when test="${sessionScope.LOGIN_MEMBER.id=='kosta100'}">
							<li><a href="/betting/MatchService?method=viewMatchList">경기
									관리</a></li>
							<li><a href="/betting/MemberService?method=viewMemberList">멤버
									관리</a></li>
						</c:when>
						<c:otherwise>

						</c:otherwise>
					</c:choose>



				</ul>
			</div>
		</nav>
		<!-- end of top nav -->
		<section id="content">
			<h2 align="center">베팅 리스트</h2>
	<table border="1" align="center">
		<tr>
			<th>베팅번호</th>
			<th>경기번호</th>
			<th>홈/어웨이</th>
			<th>팀</th>
			<th>배당률</th>
			<th>선택률</th>
			<th>누적 미네랄</th>
			<th>베팅종료시간</th>
		</tr>
		<c:forEach var="betting" items="${BETTING_LIST }">
		<tr>
			<td>${betting.num}</td>
			<td>${betting.match.num}</td>
			<c:choose>
			 	<c:when test="${betting.distnum == '1'}">
			 		<td>홈</td>
				</c:when>
				<c:otherwise>
					<td>어웨이</td>
				</c:otherwise>
			</c:choose>
			<c:choose>
			 	<c:when test="${betting.distnum == '1'}">
			 		<td>${betting.match.homeTeam.name}</td>
				</c:when>
				<c:otherwise>
					<td>${betting.match.awayTeam.name}</td>
				</c:otherwise>
			</c:choose>
			<td>${betting.batRating}</td>
			<td>${betting.seleRating}</td>
			<td>${betting.totMineral}</td>
			<td>${betting.match.matchTime}</td>
		</tr>
		</c:forEach>
	</table>
	<p align="center">
		${PAGE_LINK_TAG }
	</p>
		</section>
		</li>
	</ul>
	
</body>
</html>