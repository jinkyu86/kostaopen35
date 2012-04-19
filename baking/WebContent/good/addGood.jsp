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
<link rel="Stylesheet"  href="/baking/uploadify/uploadify.css" />
    <script src="http://code.jquery.com/jquery-1.7.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
	<script src="/baking/uploadify/jquery.uploadify.v2.1.4.js"></script>
    <script src="/baking/uploadify/swfobject.js"></script>
<style type="text/css">
	a:link {text-decoration:none}
	a:visited {text-decoration:none}
	a:hover {text-decoration:none}
	a {color:#000000; text-decoration:none; }
</style>
 <script>
		$(document).ready(function(){
			$('#my_form').validate({
				rules:{
					name: {
                        required: true,
						minlength:1
                    },
                    explantion: {
                        required: true,
						minlength:1
                    },
					price: {
                        required: true,
						digits: true,
						min:0
                    }
			},
			messages:{
				name: {
                        required: '이름을 입력해주세요.',
						minlength:'이름을 입력해주세요'
                    },
                   detail: {
                        required: '설명을 입력해주세요.',
						minlength:'설명을 입력해주세요'
                    },
                    price: {
                        required: '가격을 입력해주세요',
                        digits: '정수를 입력하세요.',
						min:'0 이상의 값을 입력하세요'
                    }
			}
				
			});
		});
		
		$(document).ready(function () {
			 $('#uplodify').uploadify({
			 	cancelImg: '/baking/uploadify/cancel.png',
        		uploader: '/baking/uploadify/uploadify.swf',
        		script: '/baking/GoodUploadServlet',
        		multi: false,
        		auto: false,
			 fileExt     : '*.jpg;*.jpeg;*.gif;*.png',
 			  fileDesc    : 'Web Image Files (.jpg, .gif, .png)',
			  buttonText:'SELECT IMAGE',
			  onComplete: function(event, queueID, fileObj,
			             response, data){
			  	alert(response+"를 서버에 저장 했습니다.");
				//id가 img인 객체선택 $('img')
				//value속성 수정  val(수정하고싶은값)
				$('#img').val(response);
				//my_form의 action설정된 서블렛으로 입력정보
				//전송
				$('#my_form').submit();
			   }
		});
			
			    $('#addGood').click(function (event) {
			       $('#uplodify').uploadifyUpload();
			    	 event.preventDefault();
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
	<li><a href="/baking/viewIndex.action">홈</a></li>			
	<li><a href="/baking/viewGoodList.action">상품</a></li>		
	<li><a href="/baking/viewRecipeList.action">레시피</a></li>			
	<li><a href="/baking/OrderService?method=CartList">장바구니</a></li>			
	<li><a href="/baking/OrderService?method=viewOrderList">주문조회</a></li>				
	<li><a href="/baking/GoodService?method=viewIndex">마이레시피</a></li>			
</ul>	
</div>
</nav>
<!-- end of top nav -->

<!-- content -->
<section id="content">	
	<a href="/baking/viewDivisionGoodList.action?division=1">- 쿠키</a>
	<a href="/baking/viewDivisionGoodList.action?division=2">- 케이크</a>  
	<a href="/baking/viewDivisionGoodList.action?division=3">- 초콜릿</a>

	<ul class="column">
	<form id="my_form" action="/baking/GoodService" method="post">
	<input type="hidden" name="method" value="addGood">
	<input type="hidden"  name="img" id="img" value=""/>
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
				<td>가격</td>
				<td><input type="text" name="goodPrice">
				</td>
			</tr>
				<tr>
				<td>수량</td>
				<td><input type="text" name="qty">
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
				<td colspan="2"><center><input type="file" name="file" id="uplodify" />
	  			<input type="button"  id="addGood" value="상품등록"/></center></td>
			</tr>
		</table>
	</form> 
	</ul>	
</section>
</ul>
</section>
</body>
</html>