<%@page import="com.sample.app.dto.TripUserName"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.app.dto.UserData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ACCEPTED HISTORY</title>

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
<script
	src="//cdn.datatables.net/plug-ins/1.10.7/integration/jqueryui/dataTables.jqueryui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="//cdn.datatables.net/plug-ins/1.10.7/integration/jqueryui/dataTables.jqueryui.css">
<link rel="stylesheet" type="text/css" href="assets/css/main.css" />
<%
	UserData userData = (UserData) session.getAttribute("userdata");
List<TripUserName> tripCarierList=(List<TripUserName>)session.getAttribute("tripUsername");
	
	   
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
		<h3>Accepted Trips</h3>

		<div id="content" style="width: 100%;">

			<table border="1" id="example" class="display" cellspacing="0"
				width="100%" style="font-size: 8pt;">
				<thead>
					<tr>
						<td>Trip Id</td>
						<td>Start Point</td>
						<td>End Point</td>
						<td>Distance</td>
						<td>Status</td>
						<td>Vehicle</td>
						<td>Generator</td>

					</tr>




				</thead>
				<%
				for (TripUserName tripUserName : tripCarierList) {
				%>

				<tr>
					<td><%=tripUserName.getTripId()%></td>
					<td><%=tripUserName.getStartPoint()%></td>
					<td><%=tripUserName.getEndPoint()%></td>
					<td><%=tripUserName.getDistance()%></td>
					<td><%=tripUserName.getTripStatus()%></td>
					<td><%=tripUserName.getVehiclePreference()%></td>
					<td><%=tripUserName.getUsername()%></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>






	<script>
		$(document).ready(function() {
			$('#example').dataTable({
				"order" : [ [ 0, "desc" ] ],
				"scrollX" : true
			});
		});
	</script>





</body>
</html>