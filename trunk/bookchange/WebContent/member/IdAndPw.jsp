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
		$("#phone").validate({
			rules:{
				tel:{
					digits:true
				}
			},
			messages:{
				tel:{
					digits:"숫자만 입력해주세요."
				}
			}
		});
	});
</script>
<script>
	$(document).ready(function(){
		$("#email").validate({
			rules:{
				email:{
					email:true
				},
				tel:{
					digits:true
				}
			},
			messages:{
				email:{
					email:"메일 형식에 맞게 써주세요."
				},
				tel:{
					digits:"숫자만 입력해주세요."
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
	 	<li><div class="txt01"><h4 align="center">Email & Password 찾기</h4></div></li>
	 	<form id="phone" action="/bookchange/MemberService/viewMemberEmail.action">
		<ul><li><div> 가입시 입력했던 전화번호를 입력하세요.('-'생략하고 숫자만 입력)</div></ul>
	 	<ul><li><div><input type="text" name="tel"/><input type="submit" value="Email찾기"/></div></li></ul>
		</form>
		<form id="email" action="/bookchange/MemberService/viewMemberPw.action">
		<ul><li><div> 이메일을 입력하세요.</div></ul>
	 	<ul><li><div><input type="text"name="email"/></div></li></ul>
		<ul><li><div> 전화번호를 입력하세요.</div></ul>
	 	<ul><li><div><input type="text"name="tel"/><input type="submit" value="PW찾기"/></div></li></ul>
		
		</form>
		</fieldset>
	 </td>
	</table>
</body>
</html>