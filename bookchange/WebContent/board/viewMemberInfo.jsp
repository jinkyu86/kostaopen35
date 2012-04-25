<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>도서물물 교환</title>
<script src="http//code.jquery.com/jquery-1.7.js"></script>
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
	 <h5 align="center">상대방 정보</h5>
	 <table border="1" bordercolor="#E6E6FA" align="center">
	 <tr>
	 <td>email</td><td>${MEMBER.email}</td>
	 </tr>
	 <tr>
	 <td>주소</td><td>${MEMBER.address}</td>
	 </tr>
	 <tr>
	 <td>전화번호</td><td>${MEMBER.tel}</td>
	 </tr>	 
	 </table>
	 <center><br>
	 <a href="/bookchange/matchChangeList.action">
	 <img src="/bookchange/webimg/return.gif" border="0"></a>
	 </center>
   </td>
  </tr>
 </table>
 </td>
 </tr>
</body>
</html>
