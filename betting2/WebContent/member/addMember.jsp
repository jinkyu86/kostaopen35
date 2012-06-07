<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html >
<html lang="en">
<head >
<title>BETTING</title>
<link rel="stylesheet" href="styles.css" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<link rel="Stylesheet" href="/betting/member/jquery.validate.password.css"/>
<style>
	#password_row label.error { display:none !important; }
</style>
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<script type="text/javascript">
 <c:if test="${SUCCESS!=null}">
 alert("${SUCCESS}");
</c:if>
</script>
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
<body style="text-align:center">
	<ul id="center1" style="text-align:center">
		<!--
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
		-->
	
		<header >
			<!--<p>
				<font color="black" style="font-size: 35px">2012 프로야구 베팅</font>
			</p>-->
			<div id="subject">
				<h1>2012 프로야구 베팅</h1>
			</div>
			
			<div id="login">
			<c:choose>
				<c:when test="${sessionScope.LOGIN_MEMBER==null}">
					<br/>
					<br/>
					<br/>
					<table align="right" style="margin-left:auto">
						<tr>
							<td align="right">
								<a href="/betting/loginForm.action" ><font color=white size="2pt">로그인</font></a>
							</td>
						</tr>
						<tr>
							<td align="right">		
								<a href="/betting/addMemberForm.action" ><font
									color=white size="2pt">회원가입</font></a>
							</td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
					<table align="right" style="margin-left:auto">
						<tr>
							<td colspan="2" align="right"><font color="white" size="2pt">${sessionScope.LOGIN_MEMBER.id }
									님 환영합니다</font></td>
						</tr>
						<tr>
							<td align="center"><font color="white" size="2pt">순위 : ${RANK }
									위|</font></td>
							<td align="center"><font color="white" size="2pt">미네랄 : ${MINERAL}
									</font></td>
						</tr>
						<tr>
							<td colspan="2" align="right"><a
								href="/betting/logout.action"> <font color="white" size="2pt">로그아웃</font>
							</a></td>
						</tr>
						<tr>
							<td colspan="2" align="right">
							<a href="/betting/editMemberForm.action"><font
									color="white" size="2pt"> 정보수정</font></a></td>
						</tr>
						<tr>
							<td colspan="2" align="right"><a
								href="/betting/viewMemberBetDataByIDList.action">
									<font color="white" size="2pt">나의 배팅 정보</font>
							</a></td>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
			</div>
		</header>
		<nav>
			<!-- top nav -->
			<div class="menu">
				<ul>
										<li><a
						href="/betting/viewHome.action">홈</a></li>
					<li><a
						href="/betting/viewMatchListToVistor.action">경기
							일정</a></li>
					<li><a href="/betting/todayBettingList.action">
							오늘의 베팅 </a></li>
					<li><a
						href="/betting/viewMemberRankingListForm.action">랭킹</a>
					</li>


					<c:choose>
						<c:when test="${sessionScope.LOGIN_MEMBER.id=='kosta100'}">
							<li><a href="/betting/viewMatchList.action">경기
									관리</a></li>
							<li><a href="/betting/viewMemberList.action">멤버
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
	<form  id="add_member" action="addMember.action" method="post">
		<table border="0" align="center" style="margin:auto">
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
				<td><input type="password" name="pw" id="pw"/>
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
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="text" name="email"  />
				</td>
			</tr>
    	</table>
    	<table border="0" align="center" style="margin:auto">
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