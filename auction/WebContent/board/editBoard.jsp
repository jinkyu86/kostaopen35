<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.or.kosta.auction.board.Board"%>
<%@ taglib  prefix="c" 
             uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물 수정</title>
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
<body background="/auction/gphoto/s20.jpg">s
<body>
<h1 align="center">게시물 수정</h1>
	<form  action="/auction/BoardService" method="post" id="my_form">
	  <input  type="hidden" name="method" value="editBoard"/>
	   <table  align="center"  border="1" bgcolor="pink">
	   		<tr>
	   			<td>게시물 번호</td>
	   			<td><input type="text" name="bNum" value="${BOARD.bNum }" readOnly="readOnly"/></td>
	   		</tr>
	   		<tr>
	   			<td>작성자 ID</td>
	   			<td><input type="text" name="userid" value="${BOARD.member.userid }" readOnly="readOnly"/></td>
	   		</tr>
	   		<tr>
	   			<td>게시물 제목</td>
	   			<td><input type="text" name="title" value="${BOARD.title }"/></td>
	   		</tr>
	   		<tr>
	   			<td>게시물 내용</td>
	   			<td><textarea name="content">${BOARD.content }</textarea></td>
	        </tr>
	        </table>
	    <center>
			<input type="submit" value="게시물수정">
			<input type="reset" value="취소">
		</center>
	   </form>
<p align="center">
	<a href="/auction/BoardService?method=viewBoard&bNum=${BOARD.bNum }">
	<img src="/auction/menu/viewBoard.jpg"/>
	</a>
</p>
</body>
</html>