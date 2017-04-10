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
<title>Customer Docs</title>

<style>
.code {
    width:500px;
    background-color:#F9F9F9;
    padding:20px 20px;
    border:1px dashed black;
      margin: 0 auto;
}

​​
</style>


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
	     <li ><a href="../customerlist/">Customers</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="../customer"><span class="glyphicon glyphicon-user"></span>Sign Up Customer</a></li>
	      <li><a href="../login"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
	    </ul>
	  </div>
	</nav>
	
	<!-- End of the nav bar  -->

<!-- Side bar for documentation -->
    <div class="col-md-3 col-lg-3">
        <div class="list-group">
         <a href="./" class="list-group-item">Overview</a>
         <a href="customer" class="list-group-item">Customer</a>
         <a href="agent" class="list-group-item ">Agent</a>
     	 <a href="package" class="list-group-item ">Package</a>
     	 <a href="#" class="list-group-item disabled">Booking</a>
     	
        </div>
    </div>
    <!--  End of the side bar -->
    
    <!-- Beginning of the documentation for customer -->
        <div id="Customer" class="col-md-9 col-lg-9">
            <h2>Booking</h2>
            </br>
            <p style="font-size:120%;">For the customer mobile application, customers can view their own bookings. Customers
            can also purchase a booking! For the agents, they can grab a single booking, a list of bookings, or even update a booking. 
             </p>
             
          <strong>Check out the Put and Post requests for Examples!</strong>
             <!-- Beginning of the table of get post put delete -->
   <h2>Rest Methods</h2>      
   <div class="col-md-11 col-lg-11">                                                                           
  <div class="table-responsive">          
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Method (Base URL: http://35.161.216.198:8080/TravelExpertsAgentsJSP/)</th>
        <th>Description</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><img src="<c:url value="/resources/images/get.png" />"> Base URL/Booking/</td>
        <td>Grab a List of all the Bookings</td>     
      </tr>
       <tr>
        <td><img src="<c:url value="/resources/images/get.png" />"> Base URL/Booking/{customerid}</td>
        <td>Grab a list of bookings by a customer ID</td>     
      </tr>
        <tr  style="cursor:pointer" data-toggle="modal" data-target="#postBooking">
        <td><img src="<c:url value="/resources/images/Post.PNG" />"> Base URL/Booking/add</td>
        <td>Create a new Booking</td>     
      </tr>
     
        <tr style="cursor:pointer" data-toggle="modal" data-target="#putBooking">
 	 <td><img src="<c:url value="/resources/images/put.PNG" />"> Base URL/Package/update </td>
        <td>Update Booking</td>      
    	</tr>
    	 <tr>
 	 <td><img src="<c:url value="/resources/images/get.png" />"> Base URL/Package/Booking/id/{bookingid} </td>
        <td>Get a single Booking by its ID</td>      
    	</tr>
    </tbody>
  </table>
  </div>
</div>
             
             
             
        </div>
	<!-- End of the documentation for Bookings -->
	
	     <!--Modal For Post Adding Bookings -->
             <div class="modal fade" id="postBooking" tabindex="-1" role="dialog" aria-labelledby="postModalTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="postModalTitle">Adding a new Booking</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Here is an example of adding a new booking Note: This is a <strong>POST</strong> request.</p>
        <p style="font-weight:bold;">The link to booking is:</p>
        <div class="url"><code>POST           http://35.161.216.198:8080/TravelExpertsAgentsJSP/Booking/add</code></div>
        <br/>
        <br/>
        <p> The request body requires the following properties (with this exact format!) <strong>Content-Type: Application/json</strong>: </p>
		<div class="code">
		<code>
		 {<br/>
			
			    "bookingDate": 956210400000, <br/>
			    "bookingNumber": "234244S", <br/>
			    "travelerCount": 2, <br/>
			    "tripTypeId": "B", <br/>
			    "formattedDate": "20-Apr-2000", <br/>
			    "packageId": 2, <br/>
			    "customerid": 105
			    
		 <br/>}
		</code>
		</div>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
             
             <!--   End of Modal for add Bookings   -->
             
             <!-- Update Bookings Put Request  -->
                        <div class="modal fade" id="putBooking" tabindex="-1" role="dialog" aria-labelledby="putModalTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="putModalTitle">Editing a Booking</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Here is an example of updating booking. Note: This is a <strong>PUT</strong> request.</p>
        <p style="font-weight:bold;">The link to booking is:</p>
        <div class="url"><code>PUT           http://35.161.216.198:8080/TravelExpertsAgentsJSP/Booking/update</code></div>
        <br/>
        <br/>
        <p> The request body requires the following properties (with this exact format!) <strong>Content-Type: Application/json</strong>: </p>
		<div class="code">
		<code>
		 {<br/>
				"bookingId":1350, <br/>
			    "bookingDate": 956210400000, <br/>
			    "bookingNumber": "234244S", <br/>
			    "travelerCount": 2, <br/>
			    "tripTypeId": "B", <br/>
			    "formattedDate": "20-Apr-2000", <br/>
			    "packageId": 2, <br/>
			    "customerid": 105
			    
		 <br/>}
		</code>
		</div>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
             
             
             
             <!-- End of Modal Edit Bookings  -->
	

</body>
</html>