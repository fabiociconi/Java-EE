<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="banner.jsp" />
	For the real club this page would show club news, have links  to activities
	and much more. 
	For testing purposes list all currents member of the club.
	<br> 
	<c:forEach items="${sessionScope.men}" var="item">
    ${item}<br>
</c:forEach>
</body>
</html>