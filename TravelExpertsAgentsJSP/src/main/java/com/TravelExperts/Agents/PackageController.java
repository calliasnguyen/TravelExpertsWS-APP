package com.TravelExperts.Agents;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TravelExperts.Service.AgentService;
import com.TravelExperts.Service.PackageService;
import com.TravelExperts.Model.Package;
///////////////////////// AUTHORIZATION TESTED HERE//////////////////////////////////////////////////////////


// This is where I will test authorization before any GET/POST methods//
// Ideally we will use a unique identifier for Customers and Agents (Ie. customers will be able to update their own information but cannot update agent things
// like packages, updating agents, etc, 
// we will use UUID from java to generate keys and allow access only to agents who are authorized...
//

@RequestMapping(value = "/Package")
@Controller
@Scope("session") // to control sessions
public class PackageController{
	
	@Autowired 
	PackageService packageService;
	
	@Autowired
	AgentService agentService;
	
	/////////////////////////////////////////////////////Get Method to grab all packages//////////////////////////////////////////////////////////
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<List<Package>> getPackageList(@RequestParam String agentAuthorization)
	{
		//Authorize the agent and if this agent does not exist return badRequest (unauthorized )401
		List<Package> packageList = null;
		if(agentService.isValidAgentAuthorization(agentAuthorization))
			{
			
				
				try{
					packageList = packageService.listPackage();
				}catch(Exception e){
					e.printStackTrace();
				}
				return new ResponseEntity<List<Package>>(packageList, HttpStatus.OK);
			
			}else
				return new ResponseEntity<List<Package>>(packageList, HttpStatus.UNAUTHORIZED);
		
	
	}
	
	////////////////////////////////////////////////////Get method for a specific Package///////////////////////////////////////////////////////////
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Package> getPackageById(@PathVariable("id") Integer id,@RequestParam String agentAuthorization)
	{
		Package p = null;
		
		//if agentAuthorization is valid then go ahead with grabbing the information 
		//otherwise send a 401 UNAUTHORIZED
		if(agentService.isValidAgentAuthorization(agentAuthorization))
		{

			 p = packageService.getPackageById(id);
			return new ResponseEntity<Package>(p, HttpStatus.OK);
		}
		else
			return new ResponseEntity<Package>(p,HttpStatus.UNAUTHORIZED);
		
	}
	
	
	/////////////////////////////////////////////////////////Update a package  Post request/////////////////////////////////////////////////////////////
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ResponseEntity<Package> updatePackage(@RequestBody Package p,@RequestParam String agentAuthorization)
	{
		//if agentAuthorization is valid then go ahead with grabbing the information 
		//otherwise send a 401 UNAUTHORIZED
		if(agentService.isValidAgentAuthorization(agentAuthorization))
		{
			packageService.updatePackage(p);
			return new ResponseEntity<Package>(p, HttpStatus.ACCEPTED);
		}
		else
			return new ResponseEntity<Package>(p, HttpStatus.UNAUTHORIZED);
		}
	
	
	
	//Add a new Package
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<Package> addPackage(@RequestBody Package p,@RequestParam String agentAuthorization)
	{
		//if agentAuthorization is valid then go ahead with grabbing the information 
		//otherwise send a 401 UNAUTHORIZED
		if(agentService.isValidAgentAuthorization(agentAuthorization))
		{
			packageService.addPackage(p);
			return new ResponseEntity<Package>(p, HttpStatus.ACCEPTED);
		}
		else
		{
			return new ResponseEntity<Package>(p,HttpStatus.UNAUTHORIZED);
		}
	}
	
	////////////////////////////////////////////////////////////////Remove a Package by ID///////////////////////////////////////////////////////////////
	@RequestMapping(value="/remove/{id}", method=RequestMethod.POST)
	public ResponseEntity<?> removePackage(@PathVariable("id") Integer id,@RequestParam String agentAuthorization)
	{//bug to fix the response strings
		//if agentAuthorization is valid then go ahead with grabbing the information 
		//otherwise send a 401 UNAUTHORIZED
		if(agentService.isValidAgentAuthorization(agentAuthorization))
		{	
		packageService.removePackage(id);
		return new ResponseEntity<String>("Package has been removed from the database",HttpStatus.ACCEPTED);
		}
		else
			return new ResponseEntity<String>("Unauthorized request",HttpStatus.UNAUTHORIZED);	
		}
	
}
