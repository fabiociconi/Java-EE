<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- taglib directive for the JSTL Format library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Building the Order : ${sessionScope.orderId} </h1>
	Please enter the quantity of each item you want to order, and then
	click Order.
	<form action="${pageContext.request.contextPath}/process"
		method="post">
		<table border=2>
			<tr>
				<th>Number</th>
				<th>Description</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<c:forEach items="${sessionScope.map}" var="item">
				<tr>
					<td>${item.itemNo}</td>
					<td>${item.itemDesc}</td>
					<td>
					<fmt:formatNumber type="currency"> ${item.itemPrice} 
					</fmt:formatNumber>
					</td>
					<td><select name="${item.itemNo}">
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
					</select></td>
				</tr>
			</c:forEach>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td><input type="submit" value="Order" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
