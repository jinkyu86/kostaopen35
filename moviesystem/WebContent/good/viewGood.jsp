<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>물건 조회</title>
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
			error.appendTo( $("#qtymsg") );
			}
	});
});

</script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#my_page').css('background-color','#C4E2FF');
		$('.top_row').css('background-color','#C4E2FF');
	});
</script>
</head>
<body>

<table width="90%" align="center">
	<!-- 상단 메뉴 시작 -->
	<tr>
		<td colspan="3">
			<jsp:include page="/common/top.jsp"></jsp:include>
		</td>
	</tr>
	<!-- 상단 메뉴 끝 -->
	<tr>
<td width=10%></td>
<td>

<table class="table_style" align="center">
	<tr>
		<td rowspan=3 width="200"><img src="/moviesystem/gphoto/${GOOD.photo}" width="200" height="200"></td>
		<th class="top_row" width="80">상품명</th><td>${GOOD.gname}</td>
	</tr>
	<tr>
		<th class="top_row">상품 가격</th><td>${GOOD.gprice}</td>
	</tr>
	<tr>
		<th class="top_row">상품 설명</th><td width="500">${GOOD.detail}</td>
	</tr>

</table>

<table border="0" align="center">
	<form action="/moviesystem/addCartList.action"  method="post"  id="my_form"  align="center">
		<input type="hidden"name="gnum" value="${GOOD.gnum}"/>
		<tr>
			<td  width="300" align="center">
				수량 : <input type="text" name="qty"  value="1" id="qty" size="6"/>
				<input type="submit" value="장바구니 담기"/>
			</td>
		</tr>
		<tr>
			<td align="center"><div id="qtymsg"></div></td>
			
		</tr>
	</form>
</table>
</td>
<td width=10%></td>
</tr>
</table>
</body>
</html>