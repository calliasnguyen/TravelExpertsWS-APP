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

<style>
img.center {
  display: block;
  margin-left: auto;
  margin-right: auto;
}
</style>


<title>Customer Docs</title>
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

<!-- Side bar for documentation -->
    <div class="col-md-3 col-lg-3">
        <div class="list-group">
         <a href="./" class="list-group-item">Overview</a>
         <a href="" class="list-group-item disabled">Customer</a>
         <a href="agent" class="list-group-item">Agent</a>
     	 <a href="package" class="list-group-item">Package</a>
     	 <a href="booking" class="list-group-item">Booking</a>
     	
        </div>
    </div>
    <!--  End of the side bar -->
    
    <!-- Beginning of the documentation for customer -->
        <div id="Customer" class="col-md-9 col-lg-9">
            <h2>Customers </h2>
            </br>
            <p style="font-size:120%;">One of the biggest components of the customer's mobile app, is to update their own information!
            Here we can grab the customer's information after they log in, and start updating their own data right away.
             </p>
             
             <p style="font-size:120%;">Another big component is to look at an agent's list of customers </p>
             
             <strong>Click on the Post and Put for examples!</strong>
             </br>
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
      <tr onclick="location.href='../home'">
        <td><img src="<c:url value="/resources/images/get.png" />"> Base URL/Customer/</td>
        <td>Grab a List of Customers</td>     
      </tr>
       <tr>
        <td><img src="<c:url value="/resources/images/get.png" />"> Base URL/Customer/{id}</td>
        <td>Grab a Customer by Customer ID</td>     
      </tr>
         <!--  to make the whole row clickable "onclick" -->
        <!--  <tr onclick="location.href='../home'"> -->
        <tr style="cursor:pointer" data-toggle="modal" data-target="#postCustomer">
        <td><img src="<c:url value="/resources/images/Post.PNG" />">Base URL/Customer/add</td>
        <td>Create a Customer</td>     
      </tr>
       <tr>
        <td><img src="<c:url value="/resources/images/get.png" />"> Base URL/Customer/agent?agentid={AGENTID}</td>
        <td>Grab a List of Customers by Agent ID</td>     
      </tr>
 	 <td><img src="<c:url value="/resources/images/get.png" />"> Base URL/Customer/verification?lastname={lastname}&email={email} </td>
        <td>Verify Customer for Login</td>    
        </tr>
        <tr style="cursor:pointer" data-toggle="modal" data-target="#putCustomer">
 	 <td><img src="<c:url value="/resources/images/put.PNG" />"> Base URL/Customer/update </td>
        <td>Update Customer</td>
        </tr>      
    </tbody>
  </table>
  </div>
</div>
             
             
             <!--Modal For Post Customer Add -->
             <div class="modal fade" id="postCustomer" tabindex="-1" role="dialog" aria-labelledby="postModalTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="postModalTitle">Adding a New Customer</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Here is an example of adding a new customer. Note: This is a <strong>POST</strong> request.</p>
        <p style="font-weight:bold;">The link to customers is:</p><img src="<c:url value="/resources/images/customerdocumentation/Postcustomer.PNG" />">
        <br/>
        <br/>
        <p> The request body requires the following properties (with this exact format!): </p>
        <img class="center" src="<c:url value="/resources/images/customerdocumentation/customerRequestBody.PNG" />">
        
      
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
             
             <!--   End of Modal Testing   -->
             
                
             <!--Modal For Post Customer Update -->
             <div class="modal fade" id="putCustomer" tabindex="-1" role="dialog" aria-labelledby="putModalTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="putModalTitle">Updating Customer</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Here is an example of updating a customer. Note: This is a <strong>PUT</strong> request.</p>
        <p style="font-weight:bold;">The link to customers is:</p><img src="<c:url value="/resources/images/customerdocumentation/putcustomerupdate.PNG" />">
        <br/>
        <br/>
        <p> The request body requires the following properties (with this exact format!): </p>
        <img class="center" src="<c:url value="/resources/images/customerdocumentation/customerRequestBody.PNG" />">
        
      
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
             
             <!--   End of Modal put new Customer  -->
             
             
             
        </div>
	<!-- End of the documentation for customer -->

</body>
</html>