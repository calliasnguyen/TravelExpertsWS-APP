<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page session="false" %>
<html>
<head>
	<title>Agent Database</title>
		<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Welcome to the Agent Database! 
</h1>

<P>  Today is: ${serverTime}. </P>

<h3>Agent List</h3>
<c:if test="${!empty listAgents}">
	<table class="tg">
	<tr>
		<th width="50">Agent ID</th>
		<th width="120">Agent Name</th>
		<th width="120">Business Phone #</th>
		<th width= "120">Email</th>
		<th width= "100">Position</th>
		<th width="50">Agency ID</th>
	</tr>
	<c:forEach items="${listAgents}" var="agent">
	<tr>
		<td>${agent.agentId}</td>
		<td>${agent.agtFirstName} ${agent.agtMiddleInitial} ${agent.agtLastName}</td>
		<td>${agent.agtBusPhone }</td>
		<td>${agent.agtEmail }</td>
		<td>${agent.agtPosition}</td>
		<td>${agent.agencyid}</td>
	</tr>
	</c:forEach>
	</table>
	</c:if>
</body>
</html>
