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
<script type="text/javascript">
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
				required:"시작가를 입력하세요."
			},
			cuPrice:{
				required:"현재가를 입력하세요."
			},
			imPrice:{
				required:"즉구가를 입력하세요.",
					digits:"정수로 입력하세요."
			},
			sTime:{
				required:"'YYYY/MM/DD'형식에 맞게 입력하세요.",
				date:"'YYYY/MM/DD'형식에 맞게 입력하세요."
			},
			eTime:{
				required:"'YYYY/MM/DD'형식에 맞게 입력하세요.",
				date:"'YYYY/MM/DD'형식에 맞게 입력하세요."
			},
			sold:{
				required:"0 또는 1을 입력하세요",
				max:"0 또는 1을 입력하세요 (1 = sold, 0 = sale)",
				min:"0 또는 1을 입력하세요 (1 = sold, 0 = sale)"
			}
		}
 	});
		$("#addAuction").click(function (event){
				var result=confirm("물품 등록을 하시겠습니까?");
			
				if(result==false){
					event.preventDefault();
				}
			});
 });
</script>
</head>
<body>
	<h1 align="center">경매등록</h1>
	<form action="/auction/addAuction.action" method="post" id="my_form">
		<table>
		<tr>
		<td>물품번호</td>
		<td><input type ="text" name="gnum" value="${GOOD.gNum}"
				 readOnly="readOnly" /></td>
		</tr>
		<tr>
		<td>물품명</td>
		<td><input type="text" name="gname" value="${GOOD.gName}" /></td>
		</tr>
		<tr>
		<td>상세설명</td>
		<td><textarea name="detail" >${GOOD.detail}</textarea></td>
		</tr>
		<tr>
		<td>이미지</td>
		<td><img name="img" src="/auction/gphoto/${GOOD.img }" height="100" width="100"></td>
		</tr>
		
		<tr>
		<td>시작가</td>
		<td><input type ="text" name="sprice" value="10" readOnly="readOnly"></td>
		</tr>
		
		<tr>
		<td>현재가격</td>
		<td><input type ="text" name="cuprice" value="10" readOnly="readOnly"></td>
		</tr>
		
		<tr>
		<td>즉구가</td>
		<td><input type ="text" name="imprice"></td>
		</tr>
			
		<tr>
		<td>경매시작시간</td>
		<td><input type ="text" name="stime"></td>
		</tr>
		
		<tr>
		<td>경매마감시간</td>
		<td><input type ="text" name="etime"></td>
		</tr>
		
		<tr>
		<td>판매여부</td>
		<td><input type ="text" name="sold"></td>
		</tr>
		
		
		<tr>
			<td><input type="submit" value="경매등록" id="addAuction"/></td>
			<td><input type="reset" value="취소"/></td>
		</tr>
	</table>
  
</form>
</body>
</html>