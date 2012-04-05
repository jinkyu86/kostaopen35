<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물 목록</title>
<script type="text/javascript">

<c:if test="${ERROR!=null}">
	alert("${ERROR}");
</c:if>

<c:if test="${DELETE!=null}">
alert("${DELETE}");
</c:if>

<c:if test="${COMPLETE!=null}">
alert("${COMPLETE}");
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
	 	<table cellpadding="0" cellspacing="0" border="0">
	    <form action="/bookchange/MemberService" method="post">
		<input type="hidden"name="method" value="logout">
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
	</td>
	</tr>
	<tr>
	 <table cellpadding="0" cellspacing="0" border="0">
	   <tr>
	   <td><a href="">
	   <img align="right" src="webimg/block.GIF" title="신고하기" border="0" width="230"/></a></td>
	   </tr>
	   
	    <tr>
	   <td>
	   <a href="/bookchange/BoardService?method=searchBoardList&categoryNo=&column=email&keyword=${sessionScope.LOGIN_EMAIL.email}">내가 등록한 책 보기</a>
	   </td>
	   <tr>	  
	   
	   <tr>
	   <td>
	   <a href="/bookchange/ChangeService?method=acceptChangeList">나와 교환을 원하는 책 보기</a>
	   </td>
	   <tr>
	   
	   <tr>
	   <td>
	   <a href="/bookchange/ChangeService?method=requestChangeList">내가 교환을 원하는 책 보기</a>
	   </td>
	   <tr>
	     
	    <tr>
	   <td>
	   <a href="/bookchange/ChangeService?method=matchChangeList">나와 교환 진행중인 책 보기</a>
	   </td>
	   <tr>
	     
	     
	     
	     </c:otherwise>
	  </c:choose>
	   
	   <tr>
	   <td>
	   	
	<table align="left">
	<tr align="left"><th>분야별 찾기</th></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=&column=title&keyword=">전체보기</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=0&column=title&keyword=">만화/잡지</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=1&column=title&keyword=">학습/참고서</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=2&column=title&keyword=">취업/수험서</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=3&column=title&keyword=">컴퓨터/IT</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=4&column=title&keyword=">소설/시/에세이</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=5&column=title&keyword=">가정/생활/요리</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=6&column=title&keyword=">여행/취미/레저</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=7&column=title&keyword=">종교/해외도서</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=8&column=title&keyword=">기타도서</a></td></tr>
	<tr><td align="left"><a href="/bookchange/BoardService?method=searchBoardList&categoryNo=9&column=title&keyword=">유아/아동</a></td></tr>
	</table>
	
	
	   </td>
	   </tr>
	 </table>
	 </tr>
	 <td width="550" height="600" valign="top" bgcolor="#FFFFE0">
	 	 <table bordercolor="#FFA500" border="1" align="center">
	 <tr align="center">
	  <th>번호</th>
	  <th>사진</th>
	  <th>올린사람</th>
	  <th>제목</th>
	  <th>교환상태</th>
	 </tr>
	  <c:forEach var="good" items="${BOARD_LIST}">
      <tr>
       <td align="center">${good.boardNo}</td>
       <td><img src="/bookchange/bookimg/${good.boardPhoto}" height="80" width="80"></td>
       <td align="center">${good.member.email}</td>
       <td align="left"><a href="/bookchange/BoardService?method=viewBoard&boardNo=${good.boardNo}">${good.boardTitle}</a></td>
       <td align="center">${good.condition.conditionIng}</td>
      </tr>
     </c:forEach>
	 </table>
	 
	 <table align="center">
	 <form action="/bookchange/BoardService" method="post">
	  <input type="hidden" name="method" value="searchBoardList">
	  <select name="categoryNo">
	   <option value="">전체</option>
	    <c:forEach var="category" items="${CATEGORY_LIST}">
	    	<c:choose>
	    	<c:when test="${category.categoryNo eq CATEGORY}">	  
		   		 <option value="${category.categoryNo}" selected>${category.categoryName}</option>
			</c:when>
			<c:otherwise>
	    		 <option value="${category.categoryNo}">${category.categoryName}</option>
	    	</c:otherwise>
	    	</c:choose>	   		   			     			     	
		</c:forEach>
	  </select>
	  <select name="column">
	   <option value="title">제목</option>
	   <option value="email">작성자</option>
	  </select>
	  <input type="text" name="keyword">
	  <input type="submit" value="검색"/>
	 </form>
	</table>
	
	 <p align="center">  ${PAGE_LINK_TAG} </p>
	 </td>
	</table>
   </td>
  </tr>
 </table>
 </td>
 </tr>
</body>
</html>