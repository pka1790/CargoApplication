<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>

<link rel="stylesheet" type="text/css" href="assets/css/registerStyle.css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
<body>
	<div id="wrapper">

		<div id="header" align="center">
			<span style="font-size: 35pt;">NJIT Cargo</span>
		</div>
		<hr />

		<div id="content" >
			<form action="register" method="post">

				<h2>Create A New Account</h2>
				
				<div class="input-fields">
					<label>FIRSTNAME</label> <input type="text" id="firstname"
						class="regfields" name="firstname" placeholder="First Name"
						required="required" />
				</div>

				<div class="input-fields">
					<label>LASTNAME</label> <input type="text" id="lastname"
						class="regfields" name="lastname" placeholder="Last Name"
						required="required" />
				</div>

				<div class="input-fields">
					<label>USERNAME</label> <input type="text" id="username"
						class="regfields" name="username" placeholder="User Name"
						required="required" />
				</div>

				<div class="input-fields">
					<label>PASSWORD</label> <input type="password" id="password"
						class="regfields" name="password" placeholder="********"
						required="required" />
				</div>

				<div class="input-fields">
					<label>EMAIL</label> <input type="email" id="emailid"
						name="emailid" class="regfields" placeholder="name@example.com"
						required="required"
						pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" />
				</div>

				<div class="input-fields" >
					<label>MOBILE</label> <input type="text" pattern="[0-9]{10}"
						class="regfields" title="Enter valid mobile" id="mobile"
						name="mobile" placeholder="1234567890" required="required" />
				</div>

				<div class="input-fields">
					<label>BIRTH DATE</label> <br /> <input type="text"
						name="birthdate" id="birthdate" placeholder="mm/dd/yyyy"
						required="required" readonly="readonly" />
				</div>

				<div  style="color: white; font: bolder;font-size: large;">
					<label>REGISTERED AS</label><br /> <input type="radio"
						name="registeras" value="loadGenerator" checked="checked" />LoadGenerator<br />
					<input type="radio" name="registeras" value="loadCarrier" />Load
					Carrier<br />
				</div>

				<div>
					<input type="submit" id="btn-create-account" name="register"
						value="Sign Up" />
				</div>

				<footer>
				<p>
				<h2>OR</h2>
				<h3 style="color: white;">
					Login With Below Accounts
					<h3>
						<a href="/auth/facebook"><img src="assets/images/f.jpg"	height="40px" /> </a> 
							<a href="/auth/twitter"><img src="assets/images/t.jpg" height="40px" /> </a> 
							<a href="/auth/google"><img	src="assets/images/g.jpg" height="40px" /> </a>
						</p>
				</footer>

			</form>
		</div>
	</div>

	<script>
  $(function() {
    $( "#bidthdate" ).datepicker();
  });
  </script>
</body>
</html>