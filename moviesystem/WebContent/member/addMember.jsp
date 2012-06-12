<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="kr.or.kosta.moviesystem.member.Member" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.jsp"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js">	
</script>
	<script type="text/javascript">


	$(document).ready(function(){
		
		$("#member_info").css('background-color','#C4E2FF');
		$("#member_join").css('background-color','#EBFBFF');
		
		$("#userid").change(function(){
		var userid=$("#userid").val();
		$.ajax('/moviesystem/checkMemberID.action',{
		data:{"userid":userid},
		success:function(data){
			$('#idcheck').html(data);
		}
	});
});
	$("#my_form").validate({
		rules:{
			name:{
				required: true
			},
			pw:{
				required: true
			},
			pwvalid:{
				equalTo:"#pw"
			},
			email: "required email",
		},
		messages:{
			name:{
				required:"이름을 입력하세요"
			},
			pw:{
				required:"비밀번호를 입력하세요",
				rangelength:"6글자 이상을 입력해주세요"
			},
			pwvalid:{
				equalTo:"비밀번호가 일치하지 않습니다"
			},
			email: {
					required: "이메일을 입력해 주세요",
					email: "이메일 형식에 맞게 입력해주세요"
			},
		}
	});
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
			<jsp:include page="left.jsp"></jsp:include>
		</td>
		<!-- 좌측 메뉴 끝 -->
		<td>
			<form id="my_form" action="/moviesystem/addMember.action" method="post">
			<div class="menu_title" ><font size="5">Join</font></div>
			<table class="table_style" style="width:80%">
			
				<tr>
					<td><label>아이디</label></td>
					<td><input type="text" name="userid" id="userid"/>
					<span id="idcheck"></span>
					</td>
				</tr>
				<tr>
					<td><label>이름</label></td>
					<td><input type="text" name="name" id="name"/></td>
				</tr>
				<tr>
					<td><label>비밀번호</label></td>
					<td><input type="password" name="pw" id="pw"/></td>
				</tr>
				<tr>
					<td><label>비밀번호확인</label></td>
					<td><input type="password" name="pwvalid"/></td>
				</tr>
				<tr>
					<td><label>이메일</label></td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td><label>전화번호</label></td>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<td><label>우편번호</label></td>
					<td><input type="text" name="zipcode"></td>
				</tr>
				<tr>
					<td><label>주소</label></td>
					<td><textarea name="addr"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="회원가입"/>
						
				</td>
				</tr>
				</table>

		</form>
		</td>
		</tr>

</body>
</html>