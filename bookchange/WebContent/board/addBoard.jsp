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
		script:"/bookchange/UploadServlet",			
		multi:false,
		auto:false,
		fileExt:"*.jpg;*.jpeg;*.png;*.gif",
		fileDesc:"WebImageFiles(.jpg,.gif,.png)",
		buttonText:"Select Photo",
		onComplete:function(event,queueID,fileObj,response,data){
			/* alert("글이 등록됐습니다."); */
			//id가 photo인 객체선택 $("#photo")
			//value 속성 수정 val(수정하고싶은값)
			$("#photo").val(response);
			//my_form의 action설정된 서블렛으로 입력정보 전송
			$("#add_board").submit();
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
	<table width="880" align="center" cellpadding="0" cellspacing="0" border="0">
	
	<tr>
	<td height="60"></td>
	</tr>

	<tr>
	<td>
		<table cellpadding="0" cellspacing="0" border="0">
		<tr align="right">
			<td width="25"></td>
			<td><a href="/bookchange/BoardService"><img src="webimg/home.gif" border="0"/></a></td>
			<td><a href="/bookchange/BoardService?method=viewBoardList"><img src="webimg/board.GIF" border="0"/></a></td>
		<c:choose>
		<c:when test="${sessionScope.LOGIN_EMAIL==null}">	
			<td><a href="/bookchange/BoardService?method=addBoardForm"><img src="webimg/join.GIF" border="0"/></a></td>
			<td><a href="/bookchange/MemberService?method=viewMember"><img src="webimg/myinfo.GIF" border="0"/></a></td>
		</c:when>
		<c:otherwise>
			<td><a href="/bookchange/BoardService?method=addBoardForm"><img src="webimg/join.GIF" border="0"/></a></td>
			<td><a href="/bookchange/MemberService?method=viewMember"><img src="webimg/myinfo.GIF" border="0"/></a></td>
		</c:otherwise>
		</c:choose>
			<td width="25"></td>
		</tr>
		</table>
	</td>
	</tr>
	
	<tr>
	<td height="10"></td>
	</tr>

	<tr>
	<td>
	<table cellpadding="0" cellspacing="0" border="0">
	 <tr>
	 <td width="220" height="600" valign="top" bgcolor="#F8F8F8">
	 <table cellpadding="0" cellspacing="0" border="0">
	 <!--로그인-->
	  <tr>
	  <td>		
	   <c:choose>
	    <c:when test="${sessionScope.LOGIN_EMAIL==null}">
	     <fieldset>
	     <table align="left" cellpadding="0" cellspacing="0" border="0">
	     <form action="/bookchange/MemberService" method="post">
		 <input type="hidden"name="method" value="login">
		 <tr>
		 <td>Email</td>
		 <td><input type="text" name="email"></td>
		 </tr>
		 <tr>
		 <td>Password</td>
		 <td><input type="password" name="pw"></td>
		 </tr>
		 <tr>
		 <td colspan="5"><div align="right">
		 <input type="submit" value="로그인">
		 </div></td>
		 </tr>
		 </form>
		  <tr>
		 <td><div align="right">
		 <form action="/bookchange/MemberService" method="post">
	  	 <input type="hidden" name="method" value="addMemberForm">
	  	  <input type="submit" value="회원가입"/>
	  	 </form></div></td>
		 <td><div align="right">
		 <form action="/bookchange/MemberService" method="post">
	  	 <input type="hidden" name="method" value="">
	  	   <input type="submit" value="Email/Pw찾기"/>
	  	 </form></div></td>
		 </tr>
	     </table>
	     </fieldset>
	    </c:when>
	   <c:otherwise>
	    <fieldset>
	 	<table cellpadding="0" cellspacing="0" border="0">
	    <form action="/bookchange/MemberService" method="post">
		<input type="hidden"name="method" value="logout">
		<tr>
		 <td>${sessionScope.LOGIN_EMAIL.email}님이 로그인하였습니다.</td>
		</tr>
		<tr>
		 <td colspan="5"><div align="right">
		 <input type="submit" value="로그아웃">
		 </div></td>
		</tr>
		</form>
		<tr>
		 <td><div align="right">
		 <form action="/bookchange/MemberService" method="post">
	  	 <input type="hidden" name="method" value="removeMemberForm">
	  	  <input type="submit" value="회원탈퇴"/>
	  	 </form></div></td>
		 <td><div align="right">
		 <form action="/bookchange/MemberService" method="post">
	  	 <input type="hidden" name="method" value="editMemberForm">
	  	   <input type="submit" value="정보수정"/>
	  	 </form>
		 </div></td>
		</tr>
	    </table>
	    </fieldset>
	</td>
	</tr>
	<tr>
	 <table cellpadding="0" cellspacing="0" border="0">
	   <tr>
	   <td><a href="/bookchange/BlockService?method=addBlockForm">
	   <img align="right" src="webimg/block.GIF" title="신고하기" border="0" width="230"/></a></td>
	   </tr>
	   
   <tr>
	   <td align="center">
	   <form action="/bookchange/BoardService" method="post">
	   <input type="hidden" name="method" value="searchBoardList">
	   <input type="hidden" name="categoryNo">
	   <input type="hidden" name="column" value="email">
	   <input type="hidden" name="keyword" value="${sessionScope.LOGIN_EMAIL.email}">
	   <input type="submit" value=" 등록한 책 목록 "></td>
	   </form>
	   </tr>	
	   
	   <tr>
		<td height="10"></td>
		</tr>  
	   
	   <tr>
	   <td align="center">
	   <form action="/bookchange/ChangeService" method="post">
	   <input type="hidden" name="method" value="requestChangeList">
	   <input type="submit" value="요청한 교환신청"></td>
	   </form>	   
	   </tr>
	   
	   <tr>
		<td height="10"></td>
		</tr>
	   
	   <tr>
	   <td align="center">
	   <form action="/bookchange/ChangeService" method="post">
	   <input type="hidden" name="method" value="acceptChangeList">
	   <input type="submit" value="들어온 교환신청"></td>
	   </form>	   
	   </tr>
	   
	   <tr>
		<td height="10"></td>
		</tr>
	   
	   <tr>
	   <td align="center">
	   <form action="/bookchange/ChangeService" method="post">
	   <input type="hidden" name="method" value="matchChangeList">
	   <input type="submit" value="교환진행중인 책 목록"></td>
	   </form>	   
	   </tr>
	   
	   <tr>
		<td height="10"></td>
		</tr>
	   
	   <tr>
	   <td align="center">
	   <form action="/bookchange/ChangeService" method="post">
	   <input type="hidden" name="method" value="matchChangeResultList">
	   <input type="submit" value="교환완료된 책 목록"></td>
	   </form>	   
	   </tr>  
	   
	   <tr>
		<td height="10"></td>
		</tr>
		
	   <tr>
    <td align="center">
    <form action="/bookchange/BlockService" method="post">
      <input type="hidden" name="method" value="selectMyBlockList">
      <input type="submit" value="신고내역보러가기">
    </form>
    </td>
    </tr>  
	     
	     </c:otherwise>
	  </c:choose>
	   
	   
	   
	   
	 </table>
	 </tr>
	 <td width="550" height="600" valign="top" bgcolor="#FFFFE0">
	 	<table width="550" height="600" cellpadding="0" cellspacing="0" border="1">
	 	<td valign="top">
	 	 
 
<h3 align="center">물품등록</h3>
<form id="add_board" action="/bookchange/BoardService" method="post">
<input type="hidden" name="method" value="addBoard"/>
<input type="hidden" name="email" value="${sessionScope.LOGIN_EMAIL.email}"/>
<input id="photo" type="hidden" name="boardPhoto" value=""/>
		<table border="1" align="center">				
		<tr align="center">
		<td>
		<label>작성자</label> ${sessionScope.LOGIN_EMAIL.email}<br/>
		</td>
		<td>
		카테고리 <select name="categoryNo">
		 <c:forEach var="category" items="${CATEGORY_LIST}">
		     <option value="${category.categoryNo}">${category.categoryName}</option>
		 </c:forEach>
		</select><br/>
		</td>
		<td>
		거래방법 <select name="dealNo">
		 <c:forEach var="deal" items="${DEAL_LIST}">
		     <option value="${deal.dealNo}">${deal.dealWay}</option>
		 </c:forEach>
		</select><br/>
		</td>
		</tr>
		<tr>
		<td colspan="2">
		<label>제목 </label><input type="text" size="50" name="boardTitle"/><br/>
		</td>
		<td>
		<label>원하는 물건 </label><input type="text" size="20" name="boardWant"/><br/>
		</td>		
		</tr>
		<tr>
		<td colspan="3">
		<label>내용</label><br><textarea cols="60" rows="10" name="boardContent"></textarea><br/>
		</td>
		</tr>
		<tr align="center">	
		</table>
</form>	
<table align="center">
<tr><td><input type="file" name="file" id="uploadify"/></td>
	<td><input type="button" id="addPhoto" value="등록" /></td>

	<td><form action="/bookchange/BoardService" method="post">
		<input type="hidden" name="method" value="viewBoardList"/></td>
	<td><input type="submit" value="취소"></td> 
		</form></td></tr>
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