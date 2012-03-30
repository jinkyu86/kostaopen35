<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<body>
	<h1 align="center">경매추가</h1>
	<form action="/auction/AuctionService" method="post">
		<input type="hidden" name="method" value="addAuction" />
		<table>
		<tr>
		<td>물품번호</td>
		<td><input type ="text" name="gNum"></td>
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