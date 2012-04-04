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
		<th>상품번호</th>
		<th>상품명</th>
		<th>이미지</th>
		<th>수량</th>
		<th>옵션</th>
		<th>가격</th>
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
<p align="center">주문자정보</p>
<table style="border: 2px solid #ddd;">
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">이름</td>
		<td><input type="text" size=25 name="name1" value="${order.member.name}"/></td>
	</tr>
	<tr style="border: 2px solid #ddd;">
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">주소</td>
		<td><input type="text" size=11 name="zipcode1" value="${order.member.zipcode}"/>
		<input type="submit" value="우편번호검색"/>( - 생략 )<br/>
		<input type="text" size=50 name="address1" value="${order.member.address}"/> 기본주소 <br/>
		<input type="text" size=50 name="strAddress1" value="${order.member.strAddress}"/> 나머지주소 </td>
	</tr>
	<tr>
		<td align="center">유선전화</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
		<input type="text" size=15 name="telNumber1" value="${order.member.telNumber}"/>( - 생략 )
		</td>
	</tr>
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">휴대전화</td>
		<td>
			<input type="text" size=15 name="phoneNumber1" value="${order.member.phoneNumber}"/>( - 생략 )
		</td>
	</tr>
	<tr>
		<td align="center">이메일</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
		<input type="text" size=25 name="email1" value="${order.member.email}"/>
		</td>
	</tr>
</c:forEach>
</table>
<p align="center">배송지정보</p>
<p align="right">배송지 정보가 주문지 정보와 동일합니까?
<input type=radio name=sl value="0"  onclick="yes()"/>예
<input type=radio name=sl value="1"  onclick="no()"/>아니오</p>

<table style="border: 2px solid #ddd;" >
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">이름</td>
		<td><input type="text" size=25 name="name"/></td>
	</tr>
	<tr style="border: 2px solid #ddd;">
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">주소</td>
		<td><input type="text" size=11 name="zipcode"/>
		<a href='#' onclick="window.open('b1.php','zip','width=500, height=500')">
		<img src="images/po.jpg" alt="" width="100" height="22"/></a>( - 생략 )<br/>
		<input type="text" size=50 name="address"/> 기본주소 <br/>
		<input type="text" size=50 name="strAddress"/> 나머지주소 </td>
	</tr>
	<tr>
		<td align="center">유선전화</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
		<input type="text" size=15 name="telNumber"/>( - 생략 )
		</td>
	</tr>
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">휴대전화</td>
		<td>
			<input type="text" size=15 name="phoneNumber"/>( - 생략 )
		</td>
	</tr>
	<tr>
		<td align="center">이메일</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
		<input type="text" size=25 name="email"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>