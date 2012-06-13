<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" 
				content="width=device-width, initial-scale=1.0, 
							maximum-scale=1.0, minimum-scale=1.0, 
							user-scalable=no"/>
		
		<link rel="shortcut icon" href="../image/icon.png">
		<link rel="apple-touch-icon" href="../image/icon.png">
		
		<link rel="Stylesheet" href="/bookchange/uploadify/uploadify.css"/>
		
		<link href="http://code.jquery.com/mobile/latest/jquery.mobile.min.css" 
			rel="stylesheet" type="text/css" />
		<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
		<script src="http://code.jquery.com/mobile/latest/jquery.mobile.min.js"></script>
		
		<script src="http://code.jquery.com/jquery-1.7.js"></script>
		<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
		<script src="/bookchange/uploadify/jquery.uploadify.v2.1.4.js"></script>
		<script src="/bookchange/uploadify/swfobject.js"></script>
		
		<script>
			$(document).ready(function(){
				$("#add_board").validate({
					rules:{
						boardWant:{
							required:true
						},
						boardTitle:{
							required:true
						},
						boardContent:{
							required:true
						},
						file:{
							required:true
						}
					},
					messages:{
						boardWant:{
							required:"원하는 물건을 입력해주세요."
						},
						boardTitle:{
							required:"제목을 입력해주세요."
						},
						boardContent:{
							required:"상세 내용을 입력해주세요."
						},
						file:{
							required:"사진을 업로드해주세요."
						}
					}			
				});
			});
		
		$(document).ready(function(){
			$("#uploadify").uploadify({
				cancelImg:"/bookchange/uploadify/cancel.png",
				uploader:"/bookchange/uploadify/uploadify.swf",
				script:"/bookchange/addBoard.action",			
				multi:false,
				auto:false,
				fileDataName:'file',
				fileExt:"*.jpg;*.jpeg;*.png;*.gif",
				fileDesc:"WebImageFiles(.jpg,.gif,.png)",
				buttonText:"Select Photo",
				onComplete:function(event,queueID,fileObj,response,data){
				$(location).attr("href","/bookchange/mviewBoardList.action");
				}
			});
			$("#addPhoto").click(function (event){
				var email=$("#email").val();
				var categoryNo=$("#categoryNo").val();
				var dealNo=$("#dealNo").val();
				var boardTitle=$("#boardTitle").val();
				var boardWant=$("#boardWant").val();
				var boardContent=$("#boardContent").val();
				$('#uploadify').uploadifySettings(
					'scriptData',{
						'email':email,'categoryNo':categoryNo,'dealNo':dealNo,
						'boardTitle':boardTitle,'boardWant':boardWant,'boardContent':boardContent
					});
				
				$("#uploadify").uploadifyUpload();
				event.preventDefault();
			});
		});
		</script>
	</head>
	<body>
		<div data-role="page">
			<div data-role="header">
				<a href="/bookchange/mviewBoardList.action" data-ajax="false" data-icon="arrow-l">이전</a>
				<h1>물품등록</h1>
			</div>
			<div data-role="content">
			
				<form id="add_board" action="/bookchange/maddBoard.action" method="post">
				<input type="hidden" id="email" name="email" value="${sessionScope.LOGIN_EMAIL.email}"/>
				<input id="photo" type="hidden" name="boardPhoto" value=""/>

				카테고리 <select id="categoryNo" name="categoryNo">
				 <c:forEach var="category" items="${CATEGORY_LIST}">
				     <option value="${category.categoryNo}">${category.categoryName}</option>
				 </c:forEach>
				</select><br/>
				거래방법 <select id="dealNo" name="dealNo">
				 <c:forEach var="deal" items="${DEAL_LIST}">
				     <option value="${deal.dealNo}">${deal.dealWay}</option>
				 </c:forEach>
				</select><br/>
				<label>제목 </label><input type="text" size="50" id="boardTitle" name="boardTitle" required/><br/>
				<label>원하는 물건 </label><input type="text" size="20" id="boardWant" name="boardWant" required/><br/>
				<label>내용</label><br><textarea cols="70" rows="10" id="boardContent" name="boardContent"></textarea><br/>
								
				<input type="file" name="file" id="uploadify"/>
				<input type="button" id="addPhoto" value="등록" /><br/>
				</form>
				<form action="/bookchange/mviewBoardList.action" method="post">
				<input type="submit" value="취소">
				</form>
			</div>
		</div>
	</body>
</html>