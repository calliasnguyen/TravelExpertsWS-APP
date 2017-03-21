<!--  INITIAL PAGE AFTER THE LOGIN PAGE -->

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
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<!-- Map to the home page here -->
<c:url var="agentURL" value="./">
</c:url>

<!--  SETTING UP SESSIONS HERE-->
	<c:set var= "agentLogin" scope="session" value="${agent}" />
	

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Travel Experts</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="">Home</a></li>

 
      <li> <a href="<c:url value="${agentURL} " />">Add/Edit Agent</a></li>
      <li><a href="bookings">Bookings</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="customer"><span class="glyphicon glyphicon-user"></span>Sign Up Customer</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>
  
<div class="jumbotron">
  <c:if test="${!empty agent.agtFirstName }">
  <h1>Welcome Back ${agent.agtFirstName} ${agent.agtLastName }! </h1> 
  </c:if>
  
  
  
  <!-- TESTING SESSION VARIABLES AND IF THEY ACTUALLY WORK -->
  <c:if test="${!empty agentLogin.agtFirstName }">
  <h1>${agentLogin.agtFirstName}</h1>
  </c:if>
  
  <p>session testing ${testing.agtFirstName} ... session agentLogin ${agentLogin.agtFirstName }</p>
       
  <p> The Time is: ${serverTime}</p>
</div>



</body>
</html>