<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
<a href="/baking/GoodService?method=viewIndex"><h1>HOME BAKING MALL</h1></a><br><br>
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
	<a href="/baking/GoodService?method=viewDivisionGoodList&division=1">- 쿠키</a>
	<a href="/baking/GoodService?method=viewDivisionGoodList&division=2">- 케이크</a>  
	<a href="/baking/GoodService?method=viewDivisionGoodList&division=3">- 초콜릿</a>
<ul class="column">			        
	<form name="addMyrecipeForm" method="post" action="/baking/MyrecipeService">
		<table border="1" align="center">
			<tr>
				<td>제목명</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberid" readonly="readonly" value="${sessionScope.member.memberid}">
				</td>
			</tr>
			<tr>	
				<td>내용</td>
				<td><textarea name="content" rows="10" cols="30" ></textarea>
				</td>
			</tr>
			<tr>
				<tr>
				<td>이미지</td>
				<td><input type="text" name="img">
				</tr>
				<tr>
	  			<td colspan="2">
	  				<center>
	  				<input type="submit" value="게시물등록"/>
	  				</center>
	  			</td>
			</tr>
		</table>
	</form>
</ul>
</section>	
</body>
</html>