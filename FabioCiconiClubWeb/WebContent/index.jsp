<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>club welcome page</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<h3>
		Welcome to the <i>Fabio Ciconi's</i> Club
	</h3>
 	<p style="color:red"> <b>${requestScope.Message}</b>
	<fieldset>
		<p>If you are a member, please use the form below to sign in.
		<form method="post" action="${pageContext.request.contextPath}/login">
			<table border="0">
				<tr>
					<td>User name</td>
					<td><input type="text" name="userName" size="12"
						maxlength="12"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" size="12"
						maxlength="12"></td>
				</tr>
			</table>
			<input type="submit" name="login" value="Login">
		</form>
	</fieldset>
	<fieldset>
		<p>
			If you not a member, please <a
				href="${pageContext.request.contextPath}/Welcome.jsp">Register
				to join</a>.
		</p>
	</fieldset>
</body>
</html>