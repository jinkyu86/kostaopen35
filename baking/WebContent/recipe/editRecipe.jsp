<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HOME BAKING</title>	
<link rel="stylesheet" href="/baking/styles.css" type="text/css" media="screen" />	
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<style type="text/css">
	a:link {text-decoration:none}
	a:visited {text-decoration:none}
	a:hover {text-decoration:none}
	a {color:#000000; text-decoration:none; }
</style>
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->	
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

</body>
</html>