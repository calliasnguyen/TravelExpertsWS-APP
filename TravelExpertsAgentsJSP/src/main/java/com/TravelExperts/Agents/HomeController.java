//CALLIAS NGUYEN.. Initial Login Controller for this project
// TO ACCESS THE WEBSITE http://localhost:8080/Agents/login

package com.TravelExperts.Agents;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TravelExperts.Model.Package;
import com.TravelExperts.Model.Agent;
import com.TravelExperts.Model.Booking;
import com.TravelExperts.Model.Customer;
import com.TravelExperts.Service.AgentService;
import com.TravelExperts.Service.BookingService;
import com.TravelExperts.Service.CustomerService;
import com.TravelExperts.Service.PackageService;


@Controller
@Scope("session") // to control sessions
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	AgentService agentService;
	
	@Autowired 
	CustomerService customerService;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	PackageService packageService;

	
	///////////////////////////////////////////////Initial Login Page ///////////////////////////////////////////////////////////////////////////////
	
	//Initial LOGIN PAGE.. need to POST to the Index Page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, String error, ModelMap model) {
		logger.info("Welcome to the login page! The client locale is {}.", locale);
			
		//need a model attribute in order to complete the form
		model.addAttribute("agent", new Agent());
		
		// initialize error here but make it null so it doesnt show up on the screen
		model.addAttribute("error");
		return "Login";
	}
	
	
//////////////////////////////////////////////////////	index page /////////////////////////////////////////////////////////////////////////////////////
	//Index Page for after logging in as an agent for posting purposes only
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	//changed model to modelMap
	public String index(Locale locale, ModelMap model, @ModelAttribute("agent") Agent a, HttpSession session) {
		logger.info("Welcome to the index page! The client locale is {}.", locale);
			
		Boolean validateCredentials = agentService.isValidAgent(a.getAgtFirstName(), a.getAgtLastName());
		
		if(validateCredentials)
		{
			//grab the agent and pass it as an object
			Agent agent = new Agent();
			agent = agentService.returnAgentbyName(a.getAgtFirstName(), a.getAgtLastName());
			
			//setting attribute here
			session.setAttribute("helloworld", "helloworld");
			session.setAttribute("agentlogin", agent);
			
			//grab the server time
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			
			String formattedDate = dateFormat.format(date);
			
			//all the added attributes to the page
			model.addAttribute("serverTime", formattedDate);
			model.addAttribute("agent",agent);
		return "index";
		}
		else
		{
			//adding error to the login page
			model.addAttribute("error", "Your username/password is invalid. Please try again.");
			return "Login";
		}
	}
	
	
	/////////////////////////////////////////Get method for the INDEX PAGE (Cannot post back to original location) called home instead of /index///////////////////////////
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	//changed model to modelMap
	public String home(Locale locale, ModelMap model, @ModelAttribute("agent") Agent a) {
		logger.info("Welcome to the index page! The client locale is {}.", locale);
		
	
		
		
		model.addAttribute("agent",a);
		
			return "index";
		}
	
	
	//////////////////////////////////////////////////AJAX CODE to update time on the index page///////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/ajaxTime", method = RequestMethod.GET)
	public @ResponseBody String getTime(Locale locale)
	{
		
		//line to test if ajax goes to this controller
		System.out.println("successfully connecting to the ajax timer");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		return formattedDate;
		
		
	}
	
	
	
	

	/////////////////////////////////////////////////////////////////Updating adding and deleting agents website/////////////////////////////////////////////////////////////
	
	//THIS IS THE UPDATING/ADDING/EDITING AGENTS WEBSITE
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("agent2", new Agent());
		model.addAttribute("agent", new Agent());
		model.addAttribute("listAgents", this.agentService.listAgents());

		return "home";
	}
	
	
	
	////////////////////////////////////////////////////////////////Bookings and customer's by specific agent/////////////////////////////////////////////////////////////
	
	//Testing the Bookings Site 
	@RequestMapping(value = "/bookings", method = RequestMethod.GET)
	public String customerAdd(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome to the booking database! The client locale is {}.", locale);	
		
	
		Agent agent =  (Agent) session.getAttribute("agentlogin");
	
		
		System.out.println("This agent is:" + agent);
		if(agent == null)
		{
			model.addAttribute("agent", new Agent());
			return "Login";
		}
		
		
		
		
		List<Customer> customersByAgent = null;
		customersByAgent = customerService.getCustomerByAgentId(agent.getAgentId());
		
		for(Customer customer: customersByAgent)
		{
			Integer customerId = customer.getCustomerId();
			List<Booking> bookingsByCustomer = null;
			try
			{
			bookingsByCustomer = bookingService.getBookingsByCustomerId(customerId);
		
			
			//set the customer with the booking + package
			customer.setBookings(bookingsByCustomer);
			
			// TEST THIS OUT LATER for each of the booking, add the assigned package value here
//			for(Booking booking:bookingsByCustomer)
//			{
//				Package bookingPackage = new Package();
//				bookingPackage =  (Package) packageService.getPackageById(booking.getPackageId());
//				
//				//see what it prints here
//				System.out.println(bookingPackage);
//			
//				booking.setPackage(bookingPackage);		
//				
//				//see if it prints out a package
//				System.out.println(booking.getPackage());
//			}
			
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}
		
		model.addAttribute("listCustomer", customersByAgent);
		return "bookings";
	}
/////////////////////////////////////////// END OF BOOKING SITE ////////////////////////////////	
	
	
	/////////////////////////////////////////////////////GET Request to grab an agent by first name and last name/////////////////////////////////////////////////////////	
	
	
					//Can delete this when finished
//Testing to see if retrieving agent by name works correctly
					@RequestMapping(value = "/validagent", method= RequestMethod.GET)
					public @ResponseBody Agent getAgentByName(@RequestParam String fname, @RequestParam String lname)
					{
						Agent agent = new Agent();
						//if the agentService returns a value then login will work
						agent = agentService.returnAgentbyName(fname, lname);
					
					
						return agent;
						
						
					}
					
			/////////////////////////////////////////////////////GET Request to grab a list of agents/////////////////////////////////////////////////////////		
	
	//Grabbing a list of all agents...
	@RequestMapping(value = "/lists", method = RequestMethod.GET)
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
	
	
	///////////////////////////////////////////////////////////////////////Add of update an agent///////////////////////////////////////////////////////////////////
	
	//For adding and updating an Agent
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addAgent(@ModelAttribute("agent") Agent a)
	{
		if(a.getAgentId() == null)
		{
			//Add a new agent
			
			//create a randomized UUID for authorization for this agent
			String uuid = UUID.randomUUID().toString();
			a.setAgentAuthorization(uuid);
			
			agentService.addAgent(a);
		}
		else
		{
			agentService.updateAgent(a);
		}
		return "redirect:/";
	}
	
	////////////////////////////////////////////////////////////////////get request to add the customer//////////////////////////////////////////////////////////////
	//For adding a new Customer
	@RequestMapping(value= "/addCustomer", method = RequestMethod.POST)
	public String addAgent(@ModelAttribute("customer") Customer c)
	{
		customerService.addCustomer(c);
		return "redirect:/customer";
	}
	
	//////////////////////////////////////////////////////////Customer WEBSITE access (need the new customer to add a customer to the form)///////////////////////////////
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String customerAdd(Locale locale, Model model, HttpSession session,  @ModelAttribute("customer") Customer c) {
		logger.info("Welcome to customer database! The client locale is {}.", locale);	

		model.addAttribute("customer",new Customer());
		return "customer";
	}
	
	
	//Request to Delete agent in the Agent WebPage
	@RequestMapping(value= "/remove/{id}")
	public String removePerson(@PathVariable("id") int id){
		
		agentService.removeAgent(id);
		return "redirect:/";
	}
	
	@RequestMapping(value= "/edit/{id}")
	public String editAgent(@PathVariable("id") int id, Model model, Locale locale){
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("agent", agentService.getAgentById(id));
		model.addAttribute("listAgents", agentService.listAgents());
		return "home";
	}
	
	
	/////////////////////////////////////////////Testing to see if Authorization works//////////////////////////////
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
	
	
}
