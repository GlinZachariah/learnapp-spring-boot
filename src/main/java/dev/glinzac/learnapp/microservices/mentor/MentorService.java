package dev.glinzac.learnapp.microservices.mentor;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.glinzac.learnapp.CalendarRepository;
import dev.glinzac.learnapp.entities.CalendarEntity;
import dev.glinzac.learnapp.entities.CardDetails;
import dev.glinzac.learnapp.entities.CourseDetails;
import dev.glinzac.learnapp.entities.MentorDetails;
import dev.glinzac.learnapp.entities.UserDetails;
import dev.glinzac.learnapp.microservices.user.CardDetailsRepository;
import dev.glinzac.learnapp.microservices.user.UserDetailsRepository;
import dev.glinzac.learnapp.models.CalendarModel;
import dev.glinzac.learnapp.models.CardDetailsModel;
import dev.glinzac.learnapp.models.CourseModel;
import dev.glinzac.learnapp.models.SignUpModel;

@Service
public class MentorService {
	@Autowired
	UserDetailsRepository userRepo;
	
	@Autowired
	CourseDetailsRepository courseRepo;
	
	@Autowired
	MentorDetailsRepository mentorRepo;
	
	@Autowired
	CalendarRepository calendarRepo;
	
	@Autowired
	CardDetailsRepository cardRepo;
	
//	add new course
	public void addCourse(CourseModel course) {
		CourseDetails newCourse = new CourseDetails();
		newCourse.setAverageRating(0);
		newCourse.setCharges(course.getCharges());
		newCourse.setCommission(0.1D);
		newCourse.setCourseId(course.getCourseid());
		newCourse.setCourseName(course.getCourseName());		
		int id = mentorRepo.findMentorId(course.getTrainerName()).orElse(0);
		if(id!=0) {
			MentorDetails mentor = mentorRepo.findById(id).get();
			newCourse.setMentorDetails(mentor);
		}
		newCourse.setSkills(course.getTechnology());
		newCourse.setTotalTraineeCount(0);
		newCourse.setTraineeCompleted(0);
		newCourse.setTraineeInProgress(0);
		newCourse.setTotalTime(course.getTotalTime());
		
		courseRepo.save(newCourse);
		
	}
//	mentor sign up
	public void signUp(SignUpModel signUp) {
		UserDetails user = new UserDetails();
		user.setUserName(signUp.getUserName());
		user.setAccountStatus(signUp.getAccountStatus());
		user.setFullName(signUp.getFullName());
		user.setUserPassword(signUp.getUserPassword());
		user.setUserRole(signUp.getUserRole());	
//		userRepo.save(user);
		
		
		MentorDetails mentor = new MentorDetails();
		mentor.setUserDetails(user);
		mentor.setCourseTypeBlog(signUp.isCourseTypeBlog());
		mentor.setCourseTypeVideo(signUp.isCourseTypeVideo());
		mentor.setCourseTypePPT(signUp.isCourseTypePPT());
		mentor.setCourseTypeDemo(signUp.isCourseTypeDemo());
		mentor.setExperience(signUp.getExperience());
		mentor.setLinkedInURL(signUp.getLinkedInURL());
		mentor.setSkills(signUp.getSkills());
		mentor.setTimeSlot(signUp.getTimeslot());
		mentor.setTimezoneId(signUp.getTimezone());
		mentorRepo.save(mentor);
		
	}
	public List<CourseModel> getCourses(int mentorId) {
		List<CourseDetails> courses = courseRepo.findByMentorId(mentorId);
		List<CourseModel> result = new ArrayList<CourseModel>();
		courses.forEach(course->{
			CourseModel modelCourse = new CourseModel();
			modelCourse.setCourseid(course.getCourseId());
			modelCourse.setCourseName(course.getCourseName());
			modelCourse.setTotalTime(course.getTotalTime());
			modelCourse.setTechnology(course.getSkills());
			modelCourse.setCharges(course.getCharges());
			result.add(modelCourse);
		});
		return result;
	}
	
	public void deleteCourse(String courseId) {
		courseRepo.deleteById(courseId);
	}
	public void saveCalendar(CalendarModel calendarData) {
		CalendarEntity data = new CalendarEntity();
		data.setFromDate(calendarData.getFromDate());
		data.setTillDate(calendarData.getTillDate());
		data.setMentorDetails(mentorRepo.findById(calendarData.getMentorId()).get());
		data.setStatus(calendarData.getStatus());
		data.setTimeSlot(calendarData.getTimeSlot());
		calendarRepo.save(data);
	}
	public void removeCalendar(int calendarId) {
		calendarRepo.deleteById(calendarId);
	}
	public List<CalendarModel> findCalendar(int mentorId) {
		List<CalendarEntity>  mentorCalendarData = calendarRepo.findMentorCalendar(mentorId).get();
		List<CalendarModel> result = new ArrayList<CalendarModel>();
		mentorCalendarData.forEach(data->{
			CalendarModel newData = new CalendarModel();
			newData.setCalendarId(data.getCalendarId());
			newData.setMentorId(data.getMentorDetails().getMentorId());
			newData.setStatus(data.getStatus());
			newData.setTimeSlot(data.getTimeSlot());
			newData.setFromDate(data.getFromDate());
			newData.setTillDate(data.getTillDate());
			result.add(newData);
		});
		return result;
	}
	public String findUserName(int mentorId) {
		MentorDetails  mentor = mentorRepo.findById(mentorId).get();
		return mentor.getUserDetails().getUserName();
	}
	
	public void updateCard(CardDetailsModel cardDetail) {
		String username =cardDetail.getUsername();
		int count = cardRepo.checkCardDetails(username);
		if (count == 1) {
			int id = cardRepo.findCardId(username).get();
			CardDetails card  = cardRepo.findById(id).orElse(null);
			card.setCardNo(cardDetail.getCardNo());
			card.setMM(cardDetail.getmM());
			card.setYY(cardDetail.getyY());
			card.setCV(cardDetail.getcV());
			cardRepo.save(card);
		}else {
			CardDetails card = new CardDetails();
			card.setCardNo(cardDetail.getCardNo());
			card.setMM(cardDetail.getmM());
			card.setYY(cardDetail.getyY());
			card.setCV(cardDetail.getcV());
			card.setUserDetails(userRepo.findById(username).get());
			cardRepo.save(card);
		}
	}
	
	public CardDetailsModel getCardDetails(String username) {
		int id = cardRepo.findCardId(username).orElse(0);
		CardDetailsModel card = new CardDetailsModel();
		if(id != 0) {
			CardDetails cardData = cardRepo.findById(id).get();
			if(cardData != null) {
				card.setCardNo(cardData.getCardNo());
				card.setmM(cardData.getMM());
				card.setyY(cardData.getYY());
				card.setcV(cardData.getCV());
				card.setUsername(cardData.getUserDetails().getUserName());
				return card;
			}
		}
		card.setCardNo("");
		card.setUsername("");
		card.setcV(0);
		card.setmM(0);
		card.setyY(0);
		return card;
	}
	
	
}
