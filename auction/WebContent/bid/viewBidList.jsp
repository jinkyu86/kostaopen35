<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@ page import="java.util.ArrayList" --%>
<%--@ page import="kr.or.kosta.student.Student" --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>입찰 리스트</title>
</head>
<body>
<table border="1" align="center">
	<tr>
		<th>입찰번호</th>
		<th>이름</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>학과</th>
	</tr>
	<%-- 
		ArrayList<Student> studentList=(ArrayList)request.getAttribute("STUDENT_LIST");
		for(int i=0;i<studentList.size();i++){
			Student student=studentList.get(i);
	--%>
	<c:forEach var="student" items="${STUDENT_LIST}">	
	
	<tr>
		<td>${student.studno }</td>
		<td>
		<a href="/ex20120305/StudentService?method=viewStudent&studno=${student.studno }">
		${student.name }</td>
		</a>
		<td>${student.userid }</td>
		<td>${student.pw }</td>
		<td>${student.department.dname }</td>
	</tr>
	</c:forEach>
</table>	
<p align="center">
	${PAGE_LINK_TAG}
<p align="center">
	<a href="/ex20120305/StudentService?method=addStudentForm">학생추가</a>
	</p>
</body>
</html>