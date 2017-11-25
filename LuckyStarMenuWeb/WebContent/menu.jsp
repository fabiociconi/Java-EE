<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Lucky Star</title>
</head>
<body>
	<h1>Welcome to the Lucky Star Restaurant</h1>
	<p>
		<font color="red"> ${requestScope.message}</font>
	</p>
	<hr />
	<c:forEach items="${requestScope.menu}" var="item">
${item}<br />
	</c:forEach>
	<hr />
	<form action="${pageContext.request.contextPath}/showmenu"
		method="post">
		Enter your name:<input type="text" value="" name="orderId">
		And click to <input type="submit" value="Place an order">
	</form>
</body>
</html>