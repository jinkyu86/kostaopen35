<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script>
	$(document).ready(function(){
		$("#userid").change(function(){
			var userid=$("#userid").val();
			
			$.ajax('/auction/MemberService',{
				data:{"method":"checkuserID","userid":userid
					},
					success : function(data){
						$('#useridcheck').html(data);
					}
			});
		});
	});
</script>
</head>
<body>
	<h1 align="center">회원가입</h1>
	<form  action="/auction/MemberService" 
		method="post">
		<input type="hidden"  name="method"
		  value="addMember"/>
		<table align="center">
			<tr>
				<td>아이디</td>
				<td><input type="text"  name="userid" id="userid">
				<span id ="useridcheck"></span></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password"  name="pw"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
					<td>
						<input type="submit" value="회원가입"/>
					</td>
					<td>
						<input type="reset" value="취소"/>
					</td>
			</tr>
		</table>
	
	</form>
</body>
</html>