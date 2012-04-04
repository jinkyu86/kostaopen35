<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>viewGood</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script>
	$(document).ready(function(){
		
		$("#deletegood").click(function (event){
			var result=confirm("물품을 삭제하시겠습니까?");
		
			if(result==false){
				event.preventDefault();
			}
		});
	});
</script>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<td width="200">물건 번호</td>
			<td>${GOOD.gNum }</td>
		</tr>
		<tr>
			<td >물건 이름</td>
			<td>${GOOD.gName }</td>
		</tr>
		<tr>
			<td>상세 설명</td>
			<td><textarea name="detail" >${GOOD.detail}</textarea></td>
		</tr>
		<tr>
			<td>이미지</td>
			<td><img src="/auction/gphoto/${GOOD.img }" height="100" width="100"></td>
		</tr>
	</table>
	 <p align="center">
		 <a href="/auction/GoodService?method=editGoodForm&gNum=${GOOD.gNum}">물품정보 수정</a>
	</p>
	<p align="center">
		 <a id="deletegood" href="/auction/GoodService?method=removeGood&gNum=${GOOD.gNum}">물품 삭제</a>
	 </p>
	 <p align="center">
		 <a href="/auction/AuctionService?method=addAuctionForm&gNum=${GOOD.gNum}">경매 등록</a>
	 </p>
<p align="center">
	<a href="/auction/GoodService?method=viewGoodList">
	    물품 목록 보기
	</a>
</p>
</body>
</html>