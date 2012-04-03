<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Today Betting List</title>
</head>
<body>
	<h2 align="center">오늘의 베팅 경기리스트</h2>
	<table border="1" align="center">
		<tr>
			<th>경기번호</th>
			<th>경기</th>
			<th>경기장소</th>
			<th>베팅 마감시간</th>
			
		</tr>
		<c:forEach var="match" items="${TODAY_MATCH}">
		<tr>
			<td>
				<a href="/betting/BettingService?method=bettingGameForm&matchno=${match.num }">
					${match.num}
				</a>
			</td>
			<td>2012 프로야구 ${match.homeTeam.name} vs ${match.awayTeam.name}</td>
			<td>${match.loc.loc}</td>
			<td>${match.matchTime}</td>
			
		</tr>
		</c:forEach>
	</table>
</body>
</html>