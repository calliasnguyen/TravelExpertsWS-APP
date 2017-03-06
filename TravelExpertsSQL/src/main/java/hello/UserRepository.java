package hello;

import org.springframework.data.repository.CrudRepository;

import hello.Agents;

public interface UserRepository extends CrudRepository<Agents, Long> {

}
