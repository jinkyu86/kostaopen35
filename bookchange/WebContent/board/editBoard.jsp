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
			script:"/bookchange/UploadServlet",			
			multi:false,
			auto:false,
			fileExt:"*.jpg;*.jpeg;*.png;*.gif",
			fileDesc:"WebImageFiles(.jpg,.gif,.png)",
			buttonText:"Select Photo",
			onComplete:function(event,queueID,fileObj,response,data){
				/* alert(response+"를 서버에 저장했습니다."); */
				//id가 photo인 객체선택 $("#photo")
				//value 속성 수정 val(수정하고싶은값)
				$("#photo").val(response);
				//my_form의 action설정된 서블렛으로 입력정보 전송
				$("#edit_board").submit();
			}
		});
		$("#addPhoto").click(function (event){
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
	<form id="edit_board" action="/bookchange/BoardService" method="post">
		<input type="hidden" name="method" value="editBoard"/>
		<input id="photo" type="hidden" name="boardPhoto" value=""/>
			<input type="hidden" name="conditionResult" value="${BOARD.condition.conditionResult}"/>
		<table bordercolor="#FFA500" border="1" align="center">
	    <tr>
		<td>작성자<input type="text" name="email" value="${sessionScope.LOGIN_EMAIL.email}" readonly="readonly"/><td/>
		<td>게시물번호<input type="text" name="boardNo" value="${BOARD.boardNo}" readonly="readonly"/><td/>
		</tr>
		<tr>
		<td>카테고리<select name="categoryNo">
		 <c:forEach var="category" items="${CATEGORY_LIST}">
		     <option value="${category.categoryNo}">${category.categoryName}</option>
		 </c:forEach>
		</select><td/>
		<td>거래방법<select name="dealNo">
		 <c:forEach var="deal" items="${DEAL_LIST}">
		     <option value="${deal.dealNo}">${deal.dealWay}</option>
		 </c:forEach>
		</select><td/>
		</tr>
		<tr>		
		<td>제목<input type="text" name="boardTitle" value="${BOARD.boardTitle}"/><td/>
		<td>원하는 물건<input type="text" name="boardWant" value="${BOARD.boardWant}"/><td/>
		</tr>
		<tr>
		<td colspan="3">
		내용<br><textarea name="boardContent" cols="60" rows="10">${BOARD.boardContent}</textarea><td/>
		</tr>
		</table>
</form>
<table align="center">
<tr><td><input type="file" name="file" id="uploadify"/></td>
	<td><input type="button" id="addPhoto" value="수정" /></td>	
	<td><form action="/bookchange/viewBoard.action" method="post">
		<input type="hidden" name="boardNo" value="${BOARD.boardNo}"></td>
	<td><input type="submit" value="취소"/></td>
		</form></tr>
</table>
	 	</td> 	
	 	</table>
	 </td>
	</table>
   </td>
  </tr>
 </table>
 </td>
 </tr>
 

</body>
</html>