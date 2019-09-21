
<%@ page import=" com.nagarro.Model.LoginBean"%>
<%@ page import=" com.nagarro.Services.ImageServices"%>

<%@ page import=" com.nagarro.Model.ImageBean"%>
<%@ page import=" java.util.List"%>
<%@ page import=" java.util.*"%>
<%@ page import=" java.io.*"%>
<%@ page import=" java.util.ArrayList"%>
<%@ page import=" java.sql.Blob"%>
<%@ page import=" java.awt.image.BufferedImage"%>
<%@ page import=" javax.imageio.ImageIO"%>
<%@ page import=" java.io.ByteArrayInputStream"%>
<%@ page import=" java.text.DecimalFormat"%>
<%@ page import=" java.math.RoundingMode"%>




<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!-- display page for image upload and display and performing actions  -->

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Upload Image</title>
<script type="text/javascript">
	function refreshPage() {
		if (confirm("Are you sure, want to Cancel?")) {
			location.reload();
		}
	}
</script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
.button {
	width: 75px;
	margin: 10px;
}

.btn {
	background-color: white; /* Blue background */
	border: none; /* Remove borders */
	color: blue; /* White text */
	padding: 12px 16px; /* Some padding */
	font-size: 26px; /* Set a font size */
	cursor: pointer; /* Mouse pointer on hover */
}

/* Darker background on mouse-over */
.btn:hover {
	background-color: lightgrey;
}
</style>
</head>
<body>

	<%
		response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");

		if (session.getAttribute("userLoginInfo") == null) {
			request.setAttribute("error", "Please Login First");
			request.getRequestDispatcher("/LoginPage.jsp").forward(request, response);
			//response.sendRedirect("/logoutController.java");

		} else {
	%>

	<form action="ImageController" method="post"
		enctype="multipart/form-data">
		<fieldset>
			<center>
				<b> IMAGE MANAGEMENT UTILITY</b>
			</center>
			<hr>
			<p align="right">

				Welcome
				<%
					LoginBean userDet = (LoginBean) session.getAttribute("userLoginInfo");
						String userName = userDet.getUsername();
						out.println(userName);
				%>

				<br> <a href="LogoutController">Sign Out</a>
			</p>

			Please select an image file to upload(Max Size 1 MB) <br> <br>
			<input type="text" id="image-div" disabled> <input
				type="file" id="image" name="image" accept="image/*" multiple
				required> <br> <br> <br> <input
				class="button" type="button" style="float: right" value="Cancel"
				onClick='refreshPage()' /> <input class="button" type="submit"
				style="float: right" value="Submit">


		</fieldset>
	</form>

	<style type="text/css">
table, th, td {
	border: 3px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
	text-align: center;
	colspan
}

table {
	border-spacing: 5px;
}
</style>

	<%
		}

		LoginBean imageListTemp1 = (LoginBean) session.getAttribute("dbUser");

		List<ImageBean> imageListTemp = imageListTemp1.getImages();

		out.println("Total image(s) uploaded = " + imageListTemp.size());

		if (imageListTemp.size() != 0) {
	%>

	<fieldset>
		<table style="width: 100%">

			<tr>
				<th colspan="1">S.No</th>
				<th colspan="2">Name</th>
				<th colspan="2">Size</th>
				<th colspan="3">Preview</th>
				<th colspan="2">Action</th>
			</tr>




			<%
				if (session.getAttribute("dbUser") != null) {

						LoginBean imageList1 = (LoginBean) session.getAttribute("dbUser");
						List<ImageBean> imageList = imageList1.getImages();

						int i = 1;
						for (ImageBean eachImageAll : imageList) {
			%>
			<tr>
				<td colspan="1">
					<%
						int imageId = eachImageAll.getImage_id();
									out.println(i);
					%> <input type="hidden" name="imgID" value="<%=imageId%>" />

				</td>

				<%
					Blob eachImageBlob = eachImageAll.getImage();
				%>
				<td colspan="2">
					<%
						String imageName = eachImageAll.getImagename();
									out.println(imageName);
					%>
				</td>

				<%
					int blobImageLength = (int) eachImageBlob.length();
								byte[] eachImageByte = eachImageBlob.getBytes(1, blobImageLength);
								String imgStringBase64 = Base64.getEncoder().encodeToString(eachImageByte);
				%>

				<td colspan="2">
					<%
						DecimalFormat df = new DecimalFormat("#.###");
									df.setRoundingMode(RoundingMode.CEILING);

									double sizeImageBytes = (imgStringBase64.length());
									double sizeImageMB = sizeImageBytes / 1024 / 1024;
									out.println(df.format(sizeImageMB) + "MB");
					%></td>


				<td colspan="3">
					<%
						out.println("<img src='data:image/jpg;base64," + imgStringBase64 + "' width='100' height='100'/>");
					%>
				</td>
				<td><a href="UpdateController?imageId=<%=imageId%>">
				<button class="btn">
						<i class="fa fa-edit"></i>
				</button></a> 
				<a href="DeleteController?imageId=<%=imageId%>">
				<button	class="btn">
						<i class="fa fa-trash"></i>
				</button></a></td>
				<%
					i++;

							}

						}
				%>

			</tr>
			<%-- <tr>
				<td colspan="1"></td>
				<td colspan="2">
					<%
						out.println("Total" + "\n" + "Size");
					%>
				</td>
				<td colspan="2">
					<%
					 DecimalFormat df = new DecimalFormat("#.###");
					df.setRoundingMode(RoundingMode.CEILING);
					out.println(df.format(ImageServices.totalSize/1024/1024) + "MB"); 
					%> 
				</td>
				<td colspan="3"></td>
				<td colspan="2"></td>

			</tr> --%>
		</table>
	</fieldset>
	<%
		}
	%>
</body>
</html>