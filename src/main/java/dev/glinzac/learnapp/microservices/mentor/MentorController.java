package dev.glinzac.learnapp.microservices.mentor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.glinzac.learnapp.models.CourseModel;
import dev.glinzac.learnapp.models.SignUpModel;

@RestController
@RequestMapping("/mentor")
public class MentorController {
	
	@Autowired
	MentorService mentorService;
	
//	signUp Mentor
	@RequestMapping(value = "/signUp" ,method = RequestMethod.POST)
	public void signUpMentor(@RequestBody SignUpModel signUp) {
		mentorService.signUp(signUp);
	}
	
//	addCourse
	@RequestMapping(value = "/addCourse",method = RequestMethod.POST)
	public void addCourse(@RequestBody CourseModel course) {
		mentorService.addCourse(course);
	}
//	getCoursesList
//	deleteCourse
}
