<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>물건 조회</title>
<script src="http//code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
</head>
<body topmargin="0" leftmargin="0" bgcolor="#FFFFFF">
	<table width="880" align="center" cellpadding="0" cellspacing="0" border="0">
	
	<tr>
	<td height="60"></td>
	</tr>

	<tr>
	<td>
		<table cellpadding="0" cellspacing="0" border="0">
		<tr align="right">
			<td width="25"></td>
			<td><a href="/bookchange/BoardService"><img src="webimg/home.gif" border="0"/></a></td>
			<td><a href="/bookchange/BoardService?method=viewBoardList"><img src="webimg/board.GIF" border="0"/></a></td>
		<c:choose>
		<c:when test="${sessionScope.LOGIN_EMAIL==null}">	
			<td><a href="/bookchange/BoardService?method=addBoardForm"><img src="webimg/join.GIF" border="0"/></a></td>
			<td><a href="/"><img src="webimg/myinfo.GIF" border="0"/></a></td>
		</c:when>
		<c:otherwise>
			<td><a href="/bookchange/BoardService?method=addBoardForm"><img src="webimg/join.GIF" border="0"/></a></td>
			<td><a href="/bookchange/MemberService?method=viewMember"><img src="webimg/myinfo.GIF" border="0"/></a></td>
		</c:otherwise>
		</c:choose>
			<td width="25"></td>
		</tr>
		</table>
	</td>
	</tr>
	
	<tr>
	<td height="10"></td>
	</tr>

	<tr>
	<td>
	<table cellpadding="0" cellspacing="0" border="0">
	 <tr>
	 <td width="220" height="600" valign="top" bgcolor="#F8F8F8">
	 <table cellpadding="0" cellspacing="0" border="0">
	 <!--로그인-->
	  <tr>
	  <td>		
	   <c:choose>
	    <c:when test="${sessionScope.LOGIN_EMAIL==null}">
	     <fieldset>
	     <table align="left" cellpadding="0" cellspacing="0" border="0">
	     <form action="/bookchange/MemberService" method="post">
		 <input type="hidden"name="method" value="login">
		 <tr>
		 <td>Email</td>
		 <td><input type="text" name="email"></td>
		 </tr>
		 <tr>
		 <td>Password</td>
		 <td><input type="password" name="pw"></td>
		 </tr>
		 <tr>
		 <td colspan="5"><div align="right">
		 <input type="submit" value="로그인">
		 </div></td>
		 </tr>
		 </form>
		  <tr>
		 <td><div align="right">
		 <form action="/bookchange/MemberService" method="post">
	  	 <input type="hidden" name="method" value="addMemberForm">
	  	  <input type="submit" value="회원가입"/>
	  	 </form></div></td>
		 <td><div align="right">
		 <form action="/bookchange/MemberService" method="post">
	  	 <input type="hidden" name="method" value="">
	  	   <input type="submit" value="Email/Pw찾기"/>
	  	 </form></div></td>
		 </tr>
	     </table>
	     </fieldset>
	    </c:when>
	   <c:otherwise>
	    <fieldset>
	 	<table cellpadding="0" cellspacing="0" border="0">
	    <form action="/bookchange/MemberService" method="post">
		<input type="hidden"name="method" value="logout">
		<tr>
		 <td>${sessionScope.LOGIN_EMAIL.email}님 로그인..</td>
		</tr>
		<tr>
		 <td colspan="5"><div align="right">
		 <input type="submit" value="로그아웃">
		 </div></td>
		</tr>
		</form>
		<tr>
		 <td><div align="right">
		 <form action="/bookchange/MemberService" method="post">
	  	 <input type="hidden" name="method" value="removeMemberForm">
	  	  <input type="submit" value="회원탈퇴"/>
	  	 </form></div></td>
		 <td><div align="right">
		 <form action="/bookchange/MemberService" method="post">
	  	 <input type="hidden" name="method" value="editMemberForm">
	  	   <input type="submit" value="정보수정"/>
	  	 </form>
		 </div></td>
		</tr>
	    </table>
	    </fieldset>
	
	</td>
	</tr>
	<tr>
	 <table cellpadding="0" cellspacing="0" border="0">
	 <tr>
	   <td><a href="/bookchange/BlockService?method=addBlockForm">
	   <img align="right" src="webimg/block.GIF" title="신고하기" border="0" width="230"/></a></td>
	   </tr>
	   
   <tr>
	   <td align="center">
	   <form action="/bookchange/BoardService" method="post">
	   <input type="hidden" name="method" value="searchBoardList">
	   <input type="hidden" name="categoryNo">
	   <input type="hidden" name="column" value="email">
	   <input type="hidden" name="keyword" value="${sessionScope.LOGIN_EMAIL.email}">
	   <input type="submit" value=" 등록한 책 목록 "></td>
	   </form>
	   </tr>	
	   
	   <tr>
		<td height="10"></td>
		</tr>  
	   
	   <tr>
	   <td align="center">
	   <form action="/bookchange/ChangeService" method="post">
	   <input type="hidden" name="method" value="requestChangeList">
	   <input type="submit" value="요청한 교환신청"></td>
	   </form>	   
	   </tr>
	   
	   <tr>
		<td height="10"></td>
		</tr>
	   
	   <tr>
	   <td align="center">
	   <form action="/bookchange/ChangeService" method="post">
	   <input type="hidden" name="method" value="acceptChangeList">
	   <input type="submit" value="들어온 교환신청"></td>
	   </form>	   
	   </tr>
	   
	   <tr>
		<td height="10"></td>
		</tr>
	   
	   <tr>
	   <td align="center">
	   <form action="/bookchange/ChangeService" method="post">
	   <input type="hidden" name="method" value="matchChangeList">
	   <input type="submit" value="교환진행중인 책 목록"></td>
	   </form>	   
	   </tr>
	   
	   <tr>
		<td height="10"></td>
		</tr>
	   
	   <tr>
	   <td align="center">
	   <form action="/bookchange/ChangeService" method="post">
	   <input type="hidden" name="method" value="matchChangeResultList">
	   <input type="submit" value="교환완료된 책 목록"></td>
	   </form>	   
	   </tr>
	     
	      <tr>
		<td height="10"></td>
		</tr>
		
	   <tr>
    <td align="center">
    <form action="/bookchange/BlockService" method="post">
      <input type="hidden" name="method" value="selectMyBlockList">
      <input type="submit" value="신고내역보러가기">
    </form>
    </td>
    </tr>  
	     
	     </c:otherwise>
	  </c:choose>
	   
	 </table>
	 </tr>
	 <td width="550" height="600" valign="top" bgcolor="#FAFAD2">
	 	<table width="550" height="600" cellpadding="0" cellspacing="0" border="1">
	 	<td>
	 	
	 	<c:choose>
  <c:when test="${sessionScope.LOGIN_EMAIL==null}">
	 <table align="center">
   		<tr><td><a href="/bookchange/MemberService?method=loginForm">
   		로그인
   		</a></td></tr>
	 </table>
  </c:when> 
  <c:when test="${sessionScope.LOGIN_EMAIL!=null}">
  <table align="center">
 	<tr><td></td>
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
   	<%--  <form action="/bookchange/BoardService" method="post">
	  <input type="hidden" name="method" value="searchBoardListWhenAdd">
	   <input type="hidden" name="boardNo" value="${BOARD.boardNo}">
	  <input type="hidden" name="keyword" value="${sessionScope.LOGIN_EMAIL.email}">
	  <input type="submit" value="교환신청">
	  </form> --%>
	  
	  <form action="/bookchange/ChangeService" method="post">
	  <input type="hidden" name="method" value="cancelChange">
	   <input type="hidden" name="demandBoardNo" value="${BOARD.boardNo}"><!-- 이게 상대방 게시물 번호 -->
	   <input type="hidden" name="agreeBoardNo" value="${AGREE_BOARD_NO}"><!-- 이건 내 게시물 번호 -->
	<td> <input type="submit" value="교환신청취소"></td></tr></table>
	  </form>
	</c:otherwise>	
	</c:choose>	 	
   	</c:when>
  <%--  </c:otherwise> --%>
 </c:choose>

 	<table align="center" border="1">
 		<tr align="center">
 			<td><b><small>게시물번호</small></b><br>${BOARD.boardNo}</td> 			
 			<td><b>올린사람</b><br>${BOARD.member.email}</td> 			
 			<td colspan="2"><b>카테고리</b><br>${BOARD.category.categoryName}</td>	
 	 		<td colspan="3"><b>거래방법</b><br>${BOARD.deal.dealWay}</td> 	 		
 		</tr>
 		<tr>
 			<td colspan="2"><b>제목</b><br>${BOARD.boardTitle}</td>
 			<td align="center" colspan="2"><b>원하는물건</b><br>${BOARD.boardWant}</td>
 			
 			<td align="center" colspan="4"><b>교환상태</b><br>${BOARD.condition.conditionIng}</td>
 		</tr>
 		<tr>
 			<td align="center" colspan="2"><img src="/bookchange/bookimg/${BOARD.boardPhoto}" height="300" width="300"></td> 			
 	 		<td colspan="6">${BOARD.boardContent}</td> 	 		
 		</tr>
 		
 		<tr>
 		<td colspan="10">
 		<b><i>댓글(${QA_COUNT})</i></b>
 		</td>
 		</tr>
 		
 		<c:forEach var="qa" items="${QA_LIST}">
 		<tr> 		
 			<td>작성자<br><small>${qa.member.email}</small></td> 			
 			<c:choose>
 			<c:when test="${sessionScope.LOGIN_EMAIL.email eq qa.member.email}">
 			 <td colspan="2"><small>${qa.qaContent}</small></td>
	 		 <form action="/bookchange/QaService" method="post">
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
	 	
	 	</td> 	
	 	</table>
	 </td>
	</table>
   </td>
  </tr>
 </table>
 </td>
 </tr>


 
</body>
</html>