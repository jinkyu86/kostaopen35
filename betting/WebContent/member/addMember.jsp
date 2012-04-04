<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 가입</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script>
	$(document).ready(function() {
		$("#id").change(function() {
			var id = $("#id").val();

			$.ajax('/betting/MemberService', {
				data : {
					"method" : "checkuserID",
					"id" : id
				},
				success : function(data) {
					$('#useridcheck').html(data);
				}
			});
		});
	});
</script>
</head>
<body>
	<form action="/betting/MemberService" method="post">
		<input type="hidden" name="method" value="addMember" />
		<table border="1" align="center">
			<tr>
				<th>ID</th>
				<td><input type="text" name="id" value="${MEMBER.id}" /></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="${MEMBER.name}" /></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="pw" value="${MEMBER.pw}" /></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="text" name="email" value="${MEMBER.email}" />
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="회원 가입" /></td>
				<td align="center"><input type="reset" value="리셋" /></td>
			</tr>
		</table>
	</form>
</body>
</html>