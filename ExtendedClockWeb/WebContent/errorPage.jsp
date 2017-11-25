<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Error</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<h1>Technical Difficulties</h1>
<h3>We are unable to complete your request </h3>
<p> Reason: ${requestScope.exception.message }</p>

<a href="${pageContext.request.contextPath}">Try again</a>

</body>
</html>