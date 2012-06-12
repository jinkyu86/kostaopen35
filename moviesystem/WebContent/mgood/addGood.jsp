<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html> 
	<head>
		<title>물건 등록</title>
		<link rel="Stylesheet"  
      	href="/moviesystem/uploadify/uploadify.css" />
      	<link rel="stylesheet" href="/moviesystem/css/Layout.css">
    	<script src="http://code.jquery.com/jquery-1.7.js"></script>
    	<script  src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
		<script src="/moviesystem/uploadify/jquery.uploadify.v2.1.4.js"></script>
    	<script src="/moviesystem/uploadify/swfobject.js"></script>
		
		<link href="../framework/jquery.mobile-1.0.css" rel="stylesheet" type="text/css" />
		<script src="../framework/jquery.mobile-1.0.js"></script>
		<!-- <script src="../framework/jquery-1.6.4.js"></script> -->
		
		<meta charset="UTF-8"/> 	
		<meta name="viewport" 
				content="width=device-width, initial-scale=1.0, 
							maximum-scale=1.0, minimum-scale=1.0, 
							user-scalable=no"/>

		<link rel="shortcut icon" href="../image/icon.png">
		<link rel="apple-touch-icon" href="../image/icon.png">

		<!-- 
		<link href="http://code.jquery.com/mobile/latest/jquery.mobile.min.css" 
			rel="stylesheet" type="text/css" />
		<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
		<script src="http://code.jquery.com/mobile/latest/jquery.mobile.min.js"></script>
	 	-->	

		<script>
		$(document).ready(function () {
			 $('#uplodify').uploadify({
			 	cancelImg: '/moviesystem/uploadify/cancel.png',
        		uploader: '/moviesystem/uploadify/uploadify.swf',
        		script: '/moviesystem/mAddGood.action',
        		multi: false,
        		auto: false,
        		fileDataName : 'file',
			 fileExt     : '*.jpg;*.jpeg;*.gif;*.png',
 			  fileDesc    : 'Web Image Files (.jpg, .gif, .png)',
			  buttonText:'SELECT PHOTO',
			  onComplete: function(event, queueID, fileObj,
			             response, data){
				  <%--전체 물건 리스트로 페이지 이동 --%>
			  	$(location).attr("href",
			  			"/moviesystem/mViewManageGoodList.action");
			   }
			   					
		});
			
			    $('#addGood').click(function (event) {
			    	<%-- 물건의 이름 입력값 리턴--%>
			    	var gname=$("#gname").val();
			    	<%--물건의 설명 리턴--%>
			    	var detail=$("#detail").val();
			    	<%--물건의 가격 리턴--%>
			    	var gprice=$("#gprice").val();
			    	<%--파일 전송시 이름,설명,가격 전송 설정--%>
			    	$('#uplodify').uploadifySettings(
			    			'scriptData', { 
			    				'gname':gname, 'detail': detail,
			    				'gprice':gprice
			    				}
			    		);
			       $('#uplodify').uploadifyUpload();
			    	 event.preventDefault();
			    });
		});
    </script>
	</head> 

	<body>
		<div data-role="page">
		
			<jsp:include page="/common/mHeader.jsp"></jsp:include>
			
			<div data-role="content">
			
				<div data-role="fieldcontain">	
					<label for="gname">상품명 : </label>
					<input type="text" id="gname" name="gname" required value="" data-mini="true"/>
				</div>
				
				<div data-role="fieldcontain">	
					<label for="gprice">가격 : </label>
					<input type="text" id="gprice" name="gprice" required value="" data-mini="true"/>
				</div>
		
				<div data-role="fieldcontain">	
					<label for="detail">상품설명 : </label>
					<textarea id="detail" data-mini="true" name="detail"></textarea>
				</div>
				
				<div data-role="fieldcontain">	
					<label for="file">이미지 : </label>
					<input type="file" name="file" id="uplodify" />
				</div>
								
				<input type="button"  id="addGood" value="물건등록"/>

			</div><!-- end content -->
		</div><!-- end page -->
	</body>
</html>
					