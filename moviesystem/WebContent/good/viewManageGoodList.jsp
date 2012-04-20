<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>물품 관리 페이지</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.jsp"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#my_page').css('background-color','#C4E2FF');
		$('#top_row').css('background-color','#C4E2FF');
		$('#good_management').css('background-color','#ebfbff');
	});
</script>
</head>
<body>
<table width="90%" align="center">
	<!-- 상단 메뉴 시작 -->
	<tr colspan="2">
		<td>
			<jsp:include page="/common/top.jsp"></jsp:include>
		</td>
	</tr>
	<!-- 상단 메뉴 끝 -->
</table>


<table width="90%" align="center">
	<tr>
		<!-- 좌측 메뉴 시작 -->
		<td valign="top" style="width:20%">
			<jsp:include page="/member/MypagLeft.jsp"></jsp:include>
		</td>
		<!-- 좌측 메뉴 끝 -->
		
		<td align="center">

			<table class="table_style" align="center">
				<tr id="top_row">
					<th>상품번호</th>
					<th>상품이미지</th>
					<th>상품명</th>
					<th>상품가격</th>
					<th>기타</th>
				</tr>
				
				<c:forEach var="good" items="${GOOD_LIST}" varStatus="i">	
				<tr>
					<td>${good.gnum}</td>
					<td>
						<a href="/moviesystem/editGoodForm.action?gnum=${good.gnum }">
							<img src="/moviesystem/gphoto/${good.photo}" width="100" height="100">
						</a>
					</td>
					<td>${good.gname}</td>
					<td>${good.gprice}</td>
					<td>
						<form action="/moviesystem/deleteGood.action" method="post">
							<input type="hidden" name="gnum" value="${good.gnum}"/>
							<input type="submit" value="물건삭제"/>
						</form>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			</form>
			<p align="center">
				${PAGE_LINK_TAG}
			</p>
			
			<table align="center">
			<tr>
			<td>
			<form action="/moviesystem/addGoodForm.action" method="post">
				<input type="submit" value="물건추가"/>
			</form>
			</td>
			</tr>
			</table>
			</form>

		</td>
	</tr>
</table>

</body>
</html>