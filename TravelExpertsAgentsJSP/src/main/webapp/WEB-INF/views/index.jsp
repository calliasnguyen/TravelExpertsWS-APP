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

	<!-- Tags for Bootstrap & AJAX -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <!--  Ajax grabbing time from the server -->
  
  <script type ="text/javascript">
  
  	function grabTime()
  	{
  		$.ajax({
  			//url ajaxTime refers to the get request "ajaxTimer" controller inside the home controller
  			url:'ajaxTime ',
  			type:"GET",
  			success : function(data)
  			{
  				console.log(data);
  				$('#response').text(data);
  			},
  			error : function(e)
  			{
  				console.log("Error: ", e);
  			}
  		
  		});
  		
  	}
  
  </script>
  
  <!--  Timer to update the ajax every 1 second -->
  <script type="text/javascript">
  	var intervalId = 0;
  	intervalId = setInterval(grabTime, 1000);
  </script>

  <style>

div.jumbotron {
background-color: #286090;
color: white;
text-align: center;
}

</style>

  

</head>
<body>

<!-- Map to the home page here -->
<c:url var="agentURL" value="./">
</c:url>

<!--  SETTING UP SESSIONS HERE-->
<!-- 	<c:set var= "agentLogin" scope="session" value="${agent}" />  -->
	

<nav class="navbar  navbar-default">
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
      <li><a href="login"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>
  <!-- Beginning of the jumbotron Div -->
<div class="jumbotron">
  
  <!--  on login if the agent is not empty, put his name here -->
  <c:if test="${!empty agent.agtFirstName }">
  <h2>Welcome Back ${agent.agtFirstName} ${agent.agtLastName }! </h2> 
  </c:if>
  
  <!--  on index return if the agent is empty... put his name here using sessions of agentlogin -->
  <c:if test="${empty agent.agtFirstName }">
  <h2>Welcome Back ${agentlogin.agtFirstName} ${agentlogin.agtLastName }! </h2> 
  </c:if>
  
  

  <h3>The Local Time is now:</h3>
  <p id="response"></p> 
</div>
<!--  End of the jumbotron div -->

<!-- Start of the image Div -->

<!--  Link to the css file -->
<!--  <link href="<c:url value="/resources/css/agentsite.css" />" rel="stylesheet"> -->

<div class="container">
  <h4>Travel Packages</h4>

  <div class="row">
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="home" target="_blank">
          <img src="<c:url value="/resources/images/beach.jpg" />" alt="Lights" style="width:100%">
          <div class="caption">
            <p>Bahamas Vacation Package</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="home" target="_blank">
          <img src="<c:url value="/resources/images/nightStars.jpg" />" alt="Nature" style="width:100%">
          <div class="caption">
            <p>Vancouver Island Package</p>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="home" target="_blank">
          <img src="<c:url value="/resources/images/paris.jpg" />" alt="Fjords" style="width:100%">
          <div class="caption">
            <p>Europe Package</p>
          </div>
        </a>
      </div>
    </div>
  </div>
</div>

<!-- End of the image Div -->

</body>
</html>