package com.TravelExperts.Service;

import java.util.List;

import com.TravelExperts.Model.Booking;

public interface BookingService {

	public List<Booking> getAllBookings();
	public List<Booking> getBookingsByCustomerId(int id);
	public void addBooking(Booking b);
	public void updateBooking(Booking b);
	public void removeBooking(int id);
	
}
