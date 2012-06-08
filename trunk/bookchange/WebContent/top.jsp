<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<body topmargin="20" leftmargin="100" bottommargin="0" bgcolor="#FFFFFF">
		<table cellpadding="0" cellspacing="0" border="0">
		<tr>
			
			<td><a href="/bookchange/boardListAtMain.action" target="main"><b>HOME</b><img src="webimg/home.jpg" border="0" width="50" height="50"/></a></td>
			<td width="70"></td>
			<td><a href="/bookchange/viewBoardList.action" target="main"><b>BOARD</b><img src="webimg/Book.jpg" border="0" width="50" height="50"/></a></td>
			<td width="70"></td>
			<td><a href="/bookchange/addBoardForm.action" target="main"><b>JOIN</b><img src="webimg/join.png" border="0" width="50" height="50"/></a></td>
			<td width="70"></td>
			<td><a href="/bookchange/viewMember.action" target="main"><b>MY INFO</b><img src="webimg/info.jpg" border="0" width="50" height="50"/></a></td>
			
		</tr>
		</table>
</body>
</html>
