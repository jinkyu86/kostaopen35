<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table width="500">
<tr>
<td>
<em><b>새로 올라온 책들</b></em>
</td>
<td align="right">
<a href="/bookchange/BoardService?method=viewBoardList"><b><i>more..</i></b></a>
</td>
</tr>
</table>
 <c:forEach var="board" items="${BOARD_LIST}">
 <table border="1" width="500" height="70">
 <tr>
  <td height="70" width="70" rowspan="4"><a href="/bookchange/BoardService?method=viewBoard&boardNo=${board.boardNo}"><img src="/bookchange/bookimg/${board.boardPhoto}" height="70" width="70"></a></td>
 </tr>
 <tr>
  <td><b>제목</b>:${board.boardTitle}</td>
  <td align="center" height="70" width="70" rowspan="4"><b>${board.condition.conditionIng}</b></td>
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