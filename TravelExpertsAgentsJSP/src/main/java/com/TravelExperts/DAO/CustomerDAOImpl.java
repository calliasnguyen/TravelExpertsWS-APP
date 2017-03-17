package com.TravelExperts.DAO;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;

import com.TravelExperts.Model.Customer;

public class CustomerDAOImpl implements CustomerDAO{

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AgentDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory = sf;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> listCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customerList = session.createQuery("from Customer").list();
		for(Customer c: customerList){
			logger.info("Customer list::" + c);
		}
		return customerList;
	}

	
	@Override
	public void addCustomer(Customer c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Customer saved successfully, Customer Details: " + c);
	
	}
	

	@Override
	public void updateCustomer(Customer c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		logger.info("Customer has been updated successfully, Customer Details: " + c);
		
	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.load(Customer.class, new Integer(id));
		logger.info("Customer has been loaded successfully");
		return customer;
	}

	@Override
	public void removeCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.load(Customer.class, new Integer(id));
		if(null != customer)
		{
			session.delete(customer);
		}
		logger.info("Customer has been deleted from the database, Customer Details: "+ customer);
	}

}
