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
	<h1>�Խù� ��ȸ</h1>
	<table border="1" align="center">
	  <tr><td>��ȣ</td><td>${BOARD.bNum}</td>
	  </tr>
	  <tr><td>���̵�</td><td>${BOARD.member.userid}</td>
	  </tr>
	  <tr><td>����</td><td>${BOARD.title}</td>
	  </tr>
	  <tr><td>����</td><td>${BOARD.content}</td>
	  </tr>
	  </table>
	  <p align="center">
	    <a href="/auction/BoardService?method=editBoardForm&bNum=${BOARD.bNum }">
	    �Խù� ����
	    </a>
	  </p>
	  <p align="center">
	    <a href="/auction/BoardService?method=remove&bNum=${BOARD/bNum }">
	    �Խù� ����
	    </a>
	  </p>
</body>
</html>