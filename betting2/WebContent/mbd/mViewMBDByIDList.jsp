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
			<h2>나의 베팅정보</h2>
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
		<ul data-role="listview">
				<c:forEach var="mbd" items="${MBD_LIST }">
					<li><a href="/betting/mViewMBDByIDForm.action?mbdnum=${mbd.num }">
						<p align="center">
						<img src="/betting/teamphoto/M${mbd.betting.match.homeTeam.photo }" />
						VS
						<img src="/betting/teamphoto/M${mbd.betting.match.awayTeam.photo }" />
						</p>
						<p>선택한 팀 : 
							<c:choose>
								<c:when test="${mbd.betting.distnum == '1' }">
									${mbd.betting.match.homeTeam.name }
								</c:when>
								<c:otherwise>
					    			${mbd.betting.match.awayTeam.name }
								</c:otherwise>				
							</c:choose>
						</p>
						<p>베팅마감시간 : ${mbd.betting.match.matchTime}</p>
						<p>베팅참여시간 : ${mbd.seleTime }
						<p>결과 : 
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
						</p>
					</a></li>
					</c:forEach>
				</ul>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" data-iconpos="top">
				<ul>
					<li><a href="/betting/mViewHome.action" data-icon="home">Home</a></li>
					<c:if test="${page<maxPage }">
						<li><a href="/betting/mViewMemberBetDataByIDList.action?page=${page+1}" data-icon="arrow-r">다음</a>
					</c:if>
					<c:if test="${page!=1 }">
						<li><a href="/betting/mViewMemberBetDataByIDList.action?page=${page-1 }" data-icon="arrow-l">이전</a>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>