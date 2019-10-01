package dev.glinzac.learnapp.microservices.mentor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.glinzac.learnapp.entities.MentorDetails;
import dev.glinzac.learnapp.entities.Technology;
import dev.glinzac.learnapp.models.CalendarModel;
import dev.glinzac.learnapp.models.CardDetailsModel;
import dev.glinzac.learnapp.models.CourseModel;
import dev.glinzac.learnapp.models.MentorHistoryModel;
import dev.glinzac.learnapp.models.MentorProgressModel;
import dev.glinzac.learnapp.models.MentorSkillModel;
import dev.glinzac.learnapp.models.SignUpModel;

@RestController
@RequestMapping("/mentor")
public class MentorController {
	
	@Autowired
	MentorService mentorService;
	
//*	signUp Mentor
	@RequestMapping(value = "/signUp" ,method = RequestMethod.POST)
	public void signUpMentor(@RequestBody SignUpModel signUp) {
		System.out.println(signUp.getUserName());
		System.out.println(signUp.getAccountStatus());
		System.out.println(signUp.getExperience());
		System.out.println(signUp.getFullName());
		System.out.println(signUp.getLinkedInURL());
		System.out.println(signUp.getTimeslot());
		System.out.println(signUp.getTimezone());
		System.out.println(signUp.getUserPassword());
		System.out.println(signUp.getUserRole());
		System.out.println(signUp.getSkills());
		mentorService.signUp(signUp);
	}
	
//	addCourse
	@RequestMapping(value = "/addCourse",method = RequestMethod.POST)
	public void addCourse(@RequestBody CourseModel course) {
		mentorService.addCourse(course);
	}
//	getCoursesList
	@RequestMapping(value = "/getCoursesList/{mentorUsername}",method = RequestMethod.GET)
	public List<CourseModel> getCourseList(@PathVariable String mentorUsername){
		int mentorId = mentorService.findMentorId(mentorUsername);
		return mentorService.getCourses(mentorId);
	}
	
//	deleteCourse
	@RequestMapping(value = "/deleteCourse/{courseId}",method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String courseId) {
		mentorService.deleteCourse(courseId);
	}
	
//	mentorCalendar add 
	@RequestMapping(value = "/addCalendar",method = RequestMethod.POST)
	public void addCalendar(@RequestBody CalendarModel calendarData) {
		System.out.println(calendarData.getMentorName());
		System.out.println(calendarData.getStatus());
		System.out.println(calendarData.getTimeSlot());
		System.out.println(calendarData.getFromDate());
		mentorService.saveCalendar(calendarData);
	}
	
//	mentorCalendar delete
	@RequestMapping(value = "/deleteCalendar",method = RequestMethod.PUT)
	public void deleteCalendar(@RequestBody CalendarModel calendar) {
		mentorService.removeCalendar(calendar);
	}
	
//	getMentorCalendar
	@RequestMapping(value = "/findCalendar/{mentorUsername}",method = RequestMethod.GET)
	public List<CalendarModel> findCalendarByMentor(@PathVariable String mentorUsername) {
		int mentorId = mentorService.findMentorId(mentorUsername);
		return mentorService.findCalendar(mentorId);
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
	@RequestMapping(value = "/getCardDetails/{mentorid}",method = RequestMethod.GET)
	public CardDetailsModel getCardDetails(@PathVariable String mentorid) {
		String username = mentorService.findUserName(Integer.parseInt(mentorid));
		return mentorService.getCardDetails(username);
	}
	
//	updateDetails
	@RequestMapping(value = "/updateMentorDetails/",method = RequestMethod.PUT)
	public void updateMentorDetails(@RequestBody SignUpModel mentorDetails) {
		mentorService.updateMentorDetails(mentorDetails);
	}
	
//	getDetails
	@RequestMapping(value = "/getMentorDetails/{mentorUsername}",method = RequestMethod.GET)
	public SignUpModel getMentorDetails(@PathVariable String mentorUsername) {
		int mentorId = mentorService.findMentorId(mentorUsername);
		return mentorService.getMentorDetails(mentorId);
	}
//*	getMentorSkills
	@RequestMapping(value = "/getMentorSkills/{mentorUsername}",method = RequestMethod.GET)
	public List<Technology> getSkills(@PathVariable  String mentorUsername){
		int mentorId = mentorService.findMentorId(mentorUsername);
		return mentorService.getSkills(mentorId);
	}
	
//*	updateMentorSkills
	@RequestMapping(value = "/updateMentorSkills",method = RequestMethod.PUT)
	public void updateSkills(@RequestBody  MentorSkillModel mentorSkill){
		mentorService.updateSkills(mentorSkill);
	}
//	viewHistory
	@RequestMapping(value = "/viewMentorHistory/{mentorUsername}",method = RequestMethod.GET)
	public List<MentorHistoryModel> viewMentorHistory(@PathVariable  String mentorUsername){
		int mentorId = mentorService.findMentorId(mentorUsername);
		return mentorService.viewHistory(mentorId);
	}
	
//	InProgress
	@RequestMapping(value = "/viewMentorProgress/{mentorUsername}",method = RequestMethod.GET)
	public List<MentorProgressModel> viewMentorProgress(@PathVariable  String mentorUsername){
		int mentorId = mentorService.findMentorId(mentorUsername);
		return mentorService.viewProgress(mentorId);
	}
	
//	updateInProgress
	@RequestMapping(value = "/updateMentorProgress",method = RequestMethod.PUT)
	public void updateMentorProgress(@RequestBody MentorProgressModel mentorCourse){
		 mentorService.updateProgress(mentorCourse);
	}
	
//	withdrawAmount
	@RequestMapping(value = "/withdrawAmount",method = RequestMethod.PUT)
	public MentorProgressModel withdrawMentorProgress(@RequestBody MentorProgressModel mentorCourse){
		 return mentorService.withdrawProgressAmount(mentorCourse);
	}
	
	
}
