<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>멤버추가</title>
</head>
<body>
	<h1 align="center">멤버추가</h1>
	<form  action="/member/MemberService" 
		method="post">
		<input type="hidden"  name="method"
		  value="addStudent"/>
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text"  name="userid"></td>
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
				<td>코인</td>
				<td><input type="text" name="coin"></td>
				</tr>
			<tr>
				<td>E머니</td>
				<td><input type="text" name="emoney"></td>
				</tr>	
				<tr>
					<td>
						<input type="submit" value="멥버추가"/>
					</td>
					<td>
						<input type="reset" value="취소"/>
					</td>
			</tr>
		</table>
	
	</form>
</body>
</html>