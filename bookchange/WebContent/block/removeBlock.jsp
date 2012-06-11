<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
<body>
 <form action="/bookchange/removeBlock.action" method="post" target="main">
 	  <table bordercolor="#E6E6FA" border="1" align="center">
  <c:if test="${LOGIN_EMAIL.email}">
         <tr>
         <ul><li><div> 삭제할 번호 입력</div><<textarea cols="40" rows="15" name="blockcontent">${block.blockNo}</textarea></li></ul>
         <ul><div><input type="submit" value="삭제"/></div></ul>	
        </tr>
  </c:if>
  </table>
 </form>
</body>
</html>