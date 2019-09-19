package dev.glinzac.learnapp.microservices.user;

import java.util.Optional;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dev.glinzac.learnapp.entities.CardDetails;

public interface CardDetailsRepository extends CrudRepository<CardDetails, Integer> {
	
	@Query(value="select * from card_details where user_name='glinzac@gmail.com' ",nativeQuery = true)
	Optional<CardDetails> findCourseByUsername(String username); 
}
