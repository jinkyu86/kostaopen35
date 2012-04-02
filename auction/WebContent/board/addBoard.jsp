<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물 작성</title>
</head>
<body>
<hr noshade>
<form name="login_form" action="/auction/BoardService" method="post">
작성자 ID: 
<c:if test="${sessionScope.LOGIN_MEMBER.userid=='admin'}">
</c:if>
<input type="text" size=10 name="userid">
<br>
제목:<input type="text" size=20 name="title">
<br>
<textarea name="content" cols=30 rows=3 wrap="hard">
게시물내용
</textarea>
<hr noshade>
<!--화면에 출력되지 않고 서버로 전송만 되는 객체-->
<input type="hidden" name="method" 
   value="addBoard" />
   <input type="submit" name="c" value="게시물추가">
</form>

</body>
</html>