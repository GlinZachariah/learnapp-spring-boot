package dev.glinzac.learnapp.microservices.mentor;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dev.glinzac.learnapp.entities.CourseDetails;

public interface CourseDetailsRepository extends CrudRepository<CourseDetails, String> {

	@Query(value="select * from course_details where technology = :tech",nativeQuery = true)
	List<CourseDetails> findTrainingInProgress(@Param(value="tech") String tech);
}
