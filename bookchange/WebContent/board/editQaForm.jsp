<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script>
	$(document).ready(function(){
		$("#edit_qa").validate({
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
<table>
<tr>		
		<td><form id="edit_qa" action="/bookchange/QaService" method="post">
		  <input type="hidden" name="method" value="editQa">
		  <input type="hidden" name="qaNo" value="${EDITQA.qaNo}">
		  <input type="hidden" name="email" value="${EDITQA.member.email}">
		  <input type="hidden" name="boardNo" value="${EDITQA.board.boardNo}">
		  <textarea name="qaContent" cols="30" rows="3">${EDITQA.qaContent}</textarea></td> 
	    <td><input type="submit" value="댓글수정"/></form></td>
	    <td>
		 <form action="/bookchange/BoardService" method="post">
		 <input type="hidden" name="method" value="viewBoard">
		 <input type="hidden" name="boardNo" value="${EDITQA.board.boardNo}">
		 <input type="submit" value="취소"/>
		 </form></td>		 
</tr>
</table>		 	 	
</body>
</html>