package dev.glinzac.learnapp.microservices.mentor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.glinzac.learnapp.entities.MentorDetails;
import dev.glinzac.learnapp.models.CalendarModel;
import dev.glinzac.learnapp.models.CardDetailsModel;
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
	@RequestMapping(value = "/getCoursesList/{mentorId}",method = RequestMethod.GET)
	public List<CourseModel> getCourseList(@PathVariable String mentorId){
		return mentorService.getCourses(Integer.parseInt(mentorId));
	}
	
//	deleteCourse
	@RequestMapping(value = "/deleteCourse/{courseId}",method = RequestMethod.GET)
	public void deleteCourse(@PathVariable String courseId) {
		mentorService.deleteCourse(courseId);
	}
	
//	mentorCalendar add 
	@RequestMapping(value = "/addCalendar",method = RequestMethod.POST)
	public void addCalendar(@RequestBody CalendarModel calendarData) {
		mentorService.saveCalendar(calendarData);
	}
	
//	mentorCalendar delete
	@RequestMapping(value = "/deleteCalendar/{calendarId}",method = RequestMethod.GET)
	public void deleteCalendar(@PathVariable String calendarId) {
		mentorService.removeCalendar(Integer.parseInt(calendarId));
	}
	
//	getMentorCalendar
	@RequestMapping(value = "/findCalendar/{mentorId}",method = RequestMethod.GET)
	public List<CalendarModel> findCalendarByMentor(@PathVariable String mentorId) {
		return mentorService.findCalendar(Integer.parseInt(mentorId));
	}

//	findUserName
	@RequestMapping(value = "/findUserName/{mentorId}",method = RequestMethod.GET)
	public String getUsername(@PathVariable String mentorId) {
		return mentorService.findUserName(Integer.parseInt(mentorId));
	}
	
//	paymentDetails  save|update
	@RequestMapping(value="/updateCardDetails",method= RequestMethod.PUT)
	public void updateCardDetails(@RequestBody CardDetailsModel cardDetails) {
		mentorService.updateCard(cardDetails);
	}
//	getPaymentDetails
	@RequestMapping(value = "/getCardDetails/{username}",method = RequestMethod.GET)
	public CardDetailsModel getCardDetails(@PathVariable String username) {
		return mentorService.getCardDetails(username);
	}
	
//	updateDetails
//	getDetails
//	getMentorSkills
//	updateMentorSkills
//	viewHistory
//	InProgress
//	updateInProgress
//	viewHistory
	
	
}
