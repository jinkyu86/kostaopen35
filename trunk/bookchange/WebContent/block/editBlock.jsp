<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 관리자 모드 -->
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
<body topmargin="0" leftmargin="0" bgcolor="#FFFFFF">
	<table>
	 <td width="550" height="600" valign="top" bgcolor="#FFFFFF">
	 	<fieldset>
	 	<div class="txt01"><h4 align="center">신고하기</h4></div>
	 	 <form action="/bookchange/editBlock" method="post" target="main">
	
		  <input type="hidden" name="registeremail" value="${sessionScope.LOGIN_EMAIL.email}">
		  <ul><li><div> Email</div>  ${LOGIN_EMAIL.email}</li></ul>
		  <ul><li><div> 연락처</div>  ${LOGIN_EMAIL.tel}</li></ul>
	 	  <ul><li><div> 내용</div><textarea cols="40" rows="15" name="blockcontent">${LOGIN_EMAIL.blockcontent}</textarea></li></ul>
	 	  <ul><li><div> 신고 대상</div><input type="text" name="blockemail">${LOGIN_EMAIL.blockemail}</ul>
	 	  <ul><li><div> 신고 진행 변경</div><select  name="blockCondition"></select></li></ul>
	 	  <ul><div><input type="submit" value="신고확정"/></div></ul>	
	 	  </form>
	 	</fieldset>
	 </td>
	</table>
</body>
</html>