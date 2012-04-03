<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>상품목록</title>
<link rel="stylesheet" href="styles.css" type="text/css" media="screen" />	
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->	
</head>
<ul>	
	<div ALIGN="right">
		<a href="">로그인</a>/
		<a href="">회원가입</a>
	</div>
<body>
<header>
	<P><font size=4>title</font></p>		
</header>
<nav>
<!-- top nav -->	
<div class="menu">			
<ul>			
	<li><a href="">홈</a></li>			
	<li><a href="">상품</a></li>				
	<li><a href="">레시피</a></li>			
	<li><a href="">장바구니</a></li>			
	<li><a href="">주문조회</a></li>				
	<li><a href="">마이레시피</a></li>		
</ul>	
</div>
</nav>
<!-- end of top nav -->

<!-- content -->
<section id="content">		
<ul class="column">			        
	<c:forEach var="good" items="${GOOD_LIST}">        
	<li>        
	<section class="block">							
	<img src="/baking/img/${good.good_division.gName }/${good.img}"/>							
	<center><h5>${good.name }</h5>	</center>														
	<center><p>${good.goodPrice }</p></center>			        
	</section>			    
	</li>
</c:forEach>
</ul>
</section>	
</body>
</html>