<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${Movie.mname}</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.jsp"></script>
<!-- 메뉴 선택 시작 -->
<script type="text/javascript">
	$(document).ready(function(){
		$('#movie').css('background-color','#C4E2FF');
		$('.sub_menu').css('display', 'block');
		$('#movie_sub').css('display', 'block');
		
		$('#button').click(function(){
			$('#vieMovie').submit();
		});
		$('#reservation').hover(function(){
			//$('#reservation').addClass('hover');
		},function(){
			//$('#reservation').removeClass('hover');
		});
	});
</script>
<c:choose>
	<c:when test="${gubun eq 'screen'}">
		<script type="text/javascript">
			$(document).ready(function(){
				$('#movie_info').css('background-color','#C4E2FF');
				$('#movie_screen').css('background-color','#C4E2FF');
			});
		</script>
	</c:when>
	<c:when test="${gubun eq 'schedule'}">
		<script type="text/javascript">
			$(document).ready(function(){
				$('#movie_info').css('background-color','#C4E2FF');
				$('#movie_schedule').css('background-color','#C4E2FF');
			});
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			$(document).ready(function(){
				$('#movie_info').css('background-color','#C4E2FF');
			});
		</script>
	</c:otherwise>
</c:choose>
</head>
<body>
<table width="90%" align="center">
	<!-- 상단 메뉴 시작 -->
	<tr>
		<td colspan="2">
			<jsp:include page="/common/top.jsp"></jsp:include>
		</td>
	</tr>
	<!-- 상단 메뉴 끝 -->
	
	<tr>
		<!-- 좌측 메뉴 시작 -->
		<td rowspan="2" valign="top" style="width:20%">
			<jsp:include page="left.jsp"></jsp:include>
		</td>
		<!-- 좌측 메뉴 끝 -->
		
		<!-- 본문 내용 시작 -->
		<td>
			<div class="menu_title" >Movie</div>
			<table class="table_style" align="right">
				<tr>
					<td rowspan="5" style="border-right:1px solid #9191C8;width:210px;" align="center"><img src="/moviesystem/movieimg/${Movie.poster}.jpg" class="poster_style2"></td>
					<td>${Movie.mname}</td>
				</tr>
				<tr>
					<td>장르 : ${Movie.genre}</td>
				</tr>
				<tr>
					<td>개봉일 : ${Movie.launchDate}</td>
				</tr>
				<tr>
					<td>가격 : ${Movie.mprice}</td>
				</tr>
				<tr>
					<td>
						<c:choose>
							<c:when test="${sessionScope.LOGIN_MEMBER eq null}"></c:when>
							<c:otherwise>
								<span id="reservation" class="button1">예매하기</span>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="background-color:#9191C8;padding-top:1px"></td>
				</tr>
				<tr>
					<td colspan="2">줄거리<br/><br/>
						${Movie.content}	
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<!-- 본문 내용 끝 -->
	<tr>
		<td clospan="2">
			<p align="center">
				<form action="/moviesystem/MovieService" id="vieMovie">
					<input type="hidden" name="method" value="viewMovieList">
					<input type="hidden" name="gubun" value="${gubun}">
					<span id="button">목록</span>
				</form>
			</p>
		</td>
	</tr>
	<!-- 하단 내용 시작 -->
	<tr>
		<td colspan="2">
			<jsp:include page="/common/footer.jsp"></jsp:include>
		</td>
	</tr>
	<!-- 하단 내용 끝 -->
</body>
</html>