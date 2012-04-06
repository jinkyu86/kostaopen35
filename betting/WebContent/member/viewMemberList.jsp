<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<html lang="en">
<head>
<title>BETTING</title>
<link rel="stylesheet" href="styles.css" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<script type="text/javascript">
 <c:if test="${ERROR!=null}">
  alert("${ERROR}");
 </c:if>
 <c:if test="${SUCCESS!=null}">
 alert("${SUCCESS}");
</c:if>
</script>
</head>
<body>
	<ul>
		<c:choose>
			<c:when test="${sessionScope.LOGIN_MEMBER==null}">
				<div ALIGN="right">
					<a href="/betting/MemberService?method=loginForm" onfocus=blur()><font
						color=black>로그인</font></a>/<a
						href="/betting/MemberService?method=addMemberForm" onfocus=blur()><font
						color=black>회원가입</font></a>
				</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		<header>
			<p>
				<font color="white" style="font-size: 27px">2012 프로야구 베팅</font>
			</p>

			
		</header>
		<nav>
			<!-- top nav -->
			<div class="menu">
				<ul>
							<li><a
						href="/betting/MemberService?method=viewHome">홈</a></li>
					<li><a
						href="/betting/MatchService?method=viewMatchListToVistor">경기
							일정</a></li>
					<li><a href="/betting/BettingService?method=todayBettingList">
							오늘의 베팅 </a></li>
					<li><a
						href="/betting/MemberService?method=viewMemberRankingListForm">랭킹</a>
					</li>


					<c:choose>
						<c:when test="${sessionScope.LOGIN_MEMBER.id=='kosta100'}">
							<li><a href="/betting/MatchService?method=viewMatchList">경기
									관리</a></li>
							<li><a href="/betting/MemberService?method=viewMemberList">멤버
									관리</a></li>
						</c:when>
						<c:otherwise>

						</c:otherwise>
					</c:choose>



				</ul>
			</div>
		</nav>
		<!-- end of top nav -->
		<section id="content">
			<form action="/betting/MemberService" method="post">
		<input type="hidden" name="mehtod" value="editMember" />
		<table border="1" align="center">
			<tr>
				<th>ID</th>
				<td><input type="text"  readOnly="readOnly" name="id" value="${MEMBER.id}" /></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="${MEMBER.name}" /></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="pw" value="${MEMBER.pw}" /></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="text" name="email" value="${MEMBER.email}" />
				</td>
			</tr>
		</table>
		<table border="0" align="center">
			<tr>
				<td><input type="submit" value="회원 정보 변경" /></td>
				<td align="center"><input type="reset" value="리셋" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="/betting/MemberService?method=removeMember&ID=${MEMBER.id}">
				회원탈퇴
				</a></td>
			</tr>
		</table>
	</form>
		</section>
		</li>
	</ul>
	
</body>
</html>