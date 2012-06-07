<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>addAuction</title>

<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<link rel="stylesheet" href="styles.css" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<c:if test="${SUCCESS!=null}">
 alert("${SUCCESS}");
</c:if>
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#my_form').validate({
			rules : {
				sPrice : {
					required : true,
					minlength : 1
				},
				cuPrice : {
					required : true,
					minlength : 1
				},
				imPrice : {
					required : true,
					minlength : 1,
					digits : true
				},
				sTime : {
					required : true,
					date : true
				},
				eTime : {
					required : true,
					date : true
				},
				sold : {
					required : true,
					minlength : 1,
					max : 1,
					min : 0
				}
			},
			messages : {
				sPrice : {
					required : "시작가를 입력하세요."
				},
				cuPrice : {
					required : "현재가를 입력하세요."
				},
				imPrice : {
					required : "즉구가를 입력하세요.",
					digits : "정수로 입력하세요."
				},
				sTime : {
					required : "'YYYY/MM/DD'형식에 맞게 입력하세요.",
					date : "'YYYY/MM/DD'형식에 맞게 입력하세요."
				},
				eTime : {
					required : "'YYYY/MM/DD'형식에 맞게 입력하세요.",
					date : "'YYYY/MM/DD'형식에 맞게 입력하세요."
				},
				sold : {
					required : "0 또는 1을 입력하세요",
					max : "0 또는 1을 입력하세요 (1 = sold, 0 = sale)",
					min : "0 또는 1을 입력하세요 (1 = sold, 0 = sale)"
				}
			}
		});
		$("#addAuction").click(function(event) {
			var result = confirm("물품 등록을 하시겠습니까?");

			if (result == false) {
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
	<p align="center"><h1 align="center">경매등록</h1>
	<form action="/auction/addAuction.action" method="post" id="my_form">
		<table>
			<tr>
		<td>물품번호</td>
		<td><input type="text" name="gnum" value="${GOOD.gNum}"
					readOnly="readOnly" /></td>
		</tr>
		<tr>
		<td>물품명</td>
		<td><input type="text" name="gname" value="${GOOD.gName}" /></td>
		</tr>
		<tr>
		<td>상세설명</td>
		<td><textarea name="detail">${GOOD.detail}</textarea></td>
		</tr>
		<tr>
		<td>이미지</td>
		<td><img name="img" src="/auction/gphoto/${GOOD.img }"
					height="100" width="100"></td>
		</tr>
		
		<tr>
		<td>시작가</td>
		<td><input type="text" name="sprice" value="10"
					readOnly="readOnly"></td>
		</tr>
		
		<tr>
		<td>현재가격</td>
		<td><input type="text" name="cuprice" value="10"
					readOnly="readOnly"></td>
		</tr>
		
		<tr>
		<td>즉구가</td>
		<td><input type="text" name="imprice"></td>
		</tr>
			
		<tr>
		<td>경매시작시간</td>
		<td><input type="text" name="stime"></td>
		</tr>
		
		<tr>
		<td>경매마감시간</td>
		<td><input type="text" name="etime"></td>
		</tr>
		
		<tr>
		<td>판매여부</td>
		<td><input type="text" name="sold"></td>
		</tr>
		
		
		<tr>
			<td><input type="submit" value="경매등록" id="addAuction" /></td>
			<td><input type="reset" value="취소" /></td>
		</tr>
	</table>
  
</form>
</p>
	
	</section>			
</body>
</html>
	





