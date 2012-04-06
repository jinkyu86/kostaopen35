<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Betting List</title>
</head>
<body>

	<h2 align="center">베팅 리스트</h2>
	<table border="1" align="center">
		<tr>
			<th>베팅번호</th>
			<th>경기번호</th>
			<th>홈/어웨이</th>
			<th>팀</th>
			<th>배당률</th>
			<th>선택률</th>
			<th>누적 미네랄</th>
			<th>베팅종료시간</th>
		</tr>
		<c:forEach var="betting" items="${BETTING_LIST }">
		<tr>
			<td>${betting.num}</td>
			<td>${betting.match.num}</td>
			<c:choose>
			 	<c:when test="${betting.distnum == '1'}">
			 		<td>홈</td>
				</c:when>
				<c:otherwise>
					<td>어웨이</td>
				</c:otherwise>
			</c:choose>
			<c:choose>
			 	<c:when test="${betting.distnum == '1'}">
			 		<td>${betting.match.homeTeam.name}</td>
				</c:when>
				<c:otherwise>
					<td>${betting.match.awayTeam.name}</td>
				</c:otherwise>
			</c:choose>
			<td>${betting.batRating}</td>
			<td>${betting.seleRating}</td>
			<td>${betting.totMineral}</td>
			<td>${betting.match.matchTime}</td>
		</tr>
		</c:forEach>
	</table>
	<p align="center">
		${PAGE_LINK_TAG }
	</p>
</body>
</html>