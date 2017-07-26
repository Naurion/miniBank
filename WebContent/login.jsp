<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<form action="Login" method="POST">
 <fieldset>
  <legend>Login in your cabinet:</legend>
    <pre>Your username: <input size="20" type="text" name="username"></pre>
    <pre>Your password: <input size="20" type="password" name="password"></pre>
    <input size="20" type="submit" value="Send" /><input size="20" type="reset" value="Clear">
 </fieldset>
</form>
	
</body>
</html>