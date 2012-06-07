<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html >
<html lang="en">
<head >
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
<body style="text-align:center">
	<ul id="center1" style="text-align:center">
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
	
		<header >
			<!--<p>
				<font color="black" style="font-size: 35px">2012 프로야구 베팅</font>
			</p>-->
			<div id="subject">
				<h1>2012 프로야구 베팅</h1>
			</div>
			
			<div id="login">
			<c:choose>
				<c:when test="${sessionScope.LOGIN_MEMBER==null}">
					<br/>
					<br/>
					<br/>
					<table align="right" style="margin-left:auto">
						<tr>
							<td align="right">
								<a href="/betting/loginForm.action" ><font color=white size="2pt">로그인</font></a>
							</td>
						</tr>
						<tr>
							<td align="right">		
								<a href="/betting/addMemberForm.action" ><font
									color=white size="2pt">회원가입</font></a>
							</td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
					<table align="right" style="margin-left:auto">
						<tr>
							<td colspan="2" align="right"><font color="white" size="2pt">${sessionScope.LOGIN_MEMBER.id }
									님 환영합니다</font></td>
						</tr>
						<tr>
							<td align="center"><font color="white" size="2pt">순위 : ${RANK }
									위|</font></td>
							<td align="center"><font color="white" size="2pt">미네랄 : ${MINERAL}
									</font></td>
						</tr>
						<tr>
							<td colspan="2" align="right"><a
								href="/betting/logout.action"> <font color="white" size="2pt">로그아웃</font>
							</a></td>
						</tr>
						<tr>
							<td colspan="2" align="right">
							<a href="/betting/editMemberForm.action"><font
									color="white" size="2pt"> 정보수정</font></a></td>
						</tr>
						<tr>
							<td colspan="2" align="right"><a
								href="/betting/viewMemberBetDataByIDList.action">
									<font color="white" size="2pt">나의 배팅 정보</font>
							</a></td>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
			</div>
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
			<form action="/betting/editMatch.action" method="post">
	
	<h3 align="center">경기 데이터 수정</h3>
	<table border="1" align="center" style="margin:auto">
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
			<th>승리팀</th>
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
				 <input type="checkbox" name="checkbox" value="1"/>결과수정시 체크
			</td>
		</tr>
		<tr>
			<th>스코어</th>
			<td><input type="text" name="score" 
					value="${MATCH.score}" /></td>
		</tr>
	</table>
	<table border="0" align="center" style="margin:auto">
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
	<table border="0" align="center" style="margin:auto">
		<tr>
			<th>
				<a href="/betting/removeMatch.action?matchno=${MATCH.num }">
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
					<a href="/betting/insertBetting.action?matchno=${MATCH.num }">
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