package com.TravelExperts.Service;

import java.util.List;

import com.TravelExperts.DAO.AgentDAO;
import com.TravelExperts.Model.Agent;
import org.springframework.transaction.annotation.Transactional;

public class AgentServiceImpl implements AgentService {

	private AgentDAO agentDAO;
	
	public void setAgentDAO(AgentDAO agentDAO)
	{
		this.agentDAO = agentDAO;
	}
	
	
	@Override
	@Transactional
	public List<Agent> listAgents() {
		return this.agentDAO.listAgents();
	}


	@Override
	@Transactional
	public void addAgent(Agent a) {
		this.agentDAO.addAgent(a);
		
	}

	@Transactional
	@Override
	public void updateAgent(Agent a) {
		this.agentDAO.updateAgent(a);
		
	}

	
	@Override
	@Transactional
	public Agent getAgentById(int id) {
		return this.agentDAO.getAgentById(id);
		
	}


	@Override
	@Transactional
	public void removeAgent(int id) {
		this.agentDAO.removeAgent(id);
		
	}


	@Override
	@Transactional
	public boolean isValidAgent(String agtFirstName, String agtLastName) {
		
		return this.agentDAO.isValidAgent(agtFirstName, agtLastName);
	}


	@Override
	@Transactional
	public Agent returnAgentbyName(String firstName, String lastName) {
	
		return this.agentDAO.returnAgentbyName(firstName, lastName);
	}


	@Override
	@Transactional
	public boolean isValidAgentAuthorization(String agtAuthorization) {
	
		return this.agentDAO.isValidAgentAuthorization(agtAuthorization);
	}


	@Override
	@Transactional
	public Agent loginAgentByEmail(String agentEmail, String agentLastName) {
		
		return this.agentDAO.loginAgentByEmail(agentEmail, agentLastName);
	}

}
