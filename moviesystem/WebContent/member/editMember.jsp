<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--@ page  import="kr.or.kosta.moviesystem.LOGIN_MEMBER.LOGIN_MEMBER --%>
<%--@ page import="java.util.ArrayList" --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>개인정보 수정</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script src="/moviesystem/js/common.jsp"></script>

<script type="text/javascript">
<c:if test="${ERROR!=null}">
	alert("${ERROR}");
</c:if>
$(document).ready(function(){

	$("#my_page").css('background-color','#C4E2FF');
	$("#member_info").css('background-color','#C4E2FF'); 
	
	$("#my_form").validate({
		rules:{
			pwvalid:{
				equalTo:"#pw"
			},
			email: "required email",
		},
		messages:{
			pwvalid:{
				equalTo:"비밀번호가 일치하지 않습니다"
			},
			email: {
					required: "이메일을 입력해 주세요",
					email: "이메일 형식에 맞게 입력해주세요"
			},
		}
	});
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
			<div class="menu_title" >개인정보수정</div>
			<table class="table_style" align="right">
		 <form id="my_form" action="/moviesystem/MemberService" method="post">
		<input type="hidden" name="method" value="editMember"/>
		
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userid" value="${LOGIN_MEMBER.userid}"   readOnly="readOnly"/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${LOGIN_MEMBER.name}" readOnly="readOnly"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw"  id="pw" value="${LOGIN_MEMBER.pw}"/></td>
		</tr>
		<tr>
			<td>비밀번호확인</td>
			<td><input type="password" name="pwvalid"  value="${LOGIN_MEMBER.pw}"/></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value="${LOGIN_MEMBER.email }"/></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone" value="${LOGIN_MEMBER.phone}"/></td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td><input type="text" name="zipcode" value="${LOGIN_MEMBER.zipcode}"/></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><textarea name="addr" >${LOGIN_MEMBER.addr}</textarea></td>
		</tr>
		
	</table>
	<table align="center">
			<tr>
				<td>
				<input type="submit" value="개인정보 수정"/>
				</td>
			</tr>
	</form>
	</table>
	<table align="center">
		<form action="/moviesystem/MemberService" method="post">
			<input type="hidden" name="method" value="dropMemberForm"/>
			<tr>
				<td>
				<input type="submit" value="회원탈퇴"/>
				</td>
			</tr>
			</form>
		</table>
	</td>
	</tr>
</body>
</html>