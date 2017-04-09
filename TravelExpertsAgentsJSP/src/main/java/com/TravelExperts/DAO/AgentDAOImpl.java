package com.TravelExperts.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;


import com.TravelExperts.Model.Agent;



public class AgentDAOImpl implements AgentDAO {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AgentDAOImpl.class);

	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Agent> listAgents() {
		Session session = this.sessionFactory.getCurrentSession();
		//the query needs to match the class... Agent
		List<Agent> agentList = session.createQuery("from Agent").list();
		for (Agent agent : agentList){
			logger.info("Agent List:: " + agent);
		}
		return agentList;
	}

	@Override
	public void addAgent(Agent a) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(a);
		logger.info("Agent saved successfully, Agent Details="+a );
		
	}

	@Override
	public void updateAgent(Agent a) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(a);
		logger.info("Agent has been successfully Updated, Agent Details="+a);
	}

	@Override
	public Agent getAgentById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Agent a = (Agent) session.load(Agent.class, new Integer(id));
		logger.info("Agent has been loaded successfully, Agent Details="+a);
		return a;
	}

	@Override
	public void removeAgent(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Agent a = (Agent) session.load(Agent.class, new Integer(id));
		if(null != a){
			session.delete(a);
		}
		logger.info("Agent has been deleted succesfully, Agent Details="+a);
		
		
	}

	@Override
	public boolean isValidAgentAuthorization(String agtAuthorization) {
		try
		{
		Session session = this.sessionFactory.getCurrentSession();
		String agentAuthorizationStatement = "Select a from Agent a where a.agtAuthorization = :authorization";
		Query query = session.createQuery(agentAuthorizationStatement);
		query.setString("authorization",agtAuthorization);
		
		//if an agent matches the authorization key supplied, then query.list.size will come back larger than 0
		//if no agent matches that authorization then kick the user out
		Integer agtAuthorizationConfirmation = query.list().size();
		
		//if the agent matches return true, otherwise return false
		if(agtAuthorizationConfirmation > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;
}	
	
	
	@Override
	public boolean isValidAgent(String agtFirstName, String agtLastName) {
		
		try{
		Session session = this.sessionFactory.getCurrentSession();
		String loginValidationStatement = "Select a from Agent a where a.agtFirstName = :firstname and a.agtLastName = :lastname ";
		Query query = session.createQuery(loginValidationStatement);
		query.setString("firstname", agtFirstName);
		query.setString("lastname", agtLastName);
		
		//if the query returns a match, the list size will be greater than 0
		Integer loginConfirmation = query.list().size();
		
		System.out.println(loginConfirmation);
		
		//Test to see if this will return anything
		if(loginConfirmation>0)
		{
			return true;
		}
		else
			return false;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public Agent returnAgentbyName(String firstName, String lastName) {
		
		Agent agent = new Agent();
		try{
			Session session = this.sessionFactory.getCurrentSession();
			String loginValidationStatement = "Select a from Agent a where a.agtFirstName = :firstname and a.agtLastName = :lastname ";
			Query query = session.createQuery(loginValidationStatement);
			query.setString("firstname", firstName);
			query.setString("lastname",  lastName);
			
			
			//This will return us one agent in a list
			//should probably find agent using custom session.createCriteria
			List<Agent> agentList = query.list();
			System.out.println(agentList);
			
			//Extract the agent out of the list
			agent = (Agent) query.list().get(0);
			
			return agent;
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			return agent;
	}

	@Override
	public Agent loginAgentByEmail(String agentEmail, String agentLastName) {
		
		//Set agent as null
		Agent agent = null;
		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			String emailValidationStatement = "Select a from Agent a where a.agtEmail = :agtEmail AND a.agtLastName = :agtLastName";
			Query query = session.createQuery(emailValidationStatement);
			query.setString("agtEmail", agentEmail);
			query.setString("agtLastName", agentLastName);
			
			
			//grabbing if the agent exists
			Integer agtAuthorizationConfirmation = query.list().size();
			
			if(agtAuthorizationConfirmation > 0)
			{
			//Extract the agent out of the list
			agent = (Agent) query.list().get(0);
			}
			
			return agent;
		}catch(Exception e)
		{	//writing the error if there is an sql error, or if the agent does not exist
			System.out.println(e.getMessage() + e.getCause());
		}
		return agent;
		
		
		
	}

	


}
