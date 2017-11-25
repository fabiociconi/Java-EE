<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game Over</title>
</head>
<body>
<h1><b>Game Over</b></h1>

<p>Guessed your number <b>${sessionScope.guessNumber.lastGuess}</b> in 
<b> ${sessionScope.guessNumber.guessCount}</b></p>

<p>Click to <a href="${pageContext.request.contextPath}/guessnumber">try again</a></p>

</body>
</html>