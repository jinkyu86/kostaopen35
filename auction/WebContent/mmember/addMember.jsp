<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>jQuery Mobile</title>
<meta charset="euc-kr" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, 
							maximum-scale=1.0, minimum-scale=1.0, 
							user-scalable=no" />

<link rel="shortcut icon" href="../image/icon.png">
<link rel="apple-touch-icon" href="../image/icon.png">


<link href="http://code.jquery.com/mobile/latest/jquery.mobile.min.css"
	rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
<script src="http://code.jquery.com/mobile/latest/jquery.mobile.min.js"></script>

<!--
		<link href="../framework/jquery.mobile-1.0.css" 
			rel="stylesheet" type="text/css" />
		<script src="../framework/jquery-1.6.4.js"></script>
		<script src="../framework/jquery.mobile-1.0.js"></script>
		-->
</script>
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
<body>
	<div data-role="page">
		<div data-role="content">
			<form id="my_form" method="post" action="/auction/maddMember.action">
				
				<div data-role="fieldcontain">
					<label for="userid">아이디:</label>
					<input id="userid" type="text" name="userid" /><span
						id="useridcheck"></span>
				</div>
				<div data-role="fieldcontain">
					<label for="name">이름:</label>
					<input id="name" type="text" name="name" />
				</div>
				<div data-role="fieldcontain">
					<label for="pw">비밀번호:</label>
					<input id="pw" type="text" name="pw" />
				</div>
				<div data-role="fieldcontain">
					<label for="email">이메일:</label>
					<input id="email" type="text" name="email"/>
				</div>
				<div data-role="fieldcontain">
					<label for="coin">코인:</label>
					<input id="coin" type="text" name="coin" />
				</div>
				<div data-role="fieldcontain">
					<label for="emoney">e머니:</label>
					<input id="emoney" type="text" name="emoney" />
				</div>
				<div data-role="fieldcontain">
					<input id="submit" type="submit" value="전송" id="addMember"/>
					<input id="reset" type="reset" value="취소"/>
				</div>
			</form>
		</div>
	</div>		
</body>
</html>