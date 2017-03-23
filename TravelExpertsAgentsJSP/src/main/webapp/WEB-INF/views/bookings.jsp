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

<style>

.btn-primary {
background-color: #26A69A;
}

</style>

</head>
<body>
<nav class="navbar navbar-default">
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
      <li><a href="login"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>

<!-- Label for bookings home page -->
<h3 style="text-align:center" style="font-weight:bold" >My Customers</h3>

<c:if test="${!empty listCustomer}">

	<c:forEach items="${listCustomer}" var="customer">
	<br>
	<!-- Label the Customer -->
<!-- 	<h4 style="font-weight:bold" >Customer: ${customer.customerFirstName} ${customer.customerLastName}</h4>  -->
	
	    <div class="panel panel-primary">
      <div class="panel-heading">Customer Information: ${customer.customerFirstName} ${customer.customerLastName}</div>
     
    </div>
	
	
	
	
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

	<!-- Heading for the bookings per customer.. not using this anymore -->	
<!-- <h4 style="text-align:center" style="font-weight:bold" >${customer.customerFirstName} ${customer.customerLastName} Bookings </h4>
-->

<!-- Testing Collapsable -->
<div class="container">
  
  <!--  this needs to follow id, and a href (as seen with customer.FirstName) to work -->
  <a style="text-align:center" href="#${customer.customerFirstName}" class="btn btn-block btn-primary" data-toggle="collapse">Bookings for ${customer.customerFirstName} ${customer.customerLastName} </a>
  <div  id="${customer.customerFirstName}" class="collapse">
 
<br>
<br>

	
	<div class="container">
	<div class="table-responsive">
	<table class="table table-hover table-condensed table-bordered">
		<thead>
	<tr>
		<th scope="row" width="100">Booking ID</th>
		<th width="120">Booking Date</th>
		<th width="120">Traveler Count</th>
		<th width="145">Package ID</th>
		<th width="145">Flight Number</th>
	</tr>
	</thead>
	<tbody>
	 <c:forEach items="${customer.booking}" var="booking">

	<!-- Start of table for each booking for a customer -->
	
	<tr class="table-info">
		<th scope="row">${booking.bookingId}</th>
		<td>${booking.formattedDate}</td>
		<td>${booking.travelerCount}</td>
		<td>${booking.packageId}</td>	
		<td>${booking.bookingNumber}</td>	
	
	</tr>
	
	
	
	 </c:forEach>
	 </tbody>
	 </table>
	</div>
	</div>
	<!-- End of table for each booking for a customer -->
	
	 <!-- TESTING THE ENDING Div for collapsable -->
  </div>
</div>
<!--  End of Collapsable -->
	
	
	</c:forEach>
	</c:if>



</body>
</html>