<%@ page language="java" 
contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib  prefix="c" 
             uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
             
<!DOCTYPE html> 
<html> 
	<head>
		<script type="text/javascript">
		 	<c:if test="${SUCCESS!=null}">
 			alert("${SUCCESS}");
			</c:if>
		</script>
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
			<h2>나의 베팅내역</h2>
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
		<form action="/betting/mMineral.action" method="post">
			<table style="margin: auto">
				<tr>
					<td align="center">
						<img src="/betting/teamphoto/M${BETTING_HOME.match.homeTeam.photo }" />
					</td>
					<th align="center" bgcolor="#dddddd">VS</th>
					<td align="center">
						<img src="/betting/teamphoto/M${BETTING_AWAY.match.awayTeam.photo }" />
					</td>
				</tr>
				<tr>
					<td align="center">${BETTING_HOME.match.homeTeam.name }</td>
					<th align="center" bgcolor="#dddddd">팀 명</th>
					<td align="center">${BETTING_AWAY.match.awayTeam.name}</td>
				</tr>
				<tr>
					<td align="center">${BETTING_HOME.batRating}</td>
					<th align="center" bgcolor="#dddddd">예상 배당률</th>
					<td align="center">${BETTING_AWAY.batRating}</td>
				</tr>
				<tr>
					<td align="center">${BETTING_HOME.seleRating}</td>
					<th align="center" bgcolor="#dddddd">선택률</th>
					<td align="center">${BETTING_AWAY.seleRating}</td>
				</tr>
				<tr>
					<td align="center">${BETTING_HOME.totMineral}</td>
					<th align="center" bgcolor="#dddddd">누적 미네랄</th>
					<td align="center">${BETTING_AWAY.totMineral}</td>
				</tr>
				<tr>
					<c:choose>
						<c:when test="${CHECK == '1' }">
							<th align="center" colspan="3" >베팅 마감 시간 :
								${BETTING_HOME.match.matchTime}</th>
						</c:when>
						<c:otherwise>
							<th align="center" colspan="3" >마감 되었습니다.</th>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<th align="center" bgcolor="#dddddd">선택한 팀</th>
					<c:choose>
						<c:when test="${MBD.betting.distnum=='1' }">
							<td align="center" colspan="2">
								${MBD.betting.match.homeTeam.name} 
							<input type="hidden" name="districtnum" value="1" />
							</td>
						</c:when>
						<c:otherwise>
							<td align="center" colspan="2">
								${MBD.betting.match.awayTeam.name} 
							<input type="hidden" name="districtnum" value="2" />
							</td>
						</c:otherwise>
					</c:choose>
				</tr>
				<c:choose>
					<c:when test="${MBD.betting.match.winTeam.num==null }">
					</c:when>
					<c:otherwise>
						<tr>
							<th align="center" bgcolor="#dddddd">승리팀</th>
							<td align="center" colspan="2">
								${MBD.betting.match.winTeam.name}</td>
						</tr>
					</c:otherwise>
				</c:choose>
				<tr>
					<th align="center" bgcolor="#dddddd">베팅금</th>
					<td align="center" colspan="2"><input type="text"
						readOnly="readOnly" name="bmineral" value="${MBD.betMineral}" /></td>
				</tr>
				<tr>
					<th align="center" bgcolor="#dddddd">예상배당금</th>
					<td align="center" colspan="2"><input type="text"
						readOnly="readOnly" name="emineral"
						value="<fmt:formatNumber 
				                      value='${MBD.betMineral*MBD.betting.batRating }'
				                     maxFractionDigits='0'/>" />
					</td>
				</tr>
			</table>
			<c:choose>
				<c:when test="${CHECK == '1' }">
					<input type="submit" value="취소 하기" /> 
					<input type="hidden" name="method" value="cancleBetting" />
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${MBD.betting.distnum=='1' }">
							<c:choose>
								<c:when test="${MBD.betting.match.winTeam.num==null }">
									<p align="center"><strong>진행중</strong></p>
								</c:when>
								<c:when
									test="${MBD.betting.match.winTeam.num eq MBD.betting.match.homeTeam.num }">
									<c:choose>
										<c:when test="${MBD.giveMineralConfirm=='0' }">
											<p align="center"><strong>베팅 성공</strong></p>
											<input type="submit" value="배당금 받기" /> 
											<input type="hidden" name="method" value="giveMineral" />
										</c:when>
										<c:otherwise>
											<p align="center"><strong>베팅 성공</strong></p>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:when test="${MBD.betting.match.winTeam.num == '9'}">
									<c:choose>
										<c:when test="${MBD.giveMineralConfirm=='0' }">
											<p align="center"><strong>무승부</strong></p>
											<input type="submit" value="베팅금 돌려받기" /> 
											<input type="hidden" name="method" value="recoveryMineral" />
										</c:when>
										<c:otherwise>
											<p align="center"><strong>무승부</strong></p>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:when test="${MBD.betting.match.winTeam.num == '10'}">
									<c:choose>
										<c:when test="${MBD.giveMineralConfirm=='0' }">
											<p align="center"><strong>경기취소</strong></p>
											<input type="submit" value="베팅금 돌려받기" /> 
											<input type="hidden" name="method" value="recoveryMineral" />
										</c:when>
										<c:otherwise>
											<p align="center"><strong>경기취소</strong></p>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<p align="center"><strong>베팅실패</strong></p>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${MBD.betting.match.winTeam.num==null }">
									<p align="center"><strong>진행중</strong></p>
								</c:when>
								<c:when
									test="${MBD.betting.match.winTeam.num eq MBD.betting.match.awayTeam.num }">
									<c:choose>
										<c:when test="${MBD.giveMineralConfirm=='0' }">
											<p align="center"><strong>베팅 성공</strong></p>
											<input type="submit" value="배당금 받기" /> 
											<input type="hidden" name="method" value="giveMineral" />
										</c:when>
										<c:otherwise>
											<p align="center"><strong>베팅 성공</strong></p>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:when test="${MBD.betting.match.winTeam.num == '9'}">
									<c:choose>
										<c:when test="${MBD.giveMineralConfirm=='0' }">
											<p align="center"><strong>무승부</strong></p>
											<input type="submit" value="베팅금 돌려받기" /> 
											<input type="hidden" name="method" value="recoveryMineral" />
										</c:when>
										<c:otherwise>
											<p align="center"><strong>무승부</strong></p>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:when test="${MBD.betting.match.winTeam.num == '10'}">
									<c:choose>
										<c:when test="${MBD.giveMineralConfirm=='0' }">
											<p align="center"><strong>경기취소</strong></p>
											<input type="submit" value="베팅금 돌려받기" /> 
											<input type="hidden" name="method" value="recoveryMineral" />
										</c:when>
										<c:otherwise>
											<p align="center"><strong>경기취소</strong></p>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<p align="center"><strong>베팅 실패</strong></p>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>

			<input type="hidden" name="home" value="${BETTING_HOME.num }" /> <input
				type="hidden" name="away" value="${BETTING_AWAY.num }" /> <input
				type="hidden" name="mbdnum" value="${MBD.num }" /> <input
				type="hidden" name="matchtime"
				value="${BETTING_HOME.match.matchTime}" />
			</form>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" data-iconpos="top">
				<ul>
					<li><a href="/betting/mViewHome.action" data-icon="home">Home</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>