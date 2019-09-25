package dev.glinzac.learnapp.microservices.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dev.glinzac.learnapp.entities.UserCompleted;
import dev.glinzac.learnapp.entities.UserProgress;

public interface UserCompletedRepository extends CrudRepository<UserCompleted, Integer> {

	@Query(value="select * from user_completed where withdraw_count < 4 && course_id IN (select course_id from course_details where mentor_id = :mentorId)",nativeQuery = true)
	List<UserCompleted> findTrainerCourses(@Param(value="mentorId") int mentorId);
	
	@Query(value="select * from user_completed where user_name= :username && course_id = :courseId",nativeQuery = true)
	Optional<UserCompleted> findCourse(@Param(value="username") String username, @Param(value="courseId") String courseId);
}
