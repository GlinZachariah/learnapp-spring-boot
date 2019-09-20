package dev.glinzac.learnapp.microservices.mentor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.glinzac.learnapp.entities.MentorDetails;

@Repository
public interface MentorDetailsRepository extends CrudRepository<MentorDetails, Integer> {
	
}
