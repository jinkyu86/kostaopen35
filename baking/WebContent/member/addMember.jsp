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
<script>
	$(document).ready(function(){
		$('#signup').validate({
			rules: {
				memberid: {
					required: true,
					minlength: 4,
					maxlength: 16
				},
				password: {
					required: true,
					minlength: 4,
					maxlength: 16
				},
				passwordCheck: {
					required: true,
					equalTo: "#password"
				},
				reginum: {
					required: true,
					digits: true
				},
				pwanswer: {
					required: true
				},
				zipcode: {
					required: true
				},
				address: {
					required: true
				},
				straddress: {
					required: true
				},
				email: {
					email: 'required email'
				},
				phonenum: {
					required: true,
					digits: true
				},
				telnum: {
					digits: true
				}
			},
			messages: {
				memberid: {
					required: '아이디를 입력하세요',
					minlength: '{0}글자 이상 입력하세요',
					maxlength: '{0}글자 이하로 입력해주세요'
				},
				password: {
					required: '비밀번호를 입력하세요',
					minlength: '{0}자 이상 입력해주세요',
					maxlength: '{0}자 이하로 입력해주세요'
				},
				passwordCheck: {
					equalTo: '비밀번호가 다릅니다'
				},
				reginum:{
					required: '주민등록번호를 입력해주세요',
					digits: '정수만 입력해주세요'
				},
				pwanswer: {
					required: '힌트의 정답을 입력해주세요'
				},
				zipcode: {
					required: '우편번호를 입력해주세요'
				},
				address: {
					required: '주소를 입력해주세요'
				},
				straddress: {
					required: '상세주소를 입력해주세요'
				},
				email: {
					email: '형식에 맞게 입력해주세요'
				},
				phonenum: {
					required: '휴대번호를 입력해주세요',
					digits: '정수만 입력해주세요'
				},
				telnum: {
					digits: '정수만 입력해주세요'
				}
			},
			submitHandler: function(frm){
				frm.submit()//통과시 전송
			},
			success: function(e){
			}
		});
	});
</script>
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
<h1>HOME BAKING MALL</h1><br><br>
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
<ul class="column">

<form action="/baking/MemberService" method="post" id="signup" >
<table style="border: 2px solid #ddd;"  width="700px" >
	
	<tr>
		<td align="center">아이디</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
			<input type="text" size=11 name="memberid"/>(영문소문자/숫자, 4~16자)
		</td>
	</tr>
	
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">비밀번호</td>
		<td>
			<input type=password size=14 name="password" id="password"/> (영문소문자/숫자, 4~16자)
		</td>
	</tr>
	
	<tr>
		<td align="center">비밀번호 확인</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
			<input type=password size=14 name="passwordCheck" />
		</td>
	</tr>
	
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">이름</td>
		<td>
			<input type="text" size=25 name="name"/>
		</td>
	</tr>
	
	<tr>
		<td align="center">주민등록번호</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
			<input type="text" size=15 name="reginum"/>( - 생략 )
		</td>
	</tr>
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">비밀번호 힌트</td>
		<td>
		<select name="pwhint">
		<option selected>어머니 성함은?</option>
		<option>아버지 성함은?</option>
		<option>초등학교 이름은?</option>
		<option>중학교 이름은?</option>
		<option>고등학교 이름은?</option>
		</select>
		</td>
	</tr>
	<tr>
		<td align="center">비밀번호 정답</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
			<input type="text" size=25 name="pwanswer"/>
		</td>
	</tr>
							   
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">주소</td>
		<td>
			<input type="text" size=11 name="zipcode"/> ( - 생략 )<br></br>
			<input type="text" size=50 name="address"/> 기본주소 <br></br>
			<input type="text" size=50 name="straddress"/> 나머지주소 
		</td>
	</tr>
	
	<tr>
		<td align="center">이메일</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
			<input type="text" size=25 name="email"/>
		</td>
	</tr>
	
	<tr>
		<td style="border: 2px solid #ddd;" width="150px"  align="center" height="37px">휴대전화</td>
		<td>
			<input type="text" size=15 name="phonenum"/>( - 생략 )
		</td>
	</tr>
	
	<tr>							   
		<td align="center">유선전화</td>
		<td style="border: 2px solid #ddd;" width="550px" height="37px" >
			<input type="text" size=15 name="telnum"/>( - 생략 )
		</td>
	</tr>				   		
</table>

<center>
	<input type="submit" value='확인'/>
	<input type="reset" value='취소'/>
</center>
</form>

</ul>
</section>	
</body>
</html>