<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--@ page  import="kr.or.kosta.moviesystem.member.Member --%>
<%--@ page import="java.util.ArrayList" --%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>개인정보 수정</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js">
</script>
<script>
$(document).ready(function(){
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
	<h1 align="center">개인정보 수정</h1>
	<table align="center">
		<form id="my_form" action="/moviesystem/MemberService" method="post">
		<input type="hidden" name="method" value="editMember"/>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userid" value="${MEMBER.userid}"   readOnly="readOnly"/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${MEMBER.name}" readOnly="readOnly"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw"  id="pw" value="${MEMBER.pw}"/></td>
		</tr>
		<tr>
			<td>비밀번호확인</td>
			<td><input type="password" name="pwvalid"  value="${MEMBER.pw}"/></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value="${MEMBER.email }"/></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone" value="${MEMBER.phone}"/></td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td><input type="text" name="zipcode" value="${MEMBER.zipcode}"/></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="addr" value="${MEMBER.addr }"/></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="개인정보 수정"/>
			</td>
		</tr>
		</form>
	</table>
</body>
</html>