package dev.glinzac.learnapp.microservices.mentor;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.glinzac.learnapp.entities.MentorDetails;
import dev.glinzac.learnapp.entities.Technology;

@Repository
public interface MentorDetailsRepository extends CrudRepository<MentorDetails, Integer> {
	
	@Query(value="select mentor_id from mentor_details where user_name = :username",nativeQuery = true)
	Optional<Integer> findMentorId(@Param(value="username") String username);
	
	@Query(value="select skills_skill_name from mentor_details_skills where mentor_details_mentor_id = :mentorId",nativeQuery = true)
	List<Technology> findMentorSkills(@Param(value="mentorId") int mentorId);
}
