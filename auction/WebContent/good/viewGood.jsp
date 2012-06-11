<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>jQuery Mobile</title>
<meta charset="euc-kr" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, 
							maximum-scale=1.0, minimum-scale=1.0, 
							user-scalable=no" />

<link rel="shortcut icon" href="../image/icon.png">
<link rel="apple-touch-icon" href="../image/icon.png">


<link href="http://code.jquery.com/mobile/latest/jquery.mobile.min.css"
	rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
<script src="http://code.jquery.com/mobile/latest/jquery.mobile.min.js"></script>

<!--
		<link href="../framework/jquery.mobile-1.0.css" 
			rel="stylesheet" type="text/css" />
		<script src="../framework/jquery-1.6.4.js"></script>
		<script src="../framework/jquery.mobile-1.0.js"></script>
		-->
</script>
<body>
	<div data-role="page">
		<div data-role="content">
			<form id="my_form" method="post" action="/auction/editGood.action">
				
				<div data-role="fieldcontain">
					<label for="gnum">물품 번호</label>
					<input id="gnum" type="text" name="gnum" value="${GOOD.gNum}" readonly="readonly"/>
				</div>
				<div data-role="fieldcontain">
					<label for="gname">물품명:</label>
					<input id="gname" type="text" name="gname" value="${GOOD.gName}"/>
				</div>
				<div data-role="fieldcontain">
					<label for="detail">상세설명:</label>
					<textarea id="detail" name="detail">${GOOD.detail }</textarea>
				</div>
				<div data-role="fieldcontain">
					<label for="img">이미지:</label>
					<input id="img" type="text" name="img" value="${GOOD.img }"/>
				</div>
				<div data-role="fieldcontain">
					<input id="submit" type="submit" value="전송"/>
					<input id="reset" type="reset" value="취소"/>
				</div>
			</form>
		</div>
	</div>
	<ul>
		<header>
			<h1>경매사이트</h1>

			<ui>
			<li><c:choose>
					<c:when test="${sessionScope.MEMBER==null}">
						<p align="right">
							<a href="/auction/loginForm.action"> <font color=black>로그인</font>
							</a>
							<br/>
							 <a href="/auction/addMemberForm.action"> <font color=black>회원가입</font>
							</a>
						</p>
					</c:when>
					<c:otherwise>
						<p align="right">
							${sessionScope.MEMBER.name }님 안녕
							<br/> 
							<a href="/auction/logout.action"> 
							<font color=black>로그 아웃</font>
							</a>
							<br/>
							<a href="/auction/viewMember.action"> 
							<font color=black>회원 정보</font>
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
				</a>
				
					
						<c:if test="${sessionScope.MEMBER.userid=='admin'}">
							<li><a href="/auction/viewGoodList.action"> <font color=white>물품
									관리 목록 보기</font>
							</a></li>
							<li><a href="/auction/viewMemberList.action"> <font color=white>회원
									목록 보기</font>
							</a></li>
						</c:if>
						<li><a href="/auction/viewBoardList.action"> <font color=white>게시물
								목록 보기</font>
						</a></li>
					
				
			</ul>
		</div>
	</nav>
	<!-- end of top nav -->

	<section id="content">
		<p align="center">
		<h1 align="center">물품 정보 수정</h1>
	<form action="/auction/editGood.action" method="post" id="my_form">
				<table border="1" align="center">
					<tr>
						<td>물품 번호</td>
						<td><input type="text" name="gnum" value="${GOOD.gNum}" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>물품명</td>
						<td><input type="text" name="gname" value="${GOOD.gName}" /></td>
					</tr>
					<tr>
						<td>상세설명</td>
						<td><textarea name="detail" >${GOOD.detail}</textarea></td>
					</tr>
					<tr>
						<td>이미지</td>
						<td><input text="text" name="img" value="${GOOD.img}"/></td>
					</tr>
			</table>
		<center>
			<input type="submit" value="물건 정보 수정"/>
			<input type="reset" value="입력취소"/>
		</center>
	</form>
<p align="center">
	<a href="/auction/viewGoodList.action">
	    <img src="/auction/menu/viewGoodList.jpg"/>
	</a>
</p>
		</p>
	</section>			
</body>
</html>