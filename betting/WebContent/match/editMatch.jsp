<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Edit Match</title>
</head>
<body>
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
	<a href="/betting/MatchService?method=removeMatch&matchno=${MATCH.num }">
		데이터 삭제
	</a>
	<br/>
	
	<c:choose>
		<c:when test="${BETTING eq '2' }">
					 베팅테이블에 입력된 데이터 입니다.
		</c:when>
		<c:otherwise>
					<a href="/betting/BettingService?method=insertBetting&matchno=${MATCH.num }">
					 	베팅테이블 데이터 입력
					 </a>
		</c:otherwise>
	</c:choose>
</body>
</html>