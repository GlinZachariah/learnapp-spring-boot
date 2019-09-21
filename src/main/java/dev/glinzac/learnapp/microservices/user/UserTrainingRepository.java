package dev.glinzac.learnapp.microservices.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dev.glinzac.learnapp.entities.UserDetails;
import dev.glinzac.learnapp.entities.UserProgress;

public interface UserTrainingRepository extends CrudRepository<UserProgress, Integer> {
	
	@Query(value="select count(*) from user_progress where user_name= :username && course_id = :coursename",nativeQuery = true)
	Optional<Integer> findProgressCourse(@Param(value="username") String username, @Param(value="coursename") String courseName);
	
	@Query(value="select * from user_progress where user_name= :username && course_id = :courseId",nativeQuery = true)
	Optional<UserProgress> findCourse(@Param(value="username") String username, @Param(value="courseId") String courseId);
	
	@Query(value="select * from user_progress where user_name = :username",nativeQuery = true)
	List<UserProgress> findTrainingInProgress(@Param(value="username") String username);
}
