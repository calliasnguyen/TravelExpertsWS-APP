package com.TravelExperts.Agents;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TravelExperts.Model.Agent;

@RequestMapping(value = "/Customer")
@Controller
public class CustomerController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody
	String getCustomer() {

		String helloWorld = "helloworld";
		return helloWorld;
	}
	
	
}
