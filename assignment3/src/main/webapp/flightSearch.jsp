<%@page contentType="text/html;charset = UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Welcome</title>
</head>
<style>
#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>
<body>
	<table>
		<tr>
			<td>Welcome ${firstname}</td>
		</tr>
		<tr>
		</tr>
		<tr>
		</tr>
	</table>
	<div class="container">
		<form:form id="flightSearchForm" modelAttribute="flightSearch"
			action="flightSearch" method="post" class="form-inline">
			<div class="form-group m-3">
				<form:label path="departureLoc">Departure Location: </form:label>
				<form:input path="departureLoc" name="departureLoc"
					id="departureLoc" class="form-control m-2" />
			</div>
			<div class="form-group">
				<form:label path="arrivalLoc">Arrival Location:</form:label>
				<form:input path="arrivalLoc" name="arrivalLoc" id="arrivalLoc"
					class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="fClass">Class:</form:label>
				<form:select path="fClass" id="fClass" name="fClass" class="form-control">
					<form:option value="EB" label="EB" ></form:option>
					<form:option value="E" label="E"></form:option>
				</form:select>
			</div>
			<div class="form-group">
				<form:label path="fSort">Sort By:</form:label>
				<form:select path="fSort" id="fSort" name="fSort" class="form-control">
					<form:option value="F" label="By Fare"></form:option>
					<form:option value="B" label="By Fare and Duration"></form:option>
				</form:select>
			</div>
			<br>
			<div class="form-group">
				<form:label path="validTill">Date(dd-mm-yyyy):</form:label>
				<form:input path="validTill" id="validTill" name="validTill" class="form-control"/>
			</div>
			<form:button id="search" name="search" class="btn btn-primary mb-2">Search</form:button>
			<a href="index.jsp">Logout</a>
		</form:form>
	</div>
	<br/><br/>
	<div class="container">
	<table id="customers">
		<tr>
			<th>Flight Number</th>
			<th>Arrival Location</th>
			<th>Departure Location</th>
			<th>Class</th>
			<th>Fare</th>
			<th>Flight Duration</th>
			<th>Flight Time</th>
			<th>Seat Availability</th>
			<th>Valid Till</th>
		</tr>
		<c:forEach items="${flights}" var="flight">
			<tr>
				<td>${flight.getFlightNo()}</td>
				<td>${flight.getArrivalLoc()}</td>
				<td>${flight.getDepartureLoc()}</td>
				<td>${flight.getfClass()}</td>
				<td>${flight.getFare()}</td>
				<td>${flight.getFlightDur()}</td>
				<td>${flight.getFlightTime()}</td>
				<td>${flight.getSeatAvail()}</td>
				<td>${flight.getValidTill()}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>