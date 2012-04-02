<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물수정</title>
<link rel="Stylesheet" href="/bookchange/uploadify/uploadify.css"/>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script src="/bookchange/uploadify/jquery.uploadify.v2.1.4.js"></script>
<script src="/bookchange/uploadify/swfobject.js"></script>
</head>
<body>
	<form action="/bookchange/BoardService" method="post">
		<input type="hidden" name="method" value="editBoard"/>
		<!-- <input type="hidden" name="photo" value=""/> -->
		작성자<input type="text" name="email" value="${sessionScope.LOGIN_EMAIL.email}" readonly="readonly"/><br/>
		게시물번호<input type="text" name="boardNo" value="${BOARD.boardNo}" readonly="readonly"/><br/>
		카테고리<select name="categoryNo">
		 <c:forEach var="category" items="${CATEGORY_LIST}">
		     <option value="${category.categoryNo}">${category.categoryName}</option>
		 </c:forEach>
		</select><br/>
		거래방법<select name="dealNo">
		 <c:forEach var="deal" items="${DEAL_LIST}">
		     <option value="${deal.dealNo}">${deal.dealWay}</option>
		 </c:forEach>
		</select><br/>
		원하는 물건<input type="text" name="boardWant" value="${BOARD.boardWant}"/><br/>
		제목<input type="text" name="boardTitle" value="${BOARD.boardTitle}"/><br/>
		내용<input type="text" name="boardContent" value="${BOARD.boardContent}"/><br/>
		사진<input type="text" name="boardPhoto" value="${BOARD.boardPhoto}"/><br/>
		<input type="hidden" name="conditionResult" value="${BOARD.condition.conditionResult}"/>
		<input type="submit" value="수정"/>
	</form>	
	<form action="/bookchange/BoardService" method="post">
	<input type="hidden" name="method" value="viewBoard">
	<input type="hidden" name="boardNo" value="${BOARD.boardNo}">
	<input type="submit" value="취소"/>
	</form>
</body>
</html>