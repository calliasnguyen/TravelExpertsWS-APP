<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Information</title>
	<!-- Tags for Bootstrap  -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>



<c:if test="${empty customer.customerFirstName }">
<p>Internal service error.. could not load customer please try again later!</p>
</c:if>


	<!--  here is the package -->
	<c:if test="${!empty p.packageName }">
	

<c:if test="${!empty customer.customerFirstName }">
<h4>Hello ${customer.customerFirstName} ${customer.customerLastName},</h4>

<h4> Here is your receipt for the ${p.packageName} package:</h4>
<h4>Your Booking Number: <strong>${booking.bookingNumber} </strong></h4>
<h4>Your Booking Id: <strong>${booking.bookingId }</strong></h4>
<br/>
	
	<!-- Table for package Start date and end date -->
	
	<h4 style="text-align:center" style="font-weight:bold" >Travel Dates</h4>
	<div class="container">
	<div class="table-responsive">
	<table class="table">
	<thead>
	<tr>
		<th width="100">Start Date</th>
		<th width="120">End Date</th>
	</tr>
	</thead>
	<tr>
		<td>${p.formattedPackageStartDate}</td>
		<td> ${p.formattedPackageEndDate}</td>
	</tr>
	
	
	</table>
	</div>
	</div>
	</c:if>
	<!-- End of the table for start and end date -->
	

	<!-- List of the Products -->
<h4 style="text-align:center" style="font-weight:bold" >List of Products Included</h4>
<c:if test="${!empty p.packageProductSupplier}">
<div class="container">
	<div class="table-responsive">
	<table class="table">
	<thead>
	<tr>
		<th width="100">Product Name</th>
		<th width="120">Supplier Name</th>
		
	</tr>
	</thead>
	<c:forEach items="${p.packageProductSupplier}" var="packageproductsupplier">
	<tr>
		<td>${packageproductsupplier.prodName}</td>
		<td>${packageproductsupplier.supplierName}</td>
		

	</tr>
	</c:forEach>
	</table>
	</div>
</div>
	</c:if>

<h4 style="text-align:center;"><strong>Total Price: $${p.packageBasePrice }0</strong></h4>
<!-- End of the list of products -->


	</c:if> <!--  end of if test for customer -->

<h4>Please let me know if you have any questions! I look forward to speaking to you soon</h4><br/>
<h4>Sincerely,</h4>

<h4>${agent.agtFirstName } ${agent.agtLastName } from TravelExperts</h4>
<p><strong>${agent.agtBusPhone }</strong></p>


</body>
</html>