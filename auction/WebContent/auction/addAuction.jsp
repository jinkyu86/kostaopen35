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
	<h1 align="center">����߰�</h1>
	<form action="/auction/AuctionService" method="post">
		<input type="hidden" name="method" value="addAuction" />
		<table>
		<tr>
		<td>��ǰ��ȣ</td>
		<td><input type ="text" name="gNum"></td>
		</tr>
		
		<tr>
		<td>���۰�</td>
		<td><input type ="text" name="sPrice"></td>
		</tr>
		
		<tr>
		<td>���簡��</td>
		<td><input type ="text" name="cuPrice"></td>
		</tr>
		
		<tr>
		<td>�ﱸ��</td>
		<td><input type ="text" name="imPrice"></td>
		</tr>
			
		<tr>
		<td>��Ž��۽ð�</td>
		<td><input type ="text" name="sTime"></td>
		</tr>
		
		<tr>
		<td>��Ÿ����ð�</td>
		<td><input type ="text" name="eTime"></td>
		</tr>
		
		<tr>
		<td>�Ǹſ���</td>
		<td><input type ="text" name="sold"></td>
		</tr>
		
		
		<tr>
			<td><input type="submit" value="����߰�"/></td>
			<td><input type="reset" value="���"/></td>
		</tr>
	</table>

</form>
</body>
</html>