<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN Page</title>
<link rel="stylesheet" type="text/css" href="assets/css/main.css"/>
</head>
<body>
<div id="wrapper" style="text-align: center;">
<div id="header" align="center" style="vertical-align: center;">
	<span>NJIT CARGO APP</span>
</div>
<hr />
<br />

<div id="content">

<form action="login" method="post">

	<span style="font-size: xx-large;">User Login</span>
	
	<div>
		<label>USERNAME</label><br/> 
		<!-- <input type="text" id="email" name="email" placeholder="name@example.com" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" /> --> 
		<input type="text" id="username" name="username" placeholder="User Name" required="required"/>
	</div>
	
	<div>
		<label>PASSWORD</label><br/>
		<input type="password" id="password" name="password" placeholder="********" required="required" /> 
	</div>
	
	<div>
		<input type="submit" id="btnlogin" value="SIGN IN"/>
		&nbsp;&nbsp;&nbsp;
		<a href="register.jsp" title="register" style="color: red;">New User?</a>
	</div>	
</form>
	
</div>
</div>

</body>
</html>