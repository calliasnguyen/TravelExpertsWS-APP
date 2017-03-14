package com.TravelExperts.Service;
import java.util.List;

import com.TravelExperts.Model.Agent;


public interface AgentService {
	
	public List<Agent> listAgents();
	public void addAgent(Agent a);
	public void updateAgent(Agent a);
	public Agent getAgentById(int id);
	public void removePerson(int id);

}
