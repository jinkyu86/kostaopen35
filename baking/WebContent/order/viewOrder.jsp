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
	<li><a href="/baking/GoodService?method=viewGoodList">상품</a></li>		
	<li><a href="/baking/RecipeService?method=viewRecipeList">레시피</a></li>			
	<li><a href="/baking/OrderService?method=CartList">장바구니</a></li>			
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
		<td colspan="2" align="center">
		${order.good.name}</td>
	</tr>
	<tr rowspan="3">
		<td>
		
			<img src="/baking/img/${order.good.good_division.gName}/${order.good.img}"/>
		
		</td>
		<td>수량:${order.qty}
		<br/>
		가격:${order.price}</td>
	<tr>
		<td>구매자</td>
		<td>${order.member.name}</td>
	</tr>
	<tr>
		<td>우편번호</td>
		<td>${order.member.zipcode}</td>
	</tr>
	<tr>
		<td rowspan="2">주소</td>
		<td>${order.member.address}</td>
	</tr>
	<tr>
		<td>${order.member.strAddress}</td>
	</tr>
	<tr>
		<td>휴대번호</td>
		<td>${order.member.phoneNumber}</td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td>${order.member.telNumber}</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td>${order.memberid}</td>
	</tr>
</table>
	<p align="center">
		<a href="/baking/viewGoodList.action">
		쇼핑하기
		</a>
	</p>
<!--  form action="/baking/OrderService" method="post">
	<input type="hidden" name="method" value="editOrderForm"/>
	<input type="hidden" name="orderNum" value="${ORDER.orderNum}"/>
	<input type="submit" value="수정하기" />
</form-->


</ul>
</section>	
</body>
</html>