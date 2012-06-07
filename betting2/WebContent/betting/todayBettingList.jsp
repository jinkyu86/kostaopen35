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
 <c:if test="${SUCCESS!=null}">
 alert("${SUCCESS}");
</c:if>
</script>
</head>
<body>
	<ul>
				<!--
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
		-->
	
		<header>
			<p>
				<font color="black" style="font-size: 27px">2012 프로야구 베팅</font>
			</p>

			<c:choose>
				<c:when test="${sessionScope.LOGIN_MEMBER==null}">
					<table border="0" align="right">
						<tr>
							<td align="right">
								<a href="/betting/loginForm.action" ><font color=black>로그인</font></a>
							</td>
						</tr>
						<tr>
							<td align="right">		
								<a href="/betting/addMemberForm.action" ><font
									color=black>회원가입</font></a>
							</td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
					<p>
					<table border="0" align="right">
						<tr>
							<td colspan="2" align="right"><font color="black">${sessionScope.LOGIN_MEMBER.id }
									님 환영합니다</font></td>
						</tr>
						<tr>
							<td align="center"><font color="black">순위 : ${RANK }
									위|</font></td>
							<td align="center"><font color="black">미네랄 : ${MINERAL}
									</font></td>
						</tr>
						<tr>
							<td colspan="2" align="right"><a
								href="/betting/logout.action"> <font
									color="black">로그아웃</font>
							</a></td>
						</tr>
						<tr>
							<td colspan="2" align="right"><a
								href="/betting/editMemberForm.action"><font
									color="black"> 정보수정</font></a></td>
						</tr>
						<tr>
							<td colspan="2" align="right"><a
								href="/betting/viewMemberBetDataByIDList.action">
									<font color="black">나의 배팅 정보</font>
							</a></td>
						</tr>
					</table>
					</p>
				</c:otherwise>
			</c:choose>
		</header>
		<nav>
			<!-- top nav -->
			<div class="menu">
				<ul>
										<li><a
						href="/betting/viewHome.action">홈</a></li>
					<li><a
						href="/betting/viewMatchListToVistor.action">경기
							일정</a></li>
					<li><a href="/betting/todayBettingList.action">
							오늘의 베팅 </a></li>
					<li><a
						href="/betting/viewMemberRankingListForm.action">랭킹</a>
					</li>


					<c:choose>
						<c:when test="${sessionScope.LOGIN_MEMBER.id=='kosta100'}">
							<li><a href="/betting/viewMatchList.action">경기
									관리</a></li>
							<li><a href="/betting/viewMemberList.action">멤버
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
			<h2 align="center">오늘의 베팅 경기리스트</h2>
	<table border="1" align="center">
		<tr>
			<th>경기번호</th>
			<th>경기</th>
			<th>경기장소</th>
			<th>베팅 마감시간</th>
			
		</tr>
		<c:forEach var="match" items="${TODAY_MATCH}">
		<tr>
			<td align="center">
				<a href="/betting/bettingGameForm.action?matchno=${match.num }">
					${match.num}
				</a>
			</td>
			<td align="center">2012 프로야구 ${match.homeTeam.name} vs ${match.awayTeam.name}</td>
			<td align="center">${match.loc.loc}</td>
			<td align="center">${match.matchTime}</td>
			
		</tr>
		</c:forEach>
	</table>
		</section>
		</li>
	</ul>
	
</body>
</html>