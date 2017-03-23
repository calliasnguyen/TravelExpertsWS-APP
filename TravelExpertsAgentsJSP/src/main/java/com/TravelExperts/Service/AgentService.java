package com.TravelExperts.Service;
import java.util.List;

import com.TravelExperts.Model.Agent;


public interface AgentService {
	
	public List<Agent> listAgents();
	public void addAgent(Agent a);
	public void updateAgent(Agent a);
	public Agent getAgentById(int id);
	public void removeAgent(int id);
	public boolean isValidAgent(String agtFirstName, String agtLastName);
	public Agent returnAgentbyName(String firstName, String lastName);
	public boolean isValidAgentAuthorization(String agtAuthorization);

}
