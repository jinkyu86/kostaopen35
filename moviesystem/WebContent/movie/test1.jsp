<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		$("#mnum").change(function(){
			var mnum = $("#mnum").val();
			//alert(mnum);
			//var servlet_url = "";
			$.getJSON("/moviesystem/MovieService?method=MovieTimeList",
				{"mnum" : mnum},
				function(data){
					//이이디가 model인 객체의 내용 삭제
				$("#scrnum").empty();
					//data에 들어있는 json객체의 수 리턴
				var length = data.length;
				for(var i=0; i<length; i++){
					var option = "<option value="+ data[i].scrnum +">"+ data[i].time +"</option>";
					$("#scrnum").append(option);
				}
			});
		});		
	});
</script>
</head>
<body>
	<form id="my_form">
		<table border="1">
			<tr>
				<td>
					<select name="mnum"  id="mnum">
						<c:forEach var="movieList" items="${MovieList}" varStatus="n">
							<option value="${movieList.mnum}">${movieList.mname}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<select id="scrnum" name="scrnum">
					</select>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>