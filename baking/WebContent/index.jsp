<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link rel="stylesheet" href="/baking/styles.css" type="text/css" media="screen" />	
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
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
		${sessionScope.member.memberid}님 어서오세요! &nbsp&nbsp
		<a href="/baking/MemberService?method=logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
	</div>
<body>
<header>
<h1>HOME BAKING MALL</h1> <br> <br>	
</header>
<nav>
<!-- top nav -->	
<div class="menu">			
<ul>			
	<li><a href="/baking/GoodService?method=viewIndex">홈</a></li>			
	<li><a href="/baking/GoodService?method=viewGoodList">상품</a></li>				
	<li><a href="/baking/RecipeService?method=viewRecipeList">레시피</a></li>			
	<li><a href="/baking/RecipeService?method=">장바구니</a></li>			
	<li><a href="/baking/RecipeService?method=">주문조회</a></li>				
	<li><a href="/baking/RecipeService?method=viewOrderList">마이레시피</a></li>		
</ul>	
</div>
</nav>
<!-- end of top nav -->

<!-- content -->
<section id="content">	
	<c:if test="${sessionScope.member.memberid=='ADMIN'}">
		<center>
		<a href="/baking/GoodService?method=addGoodForm"><input type="button" value="상품등록"> </a>
		</center>
	</c:if>
<ul class="column">			        
	<c:forEach var="good" items="${GOOD_LIST}">        
	<li>        
	<section class="block">							
	<a href="/baking/GoodService?method=viewGood&goodNum=${good.goodNum}" ><img src="/baking/img/${good.good_division.gName }/${good.img}"/></a>				
	<center><h5>${good.name }</h5>	</center>														
	<center><p>${good.goodPrice }원</p></center>			        
	</section>			    
	</li>
</c:forEach>
</ul>
</section>	
</body>
</html>