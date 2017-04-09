package com.TravelExperts.Agents;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TravelExperts.Model.Agent;
import com.TravelExperts.Model.Customer;
import com.TravelExperts.Service.AgentService;
import com.mysql.cj.fabric.Response;

@Controller
@RequestMapping(value = "/agent")

public class AgentController {

	
	@Autowired
	AgentService agentService;
	

	
	
	/////////////////////////////////////////////////////GET Request to grab a list of agents/////////////////////////////////////////////////////////		
	
	//Grabbing a list of all agents...
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody
	List<Agent> getAgent() {

		List<Agent> agentList = null;
		try {
			agentList = agentService.listAgents();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return agentList;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////Grabbing agent by ID///////////////////////////////////////
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Agent> getAgendById(@PathVariable("id") Integer agentid)
	{
		Agent agent = null;
		
		if(agentid == null)
		{
			return new ResponseEntity<Agent>(agent,HttpStatus.BAD_REQUEST);
		}
		
			agent = agentService.getAgentById(agentid);
		
		if(agent !=null)
			return new ResponseEntity<Agent>(agent, HttpStatus.OK);
		else
			return new ResponseEntity<Agent>(agent,HttpStatus.BAD_REQUEST);
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/////////////////////////////////////////////Testing to see if Authorization works//////////////////////////////////////////////////////////////////////////////
	//Test controller to see if the agent authorization works
		@RequestMapping(value="/authorization", method=RequestMethod.GET)
		public @ResponseBody String authorizationCheck(@RequestParam String authorization)
		{
			if(agentService.isValidAgentAuthorization(authorization))
			{
				return "this has been successful";
			}
			else
			return "No such agent with this authorization";
		}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
//////////////////////////////////////////Login agent by agent's email, PW being the agent's last name //////////////////////////////////////
	@RequestMapping(value="/agentlogin", method=RequestMethod.POST)
	public ResponseEntity<Agent> authorizationLoginAgent(@RequestBody Agent agent)
	{//For the requestbody You have to send the values as an agent object (the rest of the agent properties will be null)
       	//in order to parse correctly.. cannot send @requestbody as a string for the email and last name...
		//hard to parse in spring.. unless you try textnode for jackson....
		
		
	
		String agtEmail = 	agent.getAgtEmail();
		String agtLastName = agent.getAgtLastName();
		
		
		
	    agent = agentService.loginAgentByEmail(agtEmail, agtLastName);
	
	    
	    
	    if(agent != null)
	    {
	    	return new ResponseEntity<Agent>(agent, HttpStatus.OK);
	    }
	    else 
	    	return new ResponseEntity<Agent>(agent, HttpStatus.BAD_REQUEST);
	    
	}
	
////////////////////////////////////////////////////Add a new Agent////////////////////////////////////////////////////////
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<Agent> addAgent(@RequestBody Agent a, @RequestParam String agentAuthorization)
	{
		// if agent is unauthorized then dont get information
		if(agentService.isValidAgentAuthorization(agentAuthorization))
		{
			agentService.addAgent(a);
			return new ResponseEntity<Agent>(a, HttpStatus.ACCEPTED);
		}
		else
			return new ResponseEntity<Agent>(a, HttpStatus.BAD_REQUEST);	
	}
	
///////////////////////////////////////////////////UPDATE AN AGENT ///////////////////////////////////////////////////////
	@RequestMapping(value="/update", method= RequestMethod.PUT)
	public ResponseEntity<Agent> updateAgent(@RequestBody Agent a, @RequestParam String agentAuthorization)
	{
		if(agentService.isValidAgentAuthorization(agentAuthorization))
		{
			agentService.updateAgent(a);
			return new ResponseEntity<Agent>(a, HttpStatus.ACCEPTED);
		}
		else
			return new ResponseEntity<Agent>(a, HttpStatus.BAD_REQUEST);	
	}
	
	
///////////////////////////////////////////////////Remove Agent by ID///////////////////////////////////////////////////
	@RequestMapping(value="/remove/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> removeAgent(@PathVariable("id") Integer id, @RequestParam String agentAuthorization)
	{
		if(agentService.isValidAgentAuthorization(agentAuthorization))
		{
			try{	
			agentService.removeAgent(id);
			return new ResponseEntity<String>("Agent has been removed from the database", HttpStatus.ACCEPTED);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage() + e.getCause());
			}
			return new ResponseEntity<String>("Internal Error with the Database", HttpStatus.CONFLICT);
		}
		else
			return new ResponseEntity<String>("Unauthorized Request", HttpStatus.UNAUTHORIZED);
		
		
		
	}
	
}
