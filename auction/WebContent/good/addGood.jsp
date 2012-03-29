<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>addGood</title>
<link rel="Stylesheet" href="/wshop/uploadify/uploadify.css"/>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script src="/wshop/uploadify/jquery.uploadify.v2.1.4.js"></script>
<script src="/wshop/uploadify/swfobject.js"></script>
<script>
	$(document).ready(function(){
		$("#uploadify").uploadify({
			cancelImg:'/auction/uploadify/cancel.png',
			uploader:'/auction/uploadify/uploadify.swf',
			script:'/auction/UploadServlet',
			
			multi:false,
			auto:false,
			fileExt:'*.jpg;*.jpeg;*.gif;*.png',
			fileDese:'Web Image File(.jpg,.gif,.png)',
			buttonText:'SELECT PHOTO',
			onComplete: function(event,queueID,fileObj,response,data){
				alert(response+"를 서버에 저장 했습니다.");
				$("#img").val(response);
				$('#my_form').submit();
			}
		});
		
		$("#addGood").click(function (event){
			$('#uploadify').uploadifyUpload();
			event.preventDefault();	//업로드 진행상황 출력
		});
	});
</script>
</head>
<body>
	<form id="my_form" action="/auction/GoodService" method="post">
	<input type="hidden" name="method" value="addGood"/>
	<input type="hidden" name="img" value="" id="img"/>
	<h1 align="center">물품 추가</h1>
	<table border="1" align="center">
		<form action="/auction/GoodService" method="post">
		<input type="hidden" name="method" value="addGood"/>
		<tr>
			<td>물품명</td>
			<td><input type="text" name="gName" /></td>
		</tr>
		<tr>
			<td>상세설명</td>
			<td><textarea name="detail" ></textarea></td>
		</tr>
		<tr>
			<td>이미지</td>
			<td><input type="file" name="file" id="uploadify"/></td>
		</tr>
	</table>
	</form>
	<center>	
	<input type="button" id="addGood" value="물건 등록"/>
	<input type="reset" value="입력취소"/>
	</center>

</body>
</html>