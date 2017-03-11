package com.TravelExperts.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.TravelExperts.Dao.AgentDao;
import com.TravelExperts.Model.Agent;

public class AgentServicesImpl implements AgentServices {

	@Autowired
	AgentDao agentDao;
	
	@Override
	public List<Agent> getAgentList() throws Exception {
		
		return agentDao.getEntityList();
	}

}
