<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kr.or.kosta.auction.member.Member" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ�� ����Ʈ</title>
</head>
<body>
<table border="1" align="center">
	<tr>
		<th>ȸ��</th>
		<th>��й�ȣ</th>
		<th>�̸���</th>
		<th>�̸�</th>
		<th>����</th>
		<th>E�Ӵ�</th>
	</tr>
	<% 
		ArrayList<Member> memberList=(ArrayList)request.getAttribute("MEMBER_LIST");
		for(int i=0;i<memberList.size();i++){
			Member member=memberList.get(i);
	%>	
	<tr>
		<td><%=member.getUserid() %></td>
		<td>
			<a href="/auction/MemberService?method=viewMember&userid=<%=member.getUserid() %>">
		   	</a>
		  </td>
		</tr>
	<%} %>
</table>
<p align="center">
	<a href="/auction/MemberService?method=addMemberForm">ȸ���߰�</a>
</p>
</body>
</html>
