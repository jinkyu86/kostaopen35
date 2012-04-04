<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>장바구니 목록</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script src="/moviesystem/js/common.jsp"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#my_form").validate({
		rules:{
			qty:{
				digits:true,
				range:[1,100]
			}
		},
		messages:{
			qty:{
				digits:"숫자 정수를 입력해주세요.",
				range:"1 이상 100 이하의 값을 입력해주세요."
			}
		},
		errorPlacement: function(error, element) {     
			error.appendTo( $(".qtymsg") );
			}
		
	});
});
</script>
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
	
</table>

<table border="1" align="center">
	<tr>
		<th>이미지</th>
		<th>상품명</th>
		<th>단가</th>
		<th width="200">개수</th>	
		<th>총가격</th>
		<th>기타</th>	
		
	</tr>

	<c:forEach var="buy"  items="${sessionScope.CART_LIST }" varStatus="i">
	<tr>
		<td>
			<img src="/moviesystem/gphoto/${buy.good.photo}" width="100" height="100"/>
		</td>
		<td>
			${buy.good.gname}
		</td>
		<td>
			${buy.good.gprice}
		</td>
		<td>

			<form action="/moviesystem/GoodService" method="post" id="my_form">
				<input type="hidden" name="method" value="editCartList"/>
				<input type="text" name="qty" value="${buy.qty}" id="qty"size=6/>
				<input type="submit" value="수량변경"/><br/>
				<input type="hidden" name="index" value="${i.count-1}"/>
				<div class="qtymsg"></div>
								
			</form>
	
		</td>	
		<td>
			${buy.good.gprice*buy.qty}
		</td>
		<td>
			<form action="/moviesystem/GoodService" method="post">
				<input type="hidden" name="method"value="removeCartList"/>
				<input type="hidden" name="index"value="${i.count-1}"/>
				<input type="submit" value="삭제"/>
			</form>
		</td>
	</tr><br/>
		
	</c:forEach>
</table>


<table border="0" align="center" width="400">
	<tr align="center"><br/>
		<td>
		<form action="/moviesystem/BuyService" method="post">
			<input type="hidden" name="method" value="addBuy"/>	
			<input type="submit" value="결제하기" />
		</form>
		</td>
	</tr><br/>
	<tr>
		<p align="center">
			<a href="/moviesystem/GoodService?method=viewGoodList">쇼핑하러가기</a>
		</p>
	</tr>
</table>
</body>
</html>