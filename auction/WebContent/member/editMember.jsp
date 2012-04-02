<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.or.kosta.auction.member.Member"%>
<%@ page import="java.util.ArrayList"%>
<%
	Member member = (Member) request.getAttribute("MEMBER");

	ArrayList<Member> memberList = (ArrayList) request
			.getAttribute("MEMBER_LIST");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 수정</title>
</head>
<body>
	<h1 align="center">회원수정</h1>
	<table align="center">
		<form action="/auction/MemberService" method="post">
			<input type="hidden" name="method" value="editMember" />
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid"
					value="<%=member.getUserid()%> " readOnly="readOnly" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"
					value="<%=member.getPw()%>" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"
					value="<%=member.getEmail()%>"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"
					value="<%=member.getName()%>" /></td>
			</tr>
			<tr>
				<td>코인</td>
				<td><input type="text" name="coin"
					value="<%=member.getCoin()%>" /></td>
			</tr>
			<tr>
				<td>E머니</td>
				<td><input type="text" name="emoney"
					value="<%=member.getEmoney()%>" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="회원수정" /></td>
				<td><input type="reset" value="입력취소" /></td>
			</tr>
		</form>
	</table>
</body>
</html>