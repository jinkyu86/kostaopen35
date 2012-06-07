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
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script>
$(document).ready(function(){
	$('#my_form').validate({
		rules:{
			title:{
				required:true,
				minlength:1
			},
			content:{
				required:true,
				minlength:1
			}
		},
		messages:{
			title:{
				required:"제목을 입력하세요."
			},//end title
			content:{
				required:"내용을 입력하세요.",
			}//end content
		}
	});
});
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
								href="/auction/logout.action"> <font color=black>로그
									아웃</font>
							</a> <br /> <a href="/auction/viewMember.action"> <font
								color=black>회원 정보</font>
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
			<body>
				<hr noshade>
				<h1 align="center">게시물 작성</h1>
				<form name="login_form" action="/auction/addBoard.action"
					method="post" id="my_form">
					<table align="center" border="1" bgcolor="pink">
						<tr>
							<td>작성자 ID:</td>
							<td><input type="text" size=30 name="userid"
								value="${sessionScope.MEMBER.userid }" readOnly="readonly"></td>
						</tr>
						<tr>
							<td>제목:</td>
							<td><input type="text" size=50 name="title"></td>
						</tr>
						<tr>
							<td>내용:</td>
							<td><textarea name="content" cols=50 rows=10 wrap="hard"></textarea></td>
						</tr>
						<hr noshade>
					</table>
					<center>
						<input type="submit" value="게시물추가"> <input type="reset"
							value="취소">
					</center>
				</form>
		</p>
	</section>
</body>
</html>