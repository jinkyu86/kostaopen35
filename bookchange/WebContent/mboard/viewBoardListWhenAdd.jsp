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
				 var result= confirm("책을 교환 하시겠습니까?"); /* confirm문구 물어보고 yes면 true, no면 false 리턴 */
				 if(result==true){ 
					 form.submit(); /* submit()해서 진행시킴.  */
					 return true; /* true를 리턴하는 건 다음 단계로 넘어가겠다는 말임. */
				 }else{
					 event.preventDefault(); /* no면 이벤트 중지시킴. */ 
					 return false; /* 원래 화면으로 복귀. 다음 단계 안 감 */
				 }
				 
				
			}
		</script>

	</head>
	<body>
		<div data-role="page">
			<div data-role="header">
				<a href="#" data-rel="back" data-icon="arrow-l">이전</a>
				<h1>교환 물품 선택</h1>
			</div>
			<div data-role="content">
				<img src="/bookchange/bookimg/${BOARD.boardPhoto}" height="70" width="70">
				<b>${BOARD.boardTitle}</b> [${BOARD.member.email}]
				<hr>
				&nbsp;
				<hr>
				<ul data-role="listview">
					<c:forEach var="good" items="${BOARD_LIST}">
					<li>
						<table style="width:100%">
						<tr><td>
						<img src="/bookchange/bookimg/${good.boardPhoto}" height="80" width="80"/>
						<small>${good.boardTitle}</small></td>
						<td align="right">
						<form action="/bookchange/maddChange.action" data-ajax="false" method="post" onSubmit="change(this)"> 
					       	<input type="hidden" name="demandBoardNo" value="${good.boardNo}">
					       	<input type="hidden" name="agreeBoardNo" value="${BOARD.boardNo}">
					       	<input type="submit" value="교환신청" data-inline="true">
					    </form>
					    </td>
					    </table>						
					</li>
					</c:forEach>
				</ul>		
			</div>
		</div>
	</body>
</html>