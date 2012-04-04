<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물 목록</title>
<script type="text/javascript">

<c:if test="${ERROR!=null}">
	alert("${ERROR}");
</c:if>

<c:if test="${DELETE!=null}">
alert("${DELETE}");
</c:if>

<c:if test="${COMPLETE!=null}">
alert("${COMPLETE}");
</c:if>

</script>
</head>
<body>
<c:choose>
  <c:when test="${sessionScope.LOGIN_EMAIL==null}">
	 <table align="center">
	 <tr><td><a href="/bookchange/MemberService?method=loginForm">로그인</a></td></tr>
	 </table>
  </c:when>
  <c:otherwise>	
   	<table align="center">
 	<tr><td>${sessionScope.LOGIN_EMAIL.email}님</td>
 	<td><a href="/bookchange/MemberService?method=logout">로그아웃</a><td/>
   	<td><a href="/bookchange/BoardService?method=addBoardForm">물품등록</a><br/></td>
   	<td><a href="/bookchange/member/loginafter.jsp">메인으로</a></td></tr>
   	</table>
   </c:otherwise>
 </c:choose>
	
	<table align="left">
	<tr align="left"><th>분야별 찾기</th></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=&column=title&keyword=">전체보기</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=0&column=title&keyword=">만화/잡지</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=1&column=title&keyword=">학습/참고서</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=2&column=title&keyword=">취업/수험서</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=3&column=title&keyword=">컴퓨터/IT</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=4&column=title&keyword=">소설/시/에세이</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=5&column=title&keyword=">가정/생활/요리</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=6&column=title&keyword=">여행/취미/레저</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=7&column=title&keyword=">종교/해외도서</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=8&column=title&keyword=">기타도서</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=9&column=title&keyword=">유아/아동</a></td></tr>
	</table>
	
	 <table bordercolor="#FFA500" border="1" align="center">
	 <tr bgcolor="#FF8200" align="center">
	  <th>번호</th>
	  <th>사진</th>
	  <th>올린사람</th>
	  <th>제목</th>
	  <th>교환상태</th>
	 </tr>
	  <c:forEach var="good" items="${BOARD_LIST}">
      <tr>
       <td align="center">${good.boardNo}</td>
       <td><img src="/bookchange/bookimg/${good.boardPhoto}" height="80" width="80"></td>
       <td align="center">${good.member.email}</td>
       <td align="left"><a href="/bookchange/BoardService?method=viewBoard&boardNo=${good.boardNo}">${good.boardTitle}</a></td>
       <td align="center">${good.condition.conditionIng}</td>
      </tr>
     </c:forEach>
	 </table>
	 
	 <table align="center">
	 <form action="/bookchange/BoardService" method="post">
	  <input type="hidden" name="method" value="searchBoardList">
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
</body>
</html>