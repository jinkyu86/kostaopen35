<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" 
				content="width=device-width, initial-scale=1.0, 
							maximum-scale=1.0, minimum-scale=1.0, 
							user-scalable=no"/>
		
		<link rel="shortcut icon" href="../image/icon.png">
		<link rel="apple-touch-icon" href="../image/icon.png">

		
		<link href="http://code.jquery.com/mobile/latest/jquery.mobile.min.css" 
			rel="stylesheet" type="text/css" />
		<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
		<script src="http://code.jquery.com/mobile/latest/jquery.mobile.min.js"></script>
		<script src="http://code.jquery.com/jquery-1.7.js"></script>
		<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
		
	</head>
	<body>
		<div data-role="page">
			<div data-role="header">
				<a href="/bookchange/mboard/exchangeinfo.jsp" data-icon="arrow-l">이전</a>
				<h1>요구한 신청 내역</h1>
			</div>
			<div data-role="content">
				<ul data-role="listview">
					<c:forEach var="change" items="${DEMAND_CHANGE_LIST}">
						<li>
						<table style="width:100%"><tr><td>									
						<a href="/bookchange/mviewBoard.action?boardNo=${change.demandBoard.boardNo}" rel="external" data-ajax="false">
						<img src="/bookchange/bookimg/${change.demandBoard.boardPhoto}" width="80" height="80"/></a>
						</td>
						<td align="center">
						<img src="/bookchange/webimg/mrequest.png" width="90" height="40">
						</td>
						<td>
						<a href="/bookchange/mviewBoard.action?boardNo=${change.agreeBoard.boardNo}" rel="external" data-ajax="false">
						<img src="/bookchange/bookimg/${change.agreeBoard.boardPhoto}" width="80" height="80" align="right"/></a>						
						</td></tr></table>
						</li>
					</c:forEach>
				</ul>
				<br/>
				<div align="center">
				<c:if test="${page != 1}">
				<a href="/bookchange/mviewBoardList.action?page=${page-1}" data-role="button" data-icon="arrow-l" data-iconpos="left" data-inline="true">이전페이지</a>
				</c:if>
				<c:if test="${page < maxPage}">								
				<a href="/bookchange/mviewBoardList.action?page=${page+1}" data-role="button" data-icon="arrow-r" data-iconpos="right" data-inline="true">다음페이지</a>
				</c:if>
				</div>
				
			</div>
		</div>
	</body>
</html>