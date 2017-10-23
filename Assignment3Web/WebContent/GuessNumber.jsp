<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guess Number</title>
</head>

<body>

	<h1>Guess Number : ${sessionScope.guessNumber.guessCount}</h1>
<%-- 	//${sessionScope.game.guessCount --%>
	<p>
		Is your number : <b>${sessionScope.guessNumber.lastGuess}</b>

	</p>


	<p>Please indicate whether this guess is</p>
	<form action="${pageContext.request.contextPath}/guessnumber"
		method="post">
		
<input type="submit" name="getAnswer" value="Correct" style="width: 80px;">
<input type="submit" name="getAnswer" value="Too High" style="width: 80px;"> 
or <input type="submit" name="getAnswer" value="Too Low" style="width: 80px;">

	</form>


</body>
</html>