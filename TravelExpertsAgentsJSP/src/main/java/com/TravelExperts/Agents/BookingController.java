package com.TravelExperts.Agents;

import java.util.ArrayList;
import java.util.List;

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

import com.TravelExperts.Model.Booking;
import com.TravelExperts.Service.BookingService;
import com.TravelExperts.Service.PackageService;

@RequestMapping(value = "/Booking")
@Controller
@Scope("session") // to control sessions
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@Autowired
	PackageService packageService;
	
	//Get all Bookings
		@RequestMapping(value = "/", method=RequestMethod.GET)
		public @ResponseBody List<Booking> getBookings()
		{
			List<Booking> bookings = null;
			try{
				bookings = bookingService.getAllBookings();
				for(Booking booking: bookings)
				{
					Integer packageID = booking.getPackageId();
					System.out.println(packageID);
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
	
	//Get Bookings By CustomerID
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
		
		
		
		/////////////////////////////Update a Booking Post request///////////////////////////////////////////////
		@RequestMapping(value="/update", method=RequestMethod.POST)
		public ResponseEntity<Booking> updateBooking(@RequestBody Booking b)
		{
			
			bookingService.updateBooking(b);
			
			return new ResponseEntity<Booking>(b, HttpStatus.ACCEPTED);
			
		}
		
	
}
