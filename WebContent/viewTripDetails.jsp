<%@page import="com.sample.app.dto.TripPackage"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.app.dto.UserData"%>
<%@page import="com.sample.app.dto.PackageDetails"%>
<%@page import="com.sample.app.dto.Trip"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trip History</title>


<link rel="stylesheet" type="text/css" href="assets/css/main.css" />

<link rel="stylesheet" type="text/css" href="assets/css/indexStyle.css" />
<style>
/* header {
    background-color: black;
    display: block;
} */
header {
	width: 100%;
	height: 50px;
	background: #4072b4;
	position: fixed;
	top: 0;
}

footer {
	width: 100%;
	height: 60px;
	background: #4072b4;
	position: fixed;
	bottom: 0;
}
</style>

<%
	Trip trip = (Trip) session.getAttribute("trip");
	PackageDetails pkDetails = (PackageDetails) session.getAttribute("packageDetails");
	UserData userData = (UserData) session.getAttribute("userdata");
	List<TripPackage> tripPkgList= (List<TripPackage>) session.getAttribute("tripPackages");
	   
%>


</head>
<body>


	<div id="wrapper">
		<div id="header" align="center">
			<span style="font-size: 20pt;">NJIT Cargo</span>
		</div>
			<div id="welcometext" style="text-align: right; margin-right: 25px; color: white; font-weight: bold; font-size: 10pt;">
			Welcome <a href="getUpdateProfile.jsp"> <strong> <%=userData.getUsername()%></strong></a>
			&nbsp;&nbsp;<form action="logout">
			<input type="submit" value="Log Out">
			</form>
		</div>

		<hr />
<%
for (TripPackage tripPackage : tripPkgList){
%>
		<div id="content" style="width: 80%;">
			<h3>Trip Details</h3>
			<table border="4" cellspacing="5" cellpadding="5" width="100%">

				<tr>
					<td>Trip Id :</td>
					<td><%=tripPackage.getTripId()%></td>
				</tr>
				<tr>
					<td>Start Point :</td>
					<td><%=tripPackage.getStartPoint()%></td>
				</tr>
				<tr>
					<td>End Point :</td>
					<td><%=tripPackage.getEndPoint()%></td>
				</tr>
				<tr>
					<td>Distance :</td>
					<td><%=tripPackage.getDistance()%></td>
				</tr>
				<tr>
					<td>Status :</td>
					<td><%=tripPackage.getTripStatus()%></td>
				</tr>
				<tr>
					<td>Height :</td>
					<td><%=tripPackage.getHeight()%></td>
				</tr>
				<tr>
					<td>Weight :</td>
					<td><%=tripPackage.getWeight()%></td>
				</tr>
				<tr>
					<td>Length :</td>
					<td><%=tripPackage.getLength()%></td>
				</tr>
				<tr>
					<td>Width :</td>
					<td><%=tripPackage.getWidth()%></td>
				</tr>
				<tr>
					<td>Quantity :</td>
					<td><%=tripPackage.getItemCount()%></td>
				</tr>
				<tr>
					<td nowrap>shipmentType :</td>
					<td><%=tripPackage.getShipment()%></td>
				</tr>

				<tr>
					<td><input type="button" value="Confirm"
						onclick="location.href='acceptTrip?tripId='+<%=tripPackage.getTripId()%>"></td>
					<td><input type="button" value="Cancel"
						onclick="location.href='getPendingTrips'" /></td>
				</tr>
	<%}%>
			</table>
		</div>
	</div>












</body>
</html>