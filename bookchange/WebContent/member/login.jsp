<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인</title>
<script src="http//code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script>
$(document).ready(function(){
	$("#my_form").validate({
		rules:{
			
			email:"required email",
			
			
			pw:{
				required:true,
				minlength:3
				}
			},
		messages: {
			email: {
				required: '이메일을 입력해주세요',
			},
			pw: {
				required: "비밀번호를 입력해주세요",
				minlength: "3자이상 입력해주세요"
			}
		}
		});
	});	
	</script>
</head>
<body>
  <h4 align="center">로그인</h4>
  <fieldset>
  <table align="center">
  	<form id="my_form" action="/bookchange/login.action" method="post">
  	<input type="hidden"name="method"value="login">
	    <tr>
	  		<td> 아이디</td>
  			<td><input type="text" name="email"/></td>
  		</tr>
  		<tr>
	  		<td>비밀번호</td>
	  		<td><input type="password" name="pw"/></td>
  		</tr>
  		<td><input type="submit" value="로그인"/></td>
  		
  		<td><input type="reset" value="취소"/></td>
  	</form>	  
  </table>	
  </fieldset>
</body>
</html>