package dev.glinzac.learnapp.microservices.mentor;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.glinzac.learnapp.models.CourseModel;

@RestController
@RequestMapping("/mentor")
public class MentorController {
	
//	addCourse
	@RequestMapping(name = "/addCourse",method = RequestMethod.POST)
	public void addCourse(@RequestBody CourseModel course) {
		
	}
//	getCoursesList
//	deleteCourse
}
