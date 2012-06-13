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
		
		<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
		<script type="text/javascript">
			<c:if test="${ERROR!=null}">
			alert("${ERROR}");
			</c:if>
		</script>
		<script>
			$(document).ready(function(){
				$("#add_member").validate({
					rules:{
						email:{
							required:true,
							email:true
						},
						address:{
							required:true
						},
						tel:{
							required:true,
							digits:true
						},
						pw:{
							required:true,
							minlength:4
						}
					},
					messages:{
						email:{
							required:"email을 입력해주세요.",
							email:"메일 형식에 맞게 써주세요."
						},
						address:{
							required:"주소를 입력해주세요."
						},
						tel:{
							required:"전화번호를 입력해주세요.",
							digits:"숫자만 입력해주세요."
						},
						pw:{
							required:"비밀번호를 입력해주세요.",
							minlength:"4자 이상 입력해주세요."
						}
					}
				});
			});
			
			$(document).ready(function(){
			 $("#email").change(function(){ 
				//email에 입력한 값 리턴
			 	var email=$("#email").val();
				$.ajax("/bookchange/checkMemberEmail.action",{
					data:{"email":email},
					success:function(data){
					$("#emailcheck").html(data);
					}
				});	 
				});	 		
			});

	</script>
		
	</head>
	<body>
		<div data-role="page">
			<div data-role="header">
				<a href="#" data-icon="arrow-l" data-rel="back">이전</a>
				<h1>회원가입</h1>
			</div>
			<div data-role="content">	
				<form id="add_member" action="/bookchange/maddMember.action" method="post">
					<table style="width:100%">
						<tr>
							<td>Email</td>
							<td><input id="email" type="text" name="email"/></td>
							<td><span id="emailcheck"></span></td>
						</tr>
						<tr>
							<td>패스워드</td>
							<td><input type="password" name="pw"/></td>
						</tr>
						<tr>
							<td>주소</td>
							<td><input type="text" name="address"/></td>
						</tr>
						<tr>
							<td>핸드폰번호</td>
							<td><input type="text" name="tel"/></td>
						</tr>
					</table>
					<input type="submit" value="회원가입" data-icon="arrow-r"/>
				</form>
			</div>
		</div>
	</body>
</html>