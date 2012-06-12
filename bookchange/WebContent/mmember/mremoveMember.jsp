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
	</head>
	<body>
		<div data-role="page">
			<div data-role="header">
				<a href="#" data-icon="arrow-l">이전</a>
				<h1>회원탈퇴</h1>
			</div>
			<div data-role="content">	
				<form action="#" method="post">
				<input type="hidden" name="method" value="removeMember">
	 			<input type="hidden" name="email" value="${sessionScope.LOGIN_EMAIL.email}">
					<table style="width:100%">
						<tr>
							<td>Email</td>
							<td><p>${LOGIN_EMAIL.email}</p></td>
						</tr>
						<tr>
							<td>주소</td>
							<td><p>${LOGIN_EMAIL.address}</p></td>
						</tr>
						<tr>
							<td>핸드폰번호</td>
							<td><p>${LOGIN_EMAIL.tel}</p></td>
						</tr>
						<tr>
							<td>패스워드</td>
							<td><input type="password" name="pw"/></td>
						</tr>
					</table>
					<input type="submit" value="탈퇴"/>
				</form>
				<form action="#"method="post">
				<input type="hidden" name="method" value="boardListAtMain">
	 			<input type="submit" value="취소"/>		
	 			</form>
			</div>
		</div>
	</body>
</html>