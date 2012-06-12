<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>            
<html> 
	<head>
		<title>회원검색</title>
		<meta charset="euc-kr" /> 	
		<meta name="viewport" 
				content="width=device-width, initial-scale=1.0, 
							maximum-scale=1.0, minimum-scale=1.0, 
							user-scalable=no"/>
		
		<link rel="shortcut icon" href="../image/icon.png">
		<link rel="apple-touch-icon" href="../image/icon.png">

<!--  
		<link href="http://code.jquery.com/mobile/latest/jquery.mobile.min.css" 
			rel="stylesheet" type="text/css" />
		<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
		<script src="http://code.jquery.com/mobile/latest/jquery.mobile.min.js"></script>-->
	

		<link href="../framework/jquery.mobile-1.0.css" rel="stylesheet" type="text/css" />
		<script src="../framework/jquery-1.6.4.js"></script>
		<script src="../framework/jquery.mobile-1.0.js"></script>   
		
	</head> 

	<body>
		<div data-role="page">
			<jsp:include page="/common/mHeader.jsp"></jsp:include>

			<div data-role="content">
			<form action="/moviesystem/msearchMemberList.action" method="post">
			<table class="sch_style" style="margin-bottom:10px;" align="center">			
				<tr>					
					<td align="center">						
							<select name="column">
								<option value="name">이름</option>
								<option value="email">이메일</option>
								<option value="addr">주소</option>
								<option value="phone">전화번호</option>
							</select>
					</td>
					<td>
						<input type="text" name="keyword"></td>
						<td><input type="submit" value="검색"/></td>						
				</tr>				
			</table>
			</form>
				<ul data-role="listview" >
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
						<c:if test="${page<maxPage }">
						<li><a href="/moviesystem/mmember/mviewMemberList.action?page=${page+1}" data-icon="arrow-r" >다음</a></li>
						</c:if>
					</ul>
				</div>
			</div>	
			
		</div>
	</body>
</html>
