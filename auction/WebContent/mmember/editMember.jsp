<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>jQuery Mobile</title>
<meta charset="euc-kr" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, 
							maximum-scale=1.0, minimum-scale=1.0, 
							user-scalable=no" />

<link rel="shortcut icon" href="../image/icon.png">
<link rel="apple-touch-icon" href="../image/icon.png">


<link href="http://code.jquery.com/mobile/latest/jquery.mobile.min.css"
	rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
<script src="http://code.jquery.com/mobile/latest/jquery.mobile.min.js"></script>

<!--
		<link href="../framework/jquery.mobile-1.0.css" 
			rel="stylesheet" type="text/css" />
		<script src="../framework/jquery-1.6.4.js"></script>
		<script src="../framework/jquery.mobile-1.0.js"></script>
		-->
</script>
</head>
<body>
	<div data-role="page">
		<div data-role="content">
			<form id="my_form" method="post" action="/auction/meditMember.action">
				
				<div data-role="fieldcontain">
					<label for="userid">아이디:</label>
					<input id="userid" type="text" name="userid" value="${MEMBER.userid}"/>
				</div>
				<div data-role="fieldcontain">
					<label for="name">이름:</label>
					<input id="name" type="text" name="name" value="${MEMBER.name}"/>
				</div>
				<div data-role="fieldcontain">
					<label for="pw">비밀번호:</label>
					<textarea id="pw" name="pw">${MEMBER.pw }</textarea>
				</div>
				<div data-role="fieldcontain">
					<label for="email">이메일:</label>
					<input id="email" type="text" name="email" value="${MEMBER.email }"/>
				</div>
				<div data-role="fieldcontain">
					<label for="coin">코인:</label>
					<input id="coin" type="text" name="coin" value="${MEMBER.coin }"/>
				</div>
				<div data-role="fieldcontain">
					<label for="emoney">e머니:</label>
					<input id="emoney" type="text" name="emoney" value="${MEMBER.emoney }"/>
				</div>
				<div data-role="fieldcontain">
					<input id="submit" type="submit" value="전송"/>
					<input id="reset" type="reset" value="취소"/>
				</div>
			</form>
		</div>
	</div>		
</body>
</html>