<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%@ page import="kr.or.kosta.auction.member.Member" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>��� ��ȸ</h1>
	<%
		Member member=
		         (Member)request.getAttribute("MEMBER");
	%>
	<table border="1" align="center">
	  <tr>
	  <td>���̵�</td><td><%=member.getUserid() %></td>
	  </tr>
	  <tr>
	  <td>��й�ȣ</td><td><%=member.getPw() %></td>
	  </tr>
	  <tr>
	  <td>����</td><td><%=member.getEmail() %></td>
	  </tr>
	  <tr>
	  <td>�̸�</td><td><%=member.getName() %></td>
	  </tr>
	  <tr>
	  <td>����</td><td><%=member.getCoin() %></td>
	  </tr>
	  <tr>
	  <td>E�Ӵ�</td><td><%=member.getEmoney() %></td>
	  </tr>
	  </table>
	  <p align="center">
	    <a href="/auction/MemberService?method=editMemberForm&userid=<%=member.getUserid() %>">
	    �������
	    </a>
	  </p>
	  <p align="center">
	    <a href="/auction/MemberService?method=remove&userid=<%=member.getUserid() %>">
	    �������
	    </a>
	  </p>
</body>
</html>