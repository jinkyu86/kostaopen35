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
		
		<header>
			<p>
				<font color="white" style="font-size: 27px">2012 프로야구 베팅</font>
			</p>
			
			<c:choose>
				<c:when test="${sessionScope.LOGIN_MEMBER==null}">
					<table border="0" align="right">
						<tr>
							<td align="right">
								<a href="/betting/MemberService?method=loginForm" onfocus=blur()><font
									color=black>로그인</font></a>
							</td>
						</tr>
						<tr>
							<td align="right">		
								<a href="/betting/MemberService?method=addMemberForm" onfocus=blur()><font
									color=black>회원가입</font></a>
							</td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
					<p>
					<table border="0" align="right">
						<tr>
							<td colspan="2" align="right"><font color="white">${sessionScope.LOGIN_MEMBER.name}
									님 환영합니다</font></td>
						</tr>
						<tr>
							<td align="center"><font color="white">순위 : ${RANK }
									위|</font></td>
							<td align="center"><font color="white">미네랄 : ${MINERAL}
									</font></td>
						</tr>
						<tr>
							<td colspan="2" align="right"><a
								href="/betting/MemberService?method=logout"> <font
									color="white">로그아웃</font>
							</a></td>
						</tr>
						<tr>
							<td colspan="2" align="right"><a
								href="/betting/MemberService?method=editMemberForm"><font
									color="white"> 정보수정</font></a></td>
						</tr>
						<tr>
							<td colspan="2" align="right"><a
								href="/betting/MemberBetDataService?method=viewMemberBetDataByIDList">
									<font color="white">나의 배팅 정보</font>
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
						href="/betting/MemberService?method=viewHome">홈</a></li>
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
			<form action="/betting/MatchService" method="post">
	<input type="hidden" name="method" value="editMatch"/>
	<h3 align="center">경기 데이터 수정</h3>
	<table border="1" align="center">
		<tr>
			<th>경기번호</th>
			<td><input type="text" name="matchno" 
					value="${MATCH.num}" readOnly="readOnly" /></td>
		</tr>
		<tr>
			<th>홈팀</th>
			<td>
					<select name="hometeamno">
						<c:forEach var="team" items="${TEAM_LIST }" end="7">
							<option value="${team.num}"
								<c:if test="${MATCH.homeTeam.num eq team.num}">
								selected="selected"
								</c:if>
							>
								${team.name}
							</option>
						</c:forEach>
				 	</select>
			</td>
		</tr>
		<tr>
			<th>어웨이팀</th>
			<td>
				<select name="awayteamno">
						<c:forEach var="team" items="${TEAM_LIST }" end="7">
							<option value="${team.num}"
							<c:if test="${MATCH.awayTeam.num eq team.num}">
								selected="selected"
							</c:if>
							>
								${team.name}
							</option>
						</c:forEach>
				 	</select>
			</td>
		</tr>
		<tr>
			<th>경기장소</th>
			<td>
				<select name="locno">
				 		<c:forEach var="loc" items="${LOC_LIST }">
							<option value="${loc.num}"
							<c:if test="${MATCH.loc.num eq loc.num}">
								selected="selected"
							</c:if>
							>
								${loc.loc}
							</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th>경기시작시간</th>
			<td><input type="text" name="matchtime" 
					value="${MATCH.matchTime}" /></td>
		</tr>
		<tr>
			<th>경기결과</th>
			<td>
				<select name="winteamno">
						<c:forEach var="team" items="${TEAM_LIST }" >
							<option value="${team.num}"
							<c:if test="${MATCH.winTeam.num eq team.num}">
								selected="selected"
							</c:if>
							>
								${team.name}
							</option>
						</c:forEach>
				 </select>
			</td>
		</tr>
		<tr>
			<th>스코어</th>
			<td><input type="text" name="score" 
					value="${MATCH.score}" /></td>
		</tr>
	</table>
	<table border="0" align="center">
		<tr>
			<td>
					<input type="submit" value="경기데이터수정"/>
			</td>
			<td>
					<input type="reset" value="입력취소"/>
			</td>
			
		</tr>
	</table>
	
</form>
	<table border="0" align="center">
		<tr>
			<th>
				<a href="/betting/MatchService?method=removeMatch&matchno=${MATCH.num }">
					데이터 삭제
				</a>
	        </th>
		</tr>
	<c:choose>
		<c:when test="${BETTING eq '2' }">
			<tr>
				<th>베팅테이블에 입력된 데이터 입니다.</th>
			</tr>
		</c:when>
		<c:otherwise>
			<tr>
				<th>
					<a href="/betting/BettingService?method=insertBetting&matchno=${MATCH.num }">
					 	베팅테이블 데이터 입력
					</a>
				</th>
			</tr>	
		</c:otherwise>
	</c:choose>
	</table>
		</section>
		</li>
	</ul>
	
</body>
</html>