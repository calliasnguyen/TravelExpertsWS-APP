<!--  AGENT WEBSITE FOR ADDING AND DELETING AGENTS -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="java.util.*" %>    
<%@ page import="com.TravelExperts.Model.Agent" %>

<!--  HOME FILE IS THE AGENT'S WEBSITE FOR ADDING AND DELETEING AGENTS -->
<!-- CALLIAS NGUYEN -->


<%@ page session="true" %>
<html>
<head>
<!--  Link to the css file -->
<!--  <link href="<c:url value="/resources/css/agentsite.css" />" rel="stylesheet"> -->


<!-- Attempting Bootstrap on this file -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
	<title>Agent Database</title>
	
	<style>
    .error {
        color: red; font-weight: bold;
    }
</style>
		
</head>
<body>

<!-- If the value for success it true.. then show modal -->
<c:if test="${param.agentSuccess != null}" >

<!-- Script for launching a modal whenever the page is loaded on adding/editing-->
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
        This Agent has been ${param.agentSuccess}! 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
      </div>
    </div>
  </div>
</div>

<!-- end of the modal -->


<!-- session variable Agent --><!-- CANNOT RESTORE A SESSION OBJECT AGAIN ONCE SERIALZABLE YOU NEED TO FIGURE ANOTHER WAY -->
	<!-- 
	<c:set var="testing" scope="session" value="${agentLogin}"/>
	<c:set var="agentLogin" scope="session" value="${agentLogin}"/>
	 -->
	
<!-- Trying to map the home and index pages here -->
<!-- If the agent is empty.. add a new agent  this will be the nav bar for the site -->
<c:if test="${empty agent.agentId }">
<c:url var="homeURL" value="./home">
</c:url>

	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">Travel Experts</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a href="<c:url value="${homeURL}"/>">Home</a></li>
	      <li class="active"> <a href="#">Add/Edit Agent</a></li>
	      <li><a href="bookings">Bookings</a></li>
	       <li><a href="package">Packages</a></li>
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

<!-- If we are editing agents... then we have to edit the url for the nav  -->

<c:if test="${!empty agent.agentId }">

	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">Travel Experts</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a href="../home">Home</a></li>
	      <li class="active"> <a href="#">Add/Edit Agent</a></li>
	      <li><a href="../bookings">Bookings</a></li>
	       <li><a href="package">Packages</a></li>
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


<!-- Begin by Adding a new agent -->
<c:if test="${!empty agent.agentId }">
<h2 style="text-align:center">Modify ${agent.agtFirstName}  ${agent.agtLastName}</h2>
</c:if>
<c:if test="${empty agent.agentId }">
<h2 style="text-align:center">Add a New Agent</h2>
</c:if>











<!-- Beginning of the form -->
<div class = "container">
<c:url var="addAction" value="/add" ></c:url>
<form:form action="${addAction}" commandName="agent">


<!--  SHOWS US THE ID OF AN EDITED AGENT (Shows nothing if there is no value) -->
<!-- IE Shows nothing if we are adding a new agent -->
	<c:if test="${!empty agent.agentId }">
			
			<div class="form-group">
			<form:label path="agentId" for="agentid">
				<spring:message text="ID:"/>
				</form:label>
		
			<form:input id="agentid" path="agentId" name="agentid" class="form-control" readonly="true" size="8" disabled="true" />
			<form:hidden path="agentId" />
			</div>
	</c:if>
	
	<!-- Default as the page loads up -->
	<!--  Agent First Name -->
		<div class="form-group">
		<form:label path="agtFirstName" for="agtfirstname">
			<spring:message text="First Name:"/>
			</form:label>
	
		<form:input path="agtFirstName" id="agtfirstname" name="agtfirstname" class="form-control" placeholder="Enter Agent's first name (Required)"  /> <!-- Saying that if the agent First Name has a value.. then put it in otherwise leave it blank -->
		</div>
		<p><form:errors path="agtFirstName" cssClass="error"/></p>
	
	<!-- Agent Middle Initial -->
		<div class="form-group">
		<form:label path="agtMiddleInitial">
			<spring:message text="Middle Initial:"/>
			</form:label>

		<form:input path="agtMiddleInitial" placeholder="Enter your middle initial Max 2 Characters!(Required)" class="form-control" />
		</div>
		<p><form:errors path="agtMiddleInitial" cssClass="error"/></p>
	<!-- Agent Last Name -->
		<div class="form-group">
		<form:label path="agtLastName">
			<spring:message text="Last Name:"/>
			</form:label>

		<form:input path="agtLastName" placeholder="Enter your last name (Required)" class="form-control" />
		</div>
		<p><form:errors path="agtLastName" cssClass="error"/></p>
		
		<!-- Agent Business Phone -->
		<div class="form-group">
		<form:label path="agtBusPhone">
			<spring:message text="Business Phone#:"/>
			</form:label>
	
		<form:input path="agtBusPhone" placeholder="Enter your Phone Number (Required)" class="form-control"/>
		</div>
			<p><form:errors path="agtBusPhone" cssClass="error"/></p>
	
	<!--  Agent Email -->
		<div class="form-group">
			<form:label path="agtEmail" >
			<spring:message text="Email:"/>
			</form:label>
		
			<form:input path="agtEmail" placeholder="Enter your email address (Required)" class="form-control"/>
		</div>	
		<p><form:errors path="agtEmail" cssClass="error"/></p>
	<!--  Agent Position -->
		<div class="form-group">
		<form:label path="agtPosition">
			<spring:message text="Agent Position:"/>
			</form:label>
		<form:input path="agtPosition" placeholder="Enter your position (Required)" class="form-control" />
		</div>
		<p><form:errors path="agtPosition" cssClass="error"/></p>
		<!--  Agency ID -->
		<div class="form-group">
		<form:label path="agencyid">
			<spring:message text="Agency ID:"/>
			</form:label>

		<form:input type="text" title="Agency 1 or 2" pattern="\d" path="agencyid" placeholder="Enter your agency ID (Optional)" class="form-control"/>
		</div>
	
	<!-- Button edit or add new Agent -->
		
			<c:if test="${!empty agent.agentId}">
				<input type="submit" class="btn btn-primary active"
					value="<spring:message text="Edit Agent"/>" />
			</c:if>
			<c:if test="${empty agent.agentId }">
				<input type="submit" class="btn btn-primary active"
					value="<spring:message text="Add Agent"/>" />
				</c:if>

</form:form>
</div>

<!-- Table to show a list of Agents -->

<h3 style="text-align:center" style="font-weight:bold" >List of All Agents</h3>
<c:if test="${!empty listAgents}">
<div class="container">
	<div class="table-responsive">
	<table class="table">
	<thead>
	<tr>
		<th width="100">Agent ID</th>
		<th width="120">Agent Name</th>
		<th width="145">Phone #</th>
		<th width= "120">Email</th>
		<th width= "100">Position</th>
		<th width="100">Agency ID</th>
		<th width="60">Edit </th>
		<th width="60">Delete</th>
	</tr>
	</thead>
	<c:forEach items="${listAgents}" var="agent">
	<tr>
		<td>${agent.agentId}</td>
		<td>${agent.agtFirstName} ${agent.agtMiddleInitial} ${agent.agtLastName}</td>
		<td>${agent.agtBusPhone }</td>
		<td>${agent.agtEmail }</td>
		<td>${agent.agtPosition}</td>
		<td>${agent.agencyid}</td>
		<td><a href="<c:url value='/edit/${agent.agentId }' />" > Edit</a></td>
		<td><a href="<c:url value='/remove/${agent.agentId }' />" >Delete</a></td>
	</tr>
	</c:forEach>
	</table>
	</div>
</div>
	</c:if>
</body>
</html>
