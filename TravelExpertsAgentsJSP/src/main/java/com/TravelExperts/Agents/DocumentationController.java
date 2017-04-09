package com.TravelExperts.Agents;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/documentation")
public class DocumentationController {

	
	///////////////////////////////////////////////Documentation Overview Page/////////////////////////////////////
@RequestMapping(value = "/", method = RequestMethod.GET)
public String getDocumentation()
{
	
	return "documentation";
}


///////////////////////////////////////////////Customer Documentation Page/////////////////////////////////////
@RequestMapping(value = "/customer", method = RequestMethod.GET)
public String getDocumentationForCustomer()
{

return "documentationCustomer";
}


////////////////////////////////////////////////AGENT DOCUMENTATION PAGE///////////////////////////////////////
@RequestMapping(value = "/agent", method = RequestMethod.GET)
public String getDocumentationForAgent()
{

return "documentationAgent";
}

////////////////////////////////////////////////Package DOCUMENTATION PAGE///////////////////////////////////////
@RequestMapping(value = "/package", method = RequestMethod.GET)
public String getDocumentationForPackage()
{

return "documentationPackage";
}


////////////////////////////////////////////////Booking DOCUMENTATION PAGE///////////////////////////////////////
@RequestMapping(value = "/booking", method = RequestMethod.GET)
public String getDocumentationForBooking()
{

return "documentationBooking";
}


}
