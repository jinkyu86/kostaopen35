<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>결제 완료 창</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script type="text/javascript">
	$(document).ready(function(){

		$('#my_page').css('background-color','#C4E2FF');
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
		<td valign="top" style="width:20%">
						<div class="left_menu1">
				<div id="my_page">&nbsp;&nbsp;MyPage</div>
				<div id="member_info">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/MemberService?method=editMemberForm">Member Info</a></div>
				<div id="buy_list">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/BuyService?method=viewBuyList">Buy List</a></div>
				<div id="reservation_list">&nbsp;&nbsp;-&nbsp;<a href="/moviesystem/ReservationService?method=viewReservationListById">Reservation List</a></div>
			</div>		
		</td>
		<!-- 좌측 메뉴 끝 -->
		
		<!-- 본문 내용 시작 -->
		<td></td>
	</tr>
</table>
<table align="center" border="0">
	<tr>
		<td><h1 align="center">결제가 완료되었습니다.</h1></td><br/>
	</tr>
	<tr align="center">	
		<td><a href="/moviesystem/BuyService?method=viewBuyList">구매내역 보기</a></td>
	</tr>
</table>
</body>
</html>