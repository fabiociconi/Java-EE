<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Fabio Ciconi 's Club</h1>
 <p style="color:red"> <b>${requestScope.exception}</b>
 User Name require to register
 <hr>
 Please <a href="${pageContext.request.contextPath}/login">try again</a>
</body>
</html>