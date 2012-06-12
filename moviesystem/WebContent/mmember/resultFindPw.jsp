<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html> 
<html> 
	<head>
		<title>비밀번호찾긴</title>
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
			<jsp:include page="/common/mHeader.jsp"></jsp:include>
			
			<div data-role="content">

			${MEMBER.userid}님의 아이디는<font color="blue"> ${MEMBER.pw}</font>입니다.
			
			<br>
			<a href="moviesystem/mmember/mloginForm.action" data-role="button">로그인</a>
			

			</div><!-- end content -->
		</div><!-- end page -->
	</body>
</html>

 