<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
		<a href="/bookchange/ChangeService?method=viewChange">교환내역보기</a>
		</td>
	</tr>
	<tr>
		<td align="center">
		<a href="/bookchange/MemberService?method=editMemberForm">회원정보수정</a>
		</td>
	</tr>
	<tr>
		<td align="center">
			<a href="/bookchange/MemberService?method=removeMember&email=${sessionScope.LOGIN_EMAIL.email}">회원탈퇴</a>
			
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
	</table>
</body>
</html>