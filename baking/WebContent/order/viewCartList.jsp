<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>	
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
			        
<table border="1" align="center">
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>이미지</th>
			<th>수량</th>
			<th>옵션</th>
			<th>가격</th>
			<th>비고</th>
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
				<input type="submit" value="장바구니삭제"/>
				</form>
			</td>
		</tr>
		</c:forEach>
	</table>
	<center>
		<form action="/baking/OrderService" method="post">
			<input type="hidden" name="method" value="addOrderForm"/>
			  <input type="submit" value="구매하러가기"/> 
		</form>
	</center>


</ul>
</section>	
</body>
</html>