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

<form action="/baking/editMember.action" method="post">
<table style="border: 2px solid #ddd;"  width="700px" >
	<input type="hidden" name="memberid" value="${sessionScope.member.memberid}" >
	<tr>
		<td align="center">아이디</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
			${sessionScope.member.memberid}
		</td>
	</tr>
	
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">비밀번호</td>
		<td>
			<input type=password size=14 name="password" id="password" value="${sessionScope.member.password}"/>
		</td>
	</tr>
	
	<tr>
		<td align="center">비밀번호 확인</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
			<input type=password size=14 name="passwordCheck"/>
		</td>
	</tr>
	
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">이름</td>
		<td>
			${sessionScope.member.name}
		</td>
	</tr>
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">비밀번호 힌트</td>
		<td>
			${sessionScope.member.pwHint}
		</td>
	</tr>
	<tr>
		<td align="center">비밀번호 정답</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
			${sessionScope.member.pwAnswer}
		</td>
	</tr>
							   
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">주소</td>
		<td>
			<input type="text" size=11 name="zipcode" value="${sessionScope.member.zipcode}"/><br></br>
			<input type="text" size=50 name="address" value="${sessionScope.member.address}"/> 기본주소 <br></br>
			<input type="text" size=50 name="straddress" value="${sessionScope.member.strAddress}"/> 나머지주소 
		</td>
	</tr>
	
	<tr>
		<td align="center">이메일</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
			<input type="text" size=25 name="email" value="${sessionScope.member.email}"/>
		</td>
	</tr>
	
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">휴대전화</td>
		<td>
			<input type="text" size=15 name="phonenum" value="${sessionScope.member.phoneNumber}"/>
		</td>
	</tr>
	
	<tr>							   
		<td align="center">유선전화</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
			<input type="text" size=15 name="telnum" value="${sessionScope.member.telNumber}"/>
		</td>
	</tr>				   		
</table>

<center>
	<input type="submit" value='수정'/>
	<input type="reset" value='취소'/>
</center>
</form>

<form action="/baking/removeMember.action" method="post">
	<input type="hidden" name="memberid" value="${sessionScope.member.memberid}" >
	<input type="submit" value='회원탈퇴'/>
</form>

</ul>
</section>	
</body>
</html>