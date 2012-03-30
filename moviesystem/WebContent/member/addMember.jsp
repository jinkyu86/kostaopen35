<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="kr.or.kosta.moviesystem.member.Member" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js">	
</script>
<script>


$(document).ready(function(){
		$("#userid").change(function(){
		//userid에 입력한 갓을 리턴
		var userid=$("#userid").val();
	$.ajax('/moviesystem/MemberService',{
		data:{"method":"checkMemberID",
			"userid":userid},
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
	<h1 align="center">회원가입</h1>
	<form id="my_form" action="/moviesystem/MemberService" method="post">
		<input type="hidden"  name="method" value="addMember"/>
		<table align="center">
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
				<td><input type="text" name="addr"></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="회원가입"/>
				</td>
				<td>	
					<input type="reset" value="취소"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>