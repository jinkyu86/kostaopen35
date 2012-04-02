<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>회원정보수정</title>
</head>
<body>
	<h4 align="center">회원정보수정</h4>
	<table align="center">
	  
	  <form action="/bookchange/MemberService"method="post">
		  <input type="hidden" name="method" value="editMember">
	  		
			    <tr>
				<td>Email</td>
  				<td>${sessionScope.LOGIN_EMAIL.email}</td>
  		
  				
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="text" name="pw"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text"name="address" /></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text"name="tel"/></td>
				</tr>
				<tr>	
					<td colspan="2" align="center">
					<input type="hidden" name="email" value="${sessionScope.LOGIN_EMAIL.email}">
					<input type="submit" value="수정"/>
					</form>					
				</td>
				</tr>
				<tr>				
					<td colspan="2" align="center">
					<a href="/bookchange/member/loginafter.jsp">수정완료</a></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<a href="/bookchange/BoardService?method=viewBoardList">게시물보기</a>
				</td>
			</tr>
			</form>
				
	</table>
</body>
</html>