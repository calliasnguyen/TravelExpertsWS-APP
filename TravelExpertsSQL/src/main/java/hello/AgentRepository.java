package hello;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import hello.Agents;

public interface AgentRepository extends CrudRepository<Agents, Long> {

	@Modifying 
	@Transactional
	@Query("delete from Agents a where a.agentid = ?1")
	void deleteUsersbyagentid(Integer agentid);
	
	
}
