<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" 
				content="width=device-width, initial-scale=1.0, 
							maximum-scale=1.0, minimum-scale=1.0, 
							user-scalable=no"/>
		
		<link rel="shortcut icon" href="../image/icon.png">
		<link rel="apple-touch-icon" href="../image/icon.png">

		
		<link href="http://code.jquery.com/mobile/latest/jquery.mobile.min.css" 
			rel="stylesheet" type="text/css" />
		<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
		<script src="http://code.jquery.com/mobile/latest/jquery.mobile.min.js"></script>
		
		<style type="text/css">
		a{text-decoration:none;}
		</style>
		
		<script type="text/javascript">

			<c:if test="${ERROR!=null}">
				alert("${ERROR}");
			</c:if>
			
			function change(form){
				var result=confirm("삭제하시겠습니까?");
				if(result==true){
					form.submit();
					return true;
				}else{
					event.preventDefault();
					return false;
				}
			}
			
			function ok(form){
				var result=confirm("교환신청을 수락하시겠습니까?");
				if(result==true){
					form.submit();
					return true;
				}else{
					event.preventDefault();
					return false;
				}
			}
			
			
			function cancel(form){
				var result=confirm("교환신청을 취소하시겠습니까?");
				if(result==true){
					form.submit();
					return true;
				}else{
					event.preventDefault();
					return false;
				}
			}
			
			
			</script>
		
		
	</head>
	<body>
		<div data-role="page">
			<div data-role="header">
				<a href="#" data-icon="arrow-l" data-rel="back" data-ajax="false">이전</a>
				<h1>${BOARD.boardTitle}</h1>
			</div>
			<div data-role="content">
			
			<c:if test="${sessionScope.LOGIN_EMAIL!=null}">	 	
				<c:choose>
				  <c:when test="${sessionScope.LOGIN_EMAIL.email==BOARD.member.email}">
				  
					  <table style="width:100%">
					  <tr>   	
					   <td>	 
					   <form action="/bookchange/meditBoardForm.action" method="post"  data-ajax="false">
						  <input type="hidden" name="boardNo" value="${BOARD.boardNo}">
					  	  <input type="submit" value="수정">
					  </form>
					  </td>
				   
				      <td>	 	 
					  <form action="/bookchange/mremoveBoard.action" method="post" onSubmit="change(this)">
					  <input type="hidden" name="boardNo" value="${BOARD.boardNo}"/>
					  <input type="hidden" name="conditionResult" value="${BOARD.condition.conditionResult}"/>
				 	  <input type="submit" value="삭제">
				 	  </form>
				 	  </td>
				 	  </tr>
				 	  </table>
					 
					</c:when>
					
					<c:when test="${sessionScope.LOGIN_EMAIL.email != BOARD.member.email}">
					<c:choose>
					
					<c:when test="${WhenAgree!=null}">
					
					 <table style="width:100%">
					 <tr><td>
					  <form action="/bookchange/mmatchChange.action" method="post" onSubmit="ok(this)" data-ajax="false">
					   <input type="hidden" name="demandBoardNo" value="${BOARD.boardNo}">
					   <input type="hidden" name="conditionResult" value="${BOARD.condition.conditionResult}">
					   <input type="hidden" name="agreeBoardNo" value="${agreeBoardNo}">
					 <input type="submit" value="교환신청수락"> </form></td></tr></table>	 	
					  
					</c:when>
					
					<c:when test="${WhenCancel!=null}">
					 <table style="width:100%">
					 <tr><td>
					 <form action="/bookchange/mcancelChange.action" method="post" onSubmit="cancel(this)" data-ajax="false">
					   <input type="hidden" name="demandBoardNo" value="${DEMAND_BOARD_NO}"><!-- 이게 상대방 게시물 번호 -->	   
					   <input type="submit" value="교환신청취소"></form></td></tr></table>  
					
					</c:when>
					
					<c:when test="${BOARD.condition.conditionResult == 0 || BOARD.condition.conditionResult == 1}">
					<table style="width:100%"><tr>	 
				   	<td><form action="/bookchange/msearchBoardListWhenAdd.action" method="post" data-ajax="false"> 
					   <input type="hidden" name="boardNo" value="${BOARD.boardNo}">
					  <input type="hidden" name="keyword" value="${sessionScope.LOGIN_EMAIL.email}">
					  <input type="submit" value="교환신청"></form></td></tr>	
					</table>
					</c:when>   	
				 </c:choose>
				 </c:when>
				 
				 </c:choose>
				 </c:if>
 
				<b>올린사람</b> ${BOARD.member.email}<br/>
				<b>거래방법</b> ${BOARD.deal.dealWay}<br/>
				<b>교환상태</b>
				<c:choose>
 	 			<c:when test="${BOARD.condition.conditionIng eq '교환중' || BOARD.condition.conditionIng eq '교환완료' }">
 	 			<font color="red"><b>${BOARD.condition.conditionIng}</b></font><br/>
 	 			</c:when>
 	 			<c:otherwise>
	 	 		${BOARD.condition.conditionIng}<br/>
	 	 		</c:otherwise>
	 	 		</c:choose>
	 	 		<b>원하는물건</b> ${BOARD.boardWant}<br/>
	 	 		<hr>
				<img src="/bookchange/bookimg/${BOARD.boardPhoto}" height="300" width="300"><br/>
				${BOARD.boardContent}<br/>
				<hr>
				<!-- 댓글보기 -->
				<b>댓글(${QA_COUNT})</b><br/>
				
				<c:forEach var="qa" items="${QA_LIST}">
				<table style="width:100%">
				<tr>
				<td>
				<font><small><b><i>${qa.member.email}</i></b></small></font>
				</td>
				<td align="right">
				<c:if test="${sessionScope.LOGIN_EMAIL.email eq qa.member.email}">
		 			
		 			 <a href="/bookchange/meditQaForm.action?qaNo=${qa.qaNo}&qaContent=${qa.qaContent}&email=${qa.member.email}&boardNo=${qa.board.boardNo}">수정</a>
		 			 <a href="/bookchange/mremoveQa.action?qaNo=${qa.qaNo}&boardNo=${BOARD.boardNo}">&nbsp;삭제</a>
		 					 		
			 	</c:if>	
			 	</td>
				</tr>
				<tr>
				<td colspan="2">							
				&nbsp; ${qa.qaContent}
				<hr>
				</td>				
				</tr>
				</table>
				</c:forEach>
				<!-- 댓글페이지 앞뒤이동 -->
				<c:if test="${QA_COUNT != 0}">
				<c:if test="${qapage != 1}">
				<a href="/bookchange/mviewBoard.action?page=${qapage-1}&boardNo=${BOARD.boardNo}" data-role="button" data-icon="arrow-l" data-iconpos="left" data-inline="true">이전댓글</a>
				</c:if>
				<c:if test="${qapage < maxPage}">								
				<a href="/bookchange/mviewBoard.action?page=${qapage+1}&boardNo=${BOARD.boardNo}" data-role="button" data-icon="arrow-r" data-iconpos="right" data-inline="true">다음댓글</a>
				</c:if>
				</c:if>
				<!-- 댓글작성 -->
				<c:choose>
				 <c:when test="${EDITQA!=null}">
				 <form action="/bookchange/meditQa.action" method="post">
				  <input type="hidden" name="qaNo" value="${EDITQA.qaNo}">
				  <input type="hidden" name="email" value="${EDITQA.member.email}">
				  <input type="hidden" name="boardNo" value="${EDITQA.board.boardNo}">
				  <textarea name="qaContent" cols="30" rows="3">${EDITQA.qaContent}</textarea> 
			      <input type="submit" value="댓글수정"/></form>
			    
				 <form action="/bookchange/mviewBoard.action" method="post">
				 <input type="hidden" name="boardNo" value="${EDITQA.board.boardNo}">
				 <input type="submit" value="취소"/>
				 </form>
				 </c:when>
				 <c:when test="${sessionScope.LOGIN_EMAIL.email != null}">
				<form action="/bookchange/maddQa.action" method="post">
				 <input type="hidden" name="email" value="${sessionScope.LOGIN_EMAIL.email}"/>
				 <input type="hidden" name="boardNo" value="${BOARD.boardNo}"/>
				 <input type="text" name="qaContent" placeholder="댓글을 입력하세요." required/>
				  <input type="submit" value="댓글등록">
				 </form>
				 </c:when>
				</c:choose>
			</div>
		</div>
	</body>
</html>