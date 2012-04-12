<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Movie List</title>
<style>
	.admin_subMenu{font-color:#000000;}
</style>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.jsp"></script>
<c:choose>
	<c:when test="${method eq 'adminMovieList'}">
		<script>
			alert("#");
		</script>
	</c:when>
	<c:otherwise>
		<script>
			$(function(){
				$('#movie_rank').css('background-color','#C4E2FF');
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
			<jsp:include page="/member/managerLeft.jsp"></jsp:include>
		</td>
		<!-- 좌측 메뉴 끝 -->
		
		<!-- 본문 내용 시작 -->
		<td>
			<!-- 페이지 제목 시작 -->
			<div class="admin_menu" >
				<span class="admin_subMenu"  id="movie_total"><a href="/moviesystem/MovieService?method=adminMovieList">전체</a></span>
				<span style="font-color:#000000;">&nbsp;|&nbsp;</span>
				<span class="admin_subMenu" id="movie_screen"><a href="/moviesystem/MovieService?method=adminMovieList&gubun=screen">상영작</a></span>
				<span style="font-color:#000000;">&nbsp;|&nbsp;</span>
				<span class="admin_subMenu" id="movie_schedule"><a href="/moviesystem/MovieService?method=adminMovieList&gubun=schedule">상영예정작</a></span>
				<span style="font-color:#000000;">&nbsp;|&nbsp;</span>
				<span class="admin_subMenu" id="movie_rank"><a href="/moviesystem/MovieService?method=adminRankingList">예매 순위</a></span>
			</div>
			<!-- 페이지 제목 끝 -->
			
			<!-- 검색 박스 시작 -->
			<c:if test="${method != 'adminRankingList'}">
			<table class="sch_style" style="margin-bottom:10px;" align="center">
				<tr>
					<td align="center" style="padding:5px 5px 5px 5px;width:100%">
						<form method="post" name="sch_form" id="sch_form" action="/moviesystem/MovieService">
							<input type="hidden" name="method" value="adminMovieListSch">
							<input type="hidden" name="gubun" value="${gubun}">
							
							<select name="schCode" id="schCode">
								<option value="mname" <c:if test="${schCode eq 'mname'}">selected</c:if>>영화제목</option>
								<option value="genre" <c:if test="${schCode eq 'genre'}">selected</c:if>>장르</option>
								<option value="content" <c:if test="${schCode eq 'content'}">selected</c:if>>내용</option>
							</select>
							<input type="text" name="schString" id="schString" value="${schString}">
							<span id="button">검색</span>
						</form>
					</td>
				</tr>
			</table>
			</c:if>
			<!-- 검색 박스 끝 -->
			
			<!-- 영화 리스트 시작 -->
			<table class="table_style" align="right">
				<c:forEach var="movieList" items="${MovieList}" varStatus="n">
				<tr>
					<td class="movieList_img"><img src="/moviesystem/movieimg/${movieList.poster}.jpg" class="poster_style"></td>
					<td>
						<a href="/moviesystem/MovieService?method=adminMovie&gubun=${gubun}&mnum=${movieList.mnum}"><b>${movieList.mname}</b></a><br/>
						장르 : ${movieList.genre}&nbsp;&nbsp;&nbsp;<br/>
						개봉일 : <fmt:formatDate value="${movieList.launchDate}" pattern="yyyy-MM-dd"/><br/>
					</td>
				</tr>
				<c:if test="${!n.last}">
					<tr>
						<td colspan="3" style="background-color:#9191C8;padding-top:1px"></td>
					</tr>
				</c:if>
			</c:forEach>
			</table>
			<!-- 영화 리스트 끝 -->
		</td>
	</tr>
	<!-- 본문 내용 끝 -->
	<!-- 페이징 시작 -->
	<tr>
		<td>
			<table align="center" style="width:100%">
				<tr>
					<td align="center">
						${page_Link_Tag}
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<!-- 페이징 끝 -->
	<!-- 하단 내용 시작 -->
	<tr>
		<td colspan="2">
			<jsp:include page="/common/footer.jsp"></jsp:include>
		</td>
	</tr>
	<!-- 하단 내용 끝 -->
</table>
</body>
</html>