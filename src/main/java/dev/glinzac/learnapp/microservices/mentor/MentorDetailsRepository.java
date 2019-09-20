package dev.glinzac.learnapp.microservices.mentor;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.glinzac.learnapp.entities.MentorDetails;

@Repository
public interface MentorDetailsRepository extends CrudRepository<MentorDetails, Integer> {
	
	@Query(value="select mentor_id from mentor_details where user_name = :username",nativeQuery = true)
	Optional<Integer> findMentorId(@Param(value="username") String username);
}
