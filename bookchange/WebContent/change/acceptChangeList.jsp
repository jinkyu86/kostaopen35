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
	 <td width="550" height="600" valign="top">
	 <h5 align="center">나에게 들어온 교환신청</h5>
	  <table bordercolor="#E6E6FA" border="1" align="center">
	   <tr align="center">
	   	<th>My Book</th>
	    <th>신청한사람</th>
	    <th>Trade Book</th>
		<th>신청일자</th>
	   </tr>
	  <c:forEach var="change" items="${AGREE_CHANGE_LIST}">
       <tr>
        <td><img src="/bookchange/bookimg/${change.agreeBoard.boardPhoto}" height="100" width="100"></td>
        <td align="center">${change.demandBoard.member.email}</td>
        <td align="center">
		<a href="/bookchange/viewBoard.action?boardNo=${change.demandBoard.boardNo}">
		<img src="/bookchange/bookimg/${change.demandBoard.boardPhoto}"height="100" width="100"></a></td>
		<td align="center">${change.changeDate}</td>
       </tr>
      </c:forEach>
      </table>
	  <p align="center">
		${PAGE_LINK_TAG}
	  </p>
	</table>
</body>
</html>