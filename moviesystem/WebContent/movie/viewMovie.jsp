<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${Movie.mname}</title>
</head>
<body>
	<table border="1" width="90%" align="center">
		<tr>
			<td rowspan="3">${Movie.poster}</td>
			<td>${Movie.mname}</td>
		</tr>
		<tr>
			<td>장르 : ${Movie.genre}</td>
		</tr>
		<tr>
			<td>개봉일 : ${Movie.launchDate}</td>
		</tr>
		<tr>
			<td>가격 : ${Movie.mprice}</td>
		</tr>
		<tr>
			<td colspan="2">줄거리<br/><br/>
				${Movie.content}	
			</td>
		</tr>
	</table>
	<p align="center">
		<form action="/moviesystem/MovieService">
			<input type="hidden" name="method" value="viewMovieList">
			<input type="hidden" name="gubun" value="${gubun}">
			<input type="submit" value="목록">
		</form>
	</p>
</body>
</html>