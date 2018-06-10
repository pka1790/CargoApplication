<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="assets/css/main.css"/>
<link rel="stylesheet" type="text/css" href="assets/css/loginStyle.css" />
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<style>
/* header {
    background-color: black;
    display: block;
} */

html, body {
    height: 100%;
    width: 100%;
    margin: 0;
    padding: 0;
	background-image: url('couries.jpg');
	background-repeat:no-repeat;
	background-size: 81% 100%;
	
}
header {
    width: 100%;
    height: 50px;
    background: black;
    position: fixed;
    top: 0;
}

footer {
    width: 100%;
    height: 60px;
    background: black;
    position: fixed;
    bottom: 0;
}
ul li{
list-style-type: none;
display:inline;

}

ul li a{
color:white;
display:block;
font-size:20px;
word-spacing:10px;
text-decoration:none;
padding: 15px;
}
ul li a:hover{
background-color:white;
color:black;
}
.pull-right{
float:left;
margin-right:10px;
  margin-top: -32px;
}
.pull-left{
float:left;
  margin-top: -16px;
}

#img-grp-wrap {
    /* position: relative; */
    width: 100%;
    height: 60%;
    /* top: 20%;
    left: 15%; */
}

.img-wrap {
    position: relative;
    width: 100%;
    height: 100%;
}

.img-wrap img {
	
    /* position: absolute; */
    top: 0;
    left: 0;
    -moz-box-shadow: 1px 1px 4px #CCC;
    /* padding: 71px; */
	width:80%;
	height:80%;

}

.next, .prev {
    position: absolute;
    cursor: pointer;
    top: 190px;
}

.next {
    right: -1px;
	height: 35px;
}

.prev {
    left: 1px;
	height: 35px;
}
.side_content{ 
	position:relative;
	text-transform: uppercase;
	width:260px; 
	height:200px;
	float:right;
	background-color: white;
	bottom:50%;
}

</style>


</head>
<body>

<div id="wrapper" style="text-align: center;">
<div style="text-align: center;">
	<input type="button" onclick="location.href='/signin'" value="Login" style="float: none;margin: 20px 0 0 0"/>	
	<input type="button" onclick="location.href='/register'" value="Register" style="float: none; margin: 20px 0 0 0"/>
</div>

<hr/>

<div id="header" align="center" style="vertical-align: center;">
	<span style="font-size: 25px; font-weight: bold;letter-spacing: 2pt;">MnM MyCargo</span>
</div>
<div id="img-grp-wrap">
    <div class="img-wrap">
	    <img src="assets/images/pickup_2.jpg" />
	    
	    <img src="assets/images/portfolio-one-column1.jpg" />
        <img src="assets/images/pickup_1.jpg" />
        <img src="assetsimages/pickup_3.jpg" />
        <img src="images/pickup_4.jpg" />
    </div>   
</div>

<div>
		<img src="images/arrow_right.png" class="next" alt="Next"/> 
		<img src="images/arrow_left.png" class="prev" alt="Previous"/>
</div>


</div>


<script>
$('.img-wrap img:gt(0)').hide();

$('.next').click(function() {
    $('.img-wrap img:first-child').fadeOut().next().fadeIn().end().appendTo('.img-wrap');
});

$('.prev').click(function() {
    $('.img-wrap img:first-child').fadeOut();
    $('.img-wrap img:last-child').prependTo('.img-wrap').fadeOut();
    $('.img-wrap img:first-child').fadeIn();
});
</script>

</body>
</html>