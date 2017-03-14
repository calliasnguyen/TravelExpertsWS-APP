package com.TravelExperts.Agents;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TravelExperts.Model.Agent;
import com.TravelExperts.Service.AgentService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	private AgentService agentService;
//	
//	@Autowired(required=true)
//	@Qualifier(value="agentService")
//	public void setAgentService(AgentService as)
//	{
//		this.agentService = as;
//	}
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("agent", new Agent());
		model.addAttribute("listAgents", this.agentService.listAgents());
		
		return "home";
	}
	
	@Autowired
	AgentService agentService;
	
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
	
	
}
