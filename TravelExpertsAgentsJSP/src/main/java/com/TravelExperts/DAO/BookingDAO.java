package com.TravelExperts.DAO;

import java.util.List;

import com.TravelExperts.Model.Booking;

public interface BookingDAO {
	
	public List<Booking> getAllBookings();
	public List<Booking> getBookingsByCustomerId(int id);
	public void addBooking(Booking b);
	public void updateBooking(Booking b);
	public void removeBooking(int id);
	

}
