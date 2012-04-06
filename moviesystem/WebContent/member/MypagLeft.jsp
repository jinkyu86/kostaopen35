<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>

			<div class="left_menu1">
				<div id="my_page">&nbsp;&nbsp;Manager Page</div>
				<div id="member_info">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/MemberService?method=editMemberForm">Member Info</a></div>
				<div id="buy_list">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/BuyService?method=viewBuyList">Buy List</a></div>
				<div id="cancelable_buy_list">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/BuyService?method=cancelBuyListForm">Cancel Buy</a></div>
				<div id="canceled_buy_list">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/BuyService?method=viewCanceledBuyList">Canceled Buy List</a></div>
				<div id="reservation_list">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/ReservationService?method=viewReservationListById">Reservation List</a></div>
			
				<c:if  test="${LOGIN_MEMBER.userid=='mmanager'}">
					<div id="member_manage">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/MemberService?method=viewMemberList">Member Manage</a></div>
					<div id="good_management">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/GoodService?method=viewManageGoodList">Good Management</a></div>
				</c:if>
			</div>

					