<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<script src="http://code.jquery.com/jquery-1.7.1.js"></script>

	<c:choose>
		<c:when  test="${LOGIN_MEMBER.userid=='mmanager'}">
			<div class="left_menu1">
				<div id="my_page">&nbsp;&nbsp;MyPage</div>
				<div id="member_info">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/MemberService?method=editMemberForm">Member Info</a></div>
				<div id="buy_list">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/BuyService?method=viewBuyList">Buy List</a></div>
				<div id="cancelable_buy_list">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/BuyService?method=cancelBuy">Cancel Buy</a></div>
				<div id="canceled_buy_list">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/BuyService?method=viewCanceledBuyList">Canceled Buy List</a></div>
				<div id="reservation_list">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/ReservationService?method=viewReservationListById">Reservation List</a></div>
				<div id="member_manage">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/MemberService?method=viewMemberList">Member Manage</a></div>
			</div>
		</c:when>
		<c:when  test="${LOGIN_MEMBER.userid!='mmanager'}">
			<div class="left_menu1">
				<div id="my_page">&nbsp;&nbsp;MyPage</div>
				<div id="member_info">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/MemberService?method=editMemberForm">Member Info</a></div>
				<div id="buy_list">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/BuyService?method=viewBuyList">Buy List</a></div>
				<div id="cancelable_buy_list">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/BuyService?method=cancelBuy">Cancel Buy</a></div>
				<div id="canceled_buy_list">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/BuyService?method=viewCanceledBuyList">Canceled Buy List</a></div>
				<div id="reservation_list">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/ReservationService?method=viewReservationListById">Reservation List</a></div>
			</div>
		</c:when>
	</c:choose>
					