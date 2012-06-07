<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
<link rel="Stylesheet" href="/betting/member/jquery.validate.password.css"/>
<style>
	#password_row label.error { display:none !important; }
</style>
    <script src="http://code.jquery.com/jquery-1.7.js"></script>
    <script  src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
    <script src="/betting/member/jquery.validate.password.js"></script>
    <script>
        $(document).ready(function () {
            $('#add_member').validate({
                rules: {
                    id: {
                    	required:true,
						minlength:4
                    },
                    name: {
                        required: true,
                        minlength:2
                    },
					email:{
						required:true,
						email:true
					}
                },
                messages: {
                    id: {
                        required: '아이디를 입력해주세요.',
                        minlength: '{0}글자 이상 입력해주세요.'
                    },
                   name: {
                        required: '이름을 입력해주세요.',
                        minlength: '{0}글자 이상 입력해주세요.'
                    },
					email:{
						required:"이메일을 입력해주세요",
						email:"이메일형식으로 입력해주세요"
					}
                }
            });
            
            $("#id").change(function() {
				//userid에 입력한 값을 리턴
			
				var id=$("#id").val();
				
				$.ajax('/betting/checkMemberID.action', {
					data:{"id": id
					},
					success : function(data) {
						$('#idcheck').html(data);
					}
				});
            });
        });

</script>
</head>
<body>
	<h3 align="center">회원가입</h3>
	<form  id="add_member" action="addMember.action" method="post">
		<table border="0" align="center" >
			<tr>
				<th>ID</th>
				<td><input type="text" name="id" id="id"  /></td>
			</tr>
			<tr>
				<td colspan="2"><span id ="idcheck"></span></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr id="password_row">
				<th>비밀번호</th>
				<td><input type="password" name="pw" id="pw"/></td>
				<td>
					<div class="password-meter">
						<div class="password-meter-message"></div>
						<div class="password-meter-bg">
							<div class="password-meter-bar"></div>
						</div>
					</div>
				</td>		
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="password" name="pass_check"/></td>
				<td></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="text" name="email"  />
				</td>
			</tr>
    	</table>
    	<table border="0" align="center">
    		<tr>
				<td><input type="submit" value="회원 가입" /></td>
				<td align="center"><input type="reset" value="리셋" /></td>
			</tr>
    	</table>
	</form>
</body>
</html>