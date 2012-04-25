<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물 목록</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script type="text/javascript">

<c:if test="${ERROR!=null}">
	alert("${ERROR}");
</c:if>

</script>
</head>
<table>
	 <td width="550" height="600" valign="top">
	 
	 <table align="center" border="0">
<tr><td align="left"><a href="/bookchange/searchBoardList.action?categoryNo=&column=title&keyword="><small>전체보기</small></a></td>
		<td align="left"><a href="/bookchange/searchBoardList.action?categoryNo=0&column=title&keyword="><small>만화/잡지</small></a></td>
		<td align="left"><a href="/bookchange/searchBoardList.action?categoryNo=1&column=title&keyword="><small>학습/참고서</small></a></td>
		<td align="left"><a href="/bookchange/searchBoardList.action?categoryNo=2&column=title&keyword="><small>취업/수험서</small></a></td>
		<td align="left"><a href="/bookchange/searchBoardList.action?categoryNo=3&column=title&keyword="><small>컴퓨터/IT</small></a></td>
		<td align="left"><a href="/bookchange/searchBoardList.action?categoryNo=4&column=title&keyword="><small>소설/시/에세이</small></a></td></tr>
		<tr><td align="left"><a href="/bookchange/searchBoardList.action?categoryNo=5&column=title&keyword="><small>가정/생활/요리</small></a></td>
		<td align="left"><a href="/bookchange/searchBoardList.action?categoryNo=6&column=title&keyword="><small>여행/취미/레저</small></a></td>
		<td align="left"><a href="/bookchange/searchBoardList.action?categoryNo=7&column=title&keyword="><small>종교/해외도서</small></a></td>
		<td align="left"><a href="/bookchange/searchBoardList.action?categoryNo=8&column=title&keyword="><small>기타도서</small></a></td>
		<td align="left"><a href="/bookchange/searchBoardList.action?categoryNo=9&column=title&keyword="><small>유아/아동</small></a></td></tr>
 </table>
	 
	 	 <table bordercolor="#FFA500" border="1" align="center">
	 <tr align="center">
	  <th>번호</th>
	  <th>사진</th>
	  <th>작성자</th>
	  <th>제목</th>
	  <th>교환상태</th>
	 </tr>
	  <c:forEach var="good" items="${BOARD_LIST}">
      <tr>
       <td align="center"><small>${good.boardNo}</small></td>
       <td><img src="/bookchange/bookimg/${good.boardPhoto}" height="80" width="80"></td>
       <td align="center"><small>${good.member.email}</small></td>
       <td align="left"><a href="/bookchange/viewBoard.action?boardNo=${good.boardNo}">${good.boardTitle}</a></td>
       <td align="center"><small>${good.condition.conditionIng}</small></td>
      </tr>
     </c:forEach>
	 </table>
	 
	 <table align="center">
	 <form action="/bookchange/searchBoardList.action" method="post">
	  <select name="categoryNo">
	   <option value="">전체</option>
	    <c:forEach var="category" items="${CATEGORY_LIST}">
	    	<c:choose>
	    	<c:when test="${category.categoryNo eq CATEGORY}">	  
		   		 <option value="${category.categoryNo}" selected>${category.categoryName}</option>
			</c:when>
			<c:otherwise>
	    		 <option value="${category.categoryNo}">${category.categoryName}</option>
	    	</c:otherwise>
	    	</c:choose>	   		   			     			     	
		</c:forEach>
	  </select>
	  <select name="column">
	   <option value="title">제목</option>
	   <option value="email">작성자</option>
	  </select>
	  <input type="text" name="keyword">
	  <input type="submit" value="검색"/>
	 </form>
	</table>
	
	 <p align="center">  ${PAGE_LINK_TAG} </p>
	 </td>
	</table>
</body>
</html>