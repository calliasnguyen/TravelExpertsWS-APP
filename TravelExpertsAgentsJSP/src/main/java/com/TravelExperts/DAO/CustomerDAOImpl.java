package com.TravelExperts.DAO;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;

import com.TravelExperts.Model.Agent;
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

	@Override
	public Customer customerLogin(String email, String lastname) {
		
		Customer customer = null;
		
		try
		{
			Session session = this.sessionFactory.getCurrentSession();
			String customerLoginValidation = "Select c from Customer c where c.customerEmail = :customerEmail AND c.customerLastName = :customerLastName";
			Query query = session.createQuery(customerLoginValidation);
			query.setString("customerEmail", email);
			query.setString("customerLastName", lastname);
			
			//confirm that customer size > 0
			Integer loginConfirmation = query.list().size();
			
			if(loginConfirmation > 0)
			{
			
			//will return one list of agent.. so we will grab the 0th value
			customer = (Customer) query.list().get(0);
			
			//grab agent for specific customer by the id
			Integer agentID = customer.getAgentId();
			System.out.println(agentID);
			//grabbing the agent object by ID if the customer has an assigned agent
				if(agentID != null)
				{
					Agent customerAgent = (Agent) session.load(Agent.class, agentID);
					Hibernate.initialize(customerAgent);
					
					//setting the customer's agent
					customer.setAgent(customerAgent);
					
				}
			
			
			}
			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		
		return customer;
	}

}
