<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>addAuction</title>

<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script>
 $(document).ready(function(){
	 $('#my_form').validate({
		rules:{
			sPrice:{
				required:true,
				minlength:1
			},
			cuPrice:{
				required:true,
				minlength:1
			},
			imPrice:{
				required:true,
				minlength:1
			},
			sTime:{
				required:true,
				date:true
			},
			eTime:{
				required:true,
				date:true
			},
			sold:{
				required:true,
				minlength:1
			}
		},
		massages:{
			sPrice:{
				required:"시작가를 입력하세요."
			},
			cuPrice:{
				required:"현재가를 입력하세요."
			},
			imPrice:{
				required:"즉구가를 입력하세요."
			},
			sTime:{
				required:"형식에 맞게 입력하세요."
			},
			eTime:{
				required:"형식에 맞게 입력하세요."
			},
			sold:{
				required:"판매여부를 입력하세요",
			}
		}
 	});
 });
</script>
</head>
<body>
	<body>
	<h1 align="center">경매추가</h1>
	<form action="/auction/AuctionService" method="post" id="my_form">
		<input type="hidden" name="method" value="addAuction" />
		<table>
		<tr>
		<td>물품번호</td>
		<td><input type ="text" name="gNum"value="${GOOD.gNum}"
				 readOnly="readOnly" /></td>
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
		<td><img src="/auction/gphoto/${GOOD.img }" height="100" width="100"></td>
		</tr>
		
		<tr>
		<td>시작가</td>
		<td><input type ="text" name="sPrice"></td>
		</tr>
		
		<tr>
		<td>현재가격</td>
		<td><input type ="text" name="cuPrice"></td>
		</tr>
		
		<tr>
		<td>즉구가</td>
		<td><input type ="text" name="imPrice"></td>
		</tr>
			
		<tr>
		<td>경매시작시간</td>
		<td><input type ="text" name="sTime"></td>
		</tr>
		
		<tr>
		<td>경매마감시간</td>
		<td><input type ="text" name="eTime"></td>
		</tr>
		
		<tr>
		<td>판매여부</td>
		<td><input type ="text" name="sold"></td>
		</tr>
		
		
		<tr>
			<td><input type="submit" value="경매추가"/></td>
			<td><input type="reset" value="취소"/></td>
		</tr>
	</table>

</form>
</body>
</html>