<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome to the <i>Fabio Ciconi's</i> Club</h3>

<p> If you are a not member, complete the form below and click Register to join
and sign in.</p>
<p>Members should Sign in on the <a href="${pageContext.request.contextPath}/reg">Log in</a> page</p>


<p>Registration Form:</p>
 <p style="color:red"> <b>${requestScope.exception}</b>
 
<form action="${pageContext.request.contextPath}/reg" method="post">
	User Name: 
	<input type="text" name="username"> <br>
	First Name: 
	<input type="text" name="firstname"><br>
	Last Name: 
	<input type="text" name="lastname"><br> 
	Password  : 
	<input type="password" name="password"><br>
	<input type="submit" name="login" value="Register" style="width: 150px;">
	</form>
</body>
</html>