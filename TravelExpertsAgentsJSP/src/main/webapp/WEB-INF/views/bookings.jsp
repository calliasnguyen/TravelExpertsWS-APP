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

div {
border-radius: 0px;

}

div.modalborder {


    border:1px solid #E5E5E5;
      margin: 0 auto;
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
       <li><a href="package">Packages</a></li>
      <li><a href="documentation/">API Documentation</a></li>
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

	    <div id="customerinfo" class="list-group">
      <span style="cursor:pointer" data-toggle="modal" data-target="#${customer.customerId }" class="list-group-item active">Customer Information: ${customer.customerFirstName} ${customer.customerLastName}</span>
     
    </div>
	
	<!-- Modal for sending an email to Customer -->
	
	<div class="modal fade" id="${customer.customerId }" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><strong>New message for ${customer.customerFirstName} ${customer.customerLastName}: </strong></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="form-control-label">Recipient:</label>
            <input type="text" class="form-control" placeholder="${customer.customerEmail}" id="recipient-name">
          </div>
          <div class="form-group">
            <label for="message-text" class="form-control-label">Message:</label>
            <textarea class="form-control" id="message-text"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal">Send message</button>
      </div>
    </div>
  </div>
</div>
	
	
	<!-- End of sending email to Customer -->
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
	

<!-- Must confirm if there are any bookings for this customer -->
<c:if test="${!empty customer.booking}">

	<!-- Heading for the bookings per customer.. not using this anymore -->	
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
	
	<tr  style="cursor:pointer" class="table-info" data-toggle="modal" data-target="#${booking.bookingId}">
		<th scope="row">${booking.bookingId}</th>
		<td>${booking.formattedDate}</td>
		<td>${booking.travelerCount}</td>
		<td>${booking.packageId}</td>	
		<td>${booking.bookingNumber}</td>	
	
	</tr>
	
	<!-- Modal Configuration -->
	<!--  if this bookingdetail for this booking is not empty -->
	<c:if test="${!empty booking.bookingDetail}"> 
	
	<div class="modal fade" id="${booking.bookingId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 style="font-weight:bold;" style="text-align:center;" class="modal-title" id="exampleModalLabel">Booking Details for ${customer.customerFirstName} ${customer.customerLastName} booking number: ${booking.bookingId} </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      	<!--  Grabbing bookingDetails information -->
         <c:forEach items="${booking.bookingDetail}" var="bookingDetails">
  		 <div class="modalborder">
  	
   		<p style="text-align:center"><strong>Destination:</strong>${bookingDetails.destination} 	<strong>Description: </strong> ${bookingDetails.description}</p>
   		
   		<p style="text-align:center"><strong>Fee Id:</strong>${bookingDetails.feeid} 	<strong>Class ID:</strong> ${bookingDetails.classId}</p>
   		
   	
   		<p style="text-align:center"><strong>Start Date: </strong>${bookingDetails.tripStart}  <strong>End Date: </strong>${bookingDetails.tripEnd}</p>
   		
   		<p style="text-align:center"><strong>Base Price Cost:</strong>${bookingDetails.basePrice}</p>
   	     </div>  
       <br/>
        </c:forEach>
        <!-- End of the bookingDetails Information -->
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Ok</button>

      </div>
    </div>
  </div>
</div>
	</c:if>
	<!--  End of Modal Configuration -->
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
	</c:if>


	</c:forEach> 	<!-- ForEach Customer end tag -->
	</c:if>	<!--  if customer is not empty end tag -->
	


</body>
</html>