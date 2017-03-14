package com.TravelExperts.DAO;
import java.util.List;

import com.TravelExperts.Model.Agent;

public interface AgentDAO {

	
	public List<Agent> listAgents();
	public void addAgent(Agent a);
	public void updateAgent(Agent a);
	public Agent getAgentById(int id);
	public void removeAgent(int id);
}
