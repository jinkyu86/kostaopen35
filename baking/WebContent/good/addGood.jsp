<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>


<h1 align="center">상품추가</h1>
	<form action="/baking/GoodService" method="post">
	<input type="hidden" name="method" value="addGood">
		<table>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>상품설명</td>
				<td><textarea name="explantion" rows="10" cols="30" ></textarea>
				</td>
			</tr>
			<tr>
				<td>단가</td>
				<td><input type="text" name="goodPrice" id="goodPrice">
				</td>
			</tr>
			<tr>
				<td>옵션</td>
				<td><input type="text" name="option" id="option">
				</td>
			</tr>
			<tr>
				<td>상품구분</td>
				<td><select name="division">
						<c:forEach var="good_division" items="${DIVISION_LIST}">
					<option value="${good_division.division }">
							${good_division.gName}
					</option>
						</c:forEach>
				</select>
				</td>
				</tr>
				<tr>
				<td>이미지</td>
				<td><input type="text" name="img"></td>
			</tr>
			<tr>
				<td><input type="submit" value="저장"/></td>
				<td><input type="reset" value="취소"/></td>
		</table>
	</form>
</html>