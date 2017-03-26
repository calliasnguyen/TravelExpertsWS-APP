package com.TravelExperts.Service;

import java.util.List;

import javax.transaction.Transactional;

import com.TravelExperts.DAO.CustomerDAO;
import com.TravelExperts.Model.Customer;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDao;
	
	public void setCustomerDao(CustomerDAO cd)
	{
		this.customerDao = cd;
	}
	
	@Transactional
	@Override
	public List<Customer> listCustomer() {
		return this.customerDao.listCustomers();
	}

	@Transactional
	@Override
	public void addCustomer(Customer c) {
		this.customerDao.addCustomer(c);
	}

	
	@Transactional
	@Override
	public void updateCustomer(Customer c) {
		this.customerDao.updateCustomer(c);
		
	}

	@Transactional
	@Override
	public Customer getCustomerById(int id) {
		return this.customerDao.getCustomerById(id);
	}

	@Transactional
	@Override
	public void removeCustomer(int id) {
		this.customerDao.removeCustomer(id);
	}

	@Transactional
	@Override
	public List<Customer> getCustomerByAgentId(int agentID) {
			// TODO Auto-generated method stub
		return this.customerDao.getCustomerByAgentId(agentID);
	}

	@Override
	@Transactional
	public Customer customerLogin(String email, String lastname) {
		
		return this.customerDao.customerLogin(email, lastname);
	}
	
	

}
