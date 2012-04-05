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
<ul>	
	<div ALIGN="right">
		<a href="">로그인</a>|
		<a href="">ID/PW 찾기</a>|
		<a href="">회원가입</a>
	</div>
<body>		
<header>
	<P><font size=4>title</font></p>
	<div style="margin-left: 500px; ">
		ID:<input type="text" id=""/>
		PW:<input type="password" id=""/>
	</div>		
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
		<th>구매번호</th>
		<th>아이디</th>
		<th>물품번호</th>
		<th>수량</th>
		<th>가격</th>
		<th>구매날짜</th>
	</tr>
	<c:forEach var="order" items="${ORDER_LIST}">
	<tr>
		<td>
		<a href="/baking/OrderService?method=viewOrder&orderNum=${order.orderNum}">
		${order.orderNum}</a>
		</td>
		<td>${order.memberid}</td>
		<td>${order.good.goodNum}</td>
		<td>${order.qty}</td>
		<td>${order.price}</td>
		<td>
		<fmt:formatDate value="${order.buyDate}" pattern="yyyy년 MM월dd일 hh:mm:ss"/>
		</td>
	</tr>
	</c:forEach>
</table>


</ul>
</section>	
</body>
</html>