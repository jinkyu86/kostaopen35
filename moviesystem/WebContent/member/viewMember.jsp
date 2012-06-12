<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 게시물 조회</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.jsp"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#member_manage').css('background-color','#C4E2FF');
		$("#member_list").css('background-color','#EBFBFF');
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
		<!-- 좌측 메뉴 시작 -->
		<td rowspan="2" valign="top" style="width:20%">
			<jsp:include page="managerLeft.jsp"></jsp:include>
		</td>
		<!-- 좌측 메뉴 끝 -->
		<td>
			<div class="menu_title" ><font size="5">View_Member</font>	</div>
			<table class="table_style" border="1">
	<tr>
		<td>번호</td>
		<td>${MEMBER.userNum }</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td>${MEMBER.userid}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${MEMBER.name}</td>
	</tr>
	<tr>	
		<td>이메일</td>
		<td>${MEMBER.email}</td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td>${MEMBER.phone}</td>
	</tr>
	<tr>
		<td>우편번호</td>
		<td>${MEMBER.zipcode}</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>${MEMBER.addr}</td>
	</tr>
	<tr>
		<td>회원가입일</td>
		<td>${MEMBER.regDate}</td>
	</tr>
	<tr>
		<td>회원상태</td>
		<td>${MEMBER.memState}</td>
	</tr>
		<tr>
		<td colspan="2">
				<form action="/moviesystem/viewMemberList.action" method="post">
						<input type="submit" value="목록"/>
				</form>			
		</td>
	</tr>
</table>
</td>
</tr>
</table>
</body>
</html>