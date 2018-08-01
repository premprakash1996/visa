<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login here</title>
</head>
<body>
<h2>Login Page with form tags and bean</h2>
<form:form commandName="user" method="POST">
	User Name <form:input path="name"/> <br/>
	Password <form:password path="password"/><br/>
	<input type="submit" value="Login">
</form:form>
</body>
</html>