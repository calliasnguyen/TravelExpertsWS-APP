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
	public void removePerson(int id) {
		this.agentDAO.removeAgent(id);
		
	}

}
