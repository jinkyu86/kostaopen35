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
<script src="http//code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
</head>
<body topmargin="0" leftmargin="0" bgcolor="#FFFFFF">
<table>
	 <td width="580" height="600" valign="top">
	 <c:if test="${WhenAgree eq a}">
	 <table align="center">
	 <tr><td>
	  <form action="/bookchange/matchChange.action" method="post">
	   <input type="hidden" name="demandBoardNo" value="${BOARD.boardNo}">
	   <input type="hidden" name="conditionResult" value="${BOARD.condition.conditionResult}">
	   <input type="hidden" name="agreeBoardNo" value="${AGREE_BOARD_NO}">
	<td>  <input type="submit" value="교환신청수락"></td></tr></table>
	  </form>	
	  </c:if>

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
 			 <td colspan="2"><small>${qa.qaContent}</small></td>
	 		 <form action="/bookchange/editQaForm.action" method="post">
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
 	
 	 <c:if test="${sessionScope.LOGIN_EMAIL!=null}">
 		<jsp:include page="addQa.jsp"/>
 	 </c:if>

	 	</table>
	 </td>
	</table>
  </body>
</html>