package com.TravelExperts.Agents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

import com.TravelExperts.Model.Agent;
import com.TravelExperts.Model.Booking;
import com.TravelExperts.Model.Customer;
import com.TravelExperts.Service.AgentService;
import com.TravelExperts.Service.BookingService;
import com.TravelExperts.Service.CustomerService;
import com.TravelExperts.Service.PackageService;



@RequestMapping(value = "/Booking")
@Controller
@Scope("session") // to control sessions
public class BookingController<T> {

	@Autowired
	BookingService bookingService;
	
	@Autowired
	PackageService packageService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	AgentService agentService;
	
	/////////////////////////////////Get All Bookings///////////////////////////////////////////////////////
		@RequestMapping(value = "/", method=RequestMethod.GET)
		public @ResponseBody List<Booking> getBookings()
		{
			List<Booking> bookings = null;
			try{
				bookings = bookingService.getAllBookings();
				for(Booking booking: bookings)
				{
					Integer packageID = booking.getPackageId();
					
					if(packageID != null)
					{
						com.TravelExperts.Model.Package p = packageService.getPackageById(packageID);
						Hibernate.initialize(p);
						booking.setPackage(p);
						
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return bookings;
		}
	
	////////////////////////////////////////Get Bookings By CustomerID////////////////////////////////////////////
		@RequestMapping(value = "/{customerid}", method=RequestMethod.GET)
		public @ResponseBody List<Booking> getBookingsByCustomerId(@PathVariable("customerid") Integer customerid)
		{
			List<Booking> bookingsByCustomer = null;
			try{
				bookingsByCustomer = bookingService.getBookingsByCustomerId(customerid);
				for(Booking booking: bookingsByCustomer)
				{
					Integer packageID = booking.getPackageId();
					if (packageID != null)
					{
						com.TravelExperts.Model.Package p = packageService.getPackageById(packageID);
						booking.setPackage(p);
					}
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return bookingsByCustomer;
		}
		
		
		/////////////////////////////////////////Grab a single Booking by its ID/////////////////////////////
		@RequestMapping(value = "/id/{bookingid}", method = RequestMethod.GET)
		public ResponseEntity<Booking> getBookingbyId(@PathVariable("bookingid") Integer bookingid)
		{
			Booking booking = null;
			
			booking = bookingService.getBookingById(bookingid);
			if(booking != null)
			{
				return new ResponseEntity<Booking>(booking, HttpStatus.OK);
			}
			
				return new ResponseEntity<Booking>(booking, HttpStatus.BAD_REQUEST);
		}
		
		
		
		/////////////////////////////Update a Booking Post request///////////////////////////////////////////////
		@RequestMapping(value="/update", method=RequestMethod.PUT)
		public ResponseEntity<Booking> updateBooking(@RequestBody Booking b)
		{
			
			bookingService.updateBooking(b);
			
			return new ResponseEntity<Booking>(b, HttpStatus.ACCEPTED);
			
		}
		
		/////////////////////////////////Add a new Booking Post request///////////////////////////////////////////
		@RequestMapping(value="/add", method=RequestMethod.POST)
		public ResponseEntity<?> addBooking(@RequestBody Booking b) //throws Exception?
		{
		
			
			//adding a new booking	FIRST....
			System.out.println(b);
			try
			{
			//adding a new booking right away
			bookingService.addBooking(b);
			
			
			//Using tropo after the booking has been added
			//grabbing customerid and packageid
			
			//grab the customerid for the booking
			Integer customerId = b.getCustomerid();
		
		
			
			//if the customerId is not null, which it shouldn't be
			if(customerId !=null)
			{
				//grab the customer from the customer id 
				Customer customer = customerService.getCustomerById(customerId);
				
				//grab an agent from the customer id
				Integer agentId = customer.getAgentId();
				
				//if the customer has an agent,
				if(agentId !=null)
				{
					Agent agent = agentService.getAgentById(agentId);
				
					
					//String phoneNumber = "+17782418749";
					String agentPhoneNumber ="+1" + agent.getAgtBusPhone();
					
					String agentMsg = "You+have+a+new+booking+from+" + customer.getCustomerFirstName()+"+"+customer.getCustomerLastName();
					System.out.println(agentPhoneNumber);
					
					//Tropo sending text message TO THE AGENT
					//textAgentTropo(agentMsg, agentPhoneNumber);
							
					//Tropo sending text message to CUSTOMER
					String customerPhoneNumber = "+1" + customer.getCustomerBusPhone();
					
					//URL Parameters
				
					
					
					String recieptURL = "http://35.161.216.198:8080/TravelExpertsAgentsJSP/Customer/booking?bookingId="+ b.getBookingId().toString();
					String customerMsg = "Thank+you+for+purchasing+this+package+" + customer.getCustomerFirstName()+"!+Here+is+a+link+to+your+receipt+"+ recieptURL; 
					System.out.println(customerMsg);
					System.out.println(recieptURL);
					
					
					
					//Tropo sending text message to Customer here
					textAgentTropo(customerMsg, customerPhoneNumber);
				}//if agentid is null
				
				
				
			}//customerId !=null
			
			//return a response code at the end 
			return new ResponseEntity<Booking>(b, HttpStatus.ACCEPTED);
			
			}//end of try
			catch(Exception e)
			{
				String exceptionError = e.getMessage() + e.getCause();
				System.out.println(e.getMessage() + e.getCause());
				return new ResponseEntity<String>(exceptionError, HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
			
			
		
		
			
			
		}//// END OF THE REQUEST
		
		
		//Method to sent a text in tropo...
		public void textAgentTropo(String msg, String phoneNumber) throws Exception
		{
			String token = "6d6d6f4a755472624e6964466f4872497246555a6850437369716f41666e4d537741777a734a765971526743";
			String networkToUse = "SMS";
			String callerNumber = "17782418749";
			
			
			String urlParameters = "https://api.tropo.com/1.0/sessions?number=" + phoneNumber +"&token=" + token +"&msg="+msg+"&networkToUse="+ networkToUse +"&callerNumber=" + callerNumber;
			
					
			URL obj = new URL(urlParameters);
			HttpsURLConnection connection =(HttpsURLConnection) obj.openConnection();
			
			//optional default is GET
			connection.setRequestMethod("GET");
			
			int responseCode = connection.getResponseCode();
			System.out.println("\n Sending 'GET' Request to URL: " + urlParameters);
			System.out.println("Response Code: " + responseCode);
			
			//Buffer reader that reads the code of the response code.....
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result response in a string out in the system
			System.out.println(response.toString());
			
		}
		
		
	
}
