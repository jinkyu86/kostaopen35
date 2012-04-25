<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시물등록</title>
<link rel="Stylesheet" href="/bookchange/uploadify/uploadify.css"/>
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
		$(location).attr("href","/bookchange/viewBoardList.action");
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
<body topmargin="0" leftmargin="0" bgcolor="#FFFFFF">
<table>
<tr>
	 <td width="550" height="600" valign="top">
	
<h3 align="center">물품등록</h3>
<form id="add_board" action="/bookchange/addBoard.action" method="post">
<input type="hidden" id="email" name="email" value="${sessionScope.LOGIN_EMAIL.email}"/>
<input id="photo" type="hidden" name="boardPhoto" value=""/>
		<table bordercolor="#FFA500" border="1">				
		<tr align="center">
		<td>
		<label>작성자</label> ${sessionScope.LOGIN_EMAIL.email}<br/>
		</td>
		<td>
		카테고리 <select id="categoryNo" name="categoryNo">
		 <c:forEach var="category" items="${CATEGORY_LIST}">
		     <option value="${category.categoryNo}">${category.categoryName}</option>
		 </c:forEach>
		</select><br/>
		</td>
		<td>
		거래방법 <select id="dealNo" name="dealNo">
		 <c:forEach var="deal" items="${DEAL_LIST}">
		     <option value="${deal.dealNo}">${deal.dealWay}</option>
		 </c:forEach>
		</select><br/>
		</td>
		</tr>
		<tr>
		<td colspan="2">
		<label>제목 </label><input type="text" size="50" id="boardTitle" name="boardTitle"/><br/>
		</td>
		<td>
		<label>원하는 물건 </label><input type="text" size="20" id="boardWant" name="boardWant"/><br/>
		</td>		
		</tr>
		<tr>
		<td colspan="3">
		<label>내용</label><br><textarea cols="60" rows="10" id="boardContent" name="boardContent"></textarea><br/>
		</td>
		</tr>
		<tr align="center">	
		</table>
</form>	
<table align="center">
<tr><td><input type="file" name="file" id="uploadify"/></td>
	<td><input type="button" id="addPhoto" value="등록" /></td>

	<td><form action="/bookchange/viewBoardList.action" method="post">
	<td><input type="submit" value="취소"></td> 
		</form></td></tr>
</table>
</td>
</tr>
</table>
</body>
</html>