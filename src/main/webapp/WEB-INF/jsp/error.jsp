<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Ticket Booking</title>
</head>
<body>
	<div>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">Cinema Ticket Booking</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="/bookingcontroller/home">Home</a></li>
					<li><a href="/bookingcontroller/booking">Booking</a></li>
					<li><a href="/usercontroller/logout">Logout</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div>
	  <h3 style="color:red;text-align:center;">Cinema Seat Booking Faild</h3>
	  <h3 style="color:red;text-align:center;">Email Miss Match,Please Enter Registered Email</h3>
	</div>
</body>
</html> 