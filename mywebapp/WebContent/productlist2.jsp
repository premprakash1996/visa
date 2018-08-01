<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Products here</title>
</head>
<body>


<h3>List of All Products</h3>
<form action="addtocart" method="post">
<table border=0>
	<tr> <th>Id</th> <th>Name</th> <th>Price</th> <th>QoH</th> <th>Select</th></tr>
	<c:forEach var="p" items="${listOfProducts}">
		<tr>
		<td>${p.id} </td>
		<td>${p.name}</td>
		<td>${p.price}</td>
		<td>${p.qoh}</td>
		<td><input type="checkbox" name="pid" value="${p.id}"> </td>
		</tr>
	</c:forEach>
</table>
<input type=submit value="Add Selected to Cart">
</form>
<a href=home.html> Back to Home page </a>
</body>
</html>