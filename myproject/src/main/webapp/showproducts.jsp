<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List here</title>
</head>
<body>
<H3> List of all products</H3>
<table>
<tr> <th>ID</th> <th>Name </th>  <th> Deatails </th></tr>
<c:forEach items="${products}" var="p">

<tr> <td> ${p.id} </td> <td> ${p.name}</td> <td> <a href="products/${p.id}">View</a> </td> </tr>

</c:forEach>
</table>
</body>
</html>