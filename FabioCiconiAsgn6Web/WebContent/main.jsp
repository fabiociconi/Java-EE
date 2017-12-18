<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Courses web main page</title>
</head>
<body>
<%@ include file="banner.jsp"%>
<h2>Main page</h2>
<form action="${pageContext.request.contextPath}/main" method="post">
<p>To work with an existing course, enter the course code.<br> 
<font color="red"> ${requestScope.message}</font></p>
<input type="text" id="courseCode" name="courseCode" value="${sessionScope.courseCode}" />
<input type="submit" name="submit" value="Get">
<hr/>
<p>To add a new course <input type="submit" name="submit" value="Add"></p>  
</form>
</body>
</html>