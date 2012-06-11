<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>도서물물 교환</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script type="text/javascript">
	<c:if test="${ERROR!=null}">
	alert("${ERROR}");
	</c:if>
</script>
<script>
$(document).ready(function(){
	$("#edit_member").validate({
		rules:{
			email:{
				required:true,
				email:true
			},
			address:{
				required:true
			},
			tel:{
				required:true,
				digits:true
			},
			pw:{
				required:true,
				minlength:4
			}
		},
		messages:{
			email:{
				required:"email을 입력해주세요.",
				email:"메일 형식에 맞게 써주세요."
			},
			address:{
				required:"주소를 입력해주세요."
			},
			tel:{
				required:"전화번호를 입력해주세요.",
				digits:"숫자만 입력해주세요."
			},
			pw:{
				required:"비밀번호를 입력해주세요.",
				minlength:"4자 이상 입력해주세요."
			}
		}
	});
});
</script>
</head>
<body topmargin="0" leftmargin="0" bgcolor="#FFFFFF">
	<table>
	 <td width="550" height="600" valign="top" bgcolor="#FFFFFF">
	 <fieldset>
	 <li><div class="txt01"><h4 align="center">정보수정</h4></div></li>
	  <form id="edit_member" action="/bookchange/MemberService/editMember.action">
	 	<input type="hidden" name="email" value="${sessionScope.LOGIN_EMAIL.email}">
	 	<ul><li><div> 이메일</div>${LOGIN_EMAIL.email}</li></ul>
	 	<ul><li><div> 비밀번호 (영어,숫자를 4자리 이상 입력)</div><input type="password"name="pw"/></li></ul>
		<ul><li><div> 현재주소</div>${LOGIN_EMAIL.address}</ul>
		<ul><li><div> 주소</div><input type="text"name="address" size="50"/></li></ul>
		<ul><li><div> 현재 핸드폰번호</div>${LOGIN_EMAIL.tel}</ul>
		<ul><li><div> 핸드폰번호 ('-'생략하고 번호만 입력)</div><input type="text"name="tel"/></li></ul>
		<ul><input type="submit" value="수정완료"/></ul>				
		</form>
	 </fieldset>
	 </td>
	</table>
</body>
</html>