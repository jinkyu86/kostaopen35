<%@ page language="java"
    contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>파일업로드</title>
    <link rel="Stylesheet"  
      href="/jquery20120321/uploadify/uploadify.css" />
    <script src="http://code.jquery.com/jquery-1.7.js"></script>
    <script 
           src="/jquery20120321/uploadify/jquery.uploadify.v2.1.4.js"></script>
    <script 
              src="/jquery20120321/uploadify/swfobject.js"></script>
    <script>
		$(document).ready(function () {
			 $('#uplodify').uploadify({
			 	cancelImg: '/jquery20120321/uploadify/cancel.png',
        		uploader: '/jquery20120321/uploadify/uploadify.swf',
        		script: '/jquery20120321/UploadServlet',
        		multi: true,
        		auto: false
			 });
			
			    $('#my_form').submit(function (event) {
			    		    	 
			    	$('#uplodify').uploadifySettings('scriptData', { 'code1': 'data01', 'code2': 'data02' });

			       $('#uplodify').uploadifyUpload();
			    	 event.preventDefault();
			    });
		});
    </script>
</head>
<body>
	 <form id="my_form">
        <input type="file" name="file" id="uplodify" />
        <input type="submit" />
    </form>
</body>
</html>



