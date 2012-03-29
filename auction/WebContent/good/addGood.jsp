<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>addGood</title>
</head>
<body>
	<h1 align="center">물품 추가</h1>
	<form action="/auction/GoodService" method="post">
	<table border="1" align="center">	
		<input type="hidden" name="method" value="addGood"/>
		<tr>
			<td>물품명</td>
			<td><input type="text" name="gName" /></td>
		</tr>
		<tr>
			<td>상세설명</td>
			<td><textarea name="detail" ></textarea></td>
		</tr>
		<tr>
			<td>이미지</td>
			<td><input type="text" name="img"></td>
		</tr>
	</table>
	<center>	
		<input type="submit"  value="물건 등록"/>
		<input type="reset" value="입력취소"/>
	</center>
	</form>
</body>
</html>