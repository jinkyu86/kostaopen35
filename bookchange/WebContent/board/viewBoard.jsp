<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>물건 조회</title>
</head>
<body>

<c:choose>
  <c:when test="${sessionScope.LOGIN_EMAIL==null}">
	 <p align="right">
   		<a href="/bookchange/MemberService?method=loginForm">
   		로그인
   		</a>
	 </p>
  </c:when> 
  <c:when test="${sessionScope.LOGIN_EMAIL!=null}">
  <p align="right">
 	${sessionScope.LOGIN_EMAIL.email}님<br/>
   	<a href="/bookchange/MemberService?method=logout">
   	로그아웃
   	</a><br/>
   	<c:choose>
   	<c:when test="${sessionScope.LOGIN_EMAIL.email==BOARD.member.email}">
   	 <form action="/bookchange/BoardService" method="post">
	  <input type="hidden" name="method" value="editBoardForm">
	  <input type="hidden" name="boardNo" value="${BOARD.boardNo}">
	  <input type="submit" value="수정">
	 </form>	 
	  <form action="/bookchange/BoardService" method="post">
	  <input type="hidden" name="method" value="removeBoard"/>
	  <input type="hidden" name="boardNo" value="${BOARD.boardNo}"/>
	  <input type="hidden" name="conditionResult" value="${BOARD.condition.conditionResult}"/>
	  <input type="submit" value="삭제">
	 </form>
	</c:when>
	
	<c:otherwise>  
   	 <form action="/bookchange/BoardService" method="post">
	  <input type="hidden" name="method" value="searchBoardListWhenAdd">
	   <input type="hidden" name="boardNo" value="${BOARD.boardNo}">
	  <input type="hidden" name="keyword" value="${sessionScope.LOGIN_EMAIL.email}">
	  <input type="submit" value="교환신청">
	  </form>
	</c:otherwise>	
	</c:choose>	 	
   	</c:when>
  <%--  </c:otherwise> --%>
 </c:choose>
 
 <p align="right">
  <a href="/bookchange/BoardService?method=viewBoardList">전체 리스트 보기</a>
 </p>
 
 
 <h1 align="center">물건명세</h1>
 	<table align="center" border="3">
 		<tr>
 			<td>${BOARD.boardNo}</td>
 			<td>${BOARD.category.categoryName}</td>
 			<td>${BOARD.boardTitle}</td>
 			<td>${BOARD.member.email}</td>
 			<td>${BOARD.condition.conditionIng}</td>
 	 		<td>${BOARD.boardWant}</td>	
 	 		<td>${BOARD.deal.dealWay}</td>
 		</tr>
 		<tr>
 			<td align="center" colspan="3"><img src="/bookchange/bookimg/${BOARD.boardPhoto}" height="300" width="200"></td> 			
 	 		<td colspan="4">${BOARD.boardContent}</td> 	 		
 		</tr>
 		<tr>
 			<td>댓글</td>
 			<td>${QA.member.email}</td>
 			<td colspan="5">${QA.qaContent}</td>
 		</tr>
 	</table>
</body>
</html>