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
     	 <a href="" class="list-group-item disabled">Package</a>
     	 <a href="booking" class="list-group-item">Booking</a>
     	
        </div>
    </div>
    <!--  End of the side bar -->
    
    <!-- Beginning of the documentation for customer -->
        <div id="Customer" class="col-md-9 col-lg-9">
            <h2>Package</h2>
            </br>
            <p style="font-size:120%;">For the customer mobile application, there is no authorization restrictions for grabbing a list of packages, or a 
            single package. However, for updating/deleting/inserting a new package, there is now an authorization requirement (as not just anyone can touch the database!).
            This can be easily implemented for all the REST endpoints.
             </p>
             
             
             
          
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
        <td><img src="<c:url value="/resources/images/get.png" />"> Base URL/Package/</td>
        <td>Grab a List of all the Packages</td>     
      </tr>
       <tr>
        <td><img src="<c:url value="/resources/images/get.png" />"> Base URL/Package/{id}</td>
        <td>Grab a Package by its own ID</td>     
      </tr>
        <tr style="cursor:pointer" data-toggle="modal" data-target="#postPackage">
        <td><img src="<c:url value="/resources/images/Post.PNG" />"> Base URL/Package/add?agentAuthorization={AGENT AUTH KEY}</td>
        <td>Create a new Package</td>     
      </tr>
     
        <tr style="cursor:pointer" data-toggle="modal" data-target="#putPackage">
 	 <td><img src="<c:url value="/resources/images/put.PNG" />"> Base URL/Package/update?agentAuthorization={AGENT AUTH KEY} </td>
        <td>Update Package</td>      
    	</tr>
    	 <tr>
 	 <td><img src="<c:url value="/resources/images/delete.PNG" />"> Base URL/Package/remove/{packageid}?agentAuthorization={AGENT AUTH KEY} </td>
        <td>Delete Package</td>      
    	</tr>
    </tbody>
  </table>
  </div>
</div>
             
             
             <!--Modal for get Package  -->
             <div class="modal fade" id="postPackage" tabindex="-1" role="dialog" aria-labelledby="postModalTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="postModalTitle">Adding a new Package</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Here is an example of adding a new Package Note: This is a <strong>POST</strong> request.</p>
        <p style="font-weight:bold;"><u>The link to package is:</u></p>
        <div class="url"><code>POST           http://35.161.216.198:8080/TravelExpertsAgentsJSP/Package/add</code></div>
        <br/>
        <p><strong><u>Query Parameters:</u></strong></p>
        <p >agentAuthorization</p>
        
        <p><strong><u>Request Body:</u></strong></p>
        <p> The request body requires the following properties (with this exact format!) <strong>Content-Type: Application/json</strong>: </p>
		
		<div class="code">
		<code>
		 {<br/>
					   
			    "packageName": "Caribbean New Year",<br/>
			    "packageStartDate": "2017-12-25",<br/>
			    "packageEndDate": "2017-01-04",<br/>
			    "packageDescription": "Cruise the Caribbean & Celebrate the New Year.",<br/>
			    "packageBasePrice": 4800,<br/>
			    "packageAgencyCommission": 400.1<br/>
			 
		  
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
         <!--  End of package Modal -->
             
             
                      <!--Modal for editing Packages  -->
             <div class="modal fade" id="putPackage" tabindex="-1" role="dialog" aria-labelledby="postModalTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="postModalTitle">Editing a Package</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Here is an example of editing a current Package Note: This is a <strong>PUT</strong> request.</p>
        <p style="font-weight:bold;"><u>The link to package is:</u></p>
        <div class="url"><code>PUT           http://35.161.216.198:8080/TravelExpertsAgentsJSP/Package/update</code></div>
        <br/>
        <p><strong><u>Query Parameters:</u></strong></p>
        <p >agentAuthorization</p>
        
        <p><strong><u>Request Body:</u></strong></p>
        <p> The request body requires the following properties (with this exact format!) <strong>Content-Type: Application/json</strong>: </p>
		
		<div class="code">
		<code>
		 {<br/>
				"packageid":1, <br/>	   
			    "packageName": "Caribbean New Year",<br/>
			    "packageStartDate": "2017-12-25",<br/>
			    "packageEndDate": "2017-01-04",<br/>
			    "packageDescription": "Cruise the Caribbean & Celebrate the New Year.",<br/>
			    "packageBasePrice": 4800,<br/>
			    "packageAgencyCommission": 400.1<br/>
			 
		  
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
         <!--  End of  Edit package Modal -->
             
             
             
             
        </div>
	<!-- End of the documentation for Packages -->

</body>
</html>