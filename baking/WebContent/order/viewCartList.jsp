<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th>��ǰ��ȣ</th>
			<th>��ǰ��</th>
			<th>�̹���</th>
			<th>����</th>
			<th>�ɼ�</th>
			<th>����</th>
			<th>���</th>
		</tr>
		<c:forEach  var="order" items="${sessionScope.CART_LIST}" varStatus="i">
		<tr>
			<td>${order.good.goodNum}</td>
			<td>${order.good.name}</td>
			<td><img src="/baking/img/${order.good.good_division.gName }/${order.good.img}"/></td>
			<td>${order.qty}</td>
			<td>${order.good.option}</td>
			<td>${order.qty*order.good.goodPrice}</td>
			<td>
				<form action="/baking/OrderService" method="post">
				<input type="hidden" name="method" value="removeCart"/>
				<input type="hidden" name="index" value="${i.count-1}"/>
				<input type="submit" value="��ٱ��ϻ���"/>
				</form>
			</td>
		</tr>
		</c:forEach>
	</table>
	<center>
		<form action="/baking/OrderService" method="post">
			<input type="hidden" name="method" value="addOrder"/>
			  <input type="submit" value="�����ϱ�"/> 
		</form>
	</center>
</body>
</html>