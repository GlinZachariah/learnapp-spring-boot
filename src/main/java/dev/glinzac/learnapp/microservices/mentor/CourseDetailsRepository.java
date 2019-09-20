package dev.glinzac.learnapp.microservices.mentor;

import org.springframework.data.repository.CrudRepository;

import dev.glinzac.learnapp.entities.CourseDetails;

public interface CourseDetailsRepository extends CrudRepository<CourseDetails, String> {

}
