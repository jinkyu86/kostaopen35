<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물수정</title>
<link rel="Stylesheet" href="/bookchange/uploadify/uploadify.css"/>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script src="/bookchange/uploadify/jquery.uploadify.v2.1.4.js"></script>
<script src="/bookchange/uploadify/swfobject.js"></script>
<script>
	$(document).ready(function(){
		$("#edit_board").validate({
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
				boardPhoto:{
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
				boardPhoto:{
					required:"사진을 업로드해주세요."
				}
			}			
		});
	});
	
	$(document).ready(function(){
		$("#uploadify").uploadify({
			cancelImg:"/bookchange/uploadify/cancel.png",
			uploader:"/bookchange/uploadify/uploadify.swf",
			script:"/bookchange/editBoard.action",			
			multi:false,
			auto:false,
			fileDataName:'file',
			fileExt:"*.jpg;*.jpeg;*.png;*.gif",
			fileDesc:"WebImageFiles(.jpg,.gif,.png)",
			buttonText:"Select Photo",
			onComplete:function(event,queueID,fileObj,response,data){
			$(location).attr("href","/bookchange/viewBoardList.action");
			}
		});
		$("#addPhoto").click(function (event){
			var boardNo=$("#boardNo").val();
			var email=$("#email").val();
			var categoryNo=$("#categoryNo").val();
			var dealNo=$("#dealNo").val();
			var boardTitle=$("#boardTitle").val();
			var boardWant=$("#boardWant").val();
			var boardContent=$("#boardContent").val();
			var conditionResult=$("#conditionResult").val();
			$('#uploadify').uploadifySettings(
				'scriptData',{
					'email':email,'categoryNo':categoryNo,'dealNo':dealNo,
					'boardTitle':boardTitle,'boardWant':boardWant,'boardContent':boardContent,
					'conditionResult':conditionResult,'boardNo':boardNo
				});
			
			$("#uploadify").uploadifyUpload();
			event.preventDefault();
		});
	});
</script>
</head>
<body topmargin="0" leftmargin="0" bgcolor="#FFFFFF">
<table>
	 <td width="550" height="600" valign="top">
	 
	 <h3 align="center">게시물 수정</h3>
	<form id="edit_board" action="/bookchange/editBoard.action" method="post">
		<input id="photo" type="hidden" name="boardPhoto" value=""/>
		<input id="conditionResult" type="hidden" name="conditionResult" value="${BOARD.condition.conditionResult}"/>
		<table bordercolor="#E6E6FA" border="1" align="center">
	    <tr>
		<td>작성자<input type="text" id="email" name="email" value="${sessionScope.LOGIN_EMAIL.email}" readonly="readonly"/><td/>
		<td>게시물번호<input type="text" name="boardNo" value="${BOARD.boardNo}" readonly="readonly"/><td/>
		</tr>
		<tr>
		<td>카테고리<select id="categoryNo" name="categoryNo">
		 <c:forEach var="category" items="${CATEGORY_LIST}">
		     <option value="${category.categoryNo}">${category.categoryName}</option>
		 </c:forEach>
		</select><td/>
		<td>거래방법<select id="dealNo" name="dealNo">
		 <c:forEach var="deal" items="${DEAL_LIST}">
		     <option value="${deal.dealNo}">${deal.dealWay}</option>
		 </c:forEach>
		</select><td/>
		</tr>
		<tr>		
		<td>제목<input type="text" id="boardTitle" name="boardTitle" value="${BOARD.boardTitle}"/><td/>
		<td>원하는 물건<input type="text" id="boardWant" name="boardWant" value="${BOARD.boardWant}"/><td/>
		</tr>
		<tr>
		<td colspan="3">
		내용<br><textarea id="boardContent" name="boardContent" cols="60" rows="10">${BOARD.boardContent}</textarea><td/>
		</tr>
		</table>
</form>
<table align="center">
<tr><td><input type="file" name="file" id="uploadify"/></td>
	<td><input type="button" id="addPhoto" value="수정" /></td>	
	<td><form action="/bookchange/viewBoard.action" method="post">
		<input type="hidden" id="boardNo" name="boardNo" value="${BOARD.boardNo}"></td>
	<td><input type="submit" value="취소"/></td>
		</form></tr>
</table>
	 	</td> 	
	 	</table>
</body>
</html>