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
		<a href="/baking/MemberService?method=logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
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
	<form action="/baking/OrderService" method="get">
		<input type="hidden" name="method" value="addCartForm">
		<input type="hidden" name="goodNum" value="${GOOD.goodNum}">
		<input type="hidden" name="option" value="${GOOD.option}">
		<input type="hidden" name="goodPrice" value="${GOOD.goodPrice}">
		<table border="1" width="300px" height="200px" align="center">
			<tr>
				<td colspan="2" height="50px" align="center" ><h3>${GOOD.name}</h3></td>
			</tr>
			<tr>
				 <td colspan="2" align="center">
					<c:forEach var="photoList" items="${PHOTO_LIST}" begin="0" end="0">
					<img src="/baking/img/${GOOD.good_division.gName }/${photoList.image}"/>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2"><textarea cols="75" rows="10" disabled="disabled" style="overflow:hidden;">상품설명 : ${GOOD.explantion}</textarea></td>
			</tr>
			<tr>	
				<td colspan="2"><textarea cols="75" rows="4" disabled="disabled" style="overflow:hidden;">옵션 : ${RECIPE.option }</textarea></td>
			</tr>
			<tr>
				<td><center>가격 : ${GOOD.goodPrice}원</center></td>
				<td><center>수량 선택 : <select name="qty">
					<%for(int i=1;i<100;i++) {%>					
					<option value="<%=i%>"><%=i%>
					</option>
					<%} %>
					</select>
					</center>
					</td>
			</tr>
			<tr>
			<td colspan="2"><input type="submit" value="장바구니"></td>
			<tr>
		</table>
		</form>
		
		<center>
		<br/><br/>

		<c:forEach var="photoList" items="${PHOTO_LIST}" begin="1" >
				<img src="/baking/img/${GOOD.good_division.gName }/${photoList.image}"/>
		<br/><br/>		
		</c:forEach>
		
		<br/><br/>
		
		<c:if test="${GOOD_RECIPELIST!=null}">
		<center><h3>상품관련 레시피</h3></center>
		<br/>
		<table border="1">
			<tr>
				<th>레시피 번호</th>
				<th>상품구분</th>
				<th>레시피 사진</th>
			</tr>
			<c:forEach var="recipe" items="${GOOD_RECIPELIST}" >
			<tr>
				<td>${recipe.recipeNum}</td>
				<td>${recipe.good_division.gName}</td>
				<td><img src="/baking/img/recipe_${recipe.good_division.gName}/${recipe.img}"></td>
			</tr>
			</c:forEach>
		</table>
		</c:if>
		</center>
	</ul>	
</section>
</ul>
</section>		
</body>
</html>