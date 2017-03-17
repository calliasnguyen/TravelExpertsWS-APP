package com.TravelExperts.Service;

import java.util.List;

import com.TravelExperts.Model.Booking;

public interface BookingService {

	public List<Booking> getAllBookings();
	public List<Booking> getBookingsByCustomerId(int id);
	
	
}
