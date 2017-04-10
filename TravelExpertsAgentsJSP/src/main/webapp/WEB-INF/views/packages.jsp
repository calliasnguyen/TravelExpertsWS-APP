<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="java.util.*" %>    
<%@ page import="com.TravelExperts.Model.Agent" %>
    
  <%@ page session="true" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Package Page</title>
	<!-- Tags for Bootstrap & AJAX -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- CSS FILE FOR PACKAGE SITE-->
<link href="<c:url value="/resources/css/packagesite.css" />" rel="stylesheet">

<!--  need this css here so se can put the images in place -->
<style type="text/css">

/********************************/
/*       Slides backgrounds     */
/********************************/
.fade-carousel .slides .slide-1, 
.fade-carousel .slides .slide-2,
.fade-carousel .slides .slide-3 {
  height: 80vh;
  background-size: cover;
  background-position: center center;
  background-repeat: no-repeat;
}
.fade-carousel .slides .slide-1 {
  background-image: url('<c:url value="/resources/images/sun.jpg"/>'); 
}
.fade-carousel .slides .slide-2 {
  background-image: url('<c:url value="/resources/images/forest.jpg"/>');
}
.fade-carousel .slides .slide-3 {
  background-image: url('<c:url value="/resources/images/glacier.jpg"/>');
}


  .error {
        color: red; font-weight: bold;
    }

</style>

</head>
<body>

<!-- If the value for success it true.. then show modal -->
<c:if test="${param.packageSuccess != null}" >

<!-- Script for launching a modal whenever the page is loaded-->
<script type="text/javascript">
$(document).ready(function(){ 
        $('#myModal').modal('show');
    });
</script>

</c:if>
<!-- End of script -->

<!--  Beginning of the Modal -->

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><strong>Success!</strong></h5>
  
      </div>
      <div class="modal-body">
        This agent has been ${param.packageSuccess} 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
      </div>
    </div>
  </div>
</div>

<!-- end of the modal -->
<!--  Specialized nav bar.. this nav bar is for if the package is new -->
<c:if test="${empty travelPackage.packageName }">
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Travel Experts</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="home">Home</a></li>

 
      <li> <a href="<c:url value="./" />">Add/Edit Agent</a></li>
      <li><a href="bookings">Bookings</a></li>
       <li class="active"><a href="package">Packages</a></li>
      <li><a href="documentation/">API Documentation</a></li>
      <li ><a href="customerlist/">Customers</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="customer"><span class="glyphicon glyphicon-user"></span>Sign Up Customer</a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>
</c:if>
<!-- End of Nav bar for new package -->

<!--  Specialized nav bar.. this nav bar is for if user is editing a package -->
<c:if test="${!empty travelPackage.packageName }">
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Travel Experts</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="../home">Home</a></li>

 
      <li> <a href="<c:url value="./" />">Add/Edit Agent</a></li>
      <li><a href="../bookings">Bookings</a></li>
       <li class="active"><a href="../package">Packages</a></li>
      <li><a href="../documentation/">API Documentation</a></li>
      <li ><a href="../customerlist/">Customers</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="../customer"><span class="glyphicon glyphicon-user"></span>Sign Up Customer</a></li>
      <li><a href="../login"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>


</c:if>
<!-- End of Nav bar for edit package -->

<!-- Beginning of Carousel -->
<div class="carousel fade-carousel slide" data-ride="carousel" data-interval="4000" id="bs-carousel">
  <!-- Overlay -->
  <div class="overlay"></div>

  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#bs-carousel" data-slide-to="0" class="active"></li>
    <li data-target="#bs-carousel" data-slide-to="1"></li>
    <li data-target="#bs-carousel" data-slide-to="2"></li>
  </ol>
  
  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item slides active">
      <div class="slide-1"></div>
      <div class="hero">
        <hgroup>
            <h1>Packages</h1>        
            <h3>Create a new Adventure for your clients!</h3>
        </hgroup>
 
      </div>
    </div>
    <div class="item slides">
      <div class="slide-2"></div>
      <div class="hero">        
        <hgroup>
            <h1>Excursions</h1>        
            <h3>Find and customize products for the packages!</h3>
        </hgroup>       
 
      </div>
    </div>
    <div class="item slides">
      <div class="slide-3"></div>
      <div class="hero">        
        <hgroup>
            <h1>Custom Tours</h1>        
            <h3>Phone tour operators</h3>
        </hgroup>
 
      </div>
    </div>
  </div> 
</div>

<!-- End of Carousel -->

<!-- Start of the package list table -->
<!-- Table to show a list of Agents -->

<h3 style="text-align:center" style="font-weight:bold" >List of Packages</h3>
<c:if test="${!empty packageList}">
<div class="container">
	<div class="table-responsive">
	<table class="table">
	<thead>
	<tr>
		<th width="100">Package ID</th>
		<th width="120">Package Name</th>
		<th width="145">Start Date</th>
		<th width= "120">End Date</th>
		<th width= "100">Description</th>
	
		<th width="60">Edit </th>
		<th width="60">Delete</th>
	</tr>
	</thead>
	<c:forEach items="${packageList}" var="travelpackage">
	<tr>
		<td>${travelpackage.packageid}</td>
		<td>${travelpackage.packageName}</td>
		<td>${travelpackage.formattedPackageStartDate }</td>
		<td>${travelpackage.formattedPackageEndDate }</td>
		<td>${travelpackage.packageDescription}</td>
		<td><a href="<c:url value='/editpackage/${travelpackage.packageid }' />" > Edit</a></td>
		<td><a href="<c:url value='/removepackage/${travelpackage.packageid }' />" >Delete</a></td>

	</tr>
	</c:forEach>
	</table>
	</div>
</div>
	</c:if>
	
	<!-- end of package table -->

<!-- Begin by Adding a new package -->
<c:if test="${!empty travelPackage.packageName }">
<h2 style="text-align:center">Modify ${travelPackage.packageName}</h2>
</c:if>
<c:if test="${empty travelPackage.packageName }">
<h2 style="text-align:center">Add a New Package</h2>
</c:if>




<!-- Beginning of the form  commandName="travelPackage"-->
<div class = "container">
<c:url var="addAction" value="/addpackage" ></c:url>
<form:form action="${addAction}" modelAttribute="travelPackage">


<!--  SHOWS US THE ID OF AN EDITED Package(Shows nothing if there is no value) -->
<!-- IE Shows nothing if we are adding a new agent -->
	<c:if test="${!empty travelPackage.packageName }">
			
			<div class="form-group">
			<form:label path="packageid" for="packageid">
				<spring:message text="ID:"/>
				</form:label>
		
			<form:input id="packageid" path="packageid" name="packageid" class="form-control" readonly="true" size="8" disabled="true" />
			<form:hidden path="packageid" />
			</div>
	</c:if>
	
	<!-- Default as the page loads up -->
	<!--  Package Name -->
		<div class="form-group">
		<form:label path="packageName" for="packageName">
			<spring:message text="Package Name:"/>
			</form:label>
	
		<form:input path="packageName" id="packageName" name="packageName" class="form-control" placeholder="Enter a Package Name (Required)"  /> <!-- Saying that if the agent First Name has a value.. then put it in otherwise leave it blank -->
		</div>
		<p><form:errors path="packageName" cssClass="error"/></p>
	
	<!-- Package Start Date -->
		<div class="form-group">
		<form:label path="packageStartDate">
			<spring:message text="Start Date:"/>
			</form:label>

		<form:input type="date" path="packageStartDate" placeholder="Enter the Start Date (Required)" class="form-control" />
		</div>
		<p><form:errors path="packageStartDate" cssClass="error"/></p>
		
	<!--Package End Date -->
		<div class="form-group">
		<form:label path="packageEndDate">
			<spring:message text="End Date:"/>
			</form:label>

		<form:input type="date" path="packageEndDate" placeholder="Enter the End Date(Required)" class="form-control" />
		</div>
		<p><form:errors path="packageEndDate" cssClass="error"/></p>
		
		<!-- package Description -->
		<div class="form-group">
		<form:label path="packageDescription">
			<spring:message text="Description :"/>
			</form:label>
	
		<form:input path="packageDescription" placeholder="Enter the Description (Required)" class="form-control"/>
		</div>
			<p><form:errors path="packageDescription" cssClass="error"/></p>
	
	<!-- Package Base Price -->
		<div class="form-group">
			<form:label path="packageBasePrice" >
			<spring:message text="Base Price:"/>
			</form:label>

			<form:input type="number" step="0.01" min="0.00" max="9999999.99" path="packageBasePrice" placeholder="Enter the Base Price (Required)" class="form-control"/>
		</div>	
		<p><form:errors path="packageBasePrice" cssClass="error"/></p>
	<!--  Agency Commission -->
		<div class="form-group">
		<form:label path="packageAgencyCommission">
			<spring:message text="Agency Commission:"/>
			</form:label>
		<form:input type="number" step="0.01" min="0.00" max="9999999.99" path="packageAgencyCommission" placeholder="Enter the Agency Commission (Required)" class="form-control" />
		</div>
		<p><form:errors path="packageAgencyCommission" cssClass="error"/></p>
	

	<!-- Button edit or add new Agent -->
		
			<c:if test="${!empty travelPackage.packageName}">
				<input type="submit" id="btnsubmit" class="btn btn-primary active"
					value="<spring:message text="Edit Package"/>" />
			</c:if>
			<c:if test="${empty travelPackage.packageName }">
				<input type="submit" id="btnsubmit" class="btn btn-primary active"
					value="<spring:message text="Add Package"/>" />
				</c:if>

</form:form>
</div>


</body>
</html>