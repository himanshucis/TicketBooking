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
<c:if test="${not empty user}">
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
	<div class="container">
	<h3 style="color:green;">User Details For Booking</h3>
		<form action="/bookingcontroller/bookingseat" method="post">
			<div class="form-group">
				<label for="name">Name:</label> <input
					style="width: 400px;" type="text" class="form-control" id="name"
					name="name" required="required" placeholder="Enter Your Name"/>
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email" placeholder="Please Enter Registered Email"
					style="width: 400px;" class="form-control" id="email" name="email" 
					required="required">
			</div>
			<div class="form-group">
				<label for="mobile">Mobile</label> <input type="text"
					style="width: 400px;" class="form-control" id="mobile" name="mobile" 
					required="required" placeholder="Enter Your Mobile Number">
			</div>
				<div class="form-group">
				<label for="address">Seat No:</label> <input
					style="width: 400px;" type="text" class="form-control" id="seat" value="${seat}"
					name="seat" readonly="readonly"/>
			</div>
			<button type="submit" class="btn btn-success">Booking</button>
		</form>
	</div>
</c:if>
<c:if test="${empty user}">
<c:redirect url="/usercontroller/login"></c:redirect>
</c:if>
</body>
</html>