<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<div data-role="header">
				<a href="#" data-icon="arrow-l" data-rel="back"  data-role="button">이전</a>
				
				<div data-role="controlgroup" data-type="horizontal" align="right">
					<c:choose>
					<c:when test="${LOGIN_MEMBER==null}">			
							<a href="/moviesystem/mmember/mloginForm.action" data-role="button" >Login</a>
							<a href="/moviesystem/mmember/maddMemberForm.action" data-role="button">Join</a>
					</c:when>
					<c:otherwise>
							<a href="/moviesystem/mmember/mmypage.action" data-role="button" >MyPage</a>
							<a href="/moviesystem/mlogoutMember.action" data-role="button">Logout</a>
					</c:otherwise>	
					</c:choose>						
				</div>
						
			</div><!-- end header 1-->		
						
			<div data-role="header">
				<div data-role="navbar">
					<ul>
						<li><a href="/moviesystem/mmain.action">Movie</a></li>
						<li><a href="/moviesystem/mViewGoodList.action">Shopping</a></li>
					</ul>
				</div>
			</div><!-- end header2 -->
