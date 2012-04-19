<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>회원탈퇴</title>
	<link rel="stylesheet" href="/moviesystem/css/Layout.css">
	<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="/moviesystem/js/common.jsp"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#my_page").css('background-color','#C4E2FF');
		$("#member_info").css('background-color','#C4E2FF'); 
	});
	</script>
</head>
<body>
<table width="90%" align="center">
	<!-- 상단 메뉴 시작 -->
	<tr>
		<td colspan="2">
			<jsp:include page="/common/top.jsp"></jsp:include>
		</td>
	</tr>
	<!-- 상단 메뉴 끝 -->
	
	<tr>
		<!-- 좌측 메뉴 시작-->
		<td rowspan="2" valign="top" style="width:20%">
			<jsp:include page="MypagLeft.jsp"></jsp:include>
		</td>
			<!--좌측 메뉴 끝 -->
		<td>
			<div class="menu_title" ><font size="5">회원탈퇴</font></div>
			<table class="table_style" style="width:70%">
				<form action="/moviesystem/dropMember.action" method="post">
				<input type="hidden" name=userNum  value="${LOGIN_MEMBER.userNum}"/>
				  <tr>
				  	<td>회원아이디</td>
				  	<td><input type="text" name="userid"  value="${LOGIN_MEMBER.userid}" readOnly="readOnly"/></td>
				  </tr>
				  <tr>
				  	<td>회원이름</td>
				  	<td><input type="text" name="name" value="${LOGIN_MEMBER.name}"  readOnly="readOnly"/> </td>
				  </tr>
				  <tr>
					  <td>탈퇴이유</td>
					  <td><textarea name="dropReason"></textarea></td>
				  </tr>
			</table>
			<table>
				 <tr>
				  	<td>
				  		<input type="submit" value="회원탈퇴"/>
				  	</td>
				  	</tr>
			</table>
		</form>
	</td>
	</tr>
</table>
</body>
</html>