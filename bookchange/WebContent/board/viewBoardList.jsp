<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물 목록</title>
</head>
<body>
<h1 align="center">게시판</h1>	
	
	 <table border="3" align="center">
	 <tr>
	  <th>번호</th>
	  <th>올린사람</th>
	  <th>사진</th>
	  <th>제목</th>
	  <th>교환상태</th>
	 </tr>
	  <c:forEach var="good" items="${BOARD_LIST}">
      <tr>
       <td>${good.boardNo}</td>
       <td>${good.member.email}</td>
       <td><img src="/bookchange/bookimg/${good.boardPhoto}" height="100" width="80"></td>
       <td><a href="/bookchange/BoardService?method=viewBoard&boardNo=${good.boardNo}">${good.boardTitle}</a></td>
       <td>${good.condition.conditionIng}</td>
      </tr>
     </c:forEach>
	 </table>
	 
	 <table align="center">
	 <form action="/bookchange/BoardService" method="post">
	  <input type="hidden" name="method" value="searchBoardList">
	  <select name="categoryNo">
	   <option value="">전체</option>
	   <option value="0">만화/잡지</option>
	   <option value="1">학습/참고서</option>
	   <option value="2">취업/수험서</option>
	   <option value="3">컴퓨터/IT</option>
	   <option value="4">소설/시/에세이</option>
	   <option value="5">가정/생활/요리</option>
	   <option value="6">여행/취미/레저</option>
	   <option value="7">종교/해외도서</option>
	   <option value="8">기타도서</option>
	   <option value="9">유아/아동</option>
	  </select>
	  <select name="column">
	   <option value="title">제목</option>
	   <option value="email">작성자</option>
	  </select>
	  <input type="text" name="keyword">
	  <input type="submit" value="검색"/>
	 </form>
	 <a href="/bookchange/BoardService?method=addBoardForm&email=hoihoi@nate.com">물품등록</a>
	</table>
	
	 <p align="center">  ${PAGE_LINK_TAG} </p>
</body>
</html>