<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<html lang="en">
<head>
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
							${sessionScope.MEMBER.name }님 안녕<br /> <a
								href="/auction/logout.action"> <font color=black>로그아웃</font>
							</a></br> <a href="/auction/viewMember.action"> <font color=black>회원정보</font>
							</a>
						</p>
					</c:otherwise>
				</c:choose></li>
			</ui>
		</header>
	</ul>
	<nav>
		<!-- top nav -->
		<div class="menu">
			<ul>
				<li><a href="/auction/home.jsp">홈</a></li>
				<li><a href="/auction/viewAuctionList.action"> <font
						color=white>경매 보기</font>
				</a></li>
				<c:if test="${sessionScope.MEMBER.userid=='admin'}">
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
		<table align="center">
			<form action="/auction/login.action" method="post">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" /></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="로그인" /></td>
					<td align="char"><input type="reset" value="취소" /></td>
				</tr>
			</form>
		</table>
		</p>
	</section>
</body>
</html>



