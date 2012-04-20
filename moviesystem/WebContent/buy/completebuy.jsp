<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>결제 완료 창</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.jsp"></script>
<script type="text/javascript">
	$(document).ready(function(){
		//alert('${sessionScope.LOGIN_MEMBER}');
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
			<jsp:include page="/member/MypagLeft.jsp"></jsp:include>
		</td>
		<!-- 좌측 메뉴 끝 -->
		
		<!-- 본문 내용 시작 -->
		<td align="center">
				<table align="center" border="0">
				<tr>
					<td align="center"><h1 >결제가 완료되었습니다.</h1><br/></td>
				</tr>
				<tr >	
					<td align="center"><a href="/moviesystem/viewBuyList.action">구매내역 보기</a></td>
				</tr>
			</table>
		</td>
	</tr>
	<!-- 본문 내용 끝 -->
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