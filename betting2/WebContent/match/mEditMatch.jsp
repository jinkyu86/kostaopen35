<%@ page language="java" 
contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib  prefix="c" 
             uri="http://java.sun.com/jsp/jstl/core" %>
             
<!DOCTYPE html> 
<html> 
	<head>
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
			<h2>경기 일정 수정</h2>
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
			<form action="/betting/mEditMatch.action" method="post">
			<table style="margin:auto">
				<tr>
					<th>경기번호</th>
					<td><input type="text" name="matchno" 
							value="${MATCH.num}" readOnly="readOnly" /></td>
					</tr>
				<tr>
					<th>홈팀</th>
					<td>
					<select name="hometeamno" data-native-menu="false">
						<c:forEach var="team" items="${TEAM_LIST }" end="7">
							<option value="${team.num}"
								<c:if test="${MATCH.homeTeam.num eq team.num}">
								selected="selected"
								</c:if>
								>${team.name}
							</option>
						</c:forEach>
				 	</select>
					</td>
				</tr>
				<tr>
					<th>어웨이팀</th>
					<td>
						<select name="awayteamno" data-native-menu="false">
						<c:forEach var="team" items="${TEAM_LIST }" end="7">
							<option value="${team.num}"
							<c:if test="${MATCH.awayTeam.num eq team.num}">
								selected="selected"
							</c:if>
							>${team.name}
							</option>
						</c:forEach>
				 		</select>
					</td>
				</tr>
				<tr>
					<th>경기장소</th>
					<td>
						<select name="locno" data-native-menu="false">
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
					<select name="winteamno" data-native-menu="false">
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
				 	<div data-role="fieldcontain">
				 		<fieldset data-role="controlgroup" >
				 			<legend><strong>결과수정시 체크</strong></legend>
				 			<input type="checkbox" name="checkbox" value="1"/>
				 		</fieldset>
				 	</div>
					</td>
				</tr>
				<tr>
					<th>스코어</th>
					<td><input type="text" name="score" 
						value="${MATCH.score}" /></td>
				</tr>
		</table>
		<input type="submit" value="데이터 수정"/>
		<input type="reset" value="취소"/>
		</form>
		</div>
		<c:choose>
		<c:when test="${BETTING eq '2' }">
			<p align="center"><strong>베팅테이블에 입력된 데이터 입니다</strong></p>
		</c:when>
		<c:otherwise>
			<tr>
				<th>
					<a href="/betting/insertBetting.action?matchno=${MATCH.num }" data-role="button">
					 	베팅테이블 데이터 입력
					</a>
				</th>
			</tr>	
		</c:otherwise>
	</c:choose>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" data-iconpos="top">
				<ul>
				<li><a href="/betting/mViewHome.action" data-icon="home">Home</a></li>
				<li><a href="/betting/mRemoveMatch.action?matchno=${MATCH.num }" data-icon="delete">일정 삭제</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>