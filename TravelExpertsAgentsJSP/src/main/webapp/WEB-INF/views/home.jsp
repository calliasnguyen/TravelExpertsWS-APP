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

<h2>Add an Agent</h2>

<c:url var="addAction" value="/add" ></c:url>
<form:form action="${addAction}" commandName="agent">
<table>
<!--  SHOWS US THE ID OF AN EDITED AGENT (Shows nothing if there is no value) -->
	<c:if test="${!empty agent.agtFirstName }">
	<tr>
		<td>
			<form:label path="agentId">
				<spring:message text="ID"/>
				</form:label>
		</td>
		<td>
			<form:input path="agentId" readonly="true" size="8" disabled="true" />
			<form:hidden path="agentId" />
		</td>
	</tr>
	</c:if>
	
	<!-- Default as the page loads up -->
	<!--  Agent First Name -->
	<tr>
	<td>
		<form:label path="agtFirstName">
			<spring:message text="First Name"/>
			</form:label>
	</td>
	<td>
		<form:input path="agtFirstName" />
	</td>
	</tr>
	<!-- Agent Middle Initial -->
	<tr>
	<td>
		<form:label path="agtMiddleInitial">
			<spring:message text="Middle Initial"/>
			</form:label>
	</td>
	<td>
		<form:input path="agtMiddleInitial" />
	</td>
	</tr>
	<!-- Agent Last Name -->
		<tr>
	<td>
		<form:label path="agtLastName">
			<spring:message text="Last Name"/>
			</form:label>
	</td>
	<td>
		<form:input path="agtLastName" />
	</td>
	</tr>
		<!-- Agent Business Phone -->
		<tr>
	<td>
		<form:label path="agtBusPhone">
			<spring:message text="Business Phone#"/>
			</form:label>
	</td>
	<td>
		<form:input path="agtBusPhone" />
	</td>
	</tr>
	
	<!--  Agent Email -->
	<tr>
		<td>
			<form:label path="agtEmail" >
			<spring:message text="Email"/>
			</form:label>
		</td>
		<td>
			<form:input path="agtEmail"/>
		</td>
	</tr>
	<tr>
	<!--  Agent Position -->
		<tr>
	<td>
		<form:label path="agtPosition">
			<spring:message text="Agent Position"/>
			</form:label>
	</td>
	<td>
		<form:input path="agtPosition" />
	</td>
	</tr>
		<!--  Agency ID -->
	<tr>
	<td>
		<form:label path="agencyid">
			<spring:message text="Agency ID"/>
			</form:label>
	</td>
	<td>
		<form:input path="agencyid" />
	</td>
	</tr>
	
	<!-- Button edit or add new Agent -->
		<td colspan="2">
			<c:if test="${!empty agent.agtFirstName}">
				<input type="submit"
					value="<spring:message text="Edit Agent"/>" />
			</c:if>
			<c:if test="${empty agent.agtFirstName }">
				<input type="submit"
					value="<spring:message text="Add Agent"/>" />
				</c:if>
			</td>
		</tr>
</table>
</form:form>


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
		<th width="60">Edit </th>
		<th width="60">Delete</th>
	</tr>
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
	</c:if>
</body>
</html>
