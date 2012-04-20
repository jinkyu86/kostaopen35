<%@ page language="java"
    contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>물건등록</title>
    <link rel="Stylesheet"  
      href="/moviesystem/uploadify/uploadify.css" />
      <link rel="stylesheet" href="/moviesystem/css/Layout.css">
    <script src="http://code.jquery.com/jquery-1.7.js"></script>
    <script  src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
	<script src="/moviesystem/uploadify/jquery.uploadify.v2.1.4.js"></script>
    <script src="/moviesystem/uploadify/swfobject.js"></script>
  	<script src="/moviesystem/js/common.jsp"></script>
    <script>

	$(document).ready(function(){
		$("#my_form").validate({
			rules:{
				gname:{
					required:true,
					minlength:2
				},
				gprice:{
					digits:true,
					range:[1,1000000000]
				},
				detail:{
					required:true,
					minlength:2
				},
				photo:{
					required:true
				}
			},
			messages:{
				gname:{
					required:"상품명은 필수 사항입니다.",
					minlength:"상품명을 정확하게 입력해 주세요."
				},
				gprice:{
					digits:"정확한 숫자를 입력해주세요",
					range:"0에서 1000000000사이의 가격을 입력해주세요."
				},
				detail:{
					required:"상품설명을 입력해주세요",
					minlength:"상품설명을 정확하게 입력해 주세요."
				},
				photo:{
					required:"업로드할 파일명을 올려주세요."
				}
			}//end message
		});
	});
		
		$(document).ready(function () {
			 $('#uplodify').uploadify({
			 	cancelImg: '/moviesystem/uploadify/cancel.png',
        		uploader: '/moviesystem/uploadify/uploadify.swf',
        		script: '/moviesystem/addGood.action',
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
			  			"/moviesystem/viewManageGoodList.action");
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
		
		$(document).ready(function(){
			$('#my_page').css('background-color','#C4E2FF');
			$('.top_row').css('background-color','#C4E2FF');
			$('#good_management').css('background-color','#ebfbff');
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
		<td width="20%">
			<!--<jsp:include page="/member/MypagLeft.jsp"></jsp:include>-->
		</td>
		<td>
		
		
	
	 <table border="1" class="table_style">
	  	<form id="my_form" action="/moviesystem/addGood.action" method="post">	
	 	<tr>	    	
     		<th><label>물건명</label></th>
	  		<td><input type="text" name="gname" id="gname"/><br/></td>
	  	</tr>
	  	<tr>
	  		<th><label>설명</label></th>
	  		<td><textarea name="detail"  id="detail"></textarea><br/></td>
	  	</tr>
	  	<tr>
	  		<th><label>가격</label></th>
	  		<td><input type="text"  name="gprice"  id="gprice"/></td>
	  	</tr>
    	</form>
    	<tr>
    		<th><label>이미지</label></th>
    		<td>
	 			 <input type="file" name="file" id="uplodify" />
	  		</td>
	  	</tr>
	  </table>
	  <input type="button"  id="addGood" value="물건등록"/>
	      
		</td>
	</tr>      
</table>	

</body>
</html>



