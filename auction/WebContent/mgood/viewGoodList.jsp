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
		<div data-role="header">
			<h1>물품 리스트</h1>
		</div>


		<div data-role="content">
			<ul data-role="listview" >
				<c:forEach var="good" items="${GOOD_LIST }">
					<li>
					<a href="/auction/mviewGood.action?gnum=${good.gNum}"><img src="/auction/gphoto/${good.img }"" height="100" width="100"/><h3>${good.gName}</h3></a>
					</li>
				</c:forEach>
			</ul>
		</div>

		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href="/auction/maddGoodForm.action"
						data-icon="plus">물품추가</a></li>
					<li><a href="/auction/home.jsp"
						data-icon="home">홈 화면</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>

