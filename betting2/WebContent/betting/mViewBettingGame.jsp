<%@ page language="java" 
contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib  prefix="c" 
             uri="http://java.sun.com/jsp/jstl/core" %>
             
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
			<h2>Betting</h2>
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
			<table style="margin:auto">
				<tr>
					<td align="center">
					<img src="/betting/teamphoto/M${BETTING_HOME.match.homeTeam.photo }" />
					</td>
					<td align="center"  bgcolor="#dddddd">VS</td>
					<td align="center">
					<img src="/betting/teamphoto/M${BETTING_AWAY.match.awayTeam.photo }" />
					</td>
				</tr>
				<tr>
					<td align="center">${BETTING_HOME.match.homeTeam.name }</td>
					<td align="center" bgcolor="#dddddd">팀 명</td>
					<td align="center">${BETTING_AWAY.match.awayTeam.name}</td>
				</tr>
				<tr>	
					<td align="center">${BETTING_HOME.batRating}</td>
					<td align="center" bgcolor="#dddddd">예상 배당률</td>
					<td align="center">${BETTING_AWAY.batRating}</td>
				</tr>
				<tr>
					<td align="center">${BETTING_HOME.seleRating}</td>
					<td align="center" bgcolor="#dddddd">선택률</td>
					<td align="center">${BETTING_AWAY.seleRating}</td>
				</tr>
				<tr>
					<td align="center">${BETTING_HOME.totMineral}</td>
					<td align="center" bgcolor="#dddddd">누적 미네랄</td>
					<td align="center">${BETTING_AWAY.totMineral}</td>
				</tr>
				<tr>
					<c:choose>
						<c:when test="${CHECK == '1' }">	
							<td align="center" colspan="3" bgcolor="#dddddd" >종료 시간 : ${BETTING_HOME.match.matchTime}</td>
						</c:when>
						<c:otherwise>
							<td align="center" colspan="3" bgcolor="#dddddd">종료되었습니다.</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</table>
			<form action="/betting/mBettingGame.action" method="post" id="betting_form" data-ajax="false">
			<input type="hidden" name="home" value="${BETTING_HOME.num }"/>
			<input type="hidden" name="away" value="${BETTING_AWAY.num }"/>
			<input type="hidden" name="matchtime" value="${BETTING_HOME.match.matchTime}"/>
			<input type="hidden" name="matchno" value="${BETTING_HOME.match.num }"/>
			<c:choose>
				<c:when test="${CHECK == '1' }">	
					<div data-role="fieldcontain">
						<fieldset data-role="controlgroup">
							<legend><strong>선택할 팀</strong></legend>
							<input id="hometeam" type="radio" name="districtnum" value="1" checked="checked"/>
							<label for="hometeam">${BETTING_HOME.match.homeTeam.name }</label>
							<input id="awayteam" type="radio" name="districtnum" value="2" />
							<label for="awayteam">${BETTING_AWAY.match.awayTeam.name }</label>
						</fieldset>
					</div>
					<div data-role="fieldcontain">
						<label for="mineral"><strong>미네랄 : </strong></label>
						<input id="mineral" type="text" name="betmineral" value="0"/>
						
					</div>
					<input type="submit" value="참여하기"/>
				</c:when>
			</c:choose>
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