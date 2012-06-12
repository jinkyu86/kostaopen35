<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>비밀번호찾기 결과 조회</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.jsp"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#member_info").css('background-color','#C4E2FF');
			$("#member_findPw").css('background-color','#C4E2FF');
		});
	</script>
</head>
<body><table width="90%" align="center">
	<!-- 상단 메뉴 시작 -->
	<tr>
		<td colspan="2">
			<jsp:include page="/common/top.jsp"></jsp:include>
		</td>
	</tr>
	<!-- 상단 메뉴 끝 -->
	
	<tr>
		<!-- 좌측 메뉴 시작 -->
		<td rowspan="2" valign="top" style="width:20%">
			<jsp:include page="left.jsp"></jsp:include>
		</td>
		<!-- 좌측 메뉴 끝 -->
		<td>
			<div class="menu_title" >Find Password</div>
			<table class="table_style" align="right">
		<tr>
			
			<td>${MEMBER.userid}님의 비밀번호는<font color="blue"> ${MEMBER.pw}</font>입니다.</td>
		</tr>			
	</table>
	</td>
		<tr>
	<td>
		<form action="/moviesystem/loginForm.action" method="post">
	<input type="submit" value="로그인"/>
	</form>
	</td>
	</tr>
	</tr>
</body>
</html>