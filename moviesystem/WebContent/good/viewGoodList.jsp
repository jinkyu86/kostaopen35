<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>매점 상품 전체</title>
</head>
<body>
<h1 align="center">매점상품</h1>
<table border="0" align="center">
	<tr>
		<th width="300"></th>
		<th width="300"></th>
		<th width="300"></th>
		<th width="300"></th>
	</tr>
	
	<tr>
	<c:forEach var="good" items="${GOOD_LIST}" varStatus="i">	
			<td align="center">
				<a href="/moviesystem/GoodService?method=viewGood&gnum=${good.gnum}">
					<img src="/moviesystem/gphoto/${good.photo}" width="200" height="200"><br/>
				</a>
				${good.gname}<br/>
				가격:${good.gprice}	<br/>
			</td> 
		  <c:if test="${i.count%4 eq 0}">
	          </tr><tr>
	     </c:if>
	</c:forEach>
	</tr>
	
</table>
</body>
</html>