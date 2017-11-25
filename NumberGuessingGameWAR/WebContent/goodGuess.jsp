<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>goodGuess</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1>Game over -- I won</h1>
<p>Guessed your  number <b> ${sessionScope.Guesser.lastGuess}</b>
in <b>${sessionScope.Guesser.guessCount}</b> tries.</p>
<p>Click to <a href="${pageContext.request.contextPath}/GuessingGame" ><b>try again</b></a></p>
</body>
</html>