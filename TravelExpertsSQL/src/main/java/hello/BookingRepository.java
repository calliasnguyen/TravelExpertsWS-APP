package hello;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Long> {

	@Transactional
	@Query("select b from Booking b where b.customerid = ?1")
	Iterable<Booking> getBookingByCustomerId(Integer customerid);
	
	
}
