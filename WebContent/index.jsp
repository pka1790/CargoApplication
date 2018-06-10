<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.sample.app.dto.UserData"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generate Load</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBc4O7oJJvVwrdeCTTONFOQREWV4DCZmHM&v=3.exp&signed_in=false&libraries=places,geometry,drawing"></script>
<script type="text/javascript" src="assets/js/loadGoogleMap.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
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

label {
	white-space: nowrap;
}
</style>

<%
	UserData userData = (UserData) session.getAttribute("userdata");
%>

</head>
<body>

	<div id="wrapper">
		<div id="header" align="center">
			<span style="font-size: 20pt;">NJIT Cargo</span>
		</div>
		<div id="welcometext"
			style="text-align: right; margin-right: 25px; color: white; font-weight: bold; font-size: 10pt;">
			Welcome <a href="getUpdateProfile.jsp"> <strong> <%=userData.getUsername()%><br><%=userData.getUserId()%></strong></a>
			&nbsp;&nbsp;
			<form action="logout">
				<input type="submit" value="Log Out">
			</form>
		</div>
		<hr />

		<div id="content" style="line-height: 30pt;">

			<div id="message" style="width: 100%;"></div>

			<div id="parent" style="width: 100%;">
				<form action="placeOrder" name="placeOrder" id="placeOrder"
					method="post">


					<div id="locations" class="child1"
						style="width: 100%; display: none;">

						<div>
							<h4>Shipment Details</h4>
						</div>
						<table style="width: 80%">
							<tr>
								<td style="text-align: left;" width="30%"><label>Height: </label></td>
								<td><input type="text" name="height" id="height"
									class="generator-fields" required="required"
									placeholder="Height(inch)" /></td>
							</tr>

							<tr>
								<td style="text-align: left;"><label>Width: </label></td>
								<td><input type="text" name="width" id="width"
									class="generator-fields" required="required"
									placeHolder="Width(inch)" /></td>
							</tr>

							<tr>
								<td style="text-align: left;"><label>Length: </label></td>
								<td><input type="text" name="length" id="length"
									class="generator-fields" required="required"
									placeholder="Length(inch)" /></td>
							</tr>

							<tr>
								<td style="text-align: left;"><label>Weight: </label></td>
								<td><input type="text" name="weight" id="weight"
									class="generator-fields" required="required"
									placeholder="Weight(kg)" /></td>
							</tr>

							<tr>
								<td style="text-align: left;"><label>Number of
										items: </label></td>
								<td><input type="text" name="itemCount" id="itemCount"
									class="generator-fields" required="required"
									placeholder="Number of items" /></td>
							</tr>

							<tr>
								<td style="text-align: left;"><label>Distance: </label></td>
								<td><input type="text" name="distance" id="distance"
									class="generator-fields" placeholder="Distance(kms)"></td>
							</tr>

							<tr>
								<td style="text-align: left;">Type of Shipment :</td>
								<td><select id="shipment" name="shipment"
									class="generator-fields" style="width: 100%;">
										<option value="houseHold">Household Items</option>
										<option value="IndustrialGoods">Industrial Goods</option>
										<option value="vehicles">Vehicles</option>
								</select></td>
							</tr>

							<tr>
								<td colspan="2" style="text-align: left;">Date and Time for
									Transport :</td>
							</tr>
							<tr>
								<td colspan="2"><input type="text" name="transportDate"
									id="transportDate" class="generator-fields" required="required"
									readonly="readonly" placeholder="mm/dd/yyyy" size="10"
									maxlength="10" style="width: 25%;" /> <select name="hour"
									id="hour" class="generator-fields" style="width: 20%;"></select>
									<select name="minute" id="minute" class="generator-fields"
									style="width: 20%;"></select> <select name="meridiem"
									id="meridiem" class="generator-fields" style="width: 20%;">
										<option value="am">AM</option>
										<option value="pm">PM</option>
								</select></td>
							</tr>

							<tr>
								<td style="text-align: left;"><label> Special
										Instruction </label></td>
								<td><input type="text" name="specialInstruction"
									id="specialInstruction" /></td>
							</tr>
							<tr>
								<td style="text-align: left;"><label>Vehicle
										Preference </label></td>
								<td><select id="vehiclePreference" name="vehiclePreference"
									style="width: 100%;">
										<option value="Ford Pickup">Ford Pickup</option>
										<option value="Ford Flatbed">Ford Flatbed</option>
										<option value="Peterbilt Truck">Peterbilt Truck</option>
								</select></td>
							</tr>

						</table>
					</div>
					<div class="child2" style="width: 100%;">
						<div>
							<input type="text" name="startPoint" id="pac-input-start"
								class="controls" placeholder="Choose starting point"
								required="required" /> <input type="text" name="endPoint"
								id="pac-input-end" class="controls"
								placeholder="Choose destination location" required="required" />
						</div>
						<div id="googleMap" style="width: 100%;"></div>

					</div>
				</form>
			</div>

		</div>
	</div>


	<div style="text-align: center; width: 100%;">
		<input type="button" id="confirmButton" value="Place Order"
			onClick="confirmOrder();" style="width: 100pt; height: 30pt;" /> <input
			type="button" value="Next" id="nxt" onclick="nextPage();"
			style="width: 80pt; height: 30pt;"> <input type="button"
			value="Prev" id="prv" onclick="prevPage();"
			style="width: 80pt; height: 30pt; display: none;">
	</div>


	<div id="confirmDialog" style="display: none; font-size: 11pt;">
		<div id="confirmMsg"></div>
	</div>

	<script type="text/javascript">
		function nextPage() {
			$('#nxt').hide();
			$('#prv').show();

			$('.child1').show();
			$('.child2').hide();
		}

		function prevPage() {
			$('#prv').hide();
			$('#nxt').show();

			$('.child1').hide();
			$('.child2').show();
		}

		$(function() {
			//populate date picker
			$("#transportDate").datepicker();
			//populate hours of the day
			for (var h = 1; h <= 12; h++) {
				$('#hour').append($('<option/>', {
					value : h,
					text : (h + '').length == 1 ? ('0' + h) : h
				}));
			}

			//populate minutes
			for (var m = 0; m <= 59; m++) {
				$('#minute').append($('<option/>', {
					value : m,
					text : (m + '').length == 1 ? ('0' + m) : m
				}));
			}

		});

		$('#confirmButton').prop("disabled", true);
		$('#placeOrder input[type="text"]').blur(function() {
			checkInputFields();
		});
		$('#transportDate').datepicker({
			onSelect : function(curDate, instance) {
				checkInputFields();
			}
		});

		function checkInputFields() {
			var disableflag = false;
			$('#placeOrder input[type="text"]').each(function() {
				if (this.value.length == 0) {
					disableflag = true;
					return false;
				}
			});

			if (disableflag) {
				$('#confirmButton').prop("disabled", true);
			} else {
				$('#confirmButton').prop("disabled", false);
			}
		}

		function confirmOrder() {
			var data = "<b>Pick Up point :</b>" + $('#pac-input-start').val()
					+ "<br/>" + "<b>Destination :</b>"
					+ $('#pac-input-end').val() + "<br/>" + "<b>Height :</b>"
					+ $('#height').val() + "<br/>" + "<b>Width :</b>"
					+ $('#width').val() + "<br/>" + "<b>Length :</b>"
					+ $('#length').val() + "<br/>" + "<b>Weight :</b>"
					+ $('#weight').val() + "<br/>" + "<b>Item Count :</b>"
					+ $('#itemCount').val() + "<br/>" + "<b>Shipment :</b>"
					+ $('#shipment option:selected').text() + "<br/>"
					+ "<b>Vehicle Preference :</b>"
					+ $('#vehiclePreference option:selected').text() + "<br/>"
					+ "<b>Special Instructions  :</b>"
					+ $('#specialInstruction').val() + "<br/>"
					+ "<b>Date/Time :</b>" + $('#transportDate').val() + " "
					+ $("#hour option:selected").text() + ":"
					+ $("#minute option:selected").text()
					+ $("#meridiem option:selected").text() + "<br/>";

			$('#confirmMsg').empty();
			$('#confirmMsg').append(data);

			$("#confirmDialog").dialog({
				modal : true,
				title : 'Confirm',
				width : 300,
				height : 375,
				buttons : {
					Confirm : function() {
						$(this).dialog("close");

						if ($('#pac-input-start').val() != '') {
							document.getElementById('placeOrder').submit();
						} else {
							alert("Errror ");
						}
					},

					Cancel : function() {
						$(this).dialog("close");
					}
				}

			});

			/*var r = confirm(data);
			if(r){
				document.getElementById('placeOrder').submit();
			}else {
				
			}*/
		}
	</script>

</body>
</html>