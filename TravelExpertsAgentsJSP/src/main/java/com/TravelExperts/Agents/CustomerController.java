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
import com.TravelExperts.Service.CustomerService;


@RequestMapping(value = "/Customer")
@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	//GET METHOD to grab all Customers
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
	
	//GET METHOD to grab a customer by ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Customer getCustomerId(@PathVariable("id") Integer id)
	{
		Customer customer = new Customer();
		customer = customerService.getCustomerById(id);
		return customer;
	}
	
	

	
	//Adding Customer using RequestMethod POST
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
