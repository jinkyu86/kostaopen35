<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
 <table border="1" align="center">
   <tr>
	   	<th>번호</th>
	   	<th>제목</th>
	   	<th>아이디</th>
	   	<th>등록시간</th>
	   	<th>조회수</th>
   </tr>
	<c:forEach  var="myrecipe"  items="${MYRECIPE_LIST}">
	 <tr>
	      <td>${myrecipe.boardNum}</td>
	       <td>
	       		<a href="/baking/MyrecipeService?method=viewRecipe&num=${myrecipe.boardNum}">
	       			${myrecipe.title }
	           </a>
	       </td>
	       <td>${myrecipe.member.memberid}</td>
	       <td>${myrecipe.date}</td>
	       <td>${myrecipe.count}</td>
	    </tr>
	 </c:forEach>
	 </table>
</ul>
</section>
	<p align="center">
	${PAGE_LINK_TAG}
	</p>
	<p align="center">
	<a href="/baking/MyrecipeService?method=addMyrecipeForm">게시물 작성</a>
	</p>
</body>
</html>