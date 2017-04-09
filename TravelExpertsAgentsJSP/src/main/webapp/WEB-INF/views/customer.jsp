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
<Style>
 .error {
        color: red; font-weight: bold;
    }


</Style>

</head>
<body>
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

<!-- Header for new Customer -->
<h2 style="text-align:center">Add a New Customer</h2>

<!-- If the value for success it true.. then show modal -->
<c:if test="${param.customerSuccess != null}" >

<!-- Script for launching a modal whenever the page is loaded-->
<script type="text/javascript">
$(document).ready(function(){ 
        $('#myModal').modal('show');
    });
</script>

</c:if>
<!-- End of script -->



<!--  Beginning of Customer  Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><strong>Success!</strong></h5>
  
      </div>
      <div class="modal-body">
        This customer has been added to the database!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
      </div>
    </div>
  </div>
</div>

<!-- end of the modal -->


 
 
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
		 placeholder="Enter your First Name (Required)" /> </div>
		<p><form:errors path="customerFirstName" cssClass="error"/></p>
	
	
	<!-- Customer Last Name -->
		<div class="form-group">
		<form:label path="customerLastName">
			<spring:message text="Last Name:"/>
			</form:label>

		<form:input path="customerLastName" placeholder="Enter your Last Name (Required)" class="form-control" />
		</div>
		<p><form:errors path="customerLastName" cssClass="error"/></p>
		
		<!--Customer Address -->
		<div class="form-group">
		<form:label path="customerAddress">
			<spring:message text="Address:"/>
			</form:label>
	
		<form:input path="customerAddress" placeholder="Enter your Address (Required)" class="form-control"/>
		</div>
		<p><form:errors path="customerAddress" cssClass="error"/></p>
	
	<!--  Cusomter City -->
		<div class="form-group">
			<form:label path="customerCity" >
			<spring:message text="City:"/>
			</form:label>
		
			<form:input path="customerCity" placeholder="Enter your City (Required)" class="form-control"/>
		</div>	
		<p><form:errors path="customerCity" cssClass="error"/></p>
		
	<!--  Customer Province-->
		<div class="form-group">
		<form:label path="customerProvince">
			<spring:message text="Province Code:"/>
			</form:label>
		<form:input path="customerProvince" placeholder="Enter your Province Code (Required) Example: AB, BC" class="form-control" />
		</div>
		<p><form:errors path="customerProvince" cssClass="error"/></p>
		<!--  Agency postal -->
		<div class="form-group">
		<form:label path="customerPostal">
			<spring:message text="Postal Code:"/>
			</form:label>

		<form:input path="customerPostal" placeholder="Enter your Postal Code (Required)" class="form-control"/>
		</div>
		<p><form:errors path="customerPostal" cssClass="error"/></p>
		
		<!--  Customer Country -->
		<div class="form-group">
		<form:label path="customerCountry">
			<spring:message text="Country:"/>
			</form:label>

		<form:input path="customerCountry" placeholder="Enter your Country (Optional)" class="form-control"/>
		</div>
	
	<!--  Customer home phone -->
		<div class="form-group">
		<form:label path="customerHomePhone">
			<spring:message text="Home Phone Number:"/>
			</form:label>

		<form:input path="customerHomePhone" placeholder="Enter your Home Phone (Optional)" class="form-control"/>
		</div>
	
	<!--  Customer business phone -->
		<div class="form-group">
		<form:label path="customerBusPhone">
			<spring:message text="Business Phone Number:"/>
			</form:label>

		<form:input path="customerBusPhone" placeholder="Enter your Business Phone (Required)" class="form-control"/>
		</div>
		<p><form:errors path="customerBusPhone" cssClass="error"/></p>
	
		<!--  Customer Email-->
		<div class="form-group">
		<form:label path="customerEmail">
			<spring:message text="Email Address:"/>
			</form:label>

		<form:input path="customerEmail" placeholder="Enter your Email Address (Required)" class="form-control" />
		</div>
		<p><form:errors path="customerEmail" cssClass="error"/></p>
	
	
	
	
	<!-- Button add a new Customer -->
		<input type="submit" class="btn btn-primary active" value="<spring:message text="Add Customer"/>" />
			

</form:form>
</div>



</body>
</html>