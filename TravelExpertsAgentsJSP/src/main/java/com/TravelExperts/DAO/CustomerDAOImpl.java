package com.TravelExperts.DAO;

import java.util.List;

import org.hibernate.Query;
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

	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomerByAgentId(int agentID) {
		Session session = this.sessionFactory.getCurrentSession();
		String selectByAgentId = "Select c from Customer c where c.agentId = :agentid";
		Query query = session.createQuery(selectByAgentId);
		query.setInteger("agentid", new Integer(agentID));
		
		//initialize as null first
		List<Customer> agentsCustomers = null;
		
		try
		{
	
			agentsCustomers = (List<Customer>) query.list();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return agentsCustomers;
	}

}
