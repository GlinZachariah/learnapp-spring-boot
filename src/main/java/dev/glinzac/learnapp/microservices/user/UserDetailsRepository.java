package dev.glinzac.learnapp.microservices.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dev.glinzac.learnapp.entities.UserDetails;

public interface UserDetailsRepository extends CrudRepository<UserDetails, String> {
	
	@Query(value = "select * from user_details",nativeQuery = true)
	List<UserDetails> getUsers();
	
	@Query(value = "select * from user_details where user_name = :username",nativeQuery = true)
	Optional<UserDetails> getUserRole(@Param(value="username") String username);
}
