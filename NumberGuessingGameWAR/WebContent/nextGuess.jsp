<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>nextGuess</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1>Guess number: ${sessionScope.Guesser.guessCount}</h1>

<p>Is your number <b>${sessionScope.Guesser.lastGuess}?</b></p>
<form method="post" action="${pageContext.request.contextPath}/GuessingGame" >
Please indicate whether this guess is &nbsp;
<input type="Submit" name="submit" value="correct" /> &nbsp;
<input type="Submit" name="submit" value="too high" />&nbsp; or &nbsp;
<input type="Submit" name="submit" value="too low" />
</form>
</body>
</html>