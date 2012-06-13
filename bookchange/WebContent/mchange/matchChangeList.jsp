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
				<h1>교환진행중인 책 목록</h1>
			</div>
			<div data-role="content">
				<ul data-role="listview">
					<c:forEach var="change" items="${MATCH_LIST}">
						<li>
						<table style="width:100%"><tr><td rowspan="3">									
						<a href="/bookchange/mviewBoard.action?boardNo=${change.demandBoard.boardNo}" rel="external" data-ajax="false">
						<img src="/bookchange/bookimg/${change.demandBoard.boardPhoto}" width="80" height="80"/></a>
						</td>
						<td rowspan="3">
						<img src="/bookchange/webimg/ing.png" width="40" height="40">
						</td>						
						<td rowspan="3"> 
						<a href="/bookchange/mviewBoard.action?boardNo=${change.agreeBoard.boardNo}" rel="external" data-ajax="false">
						<img src="/bookchange/bookimg/${change.agreeBoard.boardPhoto}" width="80" height="80"/></a>						
						</td>
						<td>
						<a href="/bookchange/mviewMemberInfo.action?email=${change.agreeBoard.member.email}">${change.agreeBoard.member.email}</a>
						</td></tr>
						<tr>
						<td>
						<c:choose>
					        <c:when test="${change.agreeBoard.condition.conditionResult eq 2}">
					                <font><small>상대방 교환완료</small></font><font color="red"><b><small> 대기</small></b></font>
					        </c:when>
					        <c:otherwise>
					        		 <font><small>상대방 교환완료</small></font><font color="red"><b><small> 완료</small></b></font>
					        </c:otherwise>
				        </c:choose>
						</td></tr>
						<tr>
						<td>
						<form action="/bookchange/mcompleteChange.action" method="post">
				       		<input type="hidden" name="ChangeNo" value="${change.agreeBoard.boardNo}">
				       		<input type="hidden" name="BoardNo" value="${change.demandBoard.boardNo}">
				       		<input type="hidden" name="conditionResult" value="${change.agreeBoard.condition.conditionResult}">
				       		<input type="submit" value="완료확정">
			       		</form>
						</td></tr>
						</table>
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