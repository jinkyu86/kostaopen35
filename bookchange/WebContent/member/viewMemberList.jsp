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
<h1 ailgn="center">���</h1>
	
	 <table border="1" align="center">
	 <form action="/member/MemberService"method="post">
		<input type="hidden" name="method" value="viewMemberList">
  <tr>
   <th>�̸���</th>
   <th>�ּ�</th>
   <th>��й�ȣ</th>
   <th>��ȭ��ȣ</th>
  </tr>
 <c:forEach var="member" items="${MEMBER_LIST}">
  <tr>
   <td>${member.getEmail}</td>
   <td>${member.getAddress}</td>
   <td>${member.getPw}</td>
   <td>${member.getTel}</td>
  </tr>
  </c:forEach>
	</table>
</form>
</body>
</html>