<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>물건 정보 수정</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script src="/moviesystem/js/common.jsp"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#my_form").validate({
		rules:{
			gname:{
				required:true,
				minlength:2
			},
			gprice:{
				digits:true,
				range:[1,99999999]
			}
		},
		messages:{
			gname:{
				required:"상품명은 필수입력사항 입니다.",
				minlength:"상품명을 정확하게 입력해주세요."
			},
			gprice:{
				digits:"숫자 정수를 입력해주세요.",
				range:"가격범위를 초과했습니다."
			}
		}
	});
});

</script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#my_page').css('background-color','#C4E2FF');
		$('.top_row').css('background-color','#C4E2FF');
		$('#good_management').css('background-color','#ebfbff');
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
	<tr>
		<!-- 좌측 메뉴 시작 -->
		<td valign="top" style="width:20%">
			<jsp:include page="/member/MypagLeft.jsp"></jsp:include>
		</td>
		<!-- 좌측 메뉴 끝 -->
<td>
<form action="/moviesystem/GoodService" method="post" id="my_form">
<h1 align="center">물건정보수정</h1>
<table class="table_style" align="center">
	<tr>
		<td rowspan=4 width="200"><img src="/moviesystem/gphoto/${GOOD.photo}" width="200" height="200"></td>
		<th class="top_row" width="80">상품명</th>
		<td><input type="text" name="gname" value="${GOOD.gname}"/></td>
	</tr>
	<tr>
		<th class="top_row">상품 가격</th>
		<td><input type="text" name="gprice" value="${GOOD.gprice}"></td>
	</tr>
	<tr>
		<th class="top_row">상품 이미지</th>
		<td><input type="text" name="photo" value="${GOOD.photo}"></td>
	</tr>
	<tr>
		<th class="top_row">상품 설명</th>
		<td width="500">
			<textarea style="WIDTH:70%" name="detail">${GOOD.detail}</textarea>
		</td>
	</tr>
</table>
	
<input type="hidden" name="method" value="editGood"/>
<input type="hidden" name="gnum" value="${GOOD.gnum }"/>
<input type="submit" value="수정하기"/>
</form>

</td>
</table>
</body>
</html>