<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script>
	$(document).ready(function(){
		$("#add_qa").validate({
			rules:{
				qaContent:{
					required:true
				}
			},
			messages:{
				qaContent:{
					required:"내용을 입력해주세요."
				}
			}			
		});
	});
</script>
</head>
<body> 
 <form id="add_qa" action="/bookchange/addQa.action" method="post" target="main">
 <input type="hidden" name="email" value="${sessionScope.LOGIN_EMAIL.email}"/>
 <input type="hidden" name="boardNo" value="${BOARD.boardNo}"/>
  <p align="center">
  <textarea name="qaContent" cols="60" rows="3"></textarea>
  <input type="submit" value="댓글등록">
  </p> 
 </form> 
</body>
</html>