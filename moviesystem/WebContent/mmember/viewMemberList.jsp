<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>            
<html> 
	<head>
		<title>회원 리스트</title>
		<meta charset="euc-kr" /> 	
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
	
<!--
		<link href="../framework/jquery.mobile-1.0.css" rel="stylesheet" type="text/css" />
		<script src="../framework/jquery-1.6.4.js"></script>
		<script src="../framework/jquery.mobile-1.0.js"></script>   -->
		
	</head> 

	<body>
		<div data-role="page">
			<div data-role="header">
				<div data-role="controlgroup" data-type="horizontal" >
					<c:choose>
					<c:when test="${LOGIN_MEMBER==null}">			
							<a href="/moviesystem/mmember/mloginForm.action" data-role="button" >Login</a>
							<a href="/moviesystem/mmember/maddMemberForm.action" data-role="button">Join</a>
					</c:when>
					<c:otherwise>
							<a href="/moviesystem/mmember/mmypage.action" data-role="button" >MyPage</a>
							<a href="/moviesystem/mlogoutMember.action" data-role="button">Logout</a>
					</c:otherwise>	
					</c:choose>						
				</div>				
			</div><!-- end header 1-->		
			
			<div data-role="header">
				<div data-role="navbar">
					<ul>
						<li><a href="#">Movie</a></li>
						<li><a href="#">Reservation</a></li>
						<li><a href="/moviesystem/mgood/mViewGoodList.action" class="ui-btn-active">Shopping</a></li>
					</ul>
				</div>
			</div><!-- end header2 -->

			<div data-role="content">
				<ul data-role="listview">
				<!-- JSTL의 forEach태그를 이용해서 for문을 실행
				전체 항생리스트:${STUDENT_LIST}
				학생들의 학번(studno) 이름(name)-->
				<c:forEach var="member" items="${MEMBER_LIST}">
					<li data-role="list-divider">
						${member.userid}
					</li>
					<li><a href="/moviesystem/mmember/mviewMember.action?userNum=${member.userNum}">						
							<h3>${member.name}</h3>		
					</a></li>
				</c:forEach>
				</ul>
			</div>
			<div data-role="footer" data-position="fixed">
				<div data-role="navbar" >
					<ul>
						<c:if test="${page!=1}">
						<li><a href="/moviesystem/mmember/mviewMemberList.action?page=${page-1}" data-icon="arrow-l">이전</a></li>
						</c:if>
						<li><a href="/moviesystem/mmember/msearchMemberList.action" data-icon="search">회원찾기</a>
						<c:if test="${page<maxPage }">
						<li><a href="/moviesystem/mmember/mviewMemberList.action?page=${page+1}" data-icon="arrow-r" >다음</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			
		</div>
	</body>
</html>