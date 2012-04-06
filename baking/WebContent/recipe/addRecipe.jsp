<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HOME BAKING</title>	
<link rel="stylesheet" href="/baking/styles.css" type="text/css" media="screen" />	
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<style type="text/css">
	a:link {text-decoration:none}
	a:visited {text-decoration:none}
	a:hover {text-decoration:none}
	a {color:#000000; text-decoration:none; }
</style>
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->	
	<link rel="Stylesheet" href="/baking/uploadify/uploadify.css" />
    <script  src="http://code.jquery.com/jquery-1.7.js"></script>
    <script  src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
	<script  src="/baking/uploadify/jquery.uploadify.v2.1.4.js"></script>
    <script  src="/baking/uploadify/swfobject.js"></script>
    
    <script>
		$(document).ready(function(){
			$('#insert_form').validate({
				rules:{
					title: {
                        required: true,
						minlength:1
                    },
                    material: {
                        required: true,
						minlength:1
                    },
					content: {
						required: true,
						minlength:1
                    }
			},
			messages:{
				   title: {
                        required: '레시피명을 입력해주세요.',
						minlength:'레시피명을 입력해주세요'
                    },
                    material: {
                        required: '레시피재료를 입력해주세요.',
						minlength:'레시피재료를 입력해주세요'
                    },
                    content: {
                    	required: '레시피설명을 입력해주세요.',
						minlength:'레시피설명을 입력해주세요'
                    }
			}
				
			});
		});
		
		$(document).ready(function () {
			 $('#uplodify').uploadify({
			 	cancelImg: '/baking/uploadify/cancel.png',
        		uploader: '/baking/uploadify/uploadify.swf',
        		script: '/baking/UploadServlet',
        		multi: true,
        		auto: false,
			  fileExt     : '*.jpg;*.jpeg;*.gif;*.png',
 			  fileDesc    : 'Web Image Files (.jpg, .gif, .png)',
			  buttonText:'SELECT PHOTO',
			  onComplete: function(event, queueID, fileObj,
			             response, data){
			  	alert(response+"를 서버에 저장 했습니다.");
				//id가 photo인 객체선택 $('photo')
				//value속성 수정  val(수정하고싶은값)
				$('#photo').val(response);
				//my_form의 action설정된 서블렛으로 입력정보
				//전송
				$('#insert_form').submit();
			   }
			   					
		});
			
			    $('#addPhoto').submit(function (event) {
			    	var selectData=$('#division').val();

			    	$('#uplodify').uploadifySettings('scriptData', { 'code1': selectData });
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
<!-- top nav -->

</nav>

<!-- end of top nav -->

<!-- content -->
	
<section id="content">

<!-- RECIPE:레시피명, 레시피재료 ,레시피설명 RECIPE_PHOTO:레시피사진 RECIPE_GOODLIST:레시피관련상품 -->

	<ul class="column">
	
		<form id="insert_form" action="" method="post">
		<input type="hidden" name="method" value="addRecipe" />
		<input type="hidden"  name="photo" id="photo" value=""/>
		
		<table border="1" align="center" width="500px"> 
			<tr>
				<td colspan="2">레시피 추가</td>
			</tr>
			<tr>
				<td>레시피명</td>
				<td><input type="text" name="title" size=60/></td>
			</tr>
			<tr>
				
				<td>레시피구분</td>
				<td>
				<select name="division" id="division">
					<c:forEach var="division" items="${DIVISION_LIST}" >
						<option value="${division.division}">
							${division.gName}
						</option>
					</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td>레시피재료</td>
				<td><textarea cols="47" rows="6" name="material"></textarea></td>
			</tr>
			<tr>
				<td>레시피준비</td>
				<td><textarea cols="47" rows="6" name="content"></textarea></td>
			</tr>
			<tr>
				<td>리스트이미지</td>
				<td><input type="file" name="file" id="uplodify" /></td>
			</tr>
			
		</table>
		<center>
		<input type="submit" value="레시피등록" id="addPhoto"/>
		<input type="reset" value="취소"/>
		</center>
		</form>
	</ul>	
</section>
	
</body>
</html>