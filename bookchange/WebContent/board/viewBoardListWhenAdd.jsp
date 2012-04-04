<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>교환을 원하는 물건을 선택해주세요</title>
<script type="text/javascript">
<c:if test="${ERROR!=null}">
	alert("${ERROR}");
</c:if>
</script>
</head>
<body>
<c:choose>
  <c:when test="${sessionScope.LOGIN_EMAIL==null}">
	 <p align="right">
   		<a href="/bookchange/MemberService?method=loginForm">
   		로그인
   		</a>
	 </p>
  </c:when>
  <c:otherwise>
  <p align="right">
 	${sessionScope.LOGIN_EMAIL.email}님<br/>
   	<a href="/bookchange/MemberService?method=logout">
   	로그아웃
   	</a><br/>
   </c:otherwise>
 </c:choose>
 
<h1 align="center">교환 신청할 물건</h1>
	<table border="3" align="center">
		 <tr>
		  <th>번호</th>
		  <th>사진</th>
		  <th>올린사람</th>
		  <th>제목</th>
		  <th>교환상태</th>
		 </tr>
	      <tr>
	       <td>${BOARD.boardNo}</td>
	       <td><img src="/bookchange/bookimg/${BOARD.boardPhoto}" height="50" width="40"></td>
	       <td>${BOARD.member.email}</td>
	       <td>${BOARD.boardTitle}</td>
	       <td>${BOARD.condition.conditionIng}</td>
	      </tr>
		 </table>

 
<h1 align="center">교환할 물건 선택</h1>	
	
	 <table border="3" align="center">
	 <tr>
	  <th>번호</th>
	  <th>올린사람</th>
	  <th>사진</th>
	  <th>제목</th>
	  <th>교환상태</th>
	 </tr>
	  <c:forEach var="good" items="${BOARD_LIST}">
      <tr>
       <td>${good.boardNo}</td>
       <td>${good.member.email}</td>
       <td><img src="/bookchange/bookimg/${good.boardPhoto}" height="100" width="80"></td>
       <td><a href="/bookchange/BoardService?method=viewBoard&boardNo=${good.boardNo}">${good.boardTitle}</a></td>
       <td>${good.condition.conditionIng}</td>
       <td>
       	<form action="/bookchange/ChangeService" method="post">
       	<input type="hidden" name="method" value="addChange">
       	<input type="hidden" name="demandBoardNo" value="${good.boardNo}">
       	<input type="hidden" name="agreeBoardNo" value="${BOARD.boardNo}">
       	<input type="submit" value="교환신청">
       	</form>
       	</td>
      </tr>
     </c:forEach>
	 </table>
	
	 <p align="center">  ${PAGE_LINK_TAG} </p>
</body>
</html>