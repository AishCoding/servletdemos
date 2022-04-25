<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*, com.mvcdemo.model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
</head>
<body>
<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
		</tr>
		<c:forEach var="student" items="${studentList}">
			<tr>
				<td>${student.firstname}</td>
				<td>${student.lastname}</td>
				<td>${student.email}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>