<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib  prefix="c" 
             uri="http://java.sun.com/jsp/jstl/core" %>   
<%--@ page import="java.util.ArrayList" --%>
<%--@ page import="kr.or.kosta.student.Student" --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물 리스트</title>
</head>
<table align="right">
  <form action="/auction/BoardService" method="post">
   <input type="hidden" name="method" value="searchBoardList">
    <Select name="column">
      <option value="title">글제목</option>
      <option value="userid">아이디</option>
    </Select>
    <input type="text" name="keyword">
    </br>
    <input type="submit" value="검색"/>
  </form>
</table>
<body>
<table border="1" align="center">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>제목</th>
		<th>내용</th>
	</tr>
	<c:forEach  var="board"  items="${BOARD_LIST }">	
	<tr>
		<td>${board.b_num}</td>
		<td>
			<a href="/auction/BoardService?method=viewBoard&b_num=${board.b_num}">
		  	</a>
		  </td>		
		<td>${board.member.userid}</td>
	</tr>
	</c:forEach>
	<%--} --%>
</table>
<p align="center">
 ${PAGE_LINK_TAG}
 </p>
<p align="center">
	<a href="/auction/BoardService?method=addBoardForm">게시물 작성</a>
</p>
</body>
</html>