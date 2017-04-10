package com.TravelExperts.Agents;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TravelExperts.Model.Customer;
import com.TravelExperts.Service.CustomerService;

// Callias Nguyen
//  Note angular test page for the controller is in the Customer Controller...


@Controller
@Scope("request")
@RequestMapping("/customerlist")
public class AngularJSController {
	
	
	@Autowired
	CustomerService customerService;

	
	
	///////////////////////////////////////////////test angular page/////////////////////////////////////
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAngularPage()
	{
		
		return "allcustomers";
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	///////////////////////////////////////////////test angular page/////////////////////////////////////
@RequestMapping(value = "/customers", method = RequestMethod.GET)
public @ResponseBody List<Customer> getCustomerList() 
{

	return customerService.listCustomer();
}

	
	

	
}
