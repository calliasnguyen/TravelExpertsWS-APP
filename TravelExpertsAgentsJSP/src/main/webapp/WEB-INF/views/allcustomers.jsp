<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Angular Test Page</title>

<!--  Bootstrap -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<!-- Angular JS -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular-resource.js"></script>


<!-- Javascript file to execute angular JS -->
<script src="<c:url value="/resources/angularFiles/testApplication.js" />"></script>

</head>

<body ng-app="myApp" ng-controller="customerController">

<!-- Nav bar for home screen -->
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">Travel Experts</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a href="<c:url value="home"/>">Home</a></li>
	      <li> <a href="./">Add/Edit Agent</a></li>
	      <li><a href="bookings">Bookings</a></li>
	       <li><a href="package">Packages</a></li>
	      <li><a href="documentation/">API Documentation</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li class="active"><a href="#"><span class="glyphicon glyphicon-user"></span>Sign Up Customer</a></li>
	      <li><a href="login"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
	    </ul>
	  </div>
	</nav>
<!-- End of the nav bar -->


<!--  Customer list -->

<div class="row">
    <br>
      
    
    <div class="container">
        <div id="userList" class="col-sm-offset-1 col-sm-9">
            
                <!--  For the Search Function -->
            <div align="right" class="input-append">
                
                <input id="search" name="search" placeholder="Search for Customer" ng-model="query"
                       required="required"/>
 						   <button class="btn"> <i class="glyphicon glyphicon-search"></i></button>
               
            </div>
            <!--  End of the Search Function -->
            
       
            <br/>
            
            <div class="list-group">
                <div class="list-group-item">
                    <div ng-repeat="customer in angularCustomers | filter:query" class="list-group-item" style="margin-top:16px">
                     
                     
                        <div class="row-content">
                            <h3 class="list-group-item-heading">{{customer.customerFirstName}} {{customer.customerLastName}}</h3>
 
                            <p class="list-group-item-text">
                            <i class="glyphicon glyphicon-tag"></i> {{customer.customerId}} &nbsp;&nbsp;&nbsp;
                            <i class="glyphicon glyphicon-envelope"></i> {{customer.customerEmail}} &nbsp;&nbsp;&nbsp;&nbsp;
                            <i class="glyphicon glyphicon-phone-alt"></i> {{customer.customerBusPhone}}
                            </p>
                            <i class="glyphicon glyphicon-home"></i> {{customer.customerAddress}}, {{customer.customerPostal}} &nbsp;&nbsp;&nbsp;
                             <i class="glyphicon glyphicon-globe"></i> {{customer.customerCity}}, {{customer.customerProvince}}, {{customer.customerCountry}} &nbsp;&nbsp;&nbsp;
                            
                            <p>
                            
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Modified Customer List -->



</body>
</html>