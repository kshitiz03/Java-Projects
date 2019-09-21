<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<!-- UI for login page and passing info to loginController-->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<form action="LoginController" method=post>
		<hr>
		LOGIN
		<hr>

		<fieldset>
			Username: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input type="text"
				name="username" placeholder="Enter your username" value="Kshitiz">
			<br> <br> Password: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input
				type="password" name="password" placeholder="Enter your password"
				value="Rawat"> <br> <br>

			<p style="color: red"><%=(request.getAttribute("error") == null) ? "" : request.getAttribute("error")%></p>

			<br> <br> <input type="submit" name="submit" value="Sign In">

		</fieldset>
		

	</form>
</body>
</html>