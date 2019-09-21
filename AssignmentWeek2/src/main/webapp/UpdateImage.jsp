<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- Extracting imagename fron user and passing to update controller -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateController" method="post">

		Enter New Name of Image
		 <input type="text" name="newImageName">
		
		<input type="submit" name="submit" value="Update">

	</form>
</body>
</html>