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
		<a href="/baking/member/addMemberForm.action">회원가입</a>
		</c:when>
		<c:otherwise>
		${sessionScope.member.memberid}님 어서오세요! &nbsp&nbsp
		<a href="/baking/logout.action">로그아웃</a>
		<a href="/baking/viewMember.action">회원정보</a>
		</c:otherwise>
	</c:choose>
	</div>
<body>
<header>
<a href="/baking/viewIndex.action"><h1>HOME BAKING MALL</h1></a><br><br>
</header>
<nav>
<!-- top nav -->	
<div class="menu">			
<ul>			
	<li><a href="/baking/viewIndex.action">홈</a></li>			
	<li><a href="/baking/viewGoodList.action">상품</a></li>		
	<li><a href="/baking/viewRecipeList.action">레시피</a></li>			
	<li><a href="/baking/CartList.action">장바구니</a></li>			
	<li><a href="/baking/viewOrderList.action">주문조회</a></li>				
	<li><a href="/baking/viewIndex.action">마이레시피</a></li>		
</ul>	
</div>
</nav>
<!-- end of top nav -->

<!-- content -->
<section id="content">	
		        
	<form action="/baking/login.action" method="post">
	<center>
	아이디<input type="text" name="memberid"><br></br>
	패스워드<input type="password" name="password"><br></br>
	<input type="submit" value="확인"><br></br>
	</center>
</form>

</section>	
</body>
</html>