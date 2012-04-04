<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>도서물물 교환</title>
<script src="http//code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script type="text/javascript">
	<c:if test="${ERROR!=null}">
	alert("${ERROR}");
	</c:if>
</script>
</head>
<body topmargin="0" leftmargin="0" bgcolor="#FFFFFF">
	<table width="880" align="center" cellpadding="0" cellspacing="0" border="0">
	<tr>
	<td height="20"></td>
	</tr>
	</table>
	
	<tr>
	<td height="10"></td>
	</tr>

	<tr>
	<td>
		<table align="center" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td width="25"></td>
			<td><a href="main.jsp"><img src="webimg/home.gif" border="0"/></a></td>
			<td><a href="/bookchange/BoardService?method=viewBoardList"><img src="webimg/board.GIF" border="0"/></a></td>
			<td><a href="/bookchange/BoardService?method=addBoardForm"><img src="webimg/join.GIF" border="0"/></a></td>
			<td><a href="/"><img src="webimg/myinfo.GIF" border="0"/></a></td>
			<td width="25"></td>
		</tr>
		</table>
	</td>
	</tr>
	
	<tr>
	<td height="10"></td>
	</tr>

	<tr>
	<td>
	<table width="220" cellpadding="0" cellspacing="0" border="0" bgcolor="#F8F8F8">
		<tr>
		<td>
		<c:choose>
		 <c:when test="${sessionScope.LOGIN_EMAIL==null}">
		  <fieldset>
		  <table cellpadding="0" cellspacing="0" border="0">
		    <form action="/bookchange/MemberService" method="post">
			<input type="hidden"name="method" value="login">
			<tr>
			 <td>Email</td>
			 <td><input type="text" name="email"></td>
			</tr>
			<tr>
			 <td>Password</td>
			 <td><input type="password" name="pw"></td>
			</tr>
			<tr>
			 <td colspan="5"><div align="right">
			 <input type="submit" value="로그인">
			 </div></td>
			</tr>
			</form>
			<td colspan="5"><div align="right">
			 <a href="/bookchange/MemberService?method=addMemberForm"><button>회원가입</button></a>
			 <a href="/bookchange/MemberService?method="><button>Email/Pw찾기</button></a>
			</div></td>
		  </table>
		  </fieldset>
		 </c:when>
		 <c:otherwise>
		  <fieldset>
		 	<table cellpadding="0" cellspacing="0" border="0">
		    <form action="/bookchange/MemberService" method="post">
			<input type="hidden"name="method" value="logout">
			<tr>
				<td>${sessionScope.LOGIN_EMAIL.email}님 로그인..</td>
			</tr>
			<tr>
			 <td colspan="5"><div align="right">
			 <input type="submit" value="로그아웃">
			 </div></td>
			</tr>
			</form>
			<tr>
			 <td><div align="right">
			  <a href="/bookchange/MemberService?method=removeMemberForm"><button>회원탈퇴</button></a>
			 </div></td>
			</tr>
		  </table>
		  </fieldset>
		 </c:otherwise>
		</c:choose>
		</td>
		</tr>
	</table>
</body>
</html>