package com.TravelExperts.Agents;

import java.util.List;

import org.hibernate.Hibernate;

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

import com.TravelExperts.Model.Agent;
import com.TravelExperts.Model.Customer;
import com.TravelExperts.Service.AgentService;
import com.TravelExperts.Service.CustomerService;



@RequestMapping(value = "/Customer")
@Controller
@Scope("session") // to control sessions
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	AgentService agentService;
	

	
	
	/////////////////////////////////////GET METHOD to grab all Customers//////////////////////////////////
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody
	List<Customer> getCustomerlist()
	{
		List<Customer> customerList = null;
		
		try{
			customerList= customerService.listCustomer();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	////////////////////////////////////GET METHOD to grab a customer by ID/////////////////////////////////
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomerId(@PathVariable("id") Integer id)
	{
		Customer customer = null;
		try
		{
			//If customerservice cannot find a customer by the ID it will throw a bad request
		customer = customerService.getCustomerById(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}
		catch(Exception e)
		{
			//Throwing a bad request 400
			return new ResponseEntity<Customer>(customer, HttpStatus.BAD_REQUEST);
		}
		

	}

	///////////////////////////////////////////Login Validation for customer/////////////////////////
	@RequestMapping(value = "/verification", method = RequestMethod.GET)
	public ResponseEntity<Customer> loginCustomerVerification(@RequestParam String lastname, String email)
	{
		Customer customer = customerService.customerLogin(email, lastname);
		
		if(customer != null)
		{		
			//return the customer object with a status 200
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);	
		}
		else
			return new ResponseEntity<Customer>(customer, HttpStatus.BAD_REQUEST);
	
		
	}
	
	
	///////////////////////////Get METHOD to grab a list of customers by agent's ID///////////////////////////////
	@RequestMapping(value = "/agent", method = RequestMethod.GET)
	public @ResponseBody List<Customer> getCustomerByAgentId(@RequestParam int agentid)
	{
			//if nothing is found return null
		List<Customer> customersbyAgentID = null;
		customersbyAgentID = customerService.getCustomerByAgentId(agentid);
		return customersbyAgentID;
	}

	
	/////////////////////////Adding Customer using RequestMethod POST//////////////////////////////
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		
		
		//only customer country,homephone,agent id can be null
		customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	

	//Updating Customer using RequestBody... If any Customer property is not included
	//it will be given a null value
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer)
	{
		
		customerService.updateCustomer(customer);
				
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	
	
}
