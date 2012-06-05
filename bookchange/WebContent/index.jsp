<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>도서물물 교환</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script type="text/javascript">
	<c:if test="${ERROR!=null}">
	alert("${ERROR}");
	</c:if>
</script>
</head>
	<frameset rows="100,*" border="0">
		<frame src="top.jsp" name="top">	
	
	<frameset cols="280,*" border="0">
		<frame src="left.jsp" name="left">
	
		<frame src="/bookchange/boardListAtMain.action" name="main">
	</frameset>
	</frameset>
</html>