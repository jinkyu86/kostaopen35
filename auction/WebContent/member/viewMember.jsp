<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>ȸ�� ��ȸ</h1>
	<table border="1" align="center">
	  <tr>
	  <td>���̵�</td><td>${MEMBER.userid}</td>
	  </tr>
	  <tr>
	  <td>��й�ȣ</td><td>${MEMBER.pw}</td>
	  </tr>
	  <tr>
	  <td>����</td><td>${MEMBER.email}</td>
	  </tr>
	  <tr>
	  <td>�̸�</td><td>${MEMBER.name}</td>
	  </tr>
	  <tr>
	  <td>����</td><td>${MEMBER.coin}</td>
	  </tr>
	  <tr>
	  <td>E�Ӵ�</td><td>${MEMBER.emoney}</td>
	  </tr>
	  
	  </table>
	  <p align="center">
	    <a href="/auction/MemberService?method=editMemberForm&userid=${MEMBER.userid}">
	    ȸ������
	    </a>
	  </p>
	  <p align="center">
	    <a href="/auction/MemberService?method=remove&userid=${MEMBER.userid}">
	   ȸ������
	    </a>
	  </p>
</body>
</html>