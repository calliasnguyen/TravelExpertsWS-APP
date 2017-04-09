<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap on this file -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>documentation</title>
</head>
<body>
	<!-- Nav bar for the project -->
		<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">Travel Experts</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a href="<c:url value="../home"/>">Home</a></li>
	      <li> <a href="../">Add/Edit Agent</a></li>
	      <li><a href="../bookings">Bookings</a></li>
	       <li><a href="../package">Packages</a></li>
	     <li class="active"><a href="">API Documentation</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="../customer"><span class="glyphicon glyphicon-user"></span>Sign Up Customer</a></li>
	      <li><a href="../login"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
	    </ul>
	  </div>
	</nav>
	
	<!-- End of the nav bar  -->


    <div class="col-md-3 col-lg-3">
        <div class="list-group">
         <a href="#" class="list-group-item disabled">Overview</a>
         <a href="customer" class="list-group-item">Customer</a>
         <a href="agent" class="list-group-item">Agent</a>
     	 <a href="package" class="list-group-item">Package</a>
     	 <a href="booking" class="list-group-item">Booking</a>
     	
        </div>
    </div>
        <div id="Overview" class="col-md-9 col-lg-9">
            <h2 style="text-align:center">Rest API calls made easy for the Travel Experts Mobile App </h2>
            </br>
            <p style="font-size:120%;">Welcome to the documentation for the Travel Experts REST API calls. Here we explain the calls/endpoints that happen from the 
            mobile application (update/delete/add any information into the database).  This documentation is here for future reference for any 
            upgrades required on the customer and agent mobile app. To begin, please select one of the items (on the left) that you wish to learn more 
            about! </p>
        </div>


</body>
</html>