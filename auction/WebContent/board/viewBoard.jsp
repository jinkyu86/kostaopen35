<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%--@ page import="kr.or.kosta.student.Student" --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 조회</h1>
	<table border="1" align="center">
	  <tr><td>번호</td><td>${BOARD.bNum}</td>
	  </tr>
	  <tr><td>아이디</td><td>${BOARD.member.userid}</td>
	  </tr>
	  <tr><td>제목</td><td>${BOARD.title}</td>
	  </tr>
	  <tr><td>내용</td><td>${BOARD.content}</td>
	  </tr>
	  </table>
	  <p align="center">
	    <a href="/auction/BoardService?method=editBoardForm&bNum=${BOARD.bNum }">
	    게시물 수정
	    </a>
	  </p>
	  <p align="center">
	    <a href="/auction/BoardService?method=remove&bNum=${BOARD/bNum }">
	    게시물 삭제
	    </a>
	  </p>
</body>
</html>