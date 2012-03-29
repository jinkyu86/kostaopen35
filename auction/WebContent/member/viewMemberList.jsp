<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kr.or.kosta.auction.member.Member" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 리스트</title>
</head>
<body>
<table border="1" align="center">
	<tr>
		<th>회원</th>
		<th>비밀번호</th>
		<th>이메일</th>
		<th>이름</th>
		<th>코인</th>
		<th>E머니</th>
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
	<a href="/auction/MemberService?method=addMemberForm">회원추가</a>
</p>
</body>
</html>
