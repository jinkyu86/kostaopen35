<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
			<table style="width:100%" align="center">
				<tr>
					<td align="right"></td>
					<td align="right" class="top_text" id="login"></td>
					<td align="right" class="top_text" id="join"></td>
					<td align="right" class="top_text" id="mypage"></td>
				</tr>
				<tr>
					<td colspan="4" align="center" style="font-size:17pt;font-weight:bold;"><a href="/moviesystem/main.action">Movie</a></td>
				</tr>
			</table>
		</td>
	</tr>
	<!-- ìµ ìë¨ ë©ë´ ë -->
	<tr>
		<td colspan="3"  height="70px" valign="top">
			<!-- í ë©ë´ ìì -->
			<table class="topmenu" align="center">
				<tr align="center">
					<td class="topmenu_td" id="movie" align="center">Movie</td>
					<td class="topmenu_td" id="reservation">Reservation</td>
					<td class="topmenu_td" id="buy">Shopping</td>
				</tr>
			</table>
			<!-- top 메뉴 시작 -->
			<table class="sub_menu" align="center">
				<tr id="movie_sub" class="sub_menu_tr">
					<td class="movie_menu" id="moviemenu1"><A HREF="/moviesystem/viewMovieList.action?gubun=total">Movie Info</A></td>
					<td class="movie_menu" id="moviemenu2"><A HREF="/moviesystem/rankingMovieList.action">Movie Ranking</A></td>
				</tr>
				<tr id="reservation_sub" class="sub_menu_tr">
					<td class="reservation_menu"><a href="/moviesystem/addReservationForm.action">Reservation</a></td>
				</tr>
				<tr id="buy_sub" class="sub_menu_tr">
					<td class="buy_menu" id="buymenu1"><a href="/moviesystem/viewGoodList.action">Shopping</a></td>
					<td class="buy_menu" id="buymenu2"><a href="/moviesystem/viewCartList.action">CartList</a></td>
				</tr>
			</table>