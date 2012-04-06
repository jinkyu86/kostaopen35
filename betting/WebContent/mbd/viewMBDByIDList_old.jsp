<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Betting Data</title>
<script type="text/javascript">
	<c:if test="${ERROR!=null}">
		alert("${ERROR}");
	</c:if>
	<c:if test="${SUCCESS!=null}">
		alert("${SUCCESS}");
	</c:if>
</script>
</head>
<body>
<h3 align="center">나의 베팅데이터</h3>
	<table border="1" align="center">
		<tr>
			<th>번호</th>
			<th>경기날짜</th>
			<th>경기</th>
			<th>선택한팀</th>
			<th>배팅시간</th>
			<th>결과</th>
		</tr>
		<c:forEach var="mbd" items="${MBD_LIST }">
		<tr>
			<td>
			<a href="/betting/MemberBetDataService?method=viewMBDByIDForm&mbdnum=${mbd.num }">
					${mbd.num}
			</a>
			</td>
			<td>${mbd.betting.match.matchTime }</td>
			<td>2012 프로야구 ${mbd.betting.match.homeTeam.name} vs ${mbd.betting.match.awayTeam.name}</td>
			<td align="center">
				<c:choose>
					<c:when test="${mbd.betting.distnum == '1' }">
						${mbd.betting.match.homeTeam.name }
					</c:when>
					<c:otherwise>
					    ${mbd.betting.match.awayTeam.name }
					</c:otherwise>				
				</c:choose>
			</td>
			<td>${mbd.seleTime }</td>
			<td>
				<c:choose>
					<c:when test="${mbd.betting.match.winTeam.num==null }">
						진행중
					</c:when>
					<c:when test="${mbd.betting.match.winTeam.num == '9'}">
						<c:choose>
							<c:when test="${mbd.giveMineralConfirm =='0' }">
									<font color="red">무승부</font>
							</c:when>
							<c:otherwise>
								무승부
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:when test="${mbd.betting.match.winTeam.num == '10'}">
						<c:choose>
							<c:when test="${mbd.giveMineralConfirm =='0' }">
									<font color="red">취소</font>
							</c:when>
							<c:otherwise>
									취소
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${mbd.betting.distnum =='1' }">
								<c:choose>
									<c:when test="${mbd.betting.match.homeTeam.num == mbd.betting.match.winTeam.num }">
									<c:choose>
										<c:when test="${mbd.giveMineralConfirm =='0' }">
											<font color="red">성공</font>
										</c:when>
										<c:otherwise>
											성공
										</c:otherwise>
									</c:choose>
									</c:when>
									<c:otherwise>
										실패
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${mbd.betting.match.awayTeam.num == mbd.betting.match.winTeam.num }">
										<c:choose>
											<c:when test="${mbd.giveMineralConfirm =='0' }">
												<font color="red">성공</font>
											</c:when>
											<c:otherwise>
												성공
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										실패
									</c:otherwise>
								</c:choose>
							</c:otherwise>	
						</c:choose>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		</c:forEach>
	</table>
	<p align="center">
		${PAGE_LINK_TAG }
	</p>
</body>
</html>