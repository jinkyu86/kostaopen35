<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<form action="/betting/mineral.action" method="post">
	<h3 align="center">나의 베팅 상세내역</h3>
		<table border="1" align="center" style="margin:auto">
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
						<input type="hidden" name="districtnum" value="1"/>
					</td>
				</c:when>
				<c:otherwise>
					<td align="center" colspan="2">
						${MBD.betting.match.awayTeam.name}
						<input type="hidden" name="districtnum" value="2"/>
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
				 value="<fmt:formatNumber value='${MBD.betMineral*MBD.betting.batRating }' maxFractionDigits='0'/>"
				 />
			
			</td>
		</tr>
	</table>
	<c:choose>
		<c:when test="${CHECK == '1' }">	
			<table border="0" align="center" style="margin:auto">
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
								<table border="0" align="center" style="margin:auto">
									<tr>
										<th>진행중</th>
									</tr>
								</table>	
							</c:when>
							<c:when test="${MBD.betting.match.winTeam.num eq MBD.betting.match.homeTeam.num }">
								<c:choose>
									<c:when test="${MBD.giveMineralConfirm=='0' }">
										<table border="0" align="center" style="margin:auto">
											<tr><th>배팅 성공</th></tr>
											<tr>
												<td>
													<input type="submit" value="배당금 받기" /> 
													<input type="hidden" name="method" value="giveMineral" />
												</td>
											</tr>
										</table>
									</c:when>
									<c:otherwise>
										<table border="0" align="center" style="margin:auto">
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
										<table border="0" align="center" style="margin:auto">
											<tr><th>무승부</th></tr>
											<tr>
												<td>
													<input type="submit" value="베팅금 돌려받기" /> 
													<input type="hidden" name="method" value="recoveryMineral" />
												</td>
												
											</tr>
										</table>
									</c:when>
									<c:otherwise>
										<table border="0" align="center" style="margin:auto">
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
										<table border="0" align="center" style="margin:auto">
											<tr><th>경기취소</th></tr>
											<tr>
												<td>
													<input type="submit" value="베팅금 돌려받기" /> 
													<input type="hidden" name="method" value="recoveryMineral" />
												</td>
												
											</tr>
										</table>
									</c:when>
									<c:otherwise>
										<table border="0" align="center" style="margin:auto">
											<tr>
												<th>경기취소</th>
											</tr>
										</table>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<table border="0" align="center" style="margin:auto">
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
								<table border="0" align="center" style="margin:auto">
									<tr>
										<th>진행중</th>
									</tr>
								</table>	
							</c:when>
							<c:when test="${MBD.betting.match.winTeam.num eq MBD.betting.match.awayTeam.num }">
								<c:choose>
									<c:when test="${MBD.giveMineralConfirm=='0' }">
										<table border="0" align="center" style="margin:auto">
											<tr><th>배팅 성공</th></tr>
											<tr>
												<td>
													<input type="submit" value="배당금 받기" /> 
													<input type="hidden" name="method" value="giveMineral" />
												</td>
												
											</tr>
										</table>
									</c:when>
									<c:otherwise>
										<table border="0" align="center" style="margin:auto">
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
										<table border="0" align="center" style="margin:auto">
											<tr><th>무승부</th></tr>
											<tr>
												<td>
													<input type="submit" value="베팅금 돌려받기" /> 
													<input type="hidden" name="method" value="recoveryMineral" />
												</td>
												
											</tr>
										</table>
									</c:when>
									<c:otherwise>
										<table border="0" align="center" style="margin:auto">
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
										<table border="0" align="center" style="margin:auto">
											<tr><th>경기취소</th></tr>
											<tr>
												<td>
													<input type="submit" value="베팅금 돌려받기" /> 
													<input type="hidden" name="method" value="recoveryMineral" />
												</td>
												
											</tr>
										</table>
									</c:when>
									<c:otherwise>
										<table border="0" align="center" style="margin:auto">
											<tr>
												<th>경기취소</th>
											</tr>
										</table>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<table border="0" align="center" style="margin:auto">
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