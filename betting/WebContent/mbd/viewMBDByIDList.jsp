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
						href="/betting/MemberService?method=viewHome">홈</a></li>
					<li><a
						href="/betting/MatchService?method=viewMatchListToVistor">경기
							일정</a></li>
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
			<h2 align="center">나의 베팅데이터</h2>
	<table border="1" align="center">
		<tr>
			<th>번호</th>
			<th>경기날짜</th>
			<th>경기</th>
			<th>선택한팀</th>
			<th>배팅시간</th>
			<th>결과</th>
		</tr>
		<c:forEach var="mbd" items="${MBD_LIST }">
		<tr>
			<td>
			<a href="/betting/MemberBetDataService?method=viewMBDByIDForm&mbdnum=${mbd.num }">
					${mbd.num}
			</a>
			</td>
			<td>${mbd.betting.match.matchTime }</td>
			<td>2012 프로야구 ${mbd.betting.match.homeTeam.name} vs ${mbd.betting.match.awayTeam.name}</td>
			<td align="center">
				<c:choose>
					<c:when test="${mbd.betting.distnum == '1' }">
						${mbd.betting.match.homeTeam.name }
					</c:when>
					<c:otherwise>
					    ${mbd.betting.match.awayTeam.name }
					</c:otherwise>				
				</c:choose>
			</td>
			<td>${mbd.seleTime }</td>
			<td>
				<c:choose>
					<c:when test="${mbd.betting.match.winTeam.num==null }">
						진행중
					</c:when>
					<c:when test="${mbd.betting.match.winTeam.num == '9'}">
						<c:choose>
							<c:when test="${mbd.giveMineralConfirm =='0' }">
									<font color="red">무승부</font>
							</c:when>
							<c:otherwise>
								무승부
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:when test="${mbd.betting.match.winTeam.num == '10'}">
						<c:choose>
							<c:when test="${mbd.giveMineralConfirm =='0' }">
									<font color="red">취소</font>
							</c:when>
							<c:otherwise>
									취소
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${mbd.betting.distnum =='1' }">
								<c:choose>
									<c:when test="${mbd.betting.match.homeTeam.num == mbd.betting.match.winTeam.num }">
									<c:choose>
										<c:when test="${mbd.giveMineralConfirm =='0' }">
											<font color="red">성공</font>
										</c:when>
										<c:otherwise>
											성공
										</c:otherwise>
									</c:choose>
									</c:when>
									<c:otherwise>
										실패
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${mbd.betting.match.awayTeam.num == mbd.betting.match.winTeam.num }">
										<c:choose>
											<c:when test="${mbd.giveMineralConfirm =='0' }">
												<font color="red">성공</font>
											</c:when>
											<c:otherwise>
												성공
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										실패
									</c:otherwise>
								</c:choose>
							</c:otherwise>	
						</c:choose>
					</c:otherwise>
				</c:choose>
			</td>
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