<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

 
<!DOCTYPE html> 
<html> 
	<head>
		<title>회원가입</title>
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
		<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
		<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js">	
		</script>
				
<script type="text/javascript">
<c:if test="${ERROR!=null}">
	alert("${ERROR}");
</c:if>
$(document).ready(function(){

	$("#my_page").css('background-color','#C4E2FF');
	$("#member_info").css('background-color','#ebfbff'); 

	$("#my_form").validate({
		rules:{
			pwvalid:{
				equalTo:"#pw"
			},
			email: "required email",
		},
		messages:{
			pwvalid:{
				equalTo:"비밀번호가 일치하지 않습니다"
			},
			email: {
					required: "이메일을 입력해 주세요",
					email: "이메일 형식에 맞게 입력해주세요"
			},
		}
	});
});
</script>	
	</head> 

	<body>
		<div data-role="page">
			<div data-role="header">
				<div data-role="controlgroup" data-type="horizontal" >
					<a href="/moviesystem/mmember/mloginForm.action" data-role="button" >Login</a>
					<a href="/moviesystem/mmember/maddMemberForm.action" data-role="button">Join</a>
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
				<form id="my_form" action="/moviesystem/mdropMember.action" method="post">
					
					<input type="hidden" name="userNum" value="${LOGIN_MEMBER.userNum}"/>
					<div data-role="fieldcontain">
						<label for="userid">아이디:</label>
						<input id="userid" type="text" name="userid" value=" ${LOGIN_MEMBER.userid}"/>
						<span id="idcheck"></span>
					</div>
					
					<div data-role="fieldcontain">
						<label for="name">이름:</label>
						<input id="name" type="text" name="name" value="${LOGIN_MEMBER.name}"/>
					</div>
					
					<div data-role="fieldcontain">
						<label for="dropReason">탈퇴이유:</label>
						<textarea id="dropReason" name="dropReason"></textarea>
					</div>

					<input type="submit" value="회원탈퇴"/>
				</form>
				
			</div><!-- end content -->
		</div><!-- end page -->
	</body>
</html>

 