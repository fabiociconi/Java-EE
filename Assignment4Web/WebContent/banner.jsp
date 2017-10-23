<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banner to include on other pages</title>
</head>
<!-- include the next line in other JSPs before you use the JSTL tags from the core library   -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
<h3>Welcome ${sessionScope.user.user} to the online course web.</h3>
<p>There are <b>${sessionScope.codeCourseAtr.courseQtd}</b> courses in our system.</p>
<p>The last update time:<b> ${applicationScope.lastUpdated}</b></p>
<%-- <p>${sessionScope.map}</p> --%>
<c:forEach items="${sessionScope.map}" var="item">
    ${item}<br>
</c:forEach>
<form action="${pageContext.request.contextPath}/registerLogin" method="get">
<input type="submit" value="Sign out"/> 
</form>
<hr/>
</body>
</html>