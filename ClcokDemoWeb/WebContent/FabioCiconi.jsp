
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Current time display page</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1>Current date and time on server</h1>
<p>${requestScope.currentTime}</p>
<h2>Use this from to select another format</h2>
<form action="${pageContext.request.contextPath}/clock" method="post">
Select format <select name = "format">
  <option value = "full" > full </option>
  <option value = "long" > long </option>
  <option value = "medium" > medium </option>
  <option value = "short" > short </option> 
 </select> and click 
<input type="submit" name="getTime" value="Get Time">
</form>
</body>
</html>
