<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>MovieSystem</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.jsp"></script>
</head>
<body>
<table width="90%" align="center">
	<!-- ��� �޴� ���� -->
	<tr>
		<td>
			<jsp:include page="/common/top.jsp"></jsp:include>
		</td>
	</tr>
	<!-- ��� �޴� �� -->
	
	<tr>		
		<!-- ���� ���� ���� -->
		<td>
			<!-- ���� ���� ���� -->
			<div class="main_title" >�α� ����</div>
			<table class="table_style" align="center">
				<tr>
					<c:forEach var="rankingMovieList" items="${rankingMovieList}" varStatus="n">
						<td class="main_td">
							<img src="/moviesystem/movieimg/${rankingMovieList.poster}.jpg" class="main_img" style="margin:5px 0 5px 0"><br/>
							<span title="${rankingMovieList.mname}">
								<c:choose>
									<c:when test="${fn:length(rankingMovieList.mname)>9}">
										<a href="/moviesystem/MovieService?method=viewMovie&gubun=&mnum=${rankingMovieList.mnum}">${fn:substring(rankingMovieList.mname, 0, 8)}</a>
									</c:when>
									<c:otherwise>
										<a href="/moviesystem/MovieService?method=viewMovie&gubun=&mnum=${rankingMovieList.mnum}">${rankingMovieList.mname}</a>
									</c:otherwise>
								</c:choose>
							</span>
							<br/>
						</td>
					</c:forEach>
				</tr>
			</table>
			<!-- ���� ���� �� -->
			
			<!-- ���� ���� -->
			<div class="main_title" style="margin-top:10px;">����</div>
			<table class="table_style" align="center">
				<tr>
					<c:forEach var="screenMovieList" items="${screenMovieList}" varStatus="n">
						<td class="main_td">
							<img src="/moviesystem/movieimg/${screenMovieList.poster}.jpg" class="main_img" style="margin:5px 0 5px 0"><br/>
							<span title="${screenMovieList.mname}">
								<c:choose>
									<c:when test="${fn:length(screenMovieList.mname)>9}">
										<a href="/moviesystem/MovieService?method=viewMovie&gubun=screen&mnum=${screenMovieList.mnum}">${fn:substring(screenMovieList.mname, 0, 8)}</a>
									</c:when>
									<c:otherwise>
										<a href="/moviesystem/MovieService?method=viewMovie&gubun=screen&mnum=${screenMovieList.mnum}">${screenMovieList.mname}</a>
									</c:otherwise>
								</c:choose>
							</span>
							<br/>
						</td>
					</c:forEach>
				</tr>
			</table>
			<!-- ���� �� -->
			
			<!-- �� ������ ���� -->
			<div class="main_title" style="margin-top:10px;">�� ������</div>
			<table class="table_style" align="center">
				<tr>
					<c:forEach var="scheduleMovieList" items="${scheduleMovieList}" varStatus="n">
						<td class="main_td">
							<img src="/moviesystem/movieimg/${scheduleMovieList.poster}.jpg" class="main_img" style="margin:5px 0 5px 0"><br/>
							<span title="${scheduleMovieList.mname}">
							<c:choose>
								<c:when test="${fn:length(scheduleMovieList.mname)>9}">
									<a href="/moviesystem/MovieService?method=viewMovie&gubun=schedule&mnum=${scheduleMovieList.mnum}">${fn:substring(scheduleMovieList.mname, 0, 8)}</a>
								</c:when>
								<c:otherwise>
									<a href="/moviesystem/MovieService?method=viewMovie&gubun=schedule&mnum=${scheduleMovieList.mnum}">${scheduleMovieList.mname}</a>
								</c:otherwise>
							</c:choose>
							</span>
							<br/>
						</td>
					</c:forEach>
				</tr>
			</table>
			<!-- �� ������ �� -->
		</td>
	</tr>
	<!-- ���� ���� �� -->
	<!-- �ϴ� ���� ���� -->
	<tr>
		<td>
			<jsp:include page="/common/footer.jsp"></jsp:include>
		</td>
	</tr>
	<!-- �ϴ� ���� �� -->
</table>
</body>
</html>