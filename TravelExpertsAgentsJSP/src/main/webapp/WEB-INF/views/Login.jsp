<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Login Page</title>

<!--  Bootstrap -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style>

div.jumbotron {
background-color: #286090;
color: white;
text-align: center;
}

</style>
</head>
<body>

<!-- Header For the Agent Database -->
<div class="jumbotron">
  <h1 style="text-align:center">Welcome To the Agent Database</h1>      
  <p> Please enter your credentials!</p>
</div>

	<!-- Follows the Agent modelAttribute -->
	<div class="container">
	<c:url var="login" value="/index"></c:url>
	<form:form id="loginForm" action="${login}" commandName="agent">
		
			<div class="form-group">
			<form:label path="agtFirstName" for="username">
			<spring:message text="Username:"/>
			</form:label>
			
			
			<form:input id="agtFirstName" name="agtFirstName" path="agtFirstName" 
					class="form-control" placeholder="Enter your Username" />
			</div>
		
			<div class="form-group">	
			<form:label path="agtLastName" for="password">
			<spring:message text="Password:"/>
			</form:label>
		
			<form:input id="agtLastName" name="agtLastName" path="agtLastName" 
					class="form-control" placeholder="Enter your Password" type="password"/>
			</div>
			
			<c:if test="${!empty error}">
				<b style="color:red;"><c:out value="${error}"/> </b></br></br>
				  
			</c:if>
			
			<input type="submit" value="Submit" class="btn btn-primary active"  />
			
	</form:form>
	</div>


</body>
</html>