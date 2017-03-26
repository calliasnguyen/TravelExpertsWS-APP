package com.TravelExperts.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TravelExperts.Model.Booking;

public class BookingDAOImpl implements BookingDAO {

	private static final Logger logger = LoggerFactory.getLogger(BookingDAOImpl.class);
	
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory = sf;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Booking> getAllBookings() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Booking> bookingList = session.createQuery("FROM Booking").list();
		for(Booking b:bookingList)
		{
			logger.info("Booking List::" + b);
		}
		return bookingList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Booking> getBookingsByCustomerId(int id) {
		String selectByCustomerId = "Select b from Booking b where b.bookingCustomerId= ?";
		Session session = this.sessionFactory.getCurrentSession();	
		Query query = session.createQuery(selectByCustomerId);
		query.setParameter(0, new Integer(id));
		List<Booking> bookingByCustomer = query.list();
		
		logger.info("Booking by customer has been loaded!");
		return bookingByCustomer;
	}

	@Override
	public void addBooking(Booking b) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(b);
		logger.info("Booking has been saved succesfully in the database, Booking Details= " + b);
		
	}

	@Override
	public void updateBooking(Booking b) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(b);
		logger.info("Booking has been sucessfully updated in the database, Booking Details= " + b);
		
	}

	@Override
	public void removeBooking(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Booking b = (Booking) session.load(Booking.class, new Integer(id));
		if(null != b){
			session.delete(b);	
		}
		logger.info("Booking has been deleted succesfully in the database, Booking Details=" + b);
		
	}

	
	
}
