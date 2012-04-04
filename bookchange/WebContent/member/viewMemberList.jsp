<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>멤버 리스트</title>
</head>
<body>
<h1 align="center">전체 맴버 리스트</h1>
	<table border="2" align="left">		 
	<form action="/bookchange/MemberService" method="post">
	  <input type="hidden" name="method" value="searchMemberList">
     <select name="email">
     	<option value="email">이메일</option>
     </select>
		<input type="text" name="keyword">
		<br/>
		<input type="submit" value="검색">
	</form>
</table>	
 <table border="1" align="center">
 <tr>
 	<th>이메일</th>
 	<th>주소</th>
 	<th>전화번호</th>
 	<th>비밀번호</th>
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
		<a href="/bookchange/member/loginafter.jsp">로그인화면으로</a>
	</p>
	
</body>
</html>