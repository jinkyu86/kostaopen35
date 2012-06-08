<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
a{text-decoration:none;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>물건 조회</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script type="text/javascript">

<c:if test="${ERROR!=null}">
	alert("${ERROR}");
</c:if>

</script>
</head>
<body topmargin="0" leftmargin="0" bgcolor="#FFFFFF">
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
	 	
	 	
<c:choose>
  <c:when test="${sessionScope.LOGIN_EMAIL==null}">
	 <table align="center">
	 </table>
  </c:when> 
  <c:when test="${sessionScope.LOGIN_EMAIL!=null}">
  <table align="center">
  <tr>
   	<c:choose>
   	<c:when test="${sessionScope.LOGIN_EMAIL.email==BOARD.member.email}">
   	 <form action="/bookchange/editBoardForm.action" method="post">
	  <input type="hidden" name="boardNo" value="${BOARD.boardNo}">
  <td><input type="submit" value="수정"></td>
	 </form>	 
	  <form action="/bookchange/removeBoard.action" method="post" target="main">
	  <input type="hidden" name="boardNo" value="${BOARD.boardNo}"/>
	  <input type="hidden" name="conditionResult" value="${BOARD.condition.conditionResult}"/>
  <td><input type="submit" value="삭제"></td>
	 </form>
	</c:when>
	
	<c:otherwise>
	 
   	<td><form action="/bookchange/searchBoardListWhenAdd.action" method="post" target="main"> 
	   <input type="hidden" name="boardNo" value="${BOARD.boardNo}">
	  <input type="hidden" name="keyword" value="${sessionScope.LOGIN_EMAIL.email}"></td>
	  <td><input type="submit" value="교환신청"></td></tr>	  
	  </form>	  
	</c:otherwise>
		
	</c:choose>
	</table>	 	
   	</c:when>
 </c:choose>
 
 
	 	<table bordercolor="#E6E6FA" align="center" border="1">
 		<tr align="center">
 			<td><b><small>게시물번호</small></b><br>${BOARD.boardNo}</td> 			
 			<td><b>올린사람</b><br>${BOARD.member.email}</td> 			
 			<td><b>카테고리</b><br>${BOARD.category.categoryName}</td>	
 	 		<td><b>거래방법</b><br>${BOARD.deal.dealWay}</td>
 	 		<td align="center"><b>교환상태</b><br>
 	 		<c:choose>
 	 		<c:when test="${BOARD.condition.conditionIng eq '교환중' || BOARD.condition.conditionIng eq '교환완료' }">
 	 		<font color="red"><b>${BOARD.condition.conditionIng}</b></font>
 	 		</c:when>
 	 		<c:otherwise>
 	 		${BOARD.condition.conditionIng}
 	 		</c:otherwise>
 	 		</c:choose>
 	 		</td> 	 		
 		</tr>
 		<tr>
 			<td colspan="2" align="center">${BOARD.boardTitle}</td>
 			<td align="center" colspan="3"><b>원하는물건</b><br>${BOARD.boardWant}</td>
 			
 			
 		</tr>
 		<tr>
 			<td align="center" colspan="5"><img src="/bookchange/bookimg/${BOARD.boardPhoto}" height="300" width="300"></td> 			 	 		
 		</tr>
 		
 		<tr>
 		<td colspan="5">${BOARD.boardContent}</td>
 		</tr>
 		
 		<tr>
 		<td colspan="10">
 		<b><i>댓글(${QA_COUNT})</i></b>
 		</td>
 		</tr>
 		
 		<c:forEach var="qa" items="${QA_LIST}"> 		
 		<tr> 		 		
 			<td>작성자<br>
 			<small>${qa.member.email}</small></td> 			
 			<c:choose>
 			<c:when test="${sessionScope.LOGIN_EMAIL.email eq qa.member.email}">
 			 <td id="qaContent" colspan="2"><small>${qa.qaContent}</small></td>
	 		 <form id="editQa" action="/bookchange/editQaForm.action" method="post">
	 		 <input type="hidden" name="qaNo" value="${qa.qaNo}">
	 		 <input type="hidden" name="qaContent" value="${qa.qaContent}">
	 		 <input type="hidden" name="email" value="${qa.member.email}">
	 		 <input type="hidden" name="boardNo" value="${qa.board.boardNo}"> 
 		 	<td><input type="submit" value="수정"></td>
	 		 </form>
	 		 <form action="/bookchange/removeQa.action" method="post">
	 		 <input type="hidden" name="qaNo" value="${qa.qaNo}">
	 		 <input type="hidden" name="boardNo" value="${BOARD.boardNo}">
	 		   <td><input type="submit" value="삭제"/></td> 		    
	 		 </form>
	 		</c:when>
	 		<c:otherwise>
	 		 <td colspan="6"><small>${qa.qaContent}</small></td>
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
	 	</td> 	
	 	</table>
</body>
</html>