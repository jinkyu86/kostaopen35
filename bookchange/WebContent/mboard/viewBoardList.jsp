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
				<a href="#" data-rel="back" data-icon="arrow-l">이전</a>
				<h1>등록한 책 목록</h1>
			</div>
			<div data-role="content">
				<ul data-role="listview">
					<c:forEach var="board" items="${BOARD_LIST}">
						<li>
						<a href="/bookchange/mviewBoard.action?boardNo=${board.boardNo}" rel="external" data-ajax="false"><img src="/bookchange/bookimg/${board.boardPhoto}" width="80" height="80"/>
						${board.boardTitle}<br/>
						 <c:choose>						 							
					 	 		<c:when test="${board.condition.conditionIng eq '교환중' || board.condition.conditionIng eq '교환완료' }">
					 	 		<font color="red"><b><small>(${board.condition.conditionIng})</small></b></font>
					 	 		</c:when>
					 	 		<c:otherwise>
					 	 		<small>(${board.condition.conditionIng})</small>
					 	 		</c:otherwise>					 	 	
					 	 </c:choose>
					 	 </a>
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