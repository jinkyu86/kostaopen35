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

<!-- end of top nav -->

<!-- content -->
	
<section id="content">
	<a href="/baking/RecipeService?method=recipeRelativeGoodList&division=1">- 쿠키</a>&nbsp&nbsp      
	<a href="/baking/RecipeService?method=recipeRelativeGoodList&division=2">- 케이크</a>&nbsp&nbsp      
	<a href="/baking/RecipeService?method=recipeRelativeGoodList&division=3">- 초콜릿</a>
<!-- RECIPE:레시피명, 레시피재료 ,레시피설명 RECIPE_PHOTO:레시피사진 RECIPE_GOODLIST:레시피관련상품 -->

	<ul class="column">
	
		<table border="1" width="600px" height="400px" align="center">
			<tr>
				<td colspan="2" height="50px" align="center"><h3>${RECIPE.title}</h3></td>
			</tr>
			<tr>
				<td width="300px" height="28px">재료</td>
				<td rowspan="3" width="300px" align="center">
					<c:forEach var="photo" items="${RECIPE_PHOTO}" begin="0" end="0"  >
					<img src="/baking/img/recipe_${RECIPE.good_division.gName}/${photo.image}">
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td><textarea cols="36" rows="15" disabled="disabled" style="overflow:hidden;">${RECIPE.material}</textarea></td>
			</tr>
			<tr>
				<td height="28px">준비</td>
			</tr>
			<tr>
				<td colspan="2"><textarea cols="72" rows="6" disabled="disabled" style="overflow:hidden;">${RECIPE.content }</textarea></td>
			</tr>
		</table>
		
		<center>
		
		<br/><br/>
		
		<c:forEach var="photo" items="${RECIPE_PHOTO}" begin="1" >
				<img src="/baking/img/recipe_${RECIPE.good_division.gName}/${photo.image}">
		<br/><br/>		
		</c:forEach>
		
		<br/><br/>
		<center><h3>레시피관련 상품</h3></center>
		<br/><br/>
		<table border="1">
			<tr>
				<th>NO</th>
				<th>DIVISION</th>
				<th>NAME</th>
				<th>PRICE</th>
				<th>IMG</th>
			</tr>
			<c:forEach var="good" items="${RECIPE_GOODLIST}" >
			<tr>
				<td>${good.goodNum}</td>
				<td>${good.good_division.gName}</td>
				<td>${good.name}</td>
				<td>${good.goodPrice}원</td>
				<td>
				<a href="/baking/GoodService?method=viewGood&goodNum=${good.goodNum}">
				<img src="/baking/img/${good.good_division.gName}/${good.img}"></a>
				</td>
			</tr>
			</c:forEach>
		</table>
		
		</center>	
	</ul>
	<br/>
	
</section>

</body>
</html>