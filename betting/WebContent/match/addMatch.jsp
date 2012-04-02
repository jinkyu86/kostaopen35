<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Add Match</title>
</head>
<body>
	<form action="/betting/MatchService" method="post">
	<input type="hidden" name="method" value="addMatch"/>
	<h3 align="center">경기 데이터 삽입</h3>
	<table border="1" align="center">
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
					value="yyyy/mm/dd hh24:mi:ss" /></td>
		</tr>
		<tr>
			<td>
					<input type="submit" value="경기데이터삽입"/>
				</td>
				<td>
					<input type="reset" value="입력취소"/>
				</td>
		</tr>
	</table>
	
</form>
</body>
</html>