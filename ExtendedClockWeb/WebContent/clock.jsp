<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Extenfed Cclock</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h2>Paula's International clock</h2>
   <p>
   <c:forEach items = "${sessionScope.CallHistory}" var = "time">
       ${time} <br/>
   </c:forEach>
   </p>

<h2>Current time:<br/> ${requestScope.currentTime}</h2>
<h3>Format the time display</h3>
<form action="${pageContext.request.contextPath}/clock" method="post">
Select format <select name = "format">
  <option value = "full" 
     <c:if test = "${requestScope.format == 'full'}" > SELECTED </c:if>
 > full </option>
  <option value = "long" 
     <c:if test = "${requestScope.format == 'long'}" > SELECTED </c:if>
                          > long </option>
  <option value = "medium" 
     <c:if test = "${requestScope.format == 'medium'}" > SELECTED </c:if>
                          >medium</option>
  <option value = "short"
     <c:if test = "${requestScope.format == 'short'}" > SELECTED </c:if>
                          >short </option>
</select>
and click
<input type="submit" value="get time" />
</form>
<hr>
<p>Current locale: <b>${requestScope.localeName}</b><br/>
<!-- link to LocaleServlet.doGet() to clear user's session before returning to welcome page
--> 
To change locale, <a href="${pageContext.request.contextPath}/setLocale">Start over</a>. </p>
</body>
</html>