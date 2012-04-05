<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>멤버 조회</title>
</head>
<body>
	<form action="/betting/MemberService" method="post">
		<input type="hidden" name="mehtod" value="editMember" />
		<table border="1" align="center">
			<tr>
				<th>ID</th>
				<td><input type="text"  readOnly="readOnly" name="id" value="${MEMBER.id}" /></td>
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
		</table>
		<table border="0" align="center">
			<tr>
				<td><input type="submit" value="회원 정보 변경" /></td>
				<td align="center"><input type="reset" value="리셋" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="/betting/MemberService?method=removeMember&ID=${MEMBER.id}">
				회원탈퇴
				</a></td>
			</tr>
		</table>
	</form>
</body>
</html>