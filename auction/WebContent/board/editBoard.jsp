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
</head>
<body>
	<form  action="/auction/BoardService"
	  method="post">
	  <input  type="hidden" name="method" 
	    value="editBoard"/>
	   <table  align="center">
	   		<tr>
	   			<td>게시물 번호</td>
	   			<td><input type="text" name="bNum" value="${BOARD.bNum }" readOnly="readOnly"/></td>
	   		</tr>
	   		<tr>
	   			<td>게시물 제목</td>
	   			<td><input type="text" name="title" value="${BOARD.title }"/></td>
	   		</tr>
	   		<tr>
	   			<td>게시물 내용</td>
	   			<td><textarea name="content">${BOARD.content }</textarea></td>
	        </tr>
	           <tr>
	           	<td> <input type="submit"  value="게시물수정"/></td>
	           	<td> <input type="reset"  value="취소"/></td>
	           	</tr>
	           	</table>
	   </form>
</body>
</html>