<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Testing out Ajax</title>


<!-- Using the latest version of ajax jquery NOT USING MAVEN... BUT GOOGLEAPIS -->
<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>  -->


<!-- Try this one for JQUERY as well  -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>


<!-- AJAX -->
<script type="text/javascript">
	function grabTime() 
	{
		//console.log("Reaching this point via the timer");
		$.ajax({
			//url: '/ajax/ajaxtest',
			url: 'ajaxtest ',
			type: "POST",
			timeout : 5000,
			success : function(data)
			{
				console.log(data);
				$('#response').text(data);
			},
			error : function(e)
			{
				console.log("ERROR: ", e);
				
			}
					
		});
		
		
		
	}


</script>
<script type="text/javascript">
	var intervalId = 0;
	intervalId = setInterval(grabTime, 1000);
</script>

</head>
<body>

<p>Testing an Ajax document</p>
<!-- Grabbing the ajax value -->
<div id="response"></div>


</body>
</html>