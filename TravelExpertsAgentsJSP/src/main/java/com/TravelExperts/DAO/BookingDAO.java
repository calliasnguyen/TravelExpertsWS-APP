package com.TravelExperts.DAO;

import java.util.List;

import com.TravelExperts.Model.Booking;

public interface BookingDAO {
	
	public List<Booking> getAllBookings();
	public List<Booking> getBookingsByCustomerId(int id);
	

}
