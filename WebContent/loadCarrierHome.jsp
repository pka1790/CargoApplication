<%@page import="java.util.List"%>
<%@page import="com.sample.app.dto.PackageDetails"%>
<%@page import="com.sample.app.dto.Trip"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.sample.app.dto.UserData" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carrier Home</title>

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
<script src="//cdn.datatables.net/plug-ins/1.10.7/integration/jqueryui/dataTables.jqueryui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="//cdn.datatables.net/plug-ins/1.10.7/integration/jqueryui/dataTables.jqueryui.css">
<link rel="stylesheet" type="text/css" href="assets/css/main.css" />
<%
	Trip trip = (Trip) session.getAttribute("trip");
	PackageDetails pkDetails = (PackageDetails) session.getAttribute("packageDetails");
	UserData userData = (UserData) session.getAttribute("userdata");
	List<Trip> tripList= (List<Trip>) session.getAttribute("tripCarierList");
	   
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
		 
		<hr/>
		
		<h3>Available Trips</h3>
		
	
	<div id="content" style="width:100%;">
		
	<table  border="1" id="example" class="display" cellspacing="0" width="100%" style="font-size:8pt;">
	<thead>	
	<tr>
		<td>Trip Id</td>
		<td>Start Point</td>
		<td>End Point</td>
		<td>Distance</td>
		<td>Status</td>
		<td></td>
	</tr>
	</thead>
 <% 
 for(Trip trips:tripList){
 
 %>
		
		<tr>
			<td><%= trips.getTripId() %></td>
			<td><%= trips.getStartPoint() %></td>
			<td><%= trips.getEndPoint() %></td>
			<td><%= trips.getDistance() %></td>
			<td><%= trips.getTripStatus() %></td>
			<td><input type="button" value="Accept" onclick="location.href='getTripInfo?tripId='+<%= trips.getTripId() %>"/></td>
		</tr>	
 <%}%>
 </table>
	</div>
	<br/><br/>
	<div style="width: 100%;text-align: center;">
			<input type="button" value="Accepted Trips" onclick="location.href='getAcceptedTrips'" style="height: 5%;"/>
	</div>
 </div>
 
<script>
$(document).ready(function() {
    $('#example').dataTable({
    	"order": [[ 0, "desc" ]],
    	"scrollX": true
    });
    
} );




</script>	
	
	
	
 

</body>
</html>