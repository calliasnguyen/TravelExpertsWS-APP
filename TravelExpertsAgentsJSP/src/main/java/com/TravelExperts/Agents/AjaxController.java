package com.TravelExperts.Agents;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/ajax")
public class AjaxController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String ajaxHome()
	{
		return "ajax";
	}
	
	//NOTE locale might screw this up

	@RequestMapping(value="/ajaxtest", method = RequestMethod.POST)
	public  @ResponseBody String  getDate(Locale locale) 
	{
		//look into ajax here
		
		System.out.println("Testing if this connects to Ajax calls");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale );
		
		//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		
		String formattedDate = dateFormat.format(date);
		
		System.out.println("Reaching the Controller AJAX. Success!");
		
		return formattedDate;
	}
	
	
	

}
