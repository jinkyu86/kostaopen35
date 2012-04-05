<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>	
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
<link rel="stylesheet" href="/baking/styles.css" type="text/css" media="screen" />	
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<style type="text/css">
	a:link {text-decoration:none}
	a:visited {text-decoration:none}
	a:hover {text-decoration:none}
	a {color:#000000; text-decoration:none; }
</style>
</head>
<ul>	
	<div ALIGN="right">
	<c:choose> 
		<c:when test="${sessionScope.member==null}">
		<a href="/baking/member/loginForm.jsp">로그인</a>
		<a href="">회원가입</a>
		</c:when>
		<c:otherwise>
		<a href="/baking/MemberService?method=logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
	</div>
<body>
<header>
<h1>HOME BAKING MALL</h1><br><br>
</header>
<nav>
<!-- top nav -->	
<div class="menu">			
<ul>			
	<li><a href="/baking/GoodService?method=viewIndex">홈</a></li>			
	<li><a href="/baking/RecipeService?method=viewGoodList">상품</a></li>		
	<li><a href="/baking/RecipeService?method=viewRecipeList">레시피</a></li>			
	<li><a href="/baking/OrderService?method=viewCartList">장바구니</a></li>			
	<li><a href="/baking/OrderService?method=viewOrderList">주문조회</a></li>		
	<li><a href="/baking/GoodService?method=viewIndex">마이레시피</a></li>		
</ul>
</div>
</nav>

<!-- end of top nav -->

<!-- content -->
<section id="content">			
<ul class="column">
			        
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
	<c:forEach var="order" items="${sessionScope.CART_LIST}">
	<tr>
		<td>${order.good.goodNum}</td>
		<td>${order.good.name}</td>
		<td><img src="/baking/img/${order.good.good_division.gName }/${order.good.img}"/></td>
		<td>${order.qty}</td>
		<td>${order.good.option}</td>
		<td>${order.qty*order.good.goodPrice}</td>
	</tr>
	</c:forEach>
</table>
<h3 align="center">주문자정보</h3>
<table style="border: 2px solid #ddd;" align="center">
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">이름</td>
		<td><input type="text" size=25 name="name1" value="${MEMBER.name}"/></td>
	</tr>
	<tr style="border: 2px solid #ddd;">
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">주소</td>
		<td><input type="text" size=11 name="zipcode1" value="${MEMBER.zipcode}"/>( - 생략 )<br/>
		<input type="text" size=50 name="address1" value="${MEMBER.address}"/> 기본주소 <br/>
		<input type="text" size=50 name="strAddress1" value="${MEMBER.strAddress}"/> 나머지주소 </td>
	</tr>
	<tr>
		<td align="center">유선전화</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
		<input type="text" size=15 name="telNumber1" value="${MEMBER.telNumber}"/>( - 생략 )
		</td>
	</tr>
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">휴대전화</td>
		<td>
			<input type="text" size=15 name="phoneNumber1" value="${MEMBER.phoneNumber}"/>( - 생략 )
		</td>
	</tr>
	<tr>
		<td align="center">이메일</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
		<input type="text" size=25 name="email1" value="${MEMBER.email}"/>
		</td>
	</tr>
</table>
<h3 align="center">배송지정보</h3>
<p align="right">배송지 정보가 주문지 정보와 동일합니까?
<input type=radio name=sl value="0"  onclick="yes()"/>예
<input type=radio name=sl value="1"  onclick="no()"/>아니오</p>

<table style="border: 2px solid #ddd;" align="center">
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">이름</td>
		<td><input type="text" size=25 name="name"/></td>
	</tr>
	<tr style="border: 2px solid #ddd;">
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">주소</td>
		<td><input type="text" size=11 name="zipcode"/>( - 생략 )<br/>
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
<center>
<form action="/baking/OrderService" method="post">
	<input type="hidden" name="method" value="addOrder"/>
	<input type="submit" value="구매하기"/>
</form>
</center>

</ul>
</section>	
</body>
</html>