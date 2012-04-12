<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Movie Ranking</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.jsp"></script>
<!-- 메뉴 선택 시작 -->
	<script type="text/javascript">
		$(document).ready(function(){
			$('#movie').css('background-color','#C4E2FF');
			$('.sub_menu').css('display', 'block');
			$('#movie_sub').css('display', 'block');
			$("#movie_ranking").css('background-color','#C4E2FF');
			$("#screen_ranking").css('background-color','#C4E2FF');
		});
	</script>
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
			<div class="menu_title" >Movie Ranking	</div>
			<table class="table_style" align="right">
				<c:forEach var="movieList" items="${MovieList}" varStatus="n">
					<tr>
						<td rowspan="2" class="movieList_img"><img src="/moviesystem/movieimg/${movieList.poster}.jpg" class="poster_style"></td>
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