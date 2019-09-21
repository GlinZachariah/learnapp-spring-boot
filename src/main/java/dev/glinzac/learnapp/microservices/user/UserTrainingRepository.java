package dev.glinzac.learnapp.microservices.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dev.glinzac.learnapp.entities.UserDetails;
import dev.glinzac.learnapp.entities.UserProgress;

public interface UserTrainingRepository extends CrudRepository<UserProgress, Integer> {
	
	@Query(value="select d from user_progress d where d.user_name = :username",nativeQuery = true)
	List<UserProgress> findTrainingInProgress(@Param(value="username") String username);
}
