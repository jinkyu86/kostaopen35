<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HOME BAKING</title>	
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
		<a href="">로그인</a>
		<a href="">회원가입</a>
	</div>
<body>		
<header>
	<P><font size=4>title</font></p>		
	<a href="index.jsp"><img src="" alt="logo" id="logo" />
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
<table border="1" align="center">
	<tr>
		<td colspan="2" align="center">${ORDER.good.name}</td>
	</tr>
	<tr rowspan="3">
		<td>
			<img src="/baking/img/cookie/${ORDER.good.img}"/>
		</td>
		<td>수량:${ORDER.qty}
		<br/><br/>
		가격:${ORDER.price}</td>
	<tr>
		<td>구매자</td>
		<td>${ORDER.member.name}</td>
	</tr>
	<tr>
		<td>우편번호</td>
		<td>${ORDER.member.zipcode}</td>
	</tr>
	<tr>
		<td rowspan="2">주소</td>
		<td>${ORDER.member.address}</td>
	</tr>
	<tr>
		<td>${ORDER.member.strAddress}</td>
	</tr>
	<tr>
		<td>휴대번호</td>
		<td>${ORDER.member.phoneNumber}</td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td>${ORDER.member.telNumber}</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td>${ORDER.memberid}</td>
	</tr>
</table>
	<p align="center">
		<a href="/baking/GoodService?method=viewGoodList">
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