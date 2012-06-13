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
		<style type="text/css">
		a{text-decoration:none;}
		</style>
	</head>
	<body>
		<div data-role="page">
			<div data-role="header">
				<a href="#" data-rel="back" data-icon="arrow-l">이전</a>
				<h1>상대방 정보</h1>
			</div>
			<div data-role="content" align="center">
				 <table>
				 <tr>
				 <td><b>email</b></td><td>${MEMBER.email}</td>
				 </tr>
				 <tr>
				 <td><b>주소</b></td><td>${MEMBER.address}</td>
				 </tr>
				 <tr>
				 <td><b>전화번호</b></td><td>${MEMBER.tel}</td>
				 </tr>	 
				 </table>
			</div>
		</div>
	</body>
</html>