<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function yes(){
		
		order.name.value=order.name1.value;
		order.zipcode.value=order.zipcode1.value;
		order.address.value=order.address1.value;
		order.strAddress.value=order.strAddress1.value;
		order.telNumber.value=order.telNumber1.value;
		order.phoneNumber.value=order.phoneNumber1.value;
		order.email.value=order.email1.value;
}
</script>

<script type="text/javascript">
function no(){

	order.name.value='';
	order.zipcode.value='';
	order.address.value='';
	order.strAddress.value='';
	order.telNumber.value='';
	order.phoneNumber.value='';
	order.email.value='';
}
</script>
</head>
<body>
<form action="" name="order">
<table border="1" align="center">
	<tr>
		<th>��ǰ��ȣ</th>
		<th>��ǰ��</th>
		<th>�̹���</th>
		<th>����</th>
		<th>�ɼ�</th>
		<th>����</th>
	</tr>
	<c:forEach  var="order" items="${CART_LIST}">
	<tr>
		<td>${order.good.goodNum}</td>
		<td>${order.good.name}</td>
		<td><img src="/baking/img/${order.good.good_division.gName }/${order.good.img}"/></td>
		<td>${order.qty}</td>
		<td>${order.good.option}</td>
		<td>${order.qty*order.good.goodPrice}</td>
	</tr>
</table>
<p align="center">�ֹ�������</p>
<table style="border: 2px solid #ddd;">
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">�̸�</td>
		<td><input type="text" size=25 name="name1" value="${order.member.name}"/></td>
	</tr>
	<tr style="border: 2px solid #ddd;">
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">�ּ�</td>
		<td><input type="text" size=11 name="zipcode1" value="${order.member.zipcode}"/>
		<input type="submit" value="�����ȣ�˻�"/>( - ���� )<br/>
		<input type="text" size=50 name="address1" value="${order.member.address}"/> �⺻�ּ� <br/>
		<input type="text" size=50 name="strAddress1" value="${order.member.strAddress}"/> �������ּ� </td>
	</tr>
	<tr>
		<td align="center">������ȭ</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
		<input type="text" size=15 name="telNumber1" value="${order.member.telNumber}"/>( - ���� )
		</td>
	</tr>
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">�޴���ȭ</td>
		<td>
			<input type="text" size=15 name="phoneNumber1" value="${order.member.phoneNumber}"/>( - ���� )
		</td>
	</tr>
	<tr>
		<td align="center">�̸���</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
		<input type="text" size=25 name="email1" value="${order.member.email}"/>
		</td>
	</tr>
</c:forEach>
</table>
<p align="center">���������</p>
<p align="right">����� ������ �ֹ��� ������ �����մϱ�?
<input type=radio name=sl value="0"  onclick="yes()"/>��
<input type=radio name=sl value="1"  onclick="no()"/>�ƴϿ�</p>

<table style="border: 2px solid #ddd;" >
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">�̸�</td>
		<td><input type="text" size=25 name="name"/></td>
	</tr>
	<tr style="border: 2px solid #ddd;">
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">�ּ�</td>
		<td><input type="text" size=11 name="zipcode"/>
		<a href='#' onclick="window.open('b1.php','zip','width=500, height=500')">
		<img src="images/po.jpg" alt="" width="100" height="22"/></a>( - ���� )<br/>
		<input type="text" size=50 name="address"/> �⺻�ּ� <br/>
		<input type="text" size=50 name="strAddress"/> �������ּ� </td>
	</tr>
	<tr>
		<td align="center">������ȭ</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
		<input type="text" size=15 name="telNumber"/>( - ���� )
		</td>
	</tr>
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">�޴���ȭ</td>
		<td>
			<input type="text" size=15 name="phoneNumber"/>( - ���� )
		</td>
	</tr>
	<tr>
		<td align="center">�̸���</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
		<input type="text" size=25 name="email"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>