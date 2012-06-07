<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<html lang="en">
<head>
<title>게시물 조회</title>
<link rel="stylesheet" href="styles.css" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<script type="text/javascript">
 <c:if test="${SUCCESS!=null}">
 alert("${SUCCESS}");
</c:if>
</script>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script>
	$(document).ready(function(){
		
		$("#deleteboard").click(function (event){
			var result=confirm("정말 삭제하시겠습니까?");
		
			if(result==false){
				event.preventDefault();
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
		<body>
	<h1 align="center">게시물 조회</h1>
	<table  align="center"  border="1" bgcolor="pink">
	  <tr>
	  <td>번호</td><td>${BOARD.bNum}</td>
	  </tr>
	  <tr>
	  <td>아이디</td><td>${BOARD.member.userid}</td>
	  </tr>
	  <tr>
	  <td>제목</td><td>${BOARD.title}</td>
	  </tr>
	  <tr>
	  <td>내용</td><td>${BOARD.content}</td>
	  </tr>
	  </table>
<c:if test="${sessionScope.MEMBER.userid==BOARD.member.userid||sessionScope.MEMBER.userid=='admin'}">
	  <p align="center">
	    <a href="/auction/editBoardForm.action?bnum=${BOARD.bNum }">
		<img src="/auction/menu/editBoard.jpg"/>
	    </a>
	  </p>
	  <p align="center">
	    <a href="/auction/removeBoard.action?bnum=${BOARD.bNum }" id="deleteboard">
		<img src="/auction/menu/deleteBoard.jpg"/>
	    </a>
	  </p>
</c:if>
<p align="center">
	<a href="/auction/viewBoardList.action">
	<img src="/auction/menu/viewBoardList.jpg"/>
	</a>
</p>
		</p>
	</section>			
</body>
</html>