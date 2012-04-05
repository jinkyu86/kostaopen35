<%@ page language="java" 
          contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
<link rel ="Stylesheet" href="jquery.validate.password.css"/>

<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="jquery.validate.password.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<style>
	#password_row label.error {dispaly:none !important;}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$('#my_form').validate({
			rules:{
				userid:{
					required:true
				},
				pw:{ 
					required:true,
					password:true,
					minlength:2,
					maxlength:15
					},
				email:{
					required:true,
					email:true,
					minlength:5
				},
				name:{
					required:true,
					minlength:2
				}
			},	
			messages:{
				userid:{
					required:'아이디를 입력하세요.'
				},
				pw:{
					required:'패스워드를 입력하세요',
					minlength:'{0}이상 입력하세요.',
					maxlength:'{0}을 초과하였습니다'	
				},
			  email:{
					required:'이메일을 입력해주세요.',
					email:'이메일 형식에 맞게 입력해주세요',
					minlength: '{0}자 이상 입력하세요'
				},
				name:{
					required: '이름을 입력해주세요.',
					minlength: '{0}자 이상 입력하세요'
				}		
			}
			});
		$("#userid").change(function(){
			var userid=$("#userid").val();
			
			$.ajax('/auction/MemberService',{
				data:{"method":"checkuserID","userid":userid
					},
					success : function(data){
						$('#useridcheck').html(data);
					}
			});	
		});	
	
			$("#addMember").click(function (event){
				var result=confirm("가입하시겠습니까?");
			
				if(result==false){
					event.preventDefault();
				}
			});
	});
</script>

</head>
<body background="/auction/gphoto/seo.jpg">
	<h1 align="center">회원가입</h1>
	<form  action="/auction/MemberService" 
		method="post" id="my_form">
		<input type="hidden"  name="method"
		  value="addMember"/>
		<table align="center">
			<tr>
				<td>아이디</td>
				<td><input type="text"  name="userid" id="userid">
				<span id ="useridcheck"></span></td>
				<td></td>
			</tr>
			<tr>
				<td><label>비밀번호</label></td>
				<td><input type="password"  name="pw" ></td>

			</tr>
			
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
					<td>
						<input type="submit" value="회원가입" id="addMember"/>
					</td>
					<td>
						<input type="reset" value="취소"/>
					</td>
			</tr>
		</table>
	
	</form>
</body>
</html>