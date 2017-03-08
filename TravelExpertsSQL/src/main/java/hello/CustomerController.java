package hello;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.Customer;
import hello.CustomerRepository;


@Controller
@RequestMapping(path = "/customer")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
	
	//GET METHOD to grab all customers
		@GetMapping(path ="/all")
		public @ResponseBody Iterable<Customer> getAllCustomers()
		{
			//This return either JSON or XML with the users
			return customerRepository.findAll();
		}
		
	//GET METHOD to grab customer by first name and last name
		@GetMapping(path = "/fullname")
		public @ResponseBody Customer getCustomerByFullName(@RequestParam String fname, @RequestParam String lname)
		{
			return customerRepository.findByLastnameAndFirstname(lname, fname);
		}

		
	//GET METHOD to grab customer by first name		
		@GetMapping(path = "/{firstname}")
		public @ResponseBody Customer getCustomerFname(@PathVariable("firstname") String firstname)
		{
			return customerRepository.findbyFirstName(firstname);
		}
		

	//POST METHOD to update customer information
		@RequestMapping(path = "/update", method = RequestMethod.POST)
		public @ResponseBody String updateCustomer(@RequestParam Integer customerid, 
				@RequestParam String custfirstname, @RequestParam String custlastname, @RequestParam String custaddress, @RequestParam String custcity,
				@RequestParam String custprov, @RequestParam String custpostal, @RequestParam String custcountry, @RequestParam String custhomephone, @RequestParam String custbusphone, @RequestParam String custemail,
				@RequestParam Integer agentid)
		{
			Customer customer = new Customer();
			customer.setAgentId(agentid);
			customer.setCustomerAddress(custaddress);
			customer.setCustomerBusPhone(custbusphone);
			customer.setCustomerCity(custcity);
			customer.setCustomerCountry(custcountry);
			customer.setCustomerEmail(custemail);
			customer.setCustomerFirstName(custfirstname);
			customer.setCustomerHomePhone(custhomephone);
			customer.setCustomerId(customerid);
			customer.setCustomerLastName(custlastname);
			customer.setCustomerPostal(custpostal);
			customer.setCustomerProvince(custprov);
			
			
			customerRepository.save(customer);
			
			return "Updated";
		}
		
	

}
