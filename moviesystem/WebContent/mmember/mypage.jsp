<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html> 
	<head>
		<title>MyPage</title>
		<meta charset="euc-kr"/> 	
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
		
		<link href="../framework/jquery.mobile-1.0.css" 
			rel="stylesheet" type="text/css" />
		<script src="../framework/jquery-1.6.4.js"></script>
		<script src="../framework/jquery.mobile-1.0.js"></script>
	
	</head> 

	<body>
		<div data-role="dialog">		
			
			<div data-role="header" data-theme="d">
				<h1>MyPage</h1>
			</div><!-- end header -->
			
		 	<div data-role="content" align="center">
		  	  <h3 align="center">${LOGIN_MEMBER.name}님 환영합니다.</h3><br/>
		    	<a href="/moviesystem/meditMemberForm.action"  data-role="button" data-transition="slide">Edit Member</a>
		    	<a href="/moviesystem/mViewBuyList.action" data-role="button" data-transition="slide">Buy List</a>
		   	 	<a href="/moviesystem/mCancelBuyListForm.action" data-role="button" data-transition="slide">Cancel Buy</a>
		    	<a href="/moviesystem/mViewCanceledBuyList.action" data-role="button" data-transition="slide">Canceled Buy List</a>
		    	<a href="/moviesystem/mviewReservationListById.action" data-role="button" data-transition="slide">ResercationList</a>
		     	<c:if  test="${LOGIN_MEMBER.userid=='mmanager'}">
		      		<a href="/moviesystem/mviewMemberList.action" data-role="button" data-transition="slide">Member Management</a>
		      		<a href="/moviesystem/mViewManageGoodList.action" data-role="button" data-transition="slide">Good Management</a>
		      		<a href="/moviesystem/mAdminMovieList.action" data-role="button" data-transition="slide">Movie List</a>
		    	</c:if>
		   </div><!-- end content -->
		   
		</div><!-- end dialog -->
	</body>
</html>

