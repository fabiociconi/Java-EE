<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assignment #4</title>
</head>
<body>
	<h1>LOGIN</h1>
	<h2>Please type your user to login into the System....</h2>
	
<form action="${pageContext.request.contextPath}/registerLogin" method="post">
	<p>
		User Name: 
		<input type="text" name="username"> 
		<input type="submit" name="login" value="Sign in" style="width: 150px;">
		</p>	
			</form>
			 <p style="color:red"> <b>${requestScope.exception}</b></p>
</body>
</html>