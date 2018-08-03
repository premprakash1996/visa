<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login here</title>
<style type="text/css">
.err{
color:red;
}
</style>
</head>
<body>


<h2>Login Page with form tags and bean</h2>

<form:form commandName="user" method="POST">
<p> <form:errors path="*" element="div" cssClass="err"/> </p>
	User Name <form:input path="name"/> <form:errors path="name" cssClass="err"/> <br/>
	Password <form:password path="password"/> <form:errors path="password" cssClass="err"/><br/>
	<input type="submit" value="Login">
</form:form>

</body>
</html>



