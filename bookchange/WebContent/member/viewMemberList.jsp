<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��� ����Ʈ</title>
</head>
<body>
<h1 align="center">��ü �ɹ� ����Ʈ</h1>
	<table border="2" align="left">		 
	<form action="/bookchange/MemberService" method="post">
	  <input type="hidden" name="method" value="searchMemberList">
     <select name="email">
     	<option value="email">�̸���</option>
     </select>
		<input type="text" name="keyword">
		<br/>
		<input type="submit" value="�˻�">
	</form>
</table>	
 <table border="1" align="center">
 <tr>
 	<th>�̸���</th>
 	<th>�ּ�</th>
 	<th>��ȭ��ȣ</th>
 	<th>��й�ȣ</th>
 </tr>
 <c:forEach var="member" items="${MEMBER_LIST}">


   <a href="/bookchange/MemberService?method=viewMemberList&email=${member.email}">
	 </a>

 	<tr> 
 	  <th>${member.email}</th>	
 	  <th>${member.address}</th> 	  
	  <th>${member.tel}</th>
	  <th>${member.pw}</th>
	</tr>
	
  </c:forEach>
  
	</table>
<p align="center">
		${PAGE_LINK_TAG }
		</p>
	<p align="center">
		<a href="/bookchange/member/loginafter.jsp">�α���ȭ������</a>
	</p>
	
</body>
</html>