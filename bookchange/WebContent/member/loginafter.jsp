<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인페이지</title>
</head>
<body>
	<table align="center">
	<tr>
		<td align="center">
			<a href="/bookchange/BoardService?method=viewBoardList">게시물보기</a>
		</td>
	</tr>
	<tr>
		<td align="center">
			<a href="/bookchange/MemberService?method=editMemberForm">회원정보수정</a>
		</td>
	</tr>
	<tr>
		<td align="center">
			<a href="/bookchange/MemberService?method=PwInMember&email=${sessionScope.LOGIN_EMAIL.email}">회원탈퇴</a>
		</td>
	</tr>
	<tr>
		<td align="center">
			<a href="/bookchange/MemberService?method=logout">로그아웃</a>
		</td>
	</tr>
	<tr>
		<td align="center">
			<a href="/bookchange/MemberService?method=viewMember&email=${sessionScope.LOGIN_EMAIL.email}">회원정보보기</a>
		</td>
	</tr>
	
	<tr>
		<td align="center">
			<a href="/bookchange/BlockService?method=addBlock">신고합니다!!</a>
		</td>
	</tr>

	<tr>
		<td align="center">
			<a href="/bookchange/BlockService?method=searchBlockList">관리자용신고처리공간</a>
		</td>
	</tr>
	</table>
		<p align="center">
			<a href="/bookchange/ChangeService?method=acceptChangeList">나와 교환을 원하는 책 보기</a>
		</p>
		<p align="center">
			<a href="/bookchange/ChangeService?method=requestChangeList">내가 교환을 원하는 책 보기</a>
	   	</p>
	<c:choose>
	<c:when test="${sessionScope.LOGIN_EMAIL.email eq 'kimbyonsam@nate.com' }"><%--관리자용 매뉴 --%>
		<p align="center">
		   	<a href="/bookchange/MemberService?method=viewMemberList">
			 	관리자 전용 전체회원정보보기
	  	</a>
  	</p>
		<p align="center">
			<a href="/bookchange/MemberService?method=removeMember&email=${sessionScope.LOGIN_EMAIL.email}">관리자용 회원탈퇴</a>
		</p>
	  	
  	
  </c:when>
  	</c:choose>
</body>
</html>