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
	<div data-role="content">
		<div data-role="collapsible-set">
			<div data-role="collapsible">
				<h3>물품번호</h3>
				<p>${GOOD.gNum }</p>
			</div>
			<div data-role="collapsible">
				<h3>물품명</h3>
				<p>${GOOD.gName}</p>
			</div>
			<div data-role="collapsible" data-collapsed="true">
				<h3>상세설명</h3>
				<p>${GOOD.detail}</p>
			</div>
			<div data-role="collapsible" data-collapsed="true">
				<h3>사진</h3>
				<p><img src="/auction/gphoto/${GOOD.img}" height="100" weight="100"/></p>
			</div>
		</div>
	</div>
	
	<div data-role="footer" data-position="fixed">
		<div data-role="navbar" data-iconpos="top">
			<ul>
				<li><a
					href="/auction/meditGoodForm.action?gnum=${GOOD.gNum}"
					data-icon="gear">물품수정</a></li>
				<li><a href="/auction/mremoveGood.action?gnum=${GOOD.gNum }"
					data-icon="delete">물품삭제</a></li>
				<li><a href="/auction/mviewGoodList.action"
					data-icon="home">물품리스트</a></li>
			</ul>
		</div>
	</div>
</body>
</html>

