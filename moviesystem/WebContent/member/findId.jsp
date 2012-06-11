<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html> 
<html> 
	<head>
		<title>로그인</title>
		<meta charset="euc-kr"/> 	
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
		<script src="http://code.jquery.com/mobile/latest/jquery.mobile.min.js"></script>
		-->
		
		<link href="../framework/jquery.mobile-1.0.css" 
			rel="stylesheet" type="text/css" />
		<script src="../framework/jquery-1.6.4.js"></script>
		<script src="../framework/jquery.mobile-1.0.js"></script>
		
		<script type="text/javascript">
	 		<c:if test="${ERROR!=null}">
	 			alert("${ERROR}");
	 		</c:if>
		</script>
	
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
				<form action="/moviesystem/mfindId.action" method="post">
					
					<div data-role="fieldcontain">
						<label for="name">이름</label>
						<input id="name" type="text" name="name" value=""/>
					</div>
					
					<div data-role="fieldcontain">
						<label for="email">이메일:</label>
						<input id="email" type="text" name="email" value=""/>
					</div>
					
					<input type="submit" value="아이디 찾기"/>
				</form>
			</div><!-- end content -->
		</div><!-- end page -->
	</body>
</html>
