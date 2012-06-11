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
<body>
	<div data-role="page">
		<div data-role="content">
			<form id="my_form" method="post" action="/auction/maddGood.action">
				
				<div data-role="fieldcontain">
					<label for="gnum">물품 번호</label>
					<input id="gnum" type="text" name="gnum" />
				</div>
				<div data-role="fieldcontain">
					<label for="gname">물품명:</label>
					<input id="gname" type="text" name="gname" />
				</div>
				<div data-role="fieldcontain">
					<label for="detail">상세설명:</label>
					<textarea id="detail" name="detail"></textarea>
				</div>
				<div data-role="fieldcontain">
					<label for="img">이미지:</label>
					<input id="img" type="text" name="img""/>
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