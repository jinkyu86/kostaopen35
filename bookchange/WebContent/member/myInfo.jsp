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
<body topmargin="0" leftmargin="0" bgcolor="#FFFFFF">
<table>
	 <td width="550" height="600" valign="top">
	 <fieldset style="width:100; height:30">
	 <div class="txt01"><h4 align="center">MY INFORMATION</h4></div>
	 </fieldset>
	 <fieldset style="width:100; height:30">
	  <form action="/bookchange/MemberService/viewMember.action">
	  <input type="hidden" name="email" value="${sessionScope.LOGIN_EMAIL.email}">
	 	<ul><li><div> 이메일</div>${MEMBER.email}</li></ul>
		<ul><li><div> 주소</div></li>${MEMBER.address}</ul>
		<ul><li><div> 핸드폰번호</div>${MEMBER.tel}</li></ul>
	  </form>
	 </fieldset>
</td>
</table>	
</body>
</html>