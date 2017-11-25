<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Clock web welcome page</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1>Welcome to the international clock</h1>
<p>The time is formatted for your country and language and 
to the format details that you request. 
However it is not adjusted for your time zone.</p>

<h2>Please specify your locale.</h2>
<font color="red">${ requestScope.errMsg }</font>
<form action="${pageContext.request.contextPath}/setLocale" method="post">
<select name="locale">
<option SELECTED value = "USA">  USA  </option>
<option value = "GERMANY">Germany</option>
<option value = "QUEBEC">Quebec, Canada</option>
<option value = "JAPAN">Japan</option>
<option value = "ITALY">Italy</option>
</select>
<p>
<input name = "Get Time" type="Submit" value ="Get currrent time on server" />
</p>
</form>
<p><i>Note:<br/></i>Italy is not supported but included to demonstrate error handling.</p>
</body>
</html>