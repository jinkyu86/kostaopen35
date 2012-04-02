<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원탈퇴</title>
</head>
<body>
		<form action="/bookchange/MemberService"method="post">
		 <input type="hidden" name="method" value="removeMember">
		 <input type="hidden" name="email" value="${sessionScope.LOGIN_EMAIL.email}">
		  <tr>
				
				<td>Email</td>
  				<td>${sessionScope.LOGIN_EMAIL.email} 님이 탈퇴되었습니다.</td>
  			
  		  </tr>
  		  </form>
</body>
</html>