<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<html lang="en">
<head>
<title>BETTING</title>
<link rel="stylesheet" href="styles.css" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<link rel="Stylesheet" href="/betting/member/jquery.validate.password.css"/>
<style>
	#password_row label.error { display:none !important; }
</style>
<script src="/betting/member/jquery.validate.password.js"></script>
<script type="text/javascript">
 <c:if test="${ERROR!=null}">
  alert("${ERROR}");
 </c:if>
 <c:if test="${SUCCESS!=null}">
 alert("${SUCCESS}");
</c:if>

$(document).ready(function () {
    $('#add_member').validate({
        rules: {
            id: {
            	required:true,
				minlength:4
            },
            name: {
                required: true,
                minlength:4
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
		
		$.ajax('/betting/MemberService', {
			data:{"method":"checkMemberID"
				,"id": id
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
	<ul>
		<c:choose>
			<c:when test="${sessionScope.LOGIN_MEMBER==null}">
				<div ALIGN="right">
					<a href="/betting/MemberService?method=loginForm" onfocus=blur()><font
						color=black>로그인</font></a>/<a
						href="/betting/MemberService?method=addMemberForm" onfocus=blur()><font
						color=black>회원가입</font></a>
				</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		<header>
			<p>
				<font color="white" style="font-size: 27px">2012 프로야구 베팅</font>
			</p>

	
		</header>
		<nav>
			<!-- top nav -->
			<div class="menu">
				<ul>
										<li><a
						href="/betting/index.jsp">홈</a></li>
					<li><a
						href="/betting/MatchService?method=viewMatchListToVistor">경기
							일정</a></li>
					<li><a href="/betting/BettingService?method=todayBettingList">
							오늘의 베팅 </a></li>
					<li><a
						href="/betting/MemberService?method=viewMemberRankingListForm">랭킹</a>
					</li>


					<c:choose>
						<c:when test="${sessionScope.LOGIN_MEMBER.id=='kosta100'}">
							<li><a href="/betting/MatchService?method=viewMatchList">경기
									관리</a></li>
							<li><a href="/betting/MemberService?method=viewMemberList">멤버
									관리</a></li>
						</c:when>
						<c:otherwise>

						</c:otherwise>
					</c:choose>



				</ul>
			</div>
		</nav>
		<!-- end of top nav -->
		<section id="content">
			<h3 align="center">회원가입</h3>
	<form  id="add_member" action="/betting/MemberService" method="post">
		<input type="hidden" name="method" value="addMember" />
		<table border="1" align="center">
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
		</section>
		</li>
	</ul>
	
</body>
</html>