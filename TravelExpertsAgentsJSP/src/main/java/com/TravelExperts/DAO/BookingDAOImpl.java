package com.TravelExperts.DAO;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TravelExperts.Model.Booking;
import com.TravelExperts.Model.BookingDetail;

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
		
		try
		{
			//grab the booking detail by bookingID
			for(Booking booking: bookingByCustomer)
			{	//grab the bookingId to grab the bookingDetails
				Integer bookingId  = booking.getBookingId();
				
				
					
				//grabbing the bookingDetail from the bookingID	
				String selectBookingDetail = "Select bd from BookingDetail bd where bd.bookingId = :bookingDetailId";
				Query queryBookingDetail = session.createQuery(selectBookingDetail);
				queryBookingDetail.setInteger("bookingDetailId", bookingId);
				
				//if there is a bookingdetail by booking id... then
				if(queryBookingDetail.list().size() > 0)
				{
				//grab the bookingDetail from the query
				List<BookingDetail> bookingDetail = (List<BookingDetail>) queryBookingDetail.list();
					
			
				Hibernate.initialize(bookingDetail);
				booking.setBookingDetail(bookingDetail);
				}	
			
			 }
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
				
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

	@Override
	public Booking getBookingById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Booking booking = null;
		
		try
		{
		 booking = (Booking) session.load(Booking.class, new Integer(id));
		 logger.info("Booking has been grabbed by the database, Booking=" + booking);
		}catch(Exception e)
		{
			System.out.println("Client is asking for a booking that does not exist " + e.getMessage());
		}
		
		
		return booking;
	}

	
	
}
