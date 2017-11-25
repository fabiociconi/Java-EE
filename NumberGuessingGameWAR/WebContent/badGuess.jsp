<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>badGuess</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1>All ${sessionScope.Guesser.maxGuessCount} guesses are used</h1>
<h2>You win, but that should never happen.</h2>
<p> Did you change your number or respond incorrectly after a guess?</p>
<p><b>Exception:</b>  ${requestScope.exception } </p>
<p>Click to <a href="${pageContext.request.contextPath}/GuessingGame" ><b>try again</b></a></p>
</body>
</html>