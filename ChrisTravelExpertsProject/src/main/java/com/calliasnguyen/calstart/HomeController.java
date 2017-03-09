package com.calliasnguyen.calstart;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	
//	@Autowired
//	AgentRepository agentRepository;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("firstName", "Chris Billington");
		return "home";
	}
	
	@RequestMapping(value ="/hello", method = RequestMethod.GET)
	public @ResponseBody String getHello()
	{
		String hi= "hello World";
		return hi;
	}
//	
//	@RequestMapping(value ="all", method = RequestMethod.GET)
//	public @ResponseBody Iterable<Agent> getAllAgents()
//	{
//		return agentRepository.findAll();
//	}
}
