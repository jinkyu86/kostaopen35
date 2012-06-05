<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<html lang="en">
<head>
<title>editGood</title>
<link rel="stylesheet" href="styles.css" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<script type="text/javascript">
 <c:if test="${SUCCESS!=null}">
 alert("${SUCCESS}");
</c:if>
</script>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script>
$(document).ready(function(){
	$('#my_form').validate({
		rules:{
			gName:{
				required:true,
				minlength:1
			},
			detail:{
				required:true,
				minlength:1
			},
			img:{
				required:true,
				minlength:1
			}
		},
		messages:{
			gName:{
				required: "제품명을 입력하세요."
			},//end name
			detail:{
				required:"상세설명을 입력하세요."
			},//end detail
			img:{
				required:"사진파일명을 입력하세요. EX)s1.jpg",
			}//end price
		}
	});
});
</script>
</head>
<body>

	<ul>
		<header>
			<p>
				<font color="black" style="font-size: 27px">경매사이트</font>
			</p>

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