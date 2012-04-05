<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>이메일 찾기</title>
</head>
<body>

<form action="/bookchange/MemberService"method="post">
<input type="hidden" name="method" value="viewMemberEmail">
<table align="center">	
		
		<tr>
		<td>전화번호를 입력하시오		 
		<input type="text" name="tel">  
		<input type="submit" value="확인">	
		</td></tr>

</table>
</form>
</body>
</html>