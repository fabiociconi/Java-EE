<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lucky Star Restaurant</title>
</head>
<body>
	<h1>WELCOME TO THE STAR RESTAURANT</h1>
	<hr>
	<p style="color: red">
		<b>${requestScope.message}</b>
	</p>
	<c:forEach items="${sessionScope.map}" var="item">
    ${item}<br>
	</c:forEach>
	<hr>
	<form action="${pageContext.request.contextPath}/showmenu"
		method="post">
		Enter your name: <input type="text" name="username"> And click
		to <input type="submit" value="Place an Order" />
	</form>
</body>
</html>