<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">
a{text-decoration:none;}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>교환을 원하는 물건을 선택해주세요</title>
<script src="http//code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
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
<body topmargin="0" leftmargin="0" bgcolor="#FFFFFF">
	 <table>
	 <td width="580" height="600" valign="top">	 	 
 
<h4 align="center">교환 신청 대상</h4>
	<table bordercolor="#E6E6FA" border="1" align="center">
		 <tr>
		  <th>번호</th>
		  <th>사진</th>
		  <th>올린사람</th>
		  <th>제목</th>
		  <th>교환상태</th>
		 </tr>
	      <tr>
	       <td>${BOARD.boardNo}</td>
	       <td><img src="/bookchange/bookimg/${BOARD.boardPhoto}" height="70" width="70"></td>
	       <td>${BOARD.member.email}</td>
	       <td>${BOARD.boardTitle}</td>
	       <td align="center"><small>${BOARD.condition.conditionIng}</small></td>
	      </tr>
		 </table>

 
<h4 align="center">현재 교환가능한 책 목록</h4>	
	
	 <table bordercolor="#E6E6FA" border="1" align="center">
	 <tr>
	  <th>번호</th>
	  <th>올린사람</th>
	  <th>사진</th>
	  <th>제목</th>
	  <th>교환상태</th>
	  <th>책 선택</th>
	 </tr>
	  <c:forEach var="good" items="${BOARD_LIST}">
      <tr>
       <td>${good.boardNo}</td>
       <td>${good.member.email}</td>
       <td><img src="/bookchange/bookimg/${good.boardPhoto}" height="80" width="80"></td>
       <td><a href="/bookchange/viewBoard.action?boardNo=${good.boardNo}"><small>${good.boardTitle}</small></a></td>
       <td align="center"><small>${good.condition.conditionIng}</small></td>
       <td>
       	<form action="/bookchange/addChange.action"
       	 method="post" target="main" onSubmit="change(this)" > <!-- 확인창 띄우기 위한 onSubmit 추가, 메서드는 change, 인자는 form 자신! -->
       	<input type="hidden" name="demandBoardNo" value="${good.boardNo}">
       	<input type="hidden" name="agreeBoardNo" value="${BOARD.boardNo}">
       	<input type="submit"   value="교환신청" >
       	</form>
       	</td>
      </tr>
     </c:forEach>
	 </table>
	
	 <p align="center">  ${PAGE_LINK_TAG} </p>

		</td> 	
	 	</table>
</body>
</html>