<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#member_info").css('background-color','#C4E2FF');
			$("#member_login").css('background-color','#C4E2FF');
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
			<jsp:include page="left.jsp"></jsp:include>
		</td>
		<!-- 좌측 메뉴 끝 -->
		<td>
			<div class="menu_title" >Login	</div>
			<table class="table_style" align="right">
		<form action="/moviesystem/MemberService" method="post">
		<input type="hidden" name="method" value="login"/>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userid" ></td>
			<td>
			<input type="submit" value="로그인" >
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw" ></td>
			<td>
			<input type="reset" value="취소"/>
			</td>
		</tr>

		<p>
			<a href="/moviesystem/MemberService?method=addMemberForm">
			<font size=2 >회원가입 |</font>
			</a>
		
		
			<a href="/moviesystem/MemberService?method=findIdForm">
			<font size=2 >아이디
			</a>/ <a href="/moviesystem/MemberService?method=findPwForm">비밀번호</a> 찾기</font>
		</p>
			</form>		
			</table>
		</td>
	</tr>
</body>
</html>