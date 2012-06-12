<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>

			<div class="left_menu1">
				<div id="my_page">&nbsp;&nbsp;Manager Page</div>
				<div id="member_info">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/editMemberForm.action">Member Info</a></div>
				<div id="buy_list">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/viewBuyList.action"">Buy List</a></div>
				<div id="cancelable_buy_list">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/cancelBuyListForm.action"">Cancel Buy</a></div>
				<div id="canceled_buy_list">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/viewCanceledBuyList.action"">Canceled Buy List</a></div>
				<div id="reservation_list">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/viewReservationListById.action"">Reservation List</a></div>
			
				<c:if  test="${LOGIN_MEMBER.userid=='mmanager'}">
					<div id="member_manage">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/viewMemberList.action"">Member Manage</a></div>
					<div id="good_management">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/viewManageGoodList.action"">Good Management</a></div>
					<div id="movie_List">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/adminMovieList.action"">Movie List</a></div>
				</c:if>
			</div>

					