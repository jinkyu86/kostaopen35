<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<body>
<table width="500">
<tr>
<td>
<em><b>새로 올라온 책들</b></em>
</td>
<td align="right">
<a href="/bookchange/viewBoardList.action" target="main"><b><i>more..</i></b></a>
</td>
</tr>
</table>
 <c:forEach var="board" items="${BOARD_LIST}">
 <table border="1" width="530" height="70" bordercolor="#E6E6FA">
 <tr>
  <td height="70" width="70" rowspan="4"><a href="/bookchange/viewBoard.action?boardNo=${board.boardNo}"><img src="/bookchange/bookimg/${board.boardPhoto}" height="70" width="70" border="0"></a></td>
 </tr>
 <tr>
  <td><b>제목</b>:${board.boardTitle}</td>
  <td align="center" height="70" width="70" rowspan="4">
  <c:choose>
 	 		<c:when test="${board.condition.conditionIng eq '교환중' || board.condition.conditionIng eq '교환완료' }">
 	 		<font color="red"><b>${board.condition.conditionIng}</b></font>
 	 		</c:when>
 	 		<c:otherwise>
 	 		${board.condition.conditionIng}
 	 		</c:otherwise>
 	 		</c:choose>
  </td>
 </tr>
 <tr>
  <td><b>올린사람</b>:${board.member.email}</td>
 </tr>
 <tr>
  <td><b>원하는물건</b>:${board.boardWant}</td>
 </tr>
 </table>
 </c:forEach>
</body>
</html>