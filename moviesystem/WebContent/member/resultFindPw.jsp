<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib  prefix="c" 
            uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��й�ȣã�� ��� ��ȸ</title>
</head>
<body>
	<h1 align="center">��й�ȣã�� ���</h1>
	<table align="center">
		
		<tr>
			
			<td><h2>${MEMBER.userid}���� ��й�ȣ��<font color="blue"> ${MEMBER.pw}</font>�Դϴ�.</h2></td>
		</tr>
	
			
	</table>
	<p align="center">
	<a href="/moviesystem/MemberService?method=loginForm">�α���</a></p>
</body>
</html>