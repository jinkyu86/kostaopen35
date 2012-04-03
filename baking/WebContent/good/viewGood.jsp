<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>물건조회</title>
</head>
<body>
이름 : ${GOOD.name} <br><br>
설명 : ${GOOD.explantion} <br><br>
가격 : ${GOOD.goodPrice} <br><br>
상품수량 : ${GOOD.qty } <br><br>
옵션 : ${GOOD.option } <br><br>
관련레시피 목록 : <br><br>
<c:forEach var="recipe" items="${GOOD_RECIPELIST}">
	${recipe.recipeNum }
	${recipe.title }<br>
</c:forEach>
<c:forEach var="photoList" items="${PHOTO_LIST}" >
	<img src="/baking/img/${GOOD.good_division.gName }/${photoList.image}"/><br>
</c:forEach>
<a href="/baking/GoodService?method=viewGood&goodNum=${GOOD.goodNum}"><img src="/baking/img/${GOOD.good_division.gName}/${GOOD.img}" /></a>
</body>
</html>