package com.TravelExperts.Service;
import java.util.List;

import com.TravelExperts.Model.Customer;

public interface CustomerService {

	public List<Customer> listCustomer();
	public void addCustomer (Customer c);
	public void updateCustomer(Customer c);
	public Customer getCustomerById(int id);
	public void removeCustomer(int id);
}
