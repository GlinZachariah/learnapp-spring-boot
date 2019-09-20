package dev.glinzac.learnapp.microservices.user;

import java.util.Optional;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.glinzac.learnapp.entities.CardDetails;

@Repository
public interface CardDetailsRepository extends CrudRepository<CardDetails, Integer> {
	
	@Query(value="select count(*) from card_details c where c.user_name= :username",nativeQuery = true)
	int checkCardDetails(@Param(value="username") String username);
		
	@Query(value="select user_id from card_details where user_name = :username",nativeQuery = true)
	int findCardId(@Param(value="username") String username);
}
