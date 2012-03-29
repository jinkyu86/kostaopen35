<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물등록</title>
<link rel="Stylesheet" href="/jquery20120321/uploadify/uploadify.css"/>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script src="/jquery20120321/uploadify/jquery.uploadify.v2.1.4.js"></script>
<script src="/jquery20120321/uploadify/swfobject.js"></script>
</head>
<body>
	<form action="/bookchange/BoardService" method="post">
		<input type="hidden" name="method" value="addBoard"/>
		<input type="hidden" name="photo" value=""/>
		<label>작성자</label>${MEMBER.email}
		<label>제목</label><input type="text" name="name"/><br/>
		<label>내용</label><textarea name="content"></textarea><br/>
	</form>
	<input type="file" name="file" id="uploadify"/>
	<input type="button" id="addBoard" value="물건등록"/>
</body>
</html>