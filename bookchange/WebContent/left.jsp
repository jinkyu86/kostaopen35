<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>도서물물 교환</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script type="text/javascript">
	<c:if test="${ERROR!=null}">
	alert("${ERROR}");
	</c:if>
</script>
</head>
<body>
  <table cellpadding="0" cellspacing="0" border="0">
	 <!--로그인-->
	  <tr>
	  <td>		
	   <c:choose>
	    <c:when test="${sessionScope.LOGIN_EMAIL==null}">
	     <fieldset>
	     <table align="left" cellpadding="0" cellspacing="0" border="0">
	     <form action="/bookchange/login.action" method="post">

		 <tr>
		 <td>Email</td>
		 <td><input type="text" name="email"></td>
		 </tr>
		 <tr>
		 <td>Password</td>
		 <td><input type="password" name="pw"></td>
		 </tr>
		 <tr>
		 <td colspan="2" align="center">
		 <input type="submit" value="로그인">
		 </td>
		 </tr>
		 </form>
		 <tr>
		 <td><div align="left">
		 <form action="/bookchange/addMemberForm.action" method="post" target="main">
	  	  <input type="submit" value="회원가입"/>
	  	 </form></div></td>
		 <td><div align="left">
		 <form action="/bookchange/viewMemberPwAndEmail.action" method="post" target="main">
	  	
	  	   <input type="submit" value="Email/Pw찾기"/>
	  	 </form></div></td>
		 </tr>
		 </table>
	     </fieldset>
	    </c:when>
	   <c:otherwise>
	    <fieldset>
	 	<table cellpadding="0" cellspacing="0" border="0">
	    <form action="/bookchange/logout.action" method="post" target="index.jsp">
		<tr>
		 <td>${sessionScope.LOGIN_EMAIL.email}님이 로그인하였습니다.</td>
		</tr>
		<tr>
		 <td colspan="5"><div align="right">
		 <input type="submit" value="로그아웃">
		 </div></td>
		</tr>
		</form>
		<tr>
		 <td><div align="right">
		 <form action="/bookchange/removeMemberForm.action" method="post" target="main">
	  	
	  	  <input type="submit" value="회원탈퇴"/>
	  	 </form></div></td>
		 <td><div align="right">
		 <form action="/bookchange/editMemberForm.action" method="post" target="main">	  	 
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
	   <c:choose>
	   	<c:when test="${sessionScope.LOGIN_EMAIL!=null}">
	   	 <tr>
	   <td><a href="/bookchange/BlockService?method=addBlockForm" target="main">
	   <img align="right" src="webimg/block.GIF" title="신고하기" border="0" width="150"/></a></td>
	   </tr>
	   
   <tr>
	   <td>
	   <form action="/bookchange/searchBoardList.action" method="post" target="main">
	   <input type="hidden" name="categoryNo">
	   <input type="hidden" name="column" value="email">
	   <input type="hidden" name="keyword" value="${sessionScope.LOGIN_EMAIL.email}">
	   <input type="submit" value=" 등록한 책 목록 "></td>
	   </form>
	   </tr>	
	   
	   <tr>
		<td height="10"></td>
		</tr>  
	   
	   <tr>
	   <td>
	   <form action="/bookchange/requestChangeList.action" method="post" target="main">
	   <input type="submit" value="요청한 교환신청"></td>
	   </form>	   
	   </tr>
	   
	   <tr>
		<td height="10"></td>
		</tr>
	   
	   <tr>
	   <td>
	   <form action="/bookchange/acceptChangeList.action" method="post" target="main">
	   <input type="submit" value="들어온 교환신청"></td>
	   </form>	   
	   </tr>
	   
	   <tr>
		<td height="10"></td>
		</tr>
	   
	   <tr>
	   <td>
	   <form action="/bookchange/matchChangeList.action" method="post" target="main">
	   <input type="submit" value="교환진행중인 책 목록"></td>
	   </form>	   
	   </tr>
	   
	   <tr>
		<td height="10"></td>
		</tr>
	   
	   <tr>
	   <td>
	   <form action="/bookchange/matchChangeResultList.action" method="post" target="main">
	   <input type="submit" value="교환완료된 책 목록"></td>
	   </form>	   
	   </tr>
	   
	      <tr>
		<td height="10"></td>
		</tr>
		
	   <tr>
    <td>
    <form action="/bookchange/BlockService" method="post" target="main">
      <input type="hidden" name="method" value="selectMyBlockList">
      <input type="submit" value="신고내역보러가기">
    </form>
    </td>
    </tr>  
	   
	    </c:when>
		<%-- <c:otherwise>
		  <tr>
	      <td><a href="">
	      <img align="right" src="webimg/block.GIF" title="신고하기" border="0" width="230"/></a></td>
	      </tr>
		</c:otherwise> --%>
	   </c:choose>
	 </table>
</body>
</html>