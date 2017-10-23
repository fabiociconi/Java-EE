<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game Lost Exception</title>
</head>
<body>
<h1><b>All 10 guesses are used</b></h1>
<h2>You win, but that should never happen.</h2>
<p>Did you change your number or respond incorrectly after a guess?

<p><b>Exception:</b>${requestScope.exception}</p>
		
<p>Click to <a href="${pageContext.request.contextPath}/guessnumber">try again</a></p>
</body>
</html>