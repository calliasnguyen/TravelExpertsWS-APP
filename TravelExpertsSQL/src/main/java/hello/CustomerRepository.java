package hello;



import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

//	@Modifying
//	@Transactional
//	@Query("Select c from Customer c where c.custfirstname = ?1 AND c.custlastname = ?2")
//	Iterable<Customer> selectByCustomerName(String firstname, String lastname);
//	
	
	//NOTE: Customer and customerFirstName must follow the Entity Class spelling
	@Transactional
	@Query("select c from Customer c where c.customerFirstName = ?1")
	Customer findbyFirstName(String fname);
	
	
	
	  @Query("select c from Customer c where c.customerFirstName = :firstname or c.customerLastName = :lastname")
	  Customer findByLastnameAndFirstname(@Param("lastname") String lastname,
	                                 @Param("firstname") String firstname);
	
	
	
}
