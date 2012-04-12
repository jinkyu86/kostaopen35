<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Admin MovieView</title>
<style>
	.admin_subMenu{font-color:#000000;}
</style>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.jsp"></script>
<script>
	$(function(){
		$('#button').click(function(){
			$('#adminMovie').submit();
		});
	});
</script>
</head>
<body>
<table width="90%" align="center">
	<!-- ��� �޴� ���� -->
	<tr>
		<td colspan="2">
			<jsp:include page="/common/top.jsp"></jsp:include>
		</td>
	</tr>
	<!-- ��� �޴� �� -->
	
	<tr>
		<!-- ���� �޴� ���� -->
		<td rowspan="2" valign="top" style="width:20%">
			<jsp:include page="/member/managerLeft.jsp"></jsp:include>
		</td>
		<!-- ���� �޴� �� -->
		
		<!-- ���� ���� ���� -->
		<td>
			<!-- ������ ���� ���� -->
			<div class="admin_menu" >
				<span class="admin_subMenu"><a href="/moviesystem/MovieService?method=adminMovieList">��ü</a></span>
				<span style="font-color:#000000;">&nbsp;|&nbsp;</span>
				<span class="admin_subMenu"><a href="/moviesystem/MovieService?method=adminMovieList&gubun=screen">����</a></span>
				<span style="font-color:#000000;">&nbsp;|&nbsp;</span>
				<span class="admin_subMenu"><a href="/moviesystem/MovieService?method=adminMovieList&gubun=schedule">�󿵿�����</a></span>
				<span style="font-color:#000000;">&nbsp;|&nbsp;</span>
				<span class="admin_subMenu"><a href="/moviesystem/MovieService?method=adminRankingList">���� ����</a></span>
			</div>
			<!-- ������ ���� �� -->
			<table class="table_style" align="right">
				<tr>
					<td rowspan="5" style="border-right:1px solid #9191C8;width:210px;" align="center"><img src="/moviesystem/movieimg/${Movie.poster}.jpg" class="poster_style2"></td>
					<td>${Movie.mname}</td>
				</tr>
				<tr>
					<td>�帣 : ${Movie.genre}</td>
				</tr>
				<tr>
					<td>������ : ${Movie.launchDate}</td>
				</tr>
				<tr>
					<td>���� : ${Movie.mprice}</td>
				</tr>
				<tr>
					<td>
						<c:choose>
							<c:when test="${sessionScope.LOGIN_MEMBER eq null}"></c:when>
							<c:otherwise>
								<a href="/moviesystem/ScreenTimeService?method=viewScreenTimeListBymnum&mnum=${Movie.mnum}"><span id="reservation" class="button1">�����ϱ�</span></a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="background-color:#9191C8;padding-top:1px"></td>
				</tr>
				<tr>
					<td colspan="2">�ٰŸ�<br/><br/>
						${Movie.content}	
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td clospan="2">
			<p align="center">
				<form action="/moviesystem/MovieService" id="adminMovie">
					<input type="hidden" name="method" value="adminMovieList">
					<input type="hidden" name="gubun" value="${gubun}">
					<span id="button">���</span>
				</form>
			</p>
		</td>
	</tr>
	<!-- ���� ���� �� -->
	<tr>
		<td colspan="2">
			<jsp:include page="/common/footer.jsp"></jsp:include>
		</td>
	</tr>
	<!-- �ϴ� ���� �� -->
</table>
</body>
</html>