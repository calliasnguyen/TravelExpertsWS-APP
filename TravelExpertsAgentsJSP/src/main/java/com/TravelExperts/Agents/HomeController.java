//CALLIAS NGUYEN.. Initial Login Controller for this project
// TO ACCESS THE WEBSITE http://localhost:8080/Agents/login

package com.TravelExperts.Agents;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.script.ScriptEngineManager;
import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.TravelExperts.Model.Agent;
import com.TravelExperts.Model.Booking;
import com.TravelExperts.Model.BookingDetail;
import com.TravelExperts.Model.Customer;
import com.TravelExperts.Model.Package;
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
	public String login(Locale locale, String error, ModelMap model, HttpSession session) {
		logger.info("Welcome to the login page! The client locale is {}.", locale);
		
		
		
		//When user logs out we will set a new session 
		session.setAttribute("agentlogin", null);
		
		//need a model attribute in order to complete the form
		model.addAttribute("agent", new Agent());
		
		// initialize error here but make it null so it doesnt show up on the screen
		model.addAttribute("error");
		return "Login";
	}
	
	
//////////////////////////////////////////////////////	Index page /////////////////////////////////////////////////////////////////////////////////////
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
			
			//setting attribute here SESSION VARIABLES HERE
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
	public String home(Locale locale, ModelMap model, @ModelAttribute("agent") Agent a, HttpSession session) {
		logger.info("Welcome to the index page! The client locale is {}.", locale);
		
		Agent agent = (Agent) session.getAttribute("agentlogin");
		
		if(agent == null)
		{
			//need to add attribute of new agent in the login page...
			model.addAttribute("agent", new Agent());
			return "Login"; //returns to login.jsp
		}
		
		
		model.addAttribute("agent",a);
		
			return "index";
		}
	
	
	
	//////////////////////////////////////////////////AJAX CODE to update time on the index page///////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/ajaxTime", method = RequestMethod.GET)
	public @ResponseBody String getTime(Locale locale)
	{
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		String formattedDate = dateFormat.format(date);
	
		
		//Use this to fix the AWS time zone error
		 Calendar cal = Calendar.getInstance(); // creates calendar
		    cal.setTime(new Date()); // sets calendar time/date
		    cal.add(Calendar.HOUR_OF_DAY, -6); // adds one hour
		    SimpleDateFormat format1 = new SimpleDateFormat("MMM/dd/yyyy h:mm:ss a");
		    String formattedDate2 = format1.format(cal.getTime());
		
		    System.out.println(formattedDate2);
		
		return formattedDate2;
	}
	
	
	
	

	/////////////////////////////////////////////////////////////////Updating Adding and Deleting Agents Website/////////////////////////////////////////////////////////////
	//this is the initial folder... need to redirect to login right away
	
	
	//THIS IS THE UPDATING/ADDING/EDITING AGENTS WEBSITE
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		//getting value of the session
		Agent agent = (Agent) session.getAttribute("agentlogin");
		
		//if the session is null.. return to the home page
		if(agent == null)
		{
			//need to add attribute of new agent in the login page...
			model.addAttribute("agent", new Agent());
			return "Login"; //returns to login.jsp
		}
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		//model.addAttribute("agent2", new Agent());
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
			
			//keeps the session open for hibernate so that i am allowed to lazy load the bookings
			Hibernate.initialize(bookingsByCustomer);	
				
			//grabbing the bookings for each customers 
			bookingsByCustomer = bookingService.getBookingsByCustomerId(customerId);
			
			
				//if there is no bookings by customer
			if(bookingsByCustomer.isEmpty())
				{
					System.out.println("The bookings for this customer is 0");
				
					
					//Need to set something for bookings for this customer
					//as it throws the lazy loaded exception if not.. 
					//meaning that you have to initialize a customer's bookings regardless of if they have a booking or not
					customer.setBookings(bookingsByCustomer);
					
				}
				else // booking exists for customer
				{
				//set the customer with the booking
				customer.setBookings(bookingsByCustomer);
				
//				for(Booking booking: bookingsByCustomer)
//					{
//						
//						List<BookingDetail> bDetail = booking.getBookingDetail();
//							for(BookingDetail bd: bDetail)
//							{
//								System.out.println(bd.getDestination());
//							}
//					}
				
				}//end of else statement
				
			
			
			}// end of the try for finding bookings by Customer
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}// end of for customer by customers by agent
		
		model.addAttribute("listCustomer", customersByAgent);
		return "bookings";
	}
/////////////////////////////////////////// END OF BOOKING SITE ////////////////////////////////	
	
	
	////////////////////////////////        PACKAGES        ///////////////////////////////////////////
	
	
	
////////////////////////////////////////////BEGINNING OF PACKAGE SITE///////////////////////////////	
///////////////////////////////////////////Package site/////////////////////////////////////////
@RequestMapping(value = "/package", method = RequestMethod.GET)
public String getPackage(Model model, HttpSession session)
{
	
	Agent agent = (Agent) session.getAttribute("agentlogin");
	
	if(agent == null)
	{
		//need to add attribute of new agent in the login page...
		model.addAttribute("agent", new Agent());
		return "Login"; //returns to login.jsp
	}
	
	
	model.addAttribute("packageList", this.packageService.listPackage());
	model.addAttribute("travelPackage", new Package());
	

return "packages";
}

	
//////////////////////////////////////////EDITING PACKAGES///////////////////////////////////////
/////////////////////////////////////////////Request to Delete a package from the  WebPage///////////////////////////////////////////////
@RequestMapping(value= "/removepackage/{id}")
public String removePackage(@PathVariable("id") int id, HttpSession session, Model model){
	
	Agent agent = (Agent) session.getAttribute("agentlogin");
	
	if(agent == null)
	{
		//need to add attribute of new agent in the login page...
		model.addAttribute("agent", new Agent());
		return "Login"; //returns to login.jsp
	}
	
	packageService.removePackage(id);
	
	
	return "redirect:/package";
}

///////////////////////////////////////////////////////////Request for Editing Packages /////////////////////////////////////////////////
@RequestMapping(value= "/editpackage/{id}")
public String editPackage(@PathVariable("id") int id, Model model, Locale locale, HttpSession session){
	
	Agent agent = (Agent) session.getAttribute("agentlogin");
	
	if(agent == null)
	{
		//need to add attribute of new agent in the login page...
		model.addAttribute("agent", new Agent());
		return "Login"; //returns to login.jsp
	}
	
	
	Date date = new Date();
	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	
	String formattedDate = dateFormat.format(date);
	
	model.addAttribute("serverTime", formattedDate );
	model.addAttribute("travelPackage", packageService.getPackageById(id));
	model.addAttribute("packageList",packageService.listPackage());
	return "packages";
}



///////////////////////////////////////////////////////////////////////Add or update Package///////////////////////////////////////////////////////////////////
// FOR THE WEBSITE
//For adding and updating package
@RequestMapping(value= "/addpackage", method = RequestMethod.POST)
public String addPackage(@ModelAttribute("travelPackage") @Valid Package p, BindingResult result, Model model)
{
	
	
	
//if there is any errors on this page return back to site with those errors
if(result.hasErrors())
{
	model.addAttribute("packageList", this.packageService.listPackage());
	return "packages";
}

if(p.getPackageid() == null)
{
//Add a new package
	packageService.addPackage(p);
	
	//if adding a package was a success... add it as a parameter.. not sure why its a parameter.. should just be encoded
	model.addAttribute("packageSuccess", "added!");
}
else
{
	packageService.updatePackage(p);
	
	//parameter for editing success 
	model.addAttribute("packageSuccess", "edited!");
}


	//redirect to the package page...
	return "redirect:package";
}


//////////////////////////////////////////////////////////////////////////////////////////////////////End of Packages/////////////////////////////////////////////////////




	
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
					
		
	
	///////////////////////////////////////////////////////////////////////Add of update an agent///////////////////////////////////////////////////////////////////
	// FOR THE WEBSITE
	//For adding and updating an Agent
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addAgent(@ModelAttribute("agent") @Valid Agent a, BindingResult result, Model model)
	{
		//if there is any errors on this page return back to site with those errors
		if(result.hasErrors()){
			model.addAttribute("listAgents", this.agentService.listAgents());
			return "home";
		}
		
		if(a.getAgentId() == null)
		{
			//Add a new agent
			
			//create a randomized UUID for authorization for this agent
			String uuid = UUID.randomUUID().toString();
			a.setAgentAuthorization(uuid);
			
			agentService.addAgent(a);
			model.addAttribute("agentSuccess", "added");
		}
		else
		{
			agentService.updateAgent(a);
			model.addAttribute("agentSuccess", "edited");
		}
		
		return "redirect:/";
	}
	
	////////////////////////////////////////////////////////////////////get request to add the customer//////////////////////////////////////////////////////////////
	//For adding a new Customer.. This is for the WEBSITE
	@RequestMapping(value= "/addCustomer", method = RequestMethod.POST)
	public String addAgent(@ModelAttribute("customer")  @Valid Customer c, BindingResult result, HttpSession session, Model model)
	{
	
		
		
		//form validation right here
		if(result.hasErrors())
		{
			return "customer";
		}
		
		//grab the session agent
		Agent agent = (Agent) session.getAttribute("agentlogin");
		
		//add the agentid who is logged in as the agent for the customer
		if(agent !=null)
		c.setAgentId(agent.getAgentId());
		
		//add the customer into the database
		customerService.addCustomer(c);
		
		model.addAttribute("customerSuccess","success");
		return "redirect:/customer";
	}
	
	//////////////////////////////////////////////////////////Customer WEBSITE access (need the new customer to add a customer to the form)///////////////////////////////
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String customerAdd(Locale locale, Model model, HttpSession session,  @ModelAttribute("customer") Customer c) {
		logger.info("Welcome to customer database! The client locale is {}.", locale);	

		
		Agent agent = (Agent) session.getAttribute("agentlogin");
	
	if(agent == null)
	{
		//need to add attribute of new agent in the login page...
		model.addAttribute("agent", new Agent());
		return "Login"; //returns to login.jsp
	}
		
		model.addAttribute("customer",new Customer());
		return "customer";
	}
	
	
	/////////////////////////////////////////////Request to Delete agent in the Agent WebPage///////////////////////////////////////////////
	@RequestMapping(value= "/remove/{id}")
	public String removePerson(@PathVariable("id") int id, HttpSession session, Model model){
		
		Agent agent = (Agent) session.getAttribute("agentlogin");
		
	if(agent == null)
	{
		//need to add attribute of new agent in the login page...
		model.addAttribute("agent", new Agent());
		return "Login"; //returns to login.jsp
	}
		
		
		
		agentService.removeAgent(id);
		return "redirect:/";
	}
	
	///////////////////////////////////////////////////////////Request for Editing Agents /////////////////////////////////////////////////
	@RequestMapping(value= "/edit/{id}")
	public String editAgent(@PathVariable("id") int id, Model model, Locale locale, HttpSession session){
		
		Agent agent = (Agent) session.getAttribute("agentlogin");
		
	if(agent == null)
	{
		//need to add attribute of new agent in the login page...
		model.addAttribute("agent", new Agent());
		return "Login"; //returns to login.jsp
	}
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("agent", agentService.getAgentById(id));
		model.addAttribute("listAgents", agentService.listAgents());
		return "home";
	}
	
	
	
	
}
