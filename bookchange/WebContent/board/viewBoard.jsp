<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>물건 조회</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
</head>
<body>

<c:choose>
  <c:when test="${sessionScope.LOGIN_EMAIL==null}">
	 <table align="center">
   		<tr><td><a href="/bookchange/MemberService?method=loginForm">로그인</a></td>
	 </table>
  </c:when> 
  <c:when test="${sessionScope.LOGIN_EMAIL!=null}">
  <table align="center">
  <tr><td>${sessionScope.LOGIN_EMAIL.email}님</td>
  <td><a href="/bookchange/MemberService?method=logout">로그아웃</a></td>
   	<c:choose>
   	<c:when test="${sessionScope.LOGIN_EMAIL.email==BOARD.member.email}">
   	 <form action="/bookchange/BoardService" method="post">
	  <input type="hidden" name="method" value="editBoardForm">
	  <input type="hidden" name="boardNo" value="${BOARD.boardNo}">
  <td><input type="submit" value="수정"></td>
	 </form>	 
	  <form action="/bookchange/BoardService" method="post">
	  <input type="hidden" name="method" value="removeBoard"/>
	  <input type="hidden" name="boardNo" value="${BOARD.boardNo}"/>
	  <input type="hidden" name="conditionResult" value="${BOARD.condition.conditionResult}"/>
  <td><input type="submit" value="삭제"></td>
	 </form>
	</c:when>
	
	<c:otherwise>
   	<td><form action="/bookchange/BoardService" method="post">
	  <input type="hidden" name="method" value="searchBoardListWhenAdd">
	   <input type="hidden" name="boardNo" value="${BOARD.boardNo}">
	  <input type="hidden" name="keyword" value="${sessionScope.LOGIN_EMAIL.email}"></td>
	  <td><input type="submit" value="교환신청"></td></tr>
	  </form>	  
	</c:otherwise>	
	</c:choose>
	</table>	 	
   	</c:when>
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

 	<table align="center" border="3">
 		<tr align="center">
 			<td><b>게시물번호</b><br>${BOARD.boardNo}</td> 			
 			<td><b>올린사람</b><br>${BOARD.member.email}</td>
 			<td><b>카테고리</b><br>${BOARD.category.categoryName}</td>
 			<td><b>제목</b><br>${BOARD.boardTitle}</td>
 			<td><b>원하는물건</b><br>${BOARD.boardWant}</td>	
 	 		<td><b>거래방법</b><br>${BOARD.deal.dealWay}</td>
  			<td><b>교환상태</b><br>${BOARD.condition.conditionIng}</td> 	 		
 		</tr>
 		<tr>
 			<td align="center" colspan="3"><img src="/bookchange/bookimg/${BOARD.boardPhoto}" height="300" width="300"></td> 			
 	 		<td colspan="4">${BOARD.boardContent}</td> 	 		
 		</tr>
 		
 		<c:forEach var="qa" items="${QA_LIST}">
 		<tr> 		
 			<td>작성자</td>
 			<td colspan="2">${qa.member.email}</td> 			
 			<c:choose>
 			<c:when test="${sessionScope.LOGIN_EMAIL.email eq qa.member.email}">
 			 <td id="qaContent" colspan="2">${qa.qaContent}</td>
	 		 <form id="editQa" action="/bookchange/QaService" method="post">
	 		 <input type="hidden" name="method" value="editQaForm">
	 		 <input type="hidden" name="qaNo" value="${qa.qaNo}">
	 		 <input type="hidden" name="qaContent" value="${qa.qaContent}">
	 		 <input type="hidden" name="email" value="${qa.member.email}">
	 		 <input type="hidden" name="boardNo" value="${qa.board.boardNo}"> 
 		 	<td><input type="submit" value="수정"></td>
	 		 </form>
	 		 <form action="/bookchange/QaService" method="post">
	 		 <input type="hidden" name="method" value="removeQa">
	 		 <input type="hidden" name="qaNo" value="${qa.qaNo}">
	 		 <input type="hidden" name="boardNo" value="${BOARD.boardNo}">
	 		   <td><input type="submit" value="삭제"/></td> 		    
	 		 </form>
	 		</c:when>
	 		<c:otherwise>
	 		 <td colspan="4">${qa.qaContent}</td>
	 		</c:otherwise>
	 		</c:choose>  			 		 	 			
 		</tr>
 		</c:forEach>
 		<tr>
 		<td align="center" colspan="7"> ${PAGE_LINK_TAG}</td>
 		</tr>
 	</table>
 	
 	<center>
 	<c:choose>
 	 <c:when test="${EDITQA!=null}">
 			<jsp:include page="editQaForm.jsp"/>
	 	</c:when>	 	
 	 <c:when test="${sessionScope.LOGIN_EMAIL!=null}">
 		<jsp:include page="addQa.jsp"/> 		
 	 </c:when>
 	 <c:otherwise>
 	 </c:otherwise>
 	 </c:choose>	
 	 </center>
</body>
</html>