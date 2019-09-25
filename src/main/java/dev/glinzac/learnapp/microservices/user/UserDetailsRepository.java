package dev.glinzac.learnapp.microservices.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dev.glinzac.learnapp.entities.UserDetails;

public interface UserDetailsRepository extends CrudRepository<UserDetails, String> {
	
	@Query(value = "select * from user_details")
	List<UserDetails> getUsers();
}
