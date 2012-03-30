<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>viewGood</title>
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
		 <a href="/auction/GoodService?method=removeGood&gNum=${GOOD.gNum}">물품 삭제</a>
	 </p>
</body>
</html>