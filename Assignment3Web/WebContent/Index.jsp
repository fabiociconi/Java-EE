<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assignment # 3 - Number Guessing Games</title>
</head>
<body>
	<h1>Number Guessing Game</h1>

	<p>Pick a number between 0 to 1000, inclusive. Remember it but
		don't tell me. I guarantee to guess it in 10 guesses or less, provided
		you don't change your number and answer my questions truthfully</p>

	<p>I will make a series of guesses. After each guess please tell me
		whether my guess is too high, too low, or correct. The game ends when
		the guess equals your number</p>
	<!--Comments < -->
	<form action="${pageContext.request.contextPath}/guessnumber"
		method="get">
		<p>
			Click <input type="submit" value="Begin"
				style="height: 34px; color: yellow; background-color: black; width: 88px">
			when you are ready to start the game.
		</p>
	</form>
</body>
</html>