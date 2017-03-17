package com.TravelExperts.Service;

import java.util.List;

import javax.transaction.Transactional;

import com.TravelExperts.DAO.BookingDAO;
import com.TravelExperts.Model.Booking;

public class BookingServiceImpl implements BookingService {

	private BookingDAO bookingDAO;
	
	public void setBookingDAO(BookingDAO bd)
	{
		this.bookingDAO = bd;
	}
	
	@Transactional
	@Override
	public List<Booking> getAllBookings() {
		
		return bookingDAO.getAllBookings();
	}

	@Transactional
	@Override
	public List<Booking> getBookingsByCustomerId(int id) {
		return bookingDAO.getBookingsByCustomerId(id);
	}

	
	
	
	
}
