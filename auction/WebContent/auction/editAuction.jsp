<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>경매 수정</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script>
 $(document).ready(function(){
	 $('#my_form').validate({
		rules:{
			sPrice:{
				required:true,
				minlength:1,
				digits:true
			},
			cuPrice:{
				required:true,
				minlength:1,
				digits:true
			},
			imPrice:{
				required:true,
				minlength:1,
				digits:true
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
				minlength:1,
				max:1,
				min:0
			}
		},
		messages:{
			sPrice:{
				required:"시작가를 입력하세요.",
				digits:"정수로 입력하세요."
			},
			cuPrice:{
				required:"현재가를 입력하세요.",
				digits:"정수로 입력하세요."
			},
			imPrice:{
				required:"즉구가를 입력하세요.",
				digits:"정수로 입력하세요."
			},
			sTime:{
				required:"'YYYY/MM/DD HH:mm:ss'형식에 맞게 입력하세요.",
				date:"'YYYY/MM/DD HH:mm:ss'형식에 맞게 입력하세요."
			},
			eTime:{
				required:"'YYYY/MM/DD HH:mm:ss'형식에 맞게 입력하세요.",
				date:"'YYYY/MM/DD HH:mm:ss'형식에 맞게 입력하세요."
			},
			sold:{
				required:"0 또는 1을 입력하세요",
				max:"0 또는 1을 입력하세요",
				min:"0 또는 1을 입력하세요"
			}
		}
 	});
		$("#editAuction").click(function (event){
				var result=confirm("경매정보를 수정 하시겠습니까?");
			
				if(result==false){
					event.preventDefault();
				}
			});
 });
</script>
</head>
<body>
<h1 align="center">경매수정</h1>
<form action="/auction/editAuction.action" method="post" id="my_form">
		<table align="center">
		<tr>
			<td>물품번호</td>
			<td><input type="text" name="gNum"
				value="${AUCTION.good.gNum}"
				 readOnly="readOnly" /></td>
		</tr>

		<tr>
			<td>시작가</td>
			<td><input type="text" name="sPrice"
				value="${AUCTION.sPrice}" /></td>
		</tr>
		<tr>
			<td>즉구가</td>
			<td><input type="text" name="imPrice"
				value="${AUCTION.imPrice}" /></td>
		</tr>
		<tr>
			<td>경매번호</td>
			<td><input type="text" name="aNum"
				value="${AUCTION.aNum}"
				readOnly="readOnly" /></td>
		</tr>
		<tr>
			<td>경매시작시간</td>
			<td><input type="text" name="sTime"
				value="${AUCTION.sTime}" /></td>
		</tr>
		<tr>
			<td>경매마감시간</td>
			<td><input type="text" name="eTime"
				value="${AUCTION.eTime}" /></td>
		</tr>
		<tr>
			<td>판매여부</td>
			<td><input type="text" name="sold"
				value="${AUCTION.sold}" /></td>
		</tr>
		<tr>
			<td>현재가격</td>
			<td><input type="text" name="cuPrice"
				value="${AUCTION.cuPrice}" /></td>
		</tr>
		<tr>
			<td>현재입찰자</td>
			<td><input type="text" name="userid" value="${AUCTION.userid }" readOnly="readOnly"/></td>
		<tr>
			<td><input type="submit" value="경매수정" id="editAuction"/></td>
			<td><input type="reset" value="입력취소" /></td>
		</tr>
	</table>
</form>

</body>
</html>