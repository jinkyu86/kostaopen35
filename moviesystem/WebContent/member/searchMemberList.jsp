<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>검색 회원 리스트</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.jsp"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#member_manage').css('background-color','#C4E2FF');
		$("#member_search").css('background-color','#EBFBFF');

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
			<jsp:include page="managerLeft.jsp"></jsp:include>
		</td>
		<!-- 좌측 메뉴 끝 -->
		<td>
			<div class="menu_title" ><font size="5">Search_Member</font>	</div>
				<!-- 검색 박스 시작 -->
			<table class="sch_style" style="margin-bottom:10px;" align="center">
				<tr>
					<td align="center" style="padding:5px 5px 5px 5px;width:100%">
						<form action="/moviesystem/MemberService" method="post">
						<input type="hidden" name="method" value="searchMemberList">
	
							<select name="column">
								<option value="name">이름</option>
								<option value="email">이메일</option>
								<option value="addr">주소</option>
								<option value="phone">전화번호</option>
							</select>
						<input type="text" name="keyword">
						<input type="submit" value="검색"/>
						</form>
					</td>
				</tr>
			</table>
			<!-- 검색 박스
				
				<tr>
				<input type="text" name="keyword">
				<br/>
				<input type="submit" name="검색"/>
			</form>
			</table>
					</td>
				</tr>
			</table>
			<!-- 검색 박스 끝 -->
			<table class="table_style" border="1">
				<tr id="memberlist">
					<th>회원번호</th>
					<th>아이디</th>
					<th>이름</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>우편번호</th>
					<th>주소</th>
					<th>회원상태</th>
				</tr>
				<c:forEach var="member" items="${MEMBER_LIST}">
				<tr>
					<td>${member.userNum}</td>
					<td><a href="/moviesystem/MemberService?method=viewMember&userid=${member.userid}">
					<font color="blue">${member.userid}</font></a></td>
					<td>${member.name}</td>
					<td>${member.email}</td>
					<td>${member.phone}</td>
					<td>${member.zipcode}</td>
					<td>${member.addr}</td>
					<td>${member.memState}</td>
			</c:forEach>
		</table>
			<table align="center">

		</td>
		</tr>
		</table>
<p align="center">
	${PAGE_LINK_TAG}
</p>

</body>
</html>