<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="java.util.*" %>    
<%@ page import="com.TravelExperts.Model.Agent" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page session="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Attempting Bootstrap on this file -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<title>Customer Bookings</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Travel Experts</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="home">Home</a></li>

 
      <li> <a href="<c:url value="./" />">Add/Edit Agent</a></li>
      <li class="active"><a href="bookings">Bookings</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="customer"><span class="glyphicon glyphicon-user"></span>Sign Up Customer</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>


<h3 style="text-align:center" style="font-weight:bold" >My Customers</h3>
<c:if test="${!empty listCustomer}">

	<c:forEach items="${listCustomer}" var="customer">
	
	
	
	<!--  Table for all the Customer information  -->
	<div class="container">
	<div class="table-responsive">
	<table class="table">
	
	<thead>
	<tr>
		<th width="100">Customer ID</th>
		<th width="120">First Name</th>
		<th width="120">Last Name</th>
		<th width="145">Phone #</th>
		<th width= "120">Email</th>
		<th width= "100">Address</th>
	
	</tr>
	</thead>
	
	<tr>
		<td>${customer.customerId}</td>
		<td>${customer.customerFirstName}</td>
		<td>${customer.customerLastName}</td>
		<td>${customer.customerBusPhone }</td>
		<td>${customer.customerEmail }</td>
		<td>${customer.customerAddress}</td>
	</tr>
	
	</table>
	</div>
	</div>
	<!--  End of table for customer -->
	
	<h3 style="text-align:center" style="font-weight:bold" >${customer.customerFirstName} ${customer.customerLastName} Bookings </h3>
	
	<!-- Start of table for each booking for a customer -->
	<div class="container">
	<div class="table-responsive">
	<table class="table table-inverse">
	
	<thead>
	<tr>
		<th width="100">Booking ID</th>
		<th width="120">Booking Date</th>
		<th width="120">Traveler Count</th>
		<th width="145">Package ID</th>
	
	</tr>
	</thead>
	
	<tr class="table-info">
		<td>sdfsd</td>
		<td>sdfsdf</td>
		<td>sdfsdf</td>
		<td>fsdfa</td>	
	</tr>
	
	
	</table>
	</div>
	</div>
	
	<!-- End of table for each booking for a customer -->
	</c:forEach>
	</c:if>


</body>
</html>