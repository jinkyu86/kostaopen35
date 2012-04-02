<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body> 
	<table>
	 <tr>	 
		
		<form action="/bookchange/QaService" method="post">
		  <input type="hidden" name="method" value="editQa">
		  <input type="hidden" name="qaNo" value="${EDITQA.qaNo}">
		  <input type="hidden" name="email" value="${EDITQA.member.email}">
		  <input type="hidden" name="boardNo" value="${EDITQA.board.boardNo}">
		  <td><input type="text" name="qaContent" value="${EDITQA.qaContent}"/></td>
	      <td><input type="submit" value="수정"/></td>
	    </form>	  
		 <form action="/bookchange/BoardService" method="post">
		 <input type="hidden" name="method" value="viewBoard">
		 <input type="hidden" name="boardNo" value="${EDITQA.board.boardNo}">
		 <td><input type="submit" value="취소"/> </td>
		 </form> 	 
	 </tr>
	</table>
 
</body>
</html>