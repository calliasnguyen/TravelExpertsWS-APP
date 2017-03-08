package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/booking")
public class BookingController {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private PackageRepository packageRepository;
	
	//GET METHOD to grab all bookings (inner join packages)
			@GetMapping(path ="/all")
			public @ResponseBody Iterable<Booking> getAllBookings()
			{
				Iterable<Booking> bookings = bookingRepository.findAll();
				
				for(Booking booking : bookings)
				{
					Integer packageID = booking.getPackageId();
					Package p = packageRepository.GrabPackage(packageID);
					booking.setPackage(p);
				}
				return bookings;
			}

	//GET METHOD to grab a booking for a specific Customerid
			@GetMapping(path = "/{customerid}")
			public @ResponseBody Iterable<Booking> getBookingByCustomerId(@PathVariable("customerid") Integer customerid)
			{
				Iterable<Booking> bookings = bookingRepository.getBookingByCustomerId(customerid);
				for(Booking booking : bookings)
				{
					Integer packageID = booking.getPackageId();
					Package p = packageRepository.GrabPackage(packageID);
					booking.setPackage(p);
				}
				return bookings;
				
			}
			
}
