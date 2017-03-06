package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.Agents;
import hello.UserRepository;


@Controller
@RequestMapping(path = "/demo")
public class MainController {
	@Autowired

	private UserRepository userRepository;

	
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
	
		userRepository.save(n);
		return "Saved";
	}

	
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Agents> getAllUsers() {
		
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}
