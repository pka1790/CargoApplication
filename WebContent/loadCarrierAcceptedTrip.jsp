<%@page import="com.sample.app.dto.UserData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="assets/css/main.css" />
<%
	UserData userData = (UserData) session.getAttribute("userdata");
	
	   
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
		<br />
		<div style="text-align: center; line-height: 10pt;">
			<strong>Thanks for accepting trip - generator has been informed </strong>
		</div>

		<br />
		<div id="content">


			<div style="text-align: center;">
				<input type="Button" value="Go To Home"
					onclick="location.href='getPendingTrips'" />
			</div>

		</div>
	</div>



</body>
</html>