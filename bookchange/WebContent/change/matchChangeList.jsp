<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
a{text-decoration:none;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>도서물물 교환</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script type="text/javascript">
	<c:if test="${ERROR!=null}">
	alert("${ERROR}");
	</c:if>
</script>
</head>
<body topmargin="0" leftmargin="0" bgcolor="#FFFFFF">
	<table>
	 <td width="650" height="600" valign="top">
	 <h5 align="center">교환진행중인 책 목록</h5>
	  <table bordercolor="#E6E6FA" border="1" align="center">
	   <tr align="center">
	   	<th>My Book</th>
	    <th>신청한사람</th>
	    <th>Trade Book</th>
		<th>신청<br>일자</th>
		<th width="100">상대방<br>완료 여부</th>
		<th>완료<br>여부</th>
	   </tr>
	  <c:forEach var="change" items="${MATCH_LIST}">
       <tr>
        <td><img src="/bookchange/bookimg/${change.demandBoard.boardPhoto}" height="100" width="100"></td>
        <td align="center">
        <a href="/bookchange/viewMemberInfo.action?email=${change.agreeBoard.member.email}">${change.agreeBoard.member.email}</a></td>
        <td align="center">
		<a href="/bookchange/viewBoardWhenAgree.action?boardNo=${change.agreeBoard.boardNo}&agreeBoardNo=${change.demandBoard.boardNo}&WhenAgree=a">
		<img src="/bookchange/bookimg/${change.agreeBoard.boardPhoto}"height="100" width="100"></a></td>
		<td align="center">${change.changeDate}</td>
		<td align="center">
		<c:choose>
        <c:when test="${change.agreeBoard.condition.conditionResult eq 2}">
                교환<br>완료<br><font color="red"><b>대기</font>
        </c:when>
        <c:otherwise>
        		교환완료<br><font color="red"><b>완료</b></font>
        </c:otherwise>
        </c:choose>        
		</td>		
		<td>
       		<form action="/bookchange/completeChange.action" method="post">
       		<input type="hidden" name="ChangeNo" value="${change.agreeBoard.boardNo}">
       		<input type="hidden" name="BoardNo" value="${change.demandBoard.boardNo}">
       		<input type="hidden" name="conditionResult" value="${change.agreeBoard.condition.conditionResult}">
       		<input type="submit" value="완료확정">
       		</form>
       	</td>
       </tr>
      </c:forEach>
	</table>
	
	  <p align="center">
		${PAGE_LINK_TAG}
	  </p>
	  
   </td>
 
 </table>

</body>
</html>
