<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>상품목록</title>
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
		<a href="/baking/member/loginForm.jsp">로그인</a>/
		<a href="">회원가입</a>
	</div>
<body>
<header>
<marquee width=200 scrollamount=70>★</marquee><marquee width=150 scrollamount=47><font color=hotpink>★</font></marquee><marquee width=200 scrollamount=48><font color=green>☆</font></marquee><br> <marquee width=100 scrollamount=45><font color=blue>☆</font></marquee><marquee width=130 scrollamount=57><font color=hotblue>☆</font></marquee><marquee width=180 scrollamount=60><font color=red>★</font>
</marquee><marquee width=200 scrollamount=68><font color=purple>☆</font></marquee><br><h1>HOME BAKING MALL</h1> <marquee width=143 scrollamount=47><font color=pink>☆</font></marquee><marquee width=150 scrollamount=52><font color=violet>☆</font></marquee><marquee width=170 scrollamount=58><font color=orange>★</font></marquee><br> <br>			
<!-- <P><font size=4>HOME BAKING</font></p>	 -->		
</header>
<nav>
<!-- top nav -->	
<div class="menu">			
<ul>			
	<li><a href="">홈</a></li>			
	<li><a href="/baking/GoodService?method=viewGoodList">상품</a></li>				
	<li><a href="/baking/RecipeService?method=viewRecipeList">레시피</a></li>			
	<li><a href="">장바구니</a></li>			
	<li><a href="">주문조회</a></li>				
	<li><a href="">마이레시피</a></li>		
</ul>	
</div>
</nav>
<!-- end of top nav -->

<!-- content -->
<section id="content">	
	<a href="/baking/GoodService?method=viewDivisionGoodList&division=1">쿠키</a>
	<a href="/baking/GoodService?method=viewDivisionGoodList&division=2">케이크</a>  
	<a href="/baking/GoodService?method=viewDivisionGoodList&division=3">초콜릿</a>				
<ul class="column">			        
	<c:forEach var="good" items="${viewGoodList}">        
	<li>        
	<section class="block">							
	<a href="/baking/GoodService?method=viewGood&goodNum=${good.goodNum}" ><img src="/baking/img/${good.good_division.gName }/${good.img}"/></a>
	<center><h5>${good.name }</h5>	</center>														
	<center><p>${good.goodPrice }</p></center>			        
	</section>			    
	</li>
</c:forEach>
</ul>
</section>	
</body>
</html>