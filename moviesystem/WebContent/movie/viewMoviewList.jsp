<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
	<TITLE> New Document </TITLE>
	<META NAME="Author" CONTENT="">
	<META NAME="Keywords" CONTENT="">
	<META NAME="Description" CONTENT="">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="./Layout.css">
	<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
	<script>
		function menu_hover(obj, num){
			$('#'+obj).hover(function(){
				$(this).addClass('hover');
				$(this).css('background-color','#C4E2FF');
				//alert($(this).css('background-color'));				
				$('.sub_menu').css('display', 'block');
				$('#'+obj+'_sub').css('display', 'block');
				$('#'+obj+'_sub').hover(function(){
					$('#'+obj+'_sub').addClass('hover');
				},function(){
					$('#'+obj+'_sub').removeClass('hover');
					$('#'+obj).css('background-color','#ffffff');
					$('.sub_menu').css('display', 'none');
					$('#'+obj+'_sub').css('display', 'none');
				});
			});
		}
		$(document).ready(function(){
			menu_hover('movie',3);
			menu_hover('reservation',3);
			menu_hover('buy',3);
		});
	</script>
</HEAD>

<BODY>
<table width="90%" align="center">
	<!-- 최 상단 메뉴 시작 -->
	<tr>
		<td colspan="2">
			<table style="width:100%" align="center">
				<tr>
					<td align="right" style="font-size:9pt;"></td>
					<td align="right" style="width:8%;font-size:9pt;">로그인[로그아웃]</td>
					<td align="right" style="width:8%;font-size:9pt;">회원가입[마이페이지]</td>
					<td align="right" style="width:8%;font-size:9pt;">고객센터</td>
				</tr>
				<tr>
					<td colspan="4" align="center" style="font-size:17pt;font-weight:bold;">JAVA 6Team Project</td>
				</tr>
			</table>
		</td>
	</tr>
	<!-- 최 상단 메뉴 끝 -->
	<tr>
		<td colspan="2">
			<!-- 탑 메뉴 시작 -->
			<table class="topmenu" align="center">
				<tr align="center">
					<td class="topmenu_td" id="movie" align="center">aa</td>
					<td class="topmenu_td" id="reservation">bb</td>
					<td class="topmenu_td" id="buy">cc</td>
				</tr>
			</table>
			<!-- 탑 메뉴 끝 -->
			<!-- 서브 메뉴 시작 -->
			<table class="sub_menu" align="center">
				<tr id="movie_sub" class="sub_menu_tr">
					<td class="movie_menu" id="moviemenu1"><A HREF="">영화소개</A></td>
					<td class="movie_menu" id="moviemenu2"><A HREF="">영화 순위</A></td>
				</tr>
				<tr id="reservation_sub" class="sub_menu_tr">
					<td class="reservation_menu">444</td>
					<td class="reservation_menu">555</td>
					<td class="reservation_menu">666</td>
				</tr>
				<tr id="buy_sub" class="sub_menu_tr">
					<td class="buy_menu">777</td>
					<td class="buy_menu">888</td>
					<td class="buy_menu">999</td>
				</tr>
			</table>
			<!-- 서브 메뉴 끝 -->
		</td>
	</tr>
	<tr>
		<td>
			
		</td>
		<td>
			<table style="border:1px solid 9191C8;width:80%" align="center">
				<c:forEach var="movieList" items="${MOVIE_LIST}">
				<tr>
					<td rowspan="2">${movieList.poster}</td>
					<td><a href="/moviesystem/MovieService?method=viewMovie&gubun=${gubun}&mnum=${movieList.mnum}"><b>${movieList.mname}</b></a></td>
				</tr>
				<tr>
					<td>장르 : ${movieList.genre}&nbsp;&nbsp;&nbsp;
						개봉일 : <fmt:formatDate value="${movieList.launchDate}" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
			</c:forEach>
			</table>
		</td>
	</tr>
</table>
</body>
</html>