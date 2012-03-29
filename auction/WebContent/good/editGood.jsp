<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��ǰ ���� ����</title>
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
				alert(response+"�� ������ ���� �߽��ϴ�.");
				$("#img").val(response);
				$('#my_form').submit();
			}
		});
		
		$("#addGood").click(function (event){
			$('#uploadify').uploadifyUpload();
			event.preventDefault();	//���ε� �����Ȳ ���
		});
	});
</script>
</head>
<body>
	<form id="my_form" action="/wshop/GoodService" method="post">
	<input type="hidden" name="method" value="editGood"/>
	<input type="hidden" name="img" value="" id="img"/>
	<h1 align="center">��ǰ ���� ����</h1>
	<table border="1" align="center">
		<form action="/auction/GoodService" method="post">
		<input type="hidden" name="method" value="editGood"/>
		<tr>
			<td>��ǰ��</td>
			<td><input type="text" name="gName" value="${GOOD.gName}" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<td>�󼼼���</td>
			<td><textarea name="detail" >${GOOD.detail}</textarea></td>
		</tr>
		<tr>
			<td>�̹���</td>
			<td><img src='/auction/gphoto/${GOOD.img}' ></td>
		</tr>
	</table>
	<center>
	<input type="file" name="file" id="uploadify"/>
	<input type="button" id="editGood" value="���� ����">
	</center>
	</form>
</body>
</html>