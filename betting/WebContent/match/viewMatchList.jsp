<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Match List</title>
</head>
<body>
	<h2 align="center">경기 리스트</h2>
	<form action="/betting/MarchService" method="post">
	<input type="hidden" name="method" value="addMatch">
	<table border="1" align="center">
		<tr>
			<th>경기번호</th>
			<th>홈팀</th>
			<th>어웨이팀</th>
			<th>경기장소</th>
			<th>경기시작시간</th>
			<th>경기결과</th>
			<th>스코어</th>
		</tr>
		<c:forEach var="match" items="${MATCH_LIST }">
		<tr>
			<td>
				<a href="/betting/MatchService?method=editMatchForm&matchno=${match.num }">
					${match.num}
				</a>
			</td>
			<td>${match.homeTeam.name}</td>
			<td>${match.awayTeam.name}</td>
			<td>${match.loc.loc}</td>
			<td>${match.matchTime}</td>
			<td>${match.winTeam.name}</td>
			<td>${match.score}</td>
			
		</tr>
		</c:forEach>
	</table>
	</form>
	<p align="center">
		${PAGE_LINK_TAG }
	</p>
	<table border="0" align="center">
		<tr>
			<th>
				<a href="/betting/MatchService?method=addMatchForm">
					경기 데이터 삽입
				</a>
			</th>
		</tr>
	</table>
</body>
</html>