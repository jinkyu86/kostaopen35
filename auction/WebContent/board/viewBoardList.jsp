<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물 리스트</title>
</head>
<body background="/auction/gphoto/s20.jpg">
<c:choose>
	<c:when test="${sessionScope.MEMBER==null}">
		<p align="right">
			<a href="/auction/MemberService?method=loginForm">
			로그인
			</a>
		</p>
	</c:when>
	<c:otherwise>
		<p align="right">
			${sessionScope.MEMBER.name }님<br/>
			<a href="/auction/MemberService?method=logout">
			<img src="/auction/menu/logout.jpg"/>
			</a><br/>
		</p>
	</c:otherwise>
</c:choose>
<body>
<table  align="center"  border="1" bgcolor="pink">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>제목</th>
	</tr>
	<c:forEach  var="board"  items="${BOARD_LIST }">	
		<tr>
		<td>${board.bNum}</a></td>		
		<td>${board.member.userid}</td>
		<td><a href="/auction/BoardService?method=viewBoard&bNum=${board.bNum}">
		    ${board.title}</td>
	</tr>
	</c:forEach>
</table>
<p align="center">
 ${PAGE_LINK_TAG}
 </p>
 <table align="center">
  <form action="/auction/BoardService" method="post">
   <input type="hidden" name="method" value="searchBoardList">
    <Select name="column" align="center">
      <option value="title">글제목</option>
      <option value="userid">아이디</option>
    </Select>
    <input type="text" name="keyword" />
    <input type="submit" value="검색"/>
  </form>
</table>
 <c:if test="${sessionScope.MEMBER.userid!=null}">
<p align="center">
	<a href="/auction/BoardService?method=addBoardForm">
	<img src="/auction/menu/insertBoard.jpg"/>
	</a>
</p>
</c:if>
<p align="center">
	<a href="/auction/AuctionService?method=viewAuctionList">
	<img src="/auction/menu/viewAuctionList.jpg"/>
	</a>
</p>
</body>
</html>