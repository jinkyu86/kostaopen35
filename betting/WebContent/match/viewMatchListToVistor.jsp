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
			<h2 align="center">경기 일정</h2>
	<form action="/betting/MarchService" method="post">
	<input type="hidden" name="method" value="addMatch">
	<table border="1" align="center">
		<tr>
			<th>홈팀</th>
			<th>어웨이팀</th>
			<th>경기장소</th>
			<th>경기시작시간</th>
			<th>경기결과</th>
			<th>스코어</th>
		</tr>
		<c:forEach var="match" items="${MATCH_LIST }">
		<tr>
			<td>${match.homeTeam.name}</td>
			<td>${match.awayTeam.name}</td>
			<td>${match.loc.loc}</td>
			<td>${match.matchTime}</td>
			<c:choose>
				<c:when test="${match.winTeam.num == null}">
					<td colspan="2" align="center">
						진행중
					</td>
				</c:when>
				<c:when test="${match.winTeam.num == '9'}">
					<td colspan="2" align="center">
						무승부
					</td>
				</c:when>
				<c:when test="${match.winTeam.num == '10'}">
					<td colspan="2" align="center">
						취소
					</td>
				</c:when>
				<c:otherwise>
					<td>${match.winTeam.name}</td>
					<td>${match.score}</td>
				</c:otherwise>
			</c:choose>
		</tr>
		</c:forEach>
	</table>
	</form>
	<p align="center">
		${PAGE_LINK_TAG }
	</p>
		</section>
		</li>
	</ul>
	
</body>
</html>