<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>도서물물 교환</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script type="text/javascript">
	<c:if test="${ERROR!=null}">
	alert("${ERROR}");
	</c:if>
</script>
</head>
<body topmargin="0" leftmargin="0" bgcolor="#FFFFFF">
	<table>
	 <td width="550" height="600" valign="top">
	 
	 <h5 align="center">신고내역보기</h5>
	 
	  <table bordercolor="#FFA500" border="1" align="center">
	   <tr align="center">
	   	<th>Email</th>
	    <th>신고대상</th>
	    <th>현재상태</th>
	   </tr>
	  <c:forEach var="block" items="${MY_BLOCK_LIST}">
       <tr>
        <td align="center">${block.member.email}</td>
        <td align="center">${block.blockmember.email}</a></td>
		<td align="center">${block.blockCondition.blockConditionIng}</td>
       </tr>
      </c:forEach>
      </table>
     
	  <p align="center">
		${PAGE_LINK_TAG}
	  </p>
	  </td>
	  </table>
</body>
</html>