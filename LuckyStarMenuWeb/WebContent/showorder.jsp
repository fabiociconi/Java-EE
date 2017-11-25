<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<title>Order confirmation</title>
</head>
<body>
	<h2>${sessionScope.orderId},please confirm your order</h2>
	<table border=1>
		<tr>
			<th>Number</th>
			<th>Description</th>
			<th>Unit Price</th>
			<th>Quantity</th>
			<th>Cost</th>
		</tr>
		<c:set var="totalCost">0.0</c:set>
		<c:forEach items="${sessionScope.order}" var="item">
			<tr>
				<td>${item.itemNo}</td>
				<td>${item.itemDesc}</td>
				<td><fmt:formatNumber type="currency">${item.itemPrice}</fmt:formatNumber></td>
				<td>${item.quantity}</td>
				<c:set var="cost">${item.itemPrice*item.quantity}</c:set>
				<td><fmt:formatNumber type="currency">${cost}</fmt:formatNumber></td>
				<c:set var="totalCost">${cost + totalCost }</c:set>
			</tr>
		</c:forEach>
		<tr>
			<td>&nbsp;</td>
			<td>TOTAL cost of order</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td><fmt:formatNumber type="currency">${totalCost}</fmt:formatNumber></td>
		</tr>
	</table>
	<table>
		<tr>
			<td width=100>
				<form action="${pageContext.request.contextPath}/confirmorder"
					method="post">
					<input type="submit" value="CONFIRM" name="confirm" />
				</form>
			</td>
			<td width=100>
				<form action="${pageContext.request.contextPath}/confirmorder"
					method="post">
					<input type="submit" value="CANCEL" name="confirm" />
				</form>
			</td>
			<td>To EDIT, use the BACK button</td>
		</tr>
	</table>
</body>
</html>