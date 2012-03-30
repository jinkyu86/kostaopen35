<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>

<HEAD>
	<!-- 제목 선택 시작 -->
	<TITLE> 
		<c:choose>
			<c:when test="${gubun eq 'screen'}" >
				Screening
			</c:when>
			<c:when test="${gubun eq 'schedule'}">
				Screen Schedule
			</c:when>
			<c:otherwise>
				Movie Info
			</c:otherwise>
		</c:choose>
	</TITLE>
	<!-- 제목 선택 끝 -->
	<META NAME="Author" CONTENT="">
	<META NAME="Keywords" CONTENT="">
	<META NAME="Description" CONTENT="">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="/moviesystem/css/Layout.css">
	<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
	<script src="/moviesystem/js/common.js"></script>
	<!-- 메뉴 선택 시작 -->
	<c:choose>
		<c:when test="${method eq 'viewMovieList' || method eq 'rankingMovieList'}">
			<script type="text/javascript">
				$(document).ready(function(){
					$('#movie').css('background-color','#C4E2FF');
					$('.sub_menu').css('display', 'block');
					$('#movie_sub').css('display', 'block');
				});
			</script>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${method eq 'viewMovieList'}">
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
		</c:when>
	</c:choose>
	<!-- 메뉴 선택 끝 -->
</HEAD>
<BODY>
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
			<table class="sch_style" style="margin-bottom:10px;" align="center">
				<tr>
					<td align="center" style="padding:5px 5px 5px 5px;width:100%">
						<form name="sch_form" id="sch_form" action="/moviesystem/MovieService">
							<input type="hidden" name="method" value="searchMovieList">
							<input type="hidden" name="gubun" value="${gubun}">
							
							<select name="sch_code" id="sch_code">
								<option value="mname">영화제목</option>
								<option value="genre">장르</option>
								<option value="content">내용</option>
							</select>
							<input type="text" name="sch_string" id="sch_string">
							<span id="button">검색</span>
						</form>
					</td>
				</tr>
			</table>
			
			<table class="table_style" align="right">
				<c:forEach var="movieList" items="${MovieList}" varStatus="n">
				<tr>
					<td rowspan="2">${movieList.poster}</td>
					<td><a href="/moviesystem/MovieService?method=viewMovie&gubun=${gubun}&mnum=${movieList.mnum}"><b>${movieList.mname}</b></a></td>
				</tr>
				<tr>
					<td>장르 : ${movieList.genre}&nbsp;&nbsp;&nbsp;
						개봉일 : <fmt:formatDate value="${movieList.launchDate}" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				
				<c:if test="${!n.last}">
						<tr>
						<td colspan="3" style="background-color:#9191C8;padding-top:1px"></td>
					</tr>
				</c:if>
			</c:forEach>
			</table>
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