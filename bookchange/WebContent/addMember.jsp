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
	<td height="60"></td>
	</tr>

	<tr>
	<td>
		<table cellpadding="0" cellspacing="0" border="0">
		<tr align="right">
			<td width="25"></td>
			<td><a href="main.jsp"><img src="webimg/home.gif" border="0"/></a></td>
			<td><a href="/bookchange/BoardService?method=viewBoardList"><img src="webimg/board.GIF" border="0"/></a></td>
		<c:choose>
		<c:when test="${sessionScope.LOGIN_EMAIL==null}">	
			<td><a href="/bookchange/BoardService?method=addBoardForm"><img src="webimg/join.GIF" border="0"/></a></td>
			<td><a href="/bookchange/MemberService?method=viewMember"><img src="webimg/myinfo.GIF" border="0"/></a></td>
		</c:when>
		<c:otherwise>
			<td><a href="/bookchange/BoardService?method=addBoardForm"><img src="webimg/join.GIF" border="0"/></a></td>
			<td><a href="/bookchange/MemberService?method=viewMember"><img src="webimg/myinfo.GIF" border="0"/></a></td>
		</c:otherwise>
		</c:choose>
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
	<table cellpadding="0" cellspacing="0" border="0">
	 <tr>
	 <td width="220" height="600" valign="top" bgcolor="#F8F8F8">
	 <table cellpadding="0" cellspacing="0" border="0">
	 <!--로그인-->
	  <tr>
	  <td>		
	   <c:choose>
	    <c:when test="${sessionScope.LOGIN_EMAIL==null}">
	     <fieldset>
	     <table align="left" cellpadding="0" cellspacing="0" border="0">
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
		 <tr>
		 <td><div align="right">
		 <form action="/bookchange/MemberService" method="post">
	  	 <input type="hidden" name="method" value="addMemberForm">
	  	  <input type="submit" value="회원가입"/>
	  	 </form></div></td>
		 <td><div align="right">
		 <form action="/bookchange/MemberService" method="post">
	  	 <input type="hidden" name="method" value="">
	  	   <input type="submit" value="Email/Pw찾기"/>
	  	 </form></div></td>
		 </tr>
	     </table>
	     </fieldset>
	    </c:when>
	   <c:otherwise>
	    <fieldset>
	 	<table align="left" cellpadding="0" cellspacing="0" border="0">
	    <form action="/bookchange/MemberService" method="post">
		<input type="hidden"name="method" value="logout">
		<tr>
		 <td>${sessionScope.LOGIN_EMAIL.email}님이 로그인하셨습니다.</td>
		</tr>
		<tr>
		 <td colspan="5"><div align="right">
		 <input type="submit" value="로그아웃">
		 </div></td>
		</tr>
		</form>
		<tr>
		 <td><div align="right">
		 <form action="/bookchange/MemberService" method="post">
	  	 <input type="hidden" name="method" value="removeMemberForm">
	  	  <input type="submit" value="회원탈퇴"/>
	  	 </form></div></td>
		 <td><div align="right">
		 <form action="/bookchange/MemberService" method="post">
	  	 <input type="hidden" name="method" value="editMemberForm">
	  	   <input type="submit" value="정보수정"/>
	  	 </form>
		 </div></td>
		</tr>
	    </table>
	    </fieldset>
	   </c:otherwise>
	  </c:choose>
	</td>
	</tr>
	<tr>
	 <table cellpadding="0" cellspacing="0" border="0">
	   <tr>
	   <td><a href="">
	   <img align="right" src="webimg/block.GIF" title="신고하기" border="0" width="230"/></a></td>
	   </tr>
	 </table>
	 </tr>
	 <td width="550" height="600" valign="top" bgcolor="#FFFFFF">
	 <fieldset>
	 <li><div class="txt01"><h4 align="center">회원가입</h4></div></li>
	 </fieldset>
	 <fieldset>
	  <form action="/bookchange/MemberService"method="post">
		<input type="hidden" name="method" value="addMember">
	 	<ul><li><div> 이메일</div><input type="text"name="email"/>(이메일 주소를 정확히 입력)</li></ul>
		<ul><li><div> 비밀번호</div><input type="text"name="pw"/>(영어,숫자를 4자리 이상 입력)</li></ul>
		<ul><li><div> 주소</div><input type="text"name="address" size="50"/></li></ul>
		<ul><li><div> 핸드폰번호</div><input type="text"name="tel"/>(ex : XXX-XXXX-XXXX)</li></ul>
		<ul><input type="submit" value="가입"/><a href="main.jsp"><button>가입취소</button></a></ul>				
		</tr>
		</form>
	 </fieldset>
	 </td>
	</table>
   </td>
  </tr>
 </table>
 </td>
 </tr>
</body>
</html>