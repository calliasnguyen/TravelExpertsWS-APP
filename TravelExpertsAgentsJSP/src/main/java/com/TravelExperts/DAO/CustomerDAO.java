package com.TravelExperts.DAO;
import java.util.List;

import com.TravelExperts.Model.Customer;

public interface CustomerDAO {

	public List<Customer> listCustomers();
	public void addCustomer(Customer c);
	public void updateCustomer(Customer c);
	public Customer getCustomerById(int id);
	public void removeCustomer(int id);
	
}
