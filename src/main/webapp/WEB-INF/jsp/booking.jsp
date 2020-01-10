<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
		<div>
			<div style="margin-left: 500px; margin-top: 40px;">
				<h3 style="color: blue; margin-left: 70px;">Cinema Seat</h3>
				<c:forEach items="${seats}" var="seat">
					<c:if test="${seat.status == 0}">
						<a href="/bookingcontroller/bookseat?seat=${seat.seatNo}"
							onclick="return confirm('Do you want to Book Seat ?')"><i
							class="fa fa-square-o"
							style="font-size: 36px; color: green; margin-left: 20px;"></i></a>
						<c:if test="${seat.seatNo%5 == 0}">
							<br>
						</c:if>
					</c:if>
					<c:if test="${seat.status == 1}">
						<a href="/bookingcontroller/cancelbooking?seat=${seat.seatNo}"
							onclick="return confirm('Do you want to Cancle Seat ?')"><i
							class="fa fa-square-o"
							style="font-size: 36px; color: red; margin-left: 20px;"></i></a>
						<c:if test="${seat.seatNo%5 == 0}">
							<br>
						</c:if>
					</c:if>
				</c:forEach>
				<h3 style="color: blue;">Click on the Red-Seat for cancel</h3>
			</div>
		</div>
	</c:if>
	<c:if test="${empty user}">
		<c:redirect url="/usercontroller/login"></c:redirect>
	</c:if>
</body>
</html>