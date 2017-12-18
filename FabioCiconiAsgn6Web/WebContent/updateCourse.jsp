<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update course</title>
</head>
<body>
<%@ include file="banner.jsp" %>
<h2>Enter new values to update a course</h2>
<font color="red">${requestScope.message}</font>
<form action="${pageContext.request.contextPath}/update" method ="post">
<table>
<tr>
<td>Course code</td>
<td><b><input type="text" size="10" readonly name="courseCode" value="${requestScope.courseCode}"/></b></td>
</tr><tr>
<td>Course title</td>
<td>
<input type="text" size="40" name="courseTitle" value="${requestScope.courseTitle}" /> 
</td>
</tr><tr>
<td>Current Professor</td>
<td><b>
<c:choose> 
<c:when test = "${requestScope.professor == null}" >TBA: Not assigned</c:when>
<c:otherwise>${ requestScope.professor.getFullName() }</c:otherwise>
</c:choose>
</b></td>
</tr><tr>
<td>Select new Professor</td>
<td>
<select name="profId">
<c:choose>
<c:when test = "${requestScope.professor == null}">
<option value="TBA" selected>To Be assigned</option>
<option value="Add">Add </option>
</c:when>
<c:otherwise>
<option value="${requestScope.professor.profId}" selected>${requestScope.professor.getFullName() }</option>
<option value="TBA">To be assigned</option>
<option value="Add">Add</option>
</c:otherwise>
</c:choose> 
<c:forEach items="${requestScope.professors}" var="prof">
<c:if test = "${requestScope.professor.profId != prof.profId }">
<option value="${prof.profId}">${prof.getFullName() }</option>
</c:if>
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
<input type="submit" name="submit" value = "Update" />
<input type="reset" name="reset" value ="Reset form" />
<input type="submit" name="submit" value="Cancel" />
</form>
</body>
</html>