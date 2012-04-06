<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Betting</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script>
	$(document).ready(function(){
			$('#betting_form').validate({
				rules:{
					betmineral:{
						digits:true,
						range:[100,100000000]
					}
				},
				messages:{
					betmineral:{
						digits:'숫자 정수를 입력해주세요',
						range:'100이상 1억 이하의 값을 입력하세요.'
					}
				}
			});
		});
</script>

</head>
<body>
<h3 align="center">Betting</h3>
	
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
	</table>
	<form action="/betting/BettingService" method="post" id="betting_form">
	<input type="hidden" name="method" value="bettingGame"/>
	<input type="hidden" name="home" value="${BETTING_HOME.num }"/>
	<input type="hidden" name="away" value="${BETTING_AWAY.num }"/>
	<input type="hidden" name="matchtime" value="${BETTING_HOME.match.matchTime}"/>
	<c:choose>
		<c:when test="${CHECK == '1' }">	
			<table border="0" align="center">
				<tr>
					<td>
					<input type="radio" name="distnum" value="1" checked="checked"/>
						${BETTING_HOME.match.homeTeam.name }<br/>
					<input type="radio" name="distnum" value="2"/>
						${BETTING_AWAY.match.awayTeam.name}<br/>
					<input type="text" name="betmineral" align="right" value="0"/>미네랄</br>
					<input type="submit" value="참여하기"/>
					</td>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	</form>
</body>
</html>