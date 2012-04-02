<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 조회</h1>
	<table border="1" align="center">
	  <tr>
	  <td>아이디</td><td>${MEMBER.userid}</td>
	  </tr>
	  <tr>
	  <td>비밀번호</td><td>${MEMBER.pw}</td>
	  </tr>
	  <tr>
	  <td>메일</td><td>${MEMBER.email}</td>
	  </tr>
	  <tr>
	  <td>이름</td><td>${MEMBER.name}</td>
	  </tr>
	  <tr>
	  <td>코인</td><td>${MEMBER.coin}</td>
	  </tr>
	  <tr>
	  <td>E머니</td><td>${MEMBER.emoney}</td>
	  </tr>
	  
	  </table>
	  <p align="center">
	    <a href="/auction/MemberService?method=editMemberForm&userid=${MEMBER.userid}">
	    회원수정
	    </a>
	  </p>
	  <p align="center">
	    <a href="/auction/MemberService?method=remove&userid=${MEMBER.userid}">
	   회원삭제
	    </a>
	  </p>
</body>
</html>