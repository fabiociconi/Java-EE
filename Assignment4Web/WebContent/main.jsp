<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assignment 4</title>
</head>
<body>
	<jsp:include page="banner.jsp" />
	<h1>Main Page</h1>
	<p>To work with an existing course, enter course code.</p>
	<form action="${pageContext.request.contextPath}/getCourse"
		method="post">
		<input type="text" name="getCourse"> 
		<input type="submit" name="get" value="Get" style="width: 105px;">

	</form>
	<p style="color: red">
		<b>${requestScope.exception}</b>
	</p>
	<hr />
	
	<p>Add Course</p>
	
	<form action="${pageContext.request.contextPath}/getCourse"
		method="get">
		<input type="submit" name="submit" value="Add" style="width: 98px;">	
	</form>
</body>
</html>


