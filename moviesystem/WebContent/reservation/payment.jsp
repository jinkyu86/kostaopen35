<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
</head>
<body>
<table border="0" align="center">
	<tr>
		<th>결제하기</th>
	</tr>
	<tr>
		<td><a href="/moviesystem/ReservationService?method=viewReservationByResNum&resnum=${resnum}">
		<input type="button" value="확인"/>
		</a></td>
	</tr>
</body>
</html>