<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 리스트</title>


<title>AUCTION</title>
<link rel="stylesheet" href="styles.css" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<script type="text/javascript">
 <c:if test="${SUCCESS!=null}">
 alert("${SUCCESS}");
</c:if>
</script>
</head>
<body>

	<ul>
		<header>
		<h1>경매사이트</h1>

		<ui>
		<li><c:choose>
				<c:when test="${sessionScope.MEMBER==null}">
					<p align="right">
						<a href="/auction/loginForm.action"> <font color=black>로그인</font>
						</a> <br /> <a href="/auction/addMemberForm.action"> <font
							color=black>회원가입</font>
						</a>
					</p>
				</c:when>
				<c:otherwise>
					<p align="right">
						${sessionScope.MEMBER.name }님 안녕 <br /> <a
							href="/auction/logout.action"> <font color=black>로그 아웃</font>
						</a> <br /> <a href="/auction/viewMember.action"> <font
							color=black>회원 정보</font>
						</a>
					</p>
				</c:otherwise>
			</c:choose></li>
		</ui> </header>
	</ul>
	<nav> <!-- top nav -->
	<div class="menu">
		<ul>
			<li><a href="/auction/home.jsp">홈</a></li>
			<li><a href="/auction/viewAuctionList.action"> <font
					color=white>경매 보기</font>
			</a> <c:if test="${sessionScope.MEMBER.userid=='admin'}">
					<li><a href="/auction/viewGoodList.action"> <font
							color=white>물품 관리 목록 보기</font>
					</a></li>
					<li><a href="/auction/viewMemberList.action"> <font
							color=white>회원 목록 보기</font>
					</a></li>
				</c:if>
			<li><a href="/auction/viewBoardList.action"> <font
					color=white>게시물 목록 보기</font>
			</a></li>


		</ul>
	</div>
	</nav>
	<!-- end of top nav -->

	<section id="content">
	<p align="center">
	<table border="1" align="center">
		<tr>
			<th>회원아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>이름</th>
			<th>코인</th>
			<th>E머니</th>
			<th>회원정보 수정</th>
			<th>회원삭제</th>
		</tr>
		<c:forEach var="member" items="${MEMBER_LIST}">
			<tr>
				<form action="/auction/viewMemberList.action" method="post">

					<td><input type="text" name="userid" value="${member.userid}"
						readOnly="readOnly" /></label></td>
					<td><input type="password" name="pw" value="${member.pw}" /></td>
					<td><input type="text" name="email" value="${member.email}" /></td>
					<td><input type="text" name="name" value="${member.name}" /></td>
					<td><input type="text" name="coin" value="${member.coin}" /></td>
					<td><input type="text" name="emoney" value="${member.emoney}" /></td>
					<td><input type="submit" value="회원정보 수정" /> <input
						type="reset" value="취소" /></td>
					<td><a
						href="/auction/removeMember.action?userid=${member.userid }">
							<img src="/auction/menu/delete.jpg" />
					</a></td>
			</tr>
			</form>
		</c:forEach>
	</table>

	</section>
</body>
</html>







