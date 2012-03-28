<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>영화 소개</title>
</head>
<body>
	<table width="80%" align="center" border="1">
		<c:forEach var="movieList" items="${MovieList}">
			<tr>
				<td rowspan="2">${movieList.poster}</td>
				<td><a href="/moviesystem/MovieService?method=viewMovie&gubun=${gubun}&mnum=${movieList.mnum}"><b>${movieList.mname}</b></a></td>
			</tr>
			<tr>
				<td>장르 : ${movieList.genre}&nbsp;&nbsp;&nbsp;
					개봉일 : <fmt:formatDate value="${movieList.launchDate}" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p align="center">
		${page_Link_Tag}
	</p>
</body>
</html>