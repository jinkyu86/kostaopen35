<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>viewGoodList</title>
</head>
<body>
<table border="1" align="center">
		<tr>
			<th>번호</th>
			<th>이름</th>
		</tr>
		<c:forEach var="good" items="${GOOD_LIST}" varStatus="i">
		<tr>
			<td>
				${good.num}
			</td>
			<td>
				<a href="/auction/GoodService?method=viewGood&num=${good.num}">
				${good.name}
				</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>