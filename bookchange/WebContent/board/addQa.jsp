<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body> 
 <form action="/bookchange/QaService" method="post">
 <input type="hidden" name="method" value="addQa"/>
 <input type="hidden" name="email" value="${sessionScope.LOGIN_EMAIL.email}"/>
 <input type="hidden" name="boardNo" value="${BOARD.boardNo}"/>
  <p align="center">
  댓글 등록:
  <textarea name="qaContent"></textarea>
  <input type="submit" value="상품문의등록">
  </p> 
 </form> 
</body>
</html>