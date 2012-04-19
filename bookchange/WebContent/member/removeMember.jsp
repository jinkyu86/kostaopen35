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
	 <td width="550" height="600" valign="top" bgcolor="#FFFFFF">
	  <fieldset>
	  <li><div class="txt01"><h4 align="center">회원 탈퇴</h4></div></li>
	  <form action="/bookchange/MemberService" method="post">
	  <input type="hidden" name="method" value="viewMember">
	  <input type="hidden" name="email" value="${sessionScope.LOGIN_EMAIL.email}">
	 	<ul><li><div> 이메일</div>${LOGIN_EMAIL.email}</li></ul>
		<ul><li><div> 주소</div></li>${LOGIN_EMAIL.address}</ul>
		<ul><li><div> 핸드폰번호</div>${LOGIN_EMAIL.tel}</li></ul>
	  </form>
	 <li><div class="txt01"><h4 align="center">정보를 확인 하시고 탈퇴를 원하시면 비밀번호를 입력해주세요.</h4></div></li>
	 <form action="/bookchange/MemberService" method="post">
	  <input type="hidden" name="method" value="removeMember">
	  <input type="hidden" name="email" value="${sessionScope.LOGIN_EMAIL.email}">
	 	<ul><li><div> 비밀번호</div><input type="password"name="pw"/></li></ul>
	 	<ul><input type="submit" value="탈퇴"/></ul>
	  </form>
	  <form action="/bookchange/BoardService"method="post">
		<input type="hidden" name="method" value="boardListAtMain">
	 	<ul><div><input type="submit" value="취소"/></div></ul>				
	 </form>
	 </fieldset>
	 </td>
	</table>
</body>
</html>