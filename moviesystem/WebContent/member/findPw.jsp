<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>비밀번호찾기</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.jsp"></script>

	<script type="text/javascript">
		 <c:if test="${ERROR!=null}">
		 	alert("${ERROR}");
		 </c:if>
		 $(document).ready(function(){
				$("#member_info").css('background-color','#C4E2FF');
				$("#member_findPw").css('background-color','#EBFBFF');
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
			<div class="menu_title" ><font size="5">Find Password</font></div>
			<table class="table_style" style="width:70%">
				<form action="/moviesystem/findPw.action" method="post">
				<tr>
					<td>아이디</td>
					<td> <input type="text" name="userid"/></td>
					<td rowspan="3">
					<input type="submit" value="비밀번호찾기"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td> <input type="text" name="name"/></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email"/></td>
				</tr>
				</form>
			</table>
		</td>
	</tr>
</table>
</body>
</html>
