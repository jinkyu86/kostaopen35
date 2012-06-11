<%@ page language="java" 
contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib  prefix="c" 
             uri="http://java.sun.com/jsp/jstl/core" %>
             
<!DOCTYPE html> 
<html> 
	<head>
		<title>Betting</title>
		<meta charset="euc-kr" /> 	
		<meta name="viewport" 
				content="width=device-width, initial-scale=1.0, 
							maximum-scale=1.0, minimum-scale=1.0, 
							user-scalable=no"/>
		
		<link rel="shortcut icon" href="../image/item_image27.png">
		<link rel="apple-touch-icon" href="../image/item_image27.png">

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

		<link rel="stylesheet" href="styles.css" type="text/css" media="screen" />
		<link rel="stylesheet" type="text/css" href="print.css" media="print" />
		<link rel="Stylesheet" href="/betting/member/jquery.validate.password.css"/>
		<style>
			#password_row label.error { display:none !important; }
		</style>
		<script src="http://code.jquery.com/jquery-1.7.js"></script>
		<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
		<script src="/betting/member/jquery.validate.password.js"></script>
		<script type="text/javascript">
        $(document).ready(function () {
            $('#edit_member').validate({
                rules: {
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
        });

		</script>
		
	</head>
<body>
	<div data-role="page">
		<div data-role="header">
			<h2>회원정보수정</h2>
			<a href="" data-icon="arrow-l" data-rel="back">이전</a>
			<c:choose>
				<c:when test="${sessionScope.LOGIN_MEMBER==null}">
				<a href="/betting/mLoginForm.action" class="ui-btn-right">로그인</a>
				</c:when>
				<c:otherwise>
				<p align="right">${sessionScope.LOGIN_MEMBER.id }님 / 랭킹 : ${RANK }위 / 미네랄 : ${MINERAL}</p>
				<a href="/betting/mLogout.action" class="ui-btn-right">로그아웃</a>
				</c:otherwise>
			</c:choose>
		</div>
		<div data-role="content">
		<form id="edit_member" action="/betting/mEditMember.action" method="post">
			<table style="margin:auto">
				<tr>
					<th>ID</th>
					<td><input type="text" name="id" id="id"  readOnly="readOnly" value="${MEMBER.id}"/></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${MEMBER.name}"/></td>
				</tr>
				<tr id="password_row">
					<th>비밀번호</th>
					<td><input type="password" name="pw" id="pw" />
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
					<td><input type="password" name="pass_check"></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><input type="text" name="email" value="${MEMBER.email}"></td>
				</tr>
    		</table>
			<input type="submit" value="회원정보변경" />
			<input type="reset" value="취소" />
			</form>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" data-iconpos="top">
				<ul>
					<li><a href="/betting/mViewHome.action" data-icon="home">Home</a></li>
					<li><a href="/betting/mRemoveMember.action?ID=${MEMBER.id }" data-icon="delete">일정 삭제</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>