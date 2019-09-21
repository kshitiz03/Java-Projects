<%@ page import=" com.nagarro.Model.LoginBean"%>
<%@ page import=" com.nagarro.Model.ImageBean"%>
<%@ page import=" java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<!-- UI page after logout, passing request to logout controller and and throwing flow to login page  -->
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
</head>
<body>

	<%
		response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");

		HttpSession httpSession = request.getSession(true);
		request.setAttribute("error", "You have logged out successfully");

		String s1 = (String) session.getAttribute("username");

		LoginBean lb = (LoginBean) session.getAttribute("userLoginInfo");

		List<ImageBean> ib = lb.getImages();
		System.out.print(ib.size());

		session.removeAttribute("username");
		session.removeAttribute("userLoginInfo");

		session.invalidate();
		request.getRequestDispatcher("LogoutController").forward(request, response);
	%>


</body>
</html>