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
	<h1>Course Details</h1>


	<form action="${pageContext.request.contextPath}/deleteUpdateCourse"
		method="post">
		<p style="color: red">
			<b>${requestScope.exception}</b>
		</p>
		<h2>Course Details</h2>
		<p>
			Course Code <input type="text" name="codeCourse"
				value="${sessionScope.course.courseCode}" />
		</p>

		<p>
			Course Name: <input type="text" name="CourseName"
				value="${sessionScope.course.courseTitle}">

		</p>
		<h2>Professor Details</h2>
		<p>
			First Name : <input type="text" name="profFirstNameCourse"
				value="${sessionScope.course.professor.firstName}">
		</p>
		<p>
			Middle Name: <input type="text" name="profMiddleNameCourse"
				value="${sessionScope.course.professor.middleName}">
		</p>
		<p>
			Last Name : <input type="text" name="profLastNameCourse"
				value="${sessionScope.course.professor.lastName}">
		</p>
		<p>Choose one option</p>

		<input type="submit" value="Update" name="submit" style="width: 98px;">
		<input type="submit" value="Delete" name="submit" style="width: 98px;">

	</form>

	<form action="${pageContext.request.contextPath}/deleteUpdateCourse"
		method="get">
		<p>
			<input type="submit" value="Back" name="submit" style="width: 98px;">
			<input type="submit" value="Reset" name="submit" style="width: 98px;">
		</p>
	</form>

</body>
</html>