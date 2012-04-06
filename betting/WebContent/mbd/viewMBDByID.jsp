<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<form action="/betting/MemberBetDataService" method="post">
	<h3 align="center">나의 베팅 상세내역</h3>
		<table border="1" align="center">
		<tr>
			<td align="center">
				<img src="/betting/teamphoto/${BETTING_HOME.match.homeTeam.photo }" />
			</td>
			<th align="center">VS</th>
			<td align="center">
				<img src="/betting/teamphoto/${BETTING_AWAY.match.awayTeam.photo }" />
			</td>
		</tr>
		<tr>
			<td align="center">${BETTING_HOME.match.homeTeam.name }</td>
			<th align="center">팀 명</th>
			<td align="center">${BETTING_AWAY.match.awayTeam.name}</td>
		</tr>
		<tr>	
			<td align="center">${BETTING_HOME.batRating}</td>
			<th align="center">예상 배당률</th>
			<td align="center">${BETTING_AWAY.batRating}</td>
		</tr>
		<tr>
			<td align="center">${BETTING_HOME.seleRating}</td>
			<th align="center">선택률</th>
			<td align="center">${BETTING_AWAY.seleRating}</td>
		</tr>
		<tr>
			<td align="center">${BETTING_HOME.totMineral}</td>
			<th align="center">누적 미네랄</th>
			<td align="center">${BETTING_AWAY.totMineral}</td>
		</tr>
		
		<tr>
			<c:choose>
				<c:when test="${CHECK == '1' }">	
					<th align="center" colspan="3">종료 시간 : ${BETTING_HOME.match.matchTime}</th>
				</c:when>
				<c:otherwise>
					<th align="center" colspan="3">종료되었습니다.</th>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<th align="center">선택한 팀</th>
			<c:choose>
				<c:when test="${MBD.betting.distnum=='1' }">
					<td align="center" colspan="2">
						${MBD.betting.match.homeTeam.name}
						<input type="hidden" name="distnum" value="1"/>
					</td>
				</c:when>
				<c:otherwise>
					<td align="center" colspan="2">
						${MBD.betting.match.awayTeam.name}
						<input type="hidden" name="distnum" value="2"/>
					</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<c:choose>
			<c:when test="${MBD.betting.match.winTeam.num==null }">
				</c:when>
			<c:otherwise>
				<tr>
					<th align="center">승리팀</th>
					<td align="center" colspan="2">${MBD.betting.match.winTeam.name }</td>
				</tr>
			</c:otherwise>					
		</c:choose>
		<tr>
			<th align="center">베팅금</th>
			<td align="center" colspan="2">
				<input type="text" readOnly="readOnly" name="bmineral" value="${MBD.betMineral}"/>
			</td>
		</tr>
		<tr>
		<%--
			<th align="center">예상배당금</th>
			<td align="center" colspan="2">
				<input type="text" readOnly="readOnly" name="emineral" value="${MBD.betMineral*MBD.betting.batRating }"/>
			 --%>
			 <th align="center">예상배당금</th>
			<td align="center" colspan="2">
				<input type="text" readOnly="readOnly"
				 name="emineral" 
				 value="<fmt:formatNumber 
				                      value='${MBD.betMineral*MBD.betting.batRating }'
				                     maxFractionDigits='0'/>"/>
			
			</td>
		</tr>
	</table>
	<table border="1" align="center">
		
	</table>
	<c:choose>
		<c:when test="${CHECK == '1' }">	
			<table border="0" align="center">
				<tr>
					<td>
					<input type="submit" value="취소 하기"/>
					<input type="hidden" name="method" value="cancleBetting"/>
					</td>
				</tr>
			</table>
		</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${MBD.betting.distnum=='1' }">
						<c:choose>
							<c:when test="${MBD.betting.match.winTeam.num==null }">
								<table border="0" align="center">
									<tr>
										<th>진행중</th>
									</tr>
								</table>	
							</c:when>
							<c:when test="${MBD.betting.match.winTeam.num eq MBD.betting.match.homeTeam.num }">
								<c:choose>
									<c:when test="${MBD.giveMineralConfirm=='0' }">
										<table border="0" align="center">
											<tr>
												<td>
													<input type="submit" value="배당금 받기" /> 
													<input type="hidden" name="method" value="giveMineral" />
												</td>
												<th>배팅 성공</th>
											</tr>
										</table>
									</c:when>
									<c:otherwise>
										<table border="0" align="center">
											<tr>
												<th>배팅 성공</th>
											</tr>
										</table>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:when test="${MBD.betting.match.winTeam.num == '9'}">
								<c:choose>
									<c:when test="${MBD.giveMineralConfirm=='0' }">
										<table border="0" align="center">
											<tr>
												<td>
													<input type="submit" value="베팅금 돌려받기" /> 
													<input type="hidden" name="method" value="recoveryMineral" />
												</td>
												<th>무승부</th>
											</tr>
										</table>
									</c:when>
									<c:otherwise>
										<table border="0" align="center">
											<tr>
												<th>무승부</th>
											</tr>
										</table>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:when test="${MBD.betting.match.winTeam.num == '10'}">
								<c:choose>
									<c:when test="${MBD.giveMineralConfirm=='0' }">
										<table border="0" align="center">
											<tr>
												<td>
													<input type="submit" value="베팅금 돌려받기" /> 
													<input type="hidden" name="method" value="recoveryMineral" />
												</td>
												<th>경기취소</th>
											</tr>
										</table>
									</c:when>
									<c:otherwise>
										<table border="0" align="center">
											<tr>
												<th>경기취소</th>
											</tr>
										</table>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<table border="0" align="center">
									<tr>
										<th>배팅 실패</th>
									</tr>
								</table>
							</c:otherwise>
						</c:choose>
					</c:when>	
					<c:otherwise>
						<c:choose>
							<c:when test="${MBD.betting.match.winTeam.num==null }">
								<table border="0" align="center">
									<tr>
										<th>진행중</th>
									</tr>
								</table>	
							</c:when>
							<c:when test="${MBD.betting.match.winTeam.num eq MBD.betting.match.awayTeam.num }">
								<c:choose>
									<c:when test="${MBD.giveMineralConfirm=='0' }">
										<table border="0" align="center">
											<tr>
												<td>
													<input type="submit" value="배당금 받기" /> 
													<input type="hidden" name="method" value="giveMineral" />
												</td>
												<th>배팅 성공</th>
											</tr>
										</table>
									</c:when>
									<c:otherwise>
										<table border="0" align="center">
											<tr>
												<th>배팅 성공</th>
											</tr>
										</table>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:when test="${MBD.betting.match.winTeam.num == '9'}">
								<c:choose>
									<c:when test="${MBD.giveMineralConfirm=='0' }">
										<table border="0" align="center">
											<tr>
												<td>
													<input type="submit" value="베팅금 돌려받기" /> 
													<input type="hidden" name="method" value="recoveryMineral" />
												</td>
												<th>무승부</th>
											</tr>
										</table>
									</c:when>
									<c:otherwise>
										<table border="0" align="center">
											<tr>
												<th>무승부</th>
											</tr>
										</table>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:when test="${MBD.betting.match.winTeam.num == '10'}">
								<c:choose>
									<c:when test="${MBD.giveMineralConfirm=='0' }">
										<table border="0" align="center">
											<tr>
												<td>
													<input type="submit" value="베팅금 돌려받기" /> 
													<input type="hidden" name="method" value="recoveryMineral" />
												</td>
												<th>경기취소</th>
											</tr>
										</table>
									</c:when>
									<c:otherwise>
										<table border="0" align="center">
											<tr>
												<th>경기취소</th>
											</tr>
										</table>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<table border="0" align="center">
									<tr>
										<th>배팅 실패</th>
									</tr>
								</table>
							</c:otherwise>
						</c:choose>	
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
	
	<input type="hidden" name="home" value="${BETTING_HOME.num }"/>
	<input type="hidden" name="away" value="${BETTING_AWAY.num }"/>
	<input type="hidden" name="mbdnum" value="${MBD.num }"/>
	<input type="hidden" name="matchtime" value="${BETTING_HOME.match.matchTime}"/>
	</form>
		</section>
		</li>
	</ul>
	
</body>
</html>