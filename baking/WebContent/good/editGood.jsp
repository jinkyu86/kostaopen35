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
		${sessionScope.member.memberid}님 어서오세요! &nbsp
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
	<li><a href="/baking/RecipeService?method=">장바구니</a></li>			
	<li><a href="/baking/RecipeService?method=">주문조회</a></li>				
	<li><a href="/baking/RecipeService?method=viewOrderList">마이레시피</a></li>
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
	<form action="/baking/GoodService" method="post">
	<input type="hidden" name="method" value="addGood">
		<table border="1" align="center">
			<tr>
				<td>상품명</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>	
				<td>상품설명</td>
				<td><textarea name="explantion" rows="10" cols="30" ></textarea>
				</td>
			</tr>
			<tr>
				<td>옵션</td>
				<td><textarea name="option" rows="10" cols="30" ></textarea>
				</td>
			</tr>
			<tr>
				<td>단가</td>
				<td><input type="text" name="goodPrice">
				</td>
			</tr>
			<tr>
				<td>상품구분</td>
				<td><select name="division">
						<c:forEach var="good_division" items="${DIVISION_LIST}">
					<option value="${good_division.division}">
							${good_division.gName}
					</option>
						</c:forEach>
				</select>
				</td>
				</tr>
				<tr>
				<td>이미지</td>
				<td><input type="text" name="img"></td>
			</tr>
			<tr>
				<td colspan="2"><center><input type="submit" value="저장"/><input type="reset" value="취소"/></center></td>
			</tr>
		</table>
	</form> 
	</ul>	
</section>
</ul>
</section>		
</body>
</html>