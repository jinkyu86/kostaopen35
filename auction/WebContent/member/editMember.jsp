<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					value="${MEMBER.userid}" readOnly="readOnly" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"
					value="${MEMBER.pw}" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"
					value="${MEMBER.email}"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"
					value="${MEMBER.name}"/></td>
			</tr>
			<c:choose>
				<c:when test="${sessionScope.MEMBER.userid=='admin'}">
					<tr>
						<td>코인</td>
						<td><input type="text" name="coin"
							value="${MEMBER.coin}" /></td>
							
					</tr>
					<tr>
						<td>E머니</td>
						<td><input type="text" name="emoney"
							value="${MEMBER.emoney}" /></td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td>코인</td>
						<td><input type="text" name="coin"
							value="${MEMBER.coin}" readOnly="readOnly"/></td>
							
					</tr>
					<tr>
						<td>E머니</td>
						<td><input type="text" name="emoney"
							value="${MEMBER.emoney}" readOnly="readOnly"/></td>
					</tr>
				</c:otherwise>
			</c:choose>
			<tr>
				<td><input type="submit" value="회원수정" /></td>
				<td><input type="reset" value="입력취소" /></td>
			</tr>
		</form>
	</table>
</body>
</html>