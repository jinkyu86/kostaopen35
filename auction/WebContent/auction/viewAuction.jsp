<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table  align="center"  border="1">
	<tr>
	<td>��ǰ��ȣ</td><td>���۰�</td><td>�ﱸ��</td><td>��Ź�ȣ</td><td>��Ž��۽ð�</td>
	<td>��Ÿ����ð�</td><td>�Ǹſ���</td><td>���簡��</td>
	</tr>
	<tr>
				<td>${AUCTION.good.gNum}</td>
				<td>${AUCTION.sPrice}</td>
				<td>${AUCTION.imPrice}</td>
				<td>${AUCTION.aNum}</td>
				<td>${AUCTION.sTime}</td>
				<td>${AUCTION.eTime}</td>
				<td>${AUCTION.sold}</td>
				<td>${AUCTION.cuPrice}</td>
			</tr>
</table>
			
	 <p align="center">
		 <a href="/auction/AuctionService?method=editAuctionForm&aNum=${GOOD.aNum}">��ǰ���� ����</a>
	</p>
	<p align="center">
		 <a href="/auction/AuctionService?method=removeAuction&aNum=${GOOD.aNum}">��ǰ ����</a>
	 </p>
</body>
</html>