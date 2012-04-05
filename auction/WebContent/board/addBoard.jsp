<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물 작성</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script>
$(document).ready(function(){
	$('#my_form').validate({
		rules:{
			title:{
				required:true,
				minlength:1
			},
			content:{
				required:true,
				minlength:1
			}
		},
		messages:{
			title:{
				required:"제목을 입력하세요."
			},//end title
			content:{
				required:"내용을 입력하세요.",
			}//end content
		}
	});
});
</script>
</head>
<body background="/auction/gphoto/s20.jpg">
<body>
<hr noshade>
<h1 align="center">게시물 작성</h1>
<form name="login_form" action="/auction/BoardService" method="post" id="my_form">
<table  align="center"  border="1" bgcolor="pink">
<input type="hidden" name="method" value="addBoard" />
	<tr>
		<td>작성자 ID: </td>
		<td><input type="text" size=30 name="userid" value="${sessionScope.MEMBER.userid }" readOnly="readonly"></td>
	</tr>
	<tr>
		<td>제목:</td>
		<td><input type="text" size=50 name="title"></td>
	</tr>
	<tr>
		<td>내용:</td>
		<td><textarea name="content" cols=50 rows=10 wrap="hard"></textarea></td>
	</tr>
<hr noshade>
</table>
<center>
	<input type="submit" value="게시물추가">
	<input type="reset" value="취소">
</center>
</form>
<p align="center">
	<a href="/auction/BoardService?method=viewBoardList">
	<img src="/auction/menu/viewBoardList.jpg"/>
	</a>
</p>
</body>
</html>