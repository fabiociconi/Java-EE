<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a course</title>
</head>
<body>
<h2>Add a new course</h2>
<%@ include file="banner.jsp" %>
<h2>Enter data for a new course</h2>
<font color="red">${requestScope.message}</font>
<form action="${pageContext.request.contextPath}/add" method="post">
<table>
<tr>
<td>Course code</td>
<td><b><input type="text" size="10" name="courseCode" value="${requestScope.course.courseCode}"/></b></td>
</tr><tr>
<td>Course title</td>
<td>
<input type="text" size="40" name="courseTitle" value="${requestScope.course.courseTitle}" /></td>
</tr><tr>
<td>Select a Professor</td>
<td>
<select name="profId">
<option value="TBA">To Be assigned</option>
<option value="Add">Add</option>
<c:forEach items="${requestScope.professors}" var="prof">
<option value="${prof.profId}">${prof.getFullName() }</option>
</c:forEach>
</select>
</td></tr>
</table>
To add a new professor, select <b>Add</b> from the dropdown list above and supply the name below.
<fieldset>
<legend>New professor name</legend>
<table>
<tr>
<td>First name:</td>
<td><input type="text" size="20" name="profFirstName" value="${requestScope.profFirstName}"></td>
</tr><tr>
<td>Middle name:</td>
<td><input type="text" size="20" name="profMiddleName" value="${requestScope.profMiddleName}"></td>
</tr><tr>
<td>Last name:</td>
<td><input type="text" size="20" name="profLastName" value="${requestScope.profLastName}"></td>
</tr>
</table></fieldset>
<input type="submit" name="add" value="Add">
<input type="submit" name="cancel" value="Cancel">
</form>
</body>
</html>