package com.TravelExperts.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.TravelExperts.Model.Agent;

public class AgentDaoImpl implements AgentDao {

	
	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction tx = null;
	
	@Override
	@SuppressWarnings({ "unchecked" })
	public List<Agent> getEntityList() throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List agentList = session.createCriteria(Agent.class).list();
		//List agentList = session.createCriteria(Agent.class).list();
		tx.commit();
		session.close();
		return agentList;
	}

}
