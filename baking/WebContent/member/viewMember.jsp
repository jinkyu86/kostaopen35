<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>	
<link rel="stylesheet" href="/baking/styles.css" type="text/css" media="screen" />	
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script  src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script src="/baking/uploadify/jquery.uploadify.v2.1.4.js"></script>
<script src="/baking/uploadify/swfobject.js"></script>
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
<h1>HOME BAKING MALL</h1><br><br>
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
<ul class="column">

<form action="/baking/editMemberForm.action" method="post" id="signup" >

<table style="border: 2px solid #ddd;"  width="700px" >
	
	<tr>
		<td align="center"  style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">아이디</td>
		<td>
		${sessionScope.member.memberid}
		</td>
	</tr>
	
	<tr>
		<td align="center" >이름</td>
		<td  style="border: 2px solid #ddd;" width="150px"  height="37px">
		${sessionScope.member.name}
		</td>
	</tr>
							   
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px" rowspan="3">주소</td>
			<td>${sessionScope.member.zipcode}</td></tr>
			<tr><td>${sessionScope.member.address}</td></tr>
			<tr><td>${sessionScope.member.strAddress}
		</td>
	</tr>
	
	<tr>
		<td align="center">이메일</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
		${sessionScope.member.email}
		</td>
	</tr>
	
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">휴대전화</td>
		<td>
		${sessionScope.member.phoneNumber}
		</td>
	</tr>
	
	<tr>							   
		<td align="center">유선전화</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
		${sessionScope.member.telNumber}
		</td>
	</tr>				   		
</table>

<center>
	<input type="submit" value='정보수정'/>
</center>
</form>

</ul>
</section>	
</body>
</html>