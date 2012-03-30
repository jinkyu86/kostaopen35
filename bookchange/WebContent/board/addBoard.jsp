<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물등록</title>
<link rel="Stylesheet" href="/bookchange/uploadify/uploadify.css"/>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script src="/bookchange/uploadify/jquery.uploadify.v2.1.4.js"></script>
<script src="/bookchange/uploadify/swfobject.js"></script>
</head>
<body>
	<form action="/bookchange/BoardService" method="post">
		<input type="hidden" name="method" value="addBoard"/>
		<!-- <input type="hidden" name="photo" value=""/> -->
		<label>작성자</label> ${MEMBER.email}<br/>
		<select name="categoryNo">
		 <c:forEach var="category" items="${CATEGORY_LIST}">
		     <option value="${category.categoryNo}">${category.categoryName}</option>
		 </c:forEach>
		</select>
		<select name="dealNo">
		 <c:forEach var="deal" items="${DEAL_LIST}">
		     <option value="${deal.dealNo}">${deal.dealWay}</option>
		 </c:forEach>
		</select><br/>
		<label>원하는 물건</label><input type="text" name="boardWant"/><br/>
		<label>제목</label><input type="text" name="boardTitle"/><br/>
		<label>내용</label><textarea name="boardContent"></textarea><br/>
		<input type="file" name="boardPhoto" id="uploadify"/>
		<input type="submit" id="addBoard" value="물건등록"/>
	</form>	
</body>
</html>