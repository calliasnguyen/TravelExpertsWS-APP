package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.Agents;
import hello.AgentRepository;


@Controller
@RequestMapping(path = "/agent")
public class AgentController {
	@Autowired
	private AgentRepository agentRepository;

	//GET REQUEST FOR ADDING AGENTS
		@GetMapping(path="/add") // Map ONLY GET Requests
		public @ResponseBody String addNewUser (@RequestParam String fname
				, @RequestParam String email, @RequestParam String lname, @RequestParam String position) {
			// @ResponseBody means the returned String is the response, not a view name
			// @RequestParam means it is a parameter from the GET or POST request
	
			Agents n = new Agents();
			n.setAgencyid(2);
			n.setAgtbusphone("403-213-3321");
			n.setAgtlastname(lname);
			n.setAgtmiddleinitial("");
			n.setAgtposition(position);
			n.setAgtfirstname(fname);
			n.setAgtemail(email);
			agentRepository.save(n);
			return "Saved";	
		}
		
	
	//POST METHOD FOR DELETING AN AGENT BY ID
		@RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
		public @ResponseBody String deleteUser (@PathVariable("id") Integer agentid) 
		{
	
			agentRepository.deleteUsersbyagentid(agentid);
			return "Success";
		}
	

	
	//Post Method for updating an Agent
		@RequestMapping(path = "/update", method = RequestMethod.POST)
		public @ResponseBody String updateUser(@RequestParam Integer agentid, @RequestParam String agtfirstname, @RequestParam String agtlastname, @RequestParam String agtbusphone,
				@RequestParam String agtposition, @RequestParam String agtemail, @RequestParam String agtmiddleinitial, @RequestParam Integer agencyid)
		
		{
			Agents n = new Agents();
			n.setAgentid(agentid);
			n.setAgencyid(agencyid);
			n.setAgtbusphone(agtbusphone);
			n.setAgtemail(agtemail);
			n.setAgtfirstname(agtfirstname);
			n.setAgtlastname(agtlastname);
			n.setAgtmiddleinitial(agtmiddleinitial);
			n.setAgtposition(agtposition);
			
			
			agentRepository.save(n);
			
			return "Updated";
		}
	
	

	//Get Method for grabbing all agents
		@GetMapping(path = "/all")
		public @ResponseBody Iterable<Agents> getAllUsers() {
			
			// This returns a JSON or XML with the users
			return agentRepository.findAll();
		}
}
