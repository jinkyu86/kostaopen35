<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>editGood</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script>
$(document).ready(function(){
	$('#my_form').validate({
		rules:{
			gName:{
				required:true,
				minlength:1
			},
			detail:{
				required:true,
				minlength:1
			},
			img:{
				required:true,
				minlength:1
			}
		},
		messages:{
			gName:{
				required: "제품명을 입력하세요."
			},//end name
			detail:{
				required:"상세설명을 입력하세요."
			},//end detail
			img:{
				required:"사진파일명을 입력하세요. EX)s1.jpg",
			}//end price
		}
	});
});
</script>
</head>
<body>
	<h1 align="center">물품 정보 수정</h1>
	<form action="/auction/GoodService" method="post" id="my_form">
		<input type="hidden" name="method" value="editGood"/>
				<table border="1" align="center">
					<tr>
						<td>물품 번호</td>
						<td><input type="text" name="gNum" value="${GOOD.gNum}" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>물품명</td>
						<td><input type="text" name="gName" value="${GOOD.gName}" /></td>
					</tr>
					<tr>
						<td>상세설명</td>
						<td><textarea name="detail" >${GOOD.detail}</textarea></td>
					</tr>
					<tr>
						<td>이미지</td>
						<td><input text="text" name="img" value="${GOOD.img}"/></td>
					</tr>
			</table>
		<center>
			<input type="submit" value="물건 정보 수정"/>
			<input type="reset" value="입력취소"/>
		</center>
	</form>
<p align="center">
	<a href="/auction/GoodService?method=viewGoodList">
	    물품 목록 보기
	</a>
</p>
</body>
</html>