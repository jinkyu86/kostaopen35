<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물 조회</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script>
	$(document).ready(function(){
		
		$("#deleteboard").click(function (event){
			var result=confirm("정말 삭제하시겠습니까?");
		
			if(result==false){
				event.preventDefault();
			}
		});
	});
</script>
</head>
<body background="/auction/gphoto/s20.jpg">
<body>
	<h1 align="center">게시물 조회</h1>
	<table  align="center"  border="1" bgcolor="pink">
	  <tr>
	  <td>번호</td><td>${BOARD.bNum}</td>
	  </tr>
	  <tr>
	  <td>아이디</td><td>${BOARD.member.userid}</td>
	  </tr>
	  <tr>
	  <td>제목</td><td>${BOARD.title}</td>
	  </tr>
	  <tr>
	  <td>내용</td><td>${BOARD.content}</td>
	  </tr>
	  </table>
<c:if test="${sessionScope.MEMBER.userid==BOARD.member.userid||sessionScope.MEMBER.userid=='admin'}">
	  <p align="center">
	    <a href="/auction/BoardService?method=editBoardForm&bNum=${BOARD.bNum }">
		<img src="/auction/menu/editBoard.jpg"/>
	    </a>
	  </p>
	  <p align="center">
	    <a href="/auction/BoardService?method=removeBoard&bNum=${BOARD.bNum }" id="deleteboard">
		<img src="/auction/menu/deleteBoard.jpg"/>
	    </a>
	  </p>
</c:if>
<p align="center">
	<a href="/auction/BoardService?method=viewBoardList">
	<img src="/auction/menu/viewBoardList.jpg"/>
	</a>
</p>
</body>
</html>