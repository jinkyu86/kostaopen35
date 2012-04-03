<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Index</title>
<link rel="Stylesheet" href="/bookchange/uploadify/uploadify.css"/>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="/bookchange/uploadify/jquery.uploadify.v2.1.4.js"></script>
<script src="/bookchange/uploadify/swfobject.js"></script>
<script>
	$(document).ready(function(){
		$("#uploadify").uploadify({
			cancelImg:"/bookchange/uploadify/cancel.png",
			uploader:"/bookchange/uploadify/uploadify.swf",
			script:"/bookchange/UploadServlet",
			
			//sizeLimit:2097152,
			
			multi:true,
			auto:false
		});
		$("#my_form").submit(function (event){
			$("#uploadify").uploadifyUpload();
			event.preventDefault();
		});
	});
</script>
</head>
<body>
	<form id="my_form">
		<input type="file" name="file" id="uploadify"/>
		<input type="submit" />
	</form>
</body>
</html>