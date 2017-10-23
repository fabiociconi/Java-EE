<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="banner.jsp" />
	<h1>Add New Course</h1>
	<form action="${pageContext.request.contextPath}/addCourse"
		method="post">
		<p style="color: red">
			<b>${requestScope.exception}</b>
		</p>
		<h2>Course Details</h2>
		<p>
			Course Code <input type="text" name="codeCourse">
		</p>
		<p>
			Course Name <input type="text" name="nameCourse">
		</p>
		<h2>Professor Details</h2>
		<p>
			First Name : <input type="text" name="profFirstNameCourse">
		</p>
		<p>
			Middle Name: <input type="text" name="profMiddleNameCourse">
		</p>
		<p>
			Last Name : <input type="text" name="profLastNameCourse">
		</p>
		<p>
			To add a new course <input type="submit" value="Add" name="Add"
				style="width: 98px;">
		</p>
	</form>
	<form action="${pageContext.request.contextPath}/addCourse"
		method="get">
		<p>
			<input type="submit" value="Cancel" name="submit" style="width: 98px;">
		</p>
	</form>
</body>
</html>