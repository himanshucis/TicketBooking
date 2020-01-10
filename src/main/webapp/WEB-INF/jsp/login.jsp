<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
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
					<li class="active"><a href="/usercontroller/login">Signin</a></li>
					<li><a href="/usercontroller/registration">Signup</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="container">
	<h3 style="color:green;">User Login</h3>
		<form action="/usercontroller/loginuser" method="post">
			<div class="form-group">
				<label for="pname">email :</label> <input
					style="width: 400px;" type="email" class="form-control" id="email"
					name="email" required="required" placeholder="Enter Email"/>
			</div>
			<div class="form-group">
				<label for="price">Password :</label> <input type="password"
					style="width: 400px;" class="form-control" id="password" name="password" 
					required="required" placeholder="Enter Password">
			</div>
			<button type="submit" class="btn btn-success">Signin</button>
		</form>
	</div>
</body>
</html>