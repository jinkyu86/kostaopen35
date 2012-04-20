<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>영화정보 입력</title>
<link rel="stylesheet" href="/moviesystem/css/Layout.css">
<link rel="stylesheet" href="/moviesystem/uploadify/uploadify.css">
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script src="/moviesystem/js/common.jsp"></script>
<script src="/moviesystem/uploadify/jquery.uploadify.v2.1.4.js"></script>
<script src="/moviesystem/uploadify/swfobject.js"></script>
<script>
	$(function(){
		memcheck('${LOGIN_MEMBER.userid}');
		$('#member_manage').css('background-color','#C4E2FF');
		$('#movie_List').css('background-color','#EBFBFF');
		$('#movie_list').click(function(){
			location.href='/moviesystem/adminMovieList.action';
		});
		$('#cancel').click(function(){history.back();});
		
		$("#confirm").click(function(event){
			//alert($('#method').val());
			if($('#movie_name').val()==''){
				alert('영화이름을 입력하세요.');
				$('#movie_name').focus();
				return false;
			}
			if($('#movie_genre').val()==''){
				alert('영화 장르를 입력하세요.');
				$('#movie_genre').focus();
				return false;
			}
			//if($('#movie_poster').val()==''){
			//	alert('포스터를 입력하세요.');
			//	$('#movie_poster').focus();
			//	return false;
			//}
			if($('#movie_sdate').val()==''){
				alert('상영기간을 입력하세요.');
				$('#movie_sdate').focus();
				return false;
			}
			if($('#movie_edate').val()==''){
				alert('상영기간을 입력하세요.');
				$('#movie_edate').focus();
				return false;
			}
			if($('#movie_price').val()==''){
				alert('관람 가격 입력하세요.');
				$('#movie_price').focus();
				return false;
			}
			if($('#movie_content').val()==''){
				alert('영화 소개를 입력하세요.');
				$('#movie_content').focus();
				return false;
			}
			//alert($('#method').val());
			
			$("#movie_poster").uploadifyUpload();
			event.preventDefault();
		});
		$("#movie_poster").uploadify({
			cancelImg : '/moviesystem/uploadify/cancel.png',
			uploader : '/moviesystem/uploadify/uploadify.swf',
			script : '/moviesystem/MovieService?method=MovieImgUpload',
			//sizeLimit : 20097152,
			multi : false,
			auto : false,
			fileExt : '*.jpg;*.jpeg;*.png;*.gif',
			fileDexc : 'Web Image Files(.jpg, .gif, .png)',
			buttonText : 'Select Photo',
			onComplete : function(event, queueID, fileObj, response, data){
				//업로드 완료 되었을 때 할일
				alert(response+"를 서버에 저장했습니다.");
				$("#poster_name").val(response);
				// form의 action 설정된 서블릿으로 입력정보 전송
				$('#movie_form').submit();
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
			<jsp:include page="/member/managerLeft.jsp"></jsp:include>
		</td>
		<!-- 좌측 메뉴 끝 -->
		
		<!-- 본문 내용 시작 -->
		<td>
			<form name="movie_form" id="movie_form" method="post" action="/moviesystem/MovieService">
			<c:choose>
				<c:when test="${method eq 'addMovieForm'}">
					<input type="hidden" name="method" id="method" value="addMovie">
				</c:when>
				<c:otherwise>
					<input type="hidden" name="method" id="method" value="editMovie">
				</c:otherwise>
			</c:choose>
			<input type="hidden" name="mnum" value="${Movie.mnum}">
			<input type="hidden" name="poster_name" id="poster_name">
			<table class="table_style" align="right" border="1px" cellspacing="0" bgcolor="#ffffff">
				<tr>
					<td style="width:15%;text-align:center">영화명</td>
					<td style="width:85%;padding-left:20px;">
						<input type="text" name="movie_name" id="movie_name"  value="${Movie.mname}" style="width:70%;">
					</td>
				</tr>
				<tr>
					<td style="width:15%;border-right:1px solid #9191C8;text-align:center">장르</td>
					<td style="width:85%;padding-left:20px;">
						<input type="text" name="movie_genre" id="movie_genre" value="${Movie.genre}">
					</td>
				</tr>
				<tr>
					<td style="width:15%;border-right:1px solid #9191C8;text-align:center">포스터</td>
					<td style="width:85%;padding-left:20px;">
						<input type="file" name="movie_poster" id="movie_poster" >&nbsp;${Movie.poster}
					</td>
				</tr>
				<tr>
					<td style="width:15%;border-right:1px solid #9191C8;text-align:center">상영기간</td>
					<td style="width:85%;padding-left:20px;">
						<input type="text" name="movie_sdate" id="movie_sdate" style="width:100px" value="<fmt:formatDate value="${Movie.launchDate}" pattern="yyyy-MM-dd"/>">
						~
						<input type="text" name="movie_edate" id="movie_edate" style="width:100px" value="<fmt:formatDate value="${Movie.endDate}" pattern="yyyy-MM-dd"/>">
					</td>
				</tr>
				<tr>
					<td style="width:15%;border-right:1px solid #9191C8;text-align:center">가격</td>
					<td style="width:85%;padding-left:20px;">
						<input type="text" name="movie_price" id="movie_price" value="${Movie.mprice}">
					</td>
				</tr>
				<tr>
					<td style="width:15%;border-right:1px solid #9191C8;text-align:center">소개</td>
					<td style="width:85%;padding-left:20px;">
						<textarea name="movie_content" id="movie_content" style="width:95%;height:300px;">${Movie.content}</textarea>
					</td>
				</tr>
			</table>
			</form>
			<table style="width:100%;padding-top:15px;">
				<tr>
					<td style="width:100%;text-align:center">
						<span class="button1" id="confirm">확인</span>
						<span class="button1" id="cancel">취소</span>
						<span class="button1" id="movie_list">목록</span>
					</td>
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