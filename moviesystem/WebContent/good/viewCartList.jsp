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
		//$('#my_page').css('background-color','#C4E2FF');
		$('#top_row').css('background-color','#C4E2FF');
	});
</script>

<script type="text/javascript">
$(document).ready(function(){
	$("#my_form").validate({
		rules:{
			<c:forEach var="buy" items="${sessionScope.CART_LIST }" varStatus="i">
				qty${i.count-1}:{
					digits:true,
					range:[1,100]
				}
				<c:if test="${sessionScope.CART_LIST[i.count] ne null}">
					,
				</c:if>
			</c:forEach>
		},
		messages:{
			<c:forEach var="buy" items="${sessionScope.CART_LIST }" varStatus="i">
			qty${i.count-1}:{
				digits:"숫자 정수를 입력해주세요.",
				range:"1 이상 100 이하의 값을 입력해주세요."
				}
			<c:if test="${sessionScope.CART_LIST[i.count] ne null}">
				,
			</c:if>
			</c:forEach>
		},
		errorPlacement: function(error, element) { 
			<c:forEach var="buy" items="${sessionScope.CART_LIST }" varStatus="i">
			qty${i.count-1}:{
				error.appendTo( $("#qtymsg${i.count-1}"));
			}
			<c:if test="${sessionScope.CART_LIST[i.count] ne null}">
				,
			</c:if>
			</c:forEach>
		}
		
	});

});
//editCartList에서 qty를 받는데 validation이 name태크를 보고 검사하므로 이름이 바뀌면  /editCartList에 qty값이 전달이 안된다
// id로 할수 있는 방법이 없나?  유효성 검사도 안된다.

</script>
</head>
<body>
<table width="90%" align="center" >
	<!-- 상단 메뉴 시작 -->
	<tr>
		<td colspan="3">
			<jsp:include page="/common/top.jsp"></jsp:include>
		</td>
	</tr>
	<!-- 상단 메뉴 끝 -->
	
	<tr>
		<td width=20%>
		</td>
		<td>
		<h1 align="center">장바구니</h1>
			<table class="table_style" align="center" >
			
				<tr id="top_row">
					<th width="110">이미지</th>
					<th>상품명</th>
					<th>단가</th>
					<th width="200">개수</th>	
					<th>총가격</th>
					<th width="50">기타</th>	
				</tr>

				<c:forEach var="buy"  items="${sessionScope.CART_LIST }" varStatus="i">
				<tr>
					<td><img src="/moviesystem/gphoto/${buy.good.photo}" width="100" height="100"/></td>
					<td>${buy.good.gname}</td>
					<td>${buy.good.gprice}</td>
					<td>
						<form action="/moviesystem/editCartList.action" method="post" id="my_form">
							<input type="text" name="qty${i.count-1}" value="${buy.qty}" size=6/>
							<input type="submit" value="수량변경"/><br/>
							<input type="hidden" name="index"  value="${i.count-1}"/>	
							<div id="qtymsg${i.count-1}"></div>	
						</form>
					</td>	
					<td>${buy.good.gprice*buy.qty}</td>
					<td>
						<form action="/moviesystem/removeCartList.action" method="post">
							<input type="hidden" name="index"  value="${i.count-1}"/>
							<input type="submit" value="삭제"/>
						</form>
					</td>
				</tr><br/>
				</c:forEach>
			</table>

			<table align="center" width="400">
				<tr><br/>
					<td align="center">
						<c:if test="${sessionScope.CART_LIST[0] ne null}">
							<form action="/moviesystem/addBuy.action" method="post" class="my_form">
								<input type="submit" value="결제하기" />
							</form>
						</c:if>
					</td>
				</tr><br/>
				<tr align="center">
				<td>
					<p>
						<a href="/moviesystem/viewGoodList.action">쇼핑하러가기</a>
					</p>
					</td>
				</tr>
			</table>		
		</td>
		<td width=20%>
		</td>
	</tr>
</table>
</body>
</html>