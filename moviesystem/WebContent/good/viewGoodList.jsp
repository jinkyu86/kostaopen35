<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>매점 상품 전체</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.jsp"></script>

</head>
<body>
<!-- <h1 align="center">매점상품</h1> -->

<table width="90%" align="center">
	<!-- 상단 메뉴 시작 -->
	<tr>
		<td colspan="2">
			<jsp:include page="/common/top.jsp"></jsp:include>
		</td>
	</tr>
	<!-- 상단 메뉴 끝 -->
</table>

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
				상품명:${good.gname}<br/>
				가격:${good.gprice}	<br/>
			</td> 
		  <c:if test="${i.count%4 eq 0}">
	          </tr><tr>
	     </c:if>
	</c:forEach>
	</tr>
	
</table>

<table align="center" border="0">
	<tr align="center">	
		<td width="500">	
			<form action="/moviesystem/GoodService" method="post">
			<input type="hidden" name="method" value="searchGoodList"/>
			상품명 : <input type="text" name="keyword"/>
			<input type="submit" value="검색"/>
			</form>
		</td>
	</tr>
</table>


<p align="center">
	${PAGE_LINK_TAG}
</p>

</body>
</html>