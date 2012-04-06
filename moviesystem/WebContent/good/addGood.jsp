<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>물건 등록</title>
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
					range:[1,1000000000]
				},
				detail:{
					required:true,
					minlength:2
				},
				photo:{
					required:true
				}
			},
			messages:{
				gname:{
					required:"상품명은 필수 사항입니다.",
					minlength:"상품명을 정확하게 입력해 주세요."
				},
				gprice:{
					digits:"정확한 숫자를 입력해주세요",
					range:"0에서 1000000000사이의 가격을 입력해주세요."
				},
				detail:{
					required:"상품설명을 입력해주세요",
					minlength:"상품설명을 정확하게 입력해 주세요."
				},
				photo:{
					required:"업로드할 파일명을 올려주세요."
				}
			}//end message
		});
	});
	
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
		<td valign="top" style="width:20%">
			<jsp:include page="/member/MypagLeft.jsp"></jsp:include>
		</td>
<td>



<h1>물건 등록</h1>
<form id="my_form" action="/moviesystem/GoodService" method="post" >
	<input type="hidden" name="method" value="addGood"/>
	<table border="1" class="table_style">
		<tr>
			<th class="top_row" width="20%"><label>상품명</label></th>
			<td><input type="text" name="gname"/></td>
		</tr>
		<tr>
			<th class="top_row"><label>가격</label></th>
			<td><input type="text" name="gprice"/></td>
		</tr>
		<tr>
			<th class="top_row"><label>상품설명</label></th>
			<td><textarea name="detail" style="width:50%"></textarea></td>
		</tr>
		<tr>
			<th class="top_row"><label>상품이미지</label></th>
			<td><input type="text" name="photo"/></td>
		</tr>
	</table>

	<input type="submit" value="등록하기"/>
	<input type="reset" value="지우기"/>
</form>


</td>
</tr>
</table>

</body>
</html>