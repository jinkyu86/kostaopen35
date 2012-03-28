<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<p align="center" var=member >
<a href="/moviesystme12/ReservationService?method=viewReservationListById&userid=${member.userid}">
예약 정보 조회
</a>
</p>

<p align="center" var=member >
<a href="/moviesystme12/ReservationService?method=addReservationForm&userid=${member.userid}">
예약 하기
</a>
</p>

<%-- &userid=${member.userid}--%>
</body>
</html>