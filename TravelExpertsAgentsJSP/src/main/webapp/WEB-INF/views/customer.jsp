<!--  THIS IS A PAGE FOR ADDING NEW CUSTOMERS ON THE WEBSITE -->


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="java.util.*" %>    
<%@ page import="com.TravelExperts.Model.Agent" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<!-- Attempting Bootstrap on this file -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Customer</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">Travel Experts</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a href="<c:url value="${homeURL}"/>">Home</a></li>
	      <li class="active"> <a href="./">Add/Edit Agent</a></li>
	      <li><a href="bookings">Bookings</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="#"><span class="glyphicon glyphicon-user"></span>Sign Up Customer</a></li>
	      <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
	    </ul>
	  </div>
	</nav>

<!-- Header for new Customer -->
<h2 style="text-align:center">Add a New Customer</h2>


<!-- TESTING UP SESSIONS HERE -->
 <p>session testing ${testing.agtFirstName} ... session agentLogin ${agentLogin.agtFirstName }</p>
<p> session testing controller's agentlogin ${agentlogin.getAgentId()} </p>
<p> session testing controller's helloworld ${helloworld} </p>
<!-- Beginning of the form -->
<div class = "container">
<c:url var="addAction" value="/addCustomer" ></c:url>
<form:form action="${addAction}" commandName="customer">


	<!-- Default as the page loads up -->
	<!--  Customer First Name -->
		<div class="form-group">
		<form:label path="customerFirstName" for="customerfirstname">
			<spring:message text="First Name:"/>
			</form:label>
	
		<form:input path="customerFirstName" id="customerfirstname" name="customerfirstname" class="form-control"
		 placeholder="Enter your First Name" /> </div>
	
	
	<!-- Customer Last Name -->
		<div class="form-group">
		<form:label path="customerLastName">
			<spring:message text="Last Name:"/>
			</form:label>

		<form:input path="customerLastName" placeholder="Enter your Last Name" class="form-control" />
		</div>
		
		<!--Customer Address -->
		<div class="form-group">
		<form:label path="customerAddress">
			<spring:message text="Address:"/>
			</form:label>
	
		<form:input path="customerAddress" placeholder="Enter your Address" class="form-control"/>
		</div>
	
	<!--  Cusomter City -->
		<div class="form-group">
			<form:label path="customerCity" >
			<spring:message text="City:"/>
			</form:label>
		
			<form:input path="customerCity" placeholder="Enter your City" class="form-control"/>
		</div>	
		
	<!--  Customer Province-->
		<div class="form-group">
		<form:label path="customerProvince">
			<spring:message text="Province:"/>
			</form:label>
		<form:input path="customerProvince" placeholder="Enter your Province" class="form-control" />
		</div>
		<!--  Agency postal -->
		<div class="form-group">
		<form:label path="customerPostal">
			<spring:message text="Postal Code:"/>
			</form:label>

		<form:input path="customerPostal" placeholder="Enter your Postal Code" class="form-control"/>
		</div>
		
		<!--  Customer Country -->
		<div class="form-group">
		<form:label path="customerCountry">
			<spring:message text="Country:"/>
			</form:label>

		<form:input path="customerCountry" placeholder="Enter your Country" class="form-control"/>
		</div>
	
	<!--  Customer home phone -->
		<div class="form-group">
		<form:label path="customerHomePhone">
			<spring:message text="Home Phone Number:"/>
			</form:label>

		<form:input path="customerHomePhone" placeholder="Enter your Home Phone " class="form-control"/>
		</div>
	
	<!--  Customer business phone -->
		<div class="form-group">
		<form:label path="customerBusPhone">
			<spring:message text="Business Phone Number:"/>
			</form:label>

		<form:input path="customerBusPhone" placeholder="Enter your Business Phone #" class="form-control"/>
		</div>
	
		<!--  Customer Email-->
		<div class="form-group">
		<form:label path="customerEmail">
			<spring:message text="Email Address:"/>
			</form:label>

		<form:input path="customerEmail" placeholder="Enter your Email Address" class="form-control"/>
		</div>
	
	
	
	
	<!-- Button add a new Customer -->
		<input type="submit" class="btn btn-primary active" value="<spring:message text="Add Customer"/>" />
			

</form:form>
</div>



</body>
</html>