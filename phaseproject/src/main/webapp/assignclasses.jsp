<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
    <h2>Assign classes for subjects</h2>
    <form action="assignclassServlet" method="post">
        Select a Class:
        <select name="classes">
            <c:forEach items="${listClass}" var="classes">
                <option value="${classes.cname}">
                    ${classes.cname}
                </option>
            </c:forEach>
        </select>
        Select a Subject:
        <select name="subjects">
            <c:forEach items="${listClass}" var="subjects">
                <option value="${subjects.sname}">
                    ${subjects.sname}
                </option>
            </c:forEach>
        </select>
        <br/><br/>
        <input type="submit" value="Assign" />
    </form>
</div>
</body>
</html>