<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.jsp"></script>
</head>
<body>
<table width="90%" align="center">
	<!-- 상단 메뉴 시작 -->
	<tr>
		<td colspan="2">
			<jsp:include page="/common/top.jsp"></jsp:include>
		</td>
	</tr>
	<!-- 상단 메뉴 끝 -->
	
	<tr>
		<!-- 좌측 메뉴 시작 -->
		<td valign="top" style="width:20%">
			<jsp:include page="/member/MypagLeft.jsp"></jsp:include>
		</td>
		<!-- 좌측 메뉴 끝 -->
		
		<!-- 본문 내용 시작 -->
		<td align="center">














<table border="1" align="center">
	<tr>
		<th>좌</th>
		<th></th>
		<th></th>
		<th></th>
		<th></th>
		<th></th>
		<th></th>
		<th>석</th>
	</tr>


<c:forEach var="reservation" items="${TotalSeatList}"  varStatus="i">
 	
		
 		
 	    <c:choose>
			<c:when test="${reservation==0 }">		
 				<td>
				<a href="/moviesystem/SelectSeat.action?seatString=${i.count}">
				${i.count }
				</a>
				</td>
			</c:when>
			<c:otherwise>
				<td>
				x
				</td>
			</c:otherwise>
		</c:choose>
	
		
		<c:choose>
			<c:when test="${i.count%8==0 }">		
				<tr>

				</tr>
			</c:when>

		</c:choose>


</c:forEach>		
		


</table>























		</td>
	</tr>
	<!-- 본문 내용 끝 -->
	<!-- 하단 내용 시작 -->
	<tr>
		<td colspan="2">
			<jsp:include page="/common/footer.jsp"></jsp:include>
		</td>
	</tr>
	<!-- 하단 내용 끝 -->
</table>


</body>
</html>