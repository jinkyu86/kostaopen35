<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<script type="text/javascript">
function deleteGood(){
	var flag=confirm("이 상품을 삭제하시겠습니까?");
	if(flag){
		location.href="/baking/GoodService?method=removeGood&goodNum="+${GOOD.goodNum};
	}
	alert("상품이 삭제되었습니다");
}
</script>
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
	<c:if test="${sessionScope.member.memberid=='ADMIN'}">
		<center>
		<a href="/baking/GoodService?method=editGoodForm"><input type="button" value="상품수정"></a>
		&nbsp&nbsp<input type="button" onclick="deleteGood()" value="상품삭제">				
		</center>
	</c:if>
	<ul class="column">
	<form action="/baking/OrderService" method="post">
		<input type="hidden" name="method" value="viewCartList">
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
						<c:forEach var="i" begin="1" end="5">
						<option value="${i}">
							${i}
						</option>
					</c:forEach>
					</select>
					</center>
					</td>
			</tr>
			<tr>
			<td colspan="2"><center><input type="submit" value="장바구니"></center></td>
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
		
		<c:choose>
			<c:when test="${not empty requestScope.GOOD_RECIPELIST }"> <%--배열은 null이 아니고 안의 자료가 없는것일 뿐이기때문에 not empty(비어있지 않을때) 라는것을 써준다 --%>
				<center><h3>상품관련 레시피</h3></center><br/>
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
							<td><a href="/baking/RecipeService?method=viewRecipe&recipenum=${recipe.recipeNum}"><img src="/baking/img/recipe_${recipe.good_division.gName}/${recipe.img}"></a></td>
						</tr>
						</c:forEach>
					</table>
		</c:when>
		<c:otherwise>
			<center><h3>상품관련 레시피가 없습니다</h3></center>
		</c:otherwise>	
		</c:choose>
		</center>
	</ul>	
</section>
</ul>
</section>
</body>
</html>