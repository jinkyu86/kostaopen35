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
	<table border="1" align="center">		 
	<form action="/bookchange/MemberService" method="post">
	  <input type="hidden" name="method" value="searchMemberList">
  <tr>
   <th>�̸���</th>
   <th>�ּ�</th>
   <th>��й�ȣ</th>
   <th>��ȭ��ȣ</th>
  </tr>
 <c:forEach var="member" items="${MEMBER_LIST}">
  <tr>
  <td>
  <a href="/bookchange/MemberService?method=viewMemberList&email">
  ${member.email}
  </a>
  </td>
  
  
   <td>${member.address}</td>
  <td> ${member.pw}</td>	
   <td>${member.tel}</td>
  
  </tr>
  </c:forEach>
	</table>
	<p align="center">
	${PAGE_LINK_TAG }
	</p>
	<p align="center">
		<a href="/MemberService?method=searchMemberList&keyword=keyword">�ɹ��˻�</a>
	</p>

</body>
</html>