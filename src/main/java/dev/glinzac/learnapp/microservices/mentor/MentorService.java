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
import dev.glinzac.learnapp.entities.Technology;
import dev.glinzac.learnapp.entities.UserCompleted;
import dev.glinzac.learnapp.entities.UserDetails;
import dev.glinzac.learnapp.entities.UserProgress;
import dev.glinzac.learnapp.microservices.user.CardDetailsRepository;
import dev.glinzac.learnapp.microservices.user.UserCompletedRepository;
import dev.glinzac.learnapp.microservices.user.UserDetailsRepository;
import dev.glinzac.learnapp.microservices.user.UserTrainingRepository;
import dev.glinzac.learnapp.models.CalendarModel;
import dev.glinzac.learnapp.models.CardDetailsModel;
import dev.glinzac.learnapp.models.CourseModel;
import dev.glinzac.learnapp.models.MentorHistoryModel;
import dev.glinzac.learnapp.models.MentorProgressModel;
import dev.glinzac.learnapp.models.MentorSkillModel;
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
	
	@Autowired
	UserTrainingRepository progressRepo;
	
	@Autowired
	UserCompletedRepository completedRepo;
	
//	add new course
	public void addCourse(CourseModel course) {
		CourseDetails newCourse = new CourseDetails();
		newCourse.setAverageRating(0);
		newCourse.setCharges(course.getCharges());
		newCourse.setCommission(0.1D);
		newCourse.setCourseId(course.getCourseid());
		newCourse.setCourseName(course.getCourseName());		
		
		newCourse.setSkills(course.getTechnology());
		newCourse.setTotalTraineeCount(0);
		newCourse.setTraineeCompleted(0);
		newCourse.setTraineeInProgress(0);
		newCourse.setTotalTime(course.getTotalTime());
		newCourse.setTotalRevenue(0.0D);
		newCourse.setMentorEarned(0.0D);
		int id = mentorRepo.findMentorId(course.getTrainerName()).orElse(0);
		if(id!=0) {
			MentorDetails mentor = mentorRepo.findById(id).get();
			newCourse.setMentorDetails(mentor);
			courseRepo.save(newCourse);
		}
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
		data.setMentorDetails(mentorRepo.findById(mentorRepo.findMentorId(calendarData.getMentorName()).get()).get() );
		data.setStatus(calendarData.getStatus());
		data.setTimeSlot(calendarData.getTimeSlot());
		calendarRepo.save(data);
	}
	public void removeCalendar(CalendarModel calendar) {
		int mentorId = findMentorId(calendar.getMentorName());
		CalendarEntity  cal = calendarRepo.getMentorCalendar(calendar.getFromDate(),calendar.getTillDate(),calendar.getTimeSlot(),mentorId).get();
		calendarRepo.deleteById(cal.getCalendarId());
	}
	
	public List<CalendarModel> findCalendar(int mentorId) {
		List<CalendarEntity>  mentorCalendarData = calendarRepo.findMentorCalendar(mentorId).orElse(null);
		List<CalendarModel> result = new ArrayList<CalendarModel>();
		if(mentorCalendarData != null) {
			mentorCalendarData.forEach(data->{
				CalendarModel newData = new CalendarModel();
//				newData.setCalendarId(data.getCalendarId());
				newData.setMentorName(data.getMentorDetails().getUserDetails().getUserName());
				newData.setStatus(data.getStatus());
				newData.setTimeSlot(data.getTimeSlot());
				newData.setFromDate(data.getFromDate());
				newData.setTillDate(data.getTillDate());
				result.add(newData);
			});
		}
		return result;
	}
	public String findUserName(int mentorId) {
		MentorDetails  mentor = mentorRepo.findById(mentorId).get();
		return mentor.getUserDetails().getUserName();
	}
	
	public int findMentorId(String username) {
		return mentorRepo.findMentorId(username).get();
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
	
	public void updateMentorDetails(SignUpModel mentorDetails) {
		int mentorId = mentorRepo.findMentorId(mentorDetails.getUserName()).get();
		MentorDetails mentor = mentorRepo.findById(mentorId).get();
		UserDetails user = userRepo.findById(mentorDetails.getUserName()).get();
		user.setUserName(mentorDetails.getUserName());
		user.setAccountStatus(mentorDetails.getAccountStatus());
		user.setFullName(mentorDetails.getFullName());
		user.setUserPassword(mentorDetails.getUserPassword());
		user.setUserRole(mentorDetails.getUserRole());	
		userRepo.save(user);

		mentor.setUserDetails(user);
		mentor.setCourseTypeBlog(mentorDetails.isCourseTypeBlog());
		mentor.setCourseTypeVideo(mentorDetails.isCourseTypeVideo());
		mentor.setCourseTypePPT(mentorDetails.isCourseTypePPT());
		mentor.setCourseTypeDemo(mentorDetails.isCourseTypeDemo());
		mentor.setExperience(mentorDetails.getExperience());
		mentor.setLinkedInURL(mentorDetails.getLinkedInURL());
//		mentor.setSkills(mentorDetails.getSkills());
		mentor.setTimeSlot(mentorDetails.getTimeslot());
		mentor.setTimezoneId(mentorDetails.getTimezone());
		mentorRepo.save(mentor);
	}
	public SignUpModel getMentorDetails(int mentorId) {
		MentorDetails mentor = mentorRepo.findById(mentorId).get();
		SignUpModel result = new SignUpModel();
		result.setUserName(mentor.getUserDetails().getUserName());
		result.setFullName(mentor.getUserDetails().getFullName());
		result.setUserPassword(mentor.getUserDetails().getUserPassword());
		result.setAccountStatus(mentor.getUserDetails().getAccountStatus());
		result.setCourseTypeBlog(mentor.isCourseTypeBlog());
		result.setCourseTypeVideo(mentor.isCourseTypeVideo());;
		result.setCourseTypePPT(mentor.isCourseTypePPT());
		result.setCourseTypeDemo(mentor.isCourseTypeDemo());
		result.setExperience(mentor.getExperience());
		result.setUserRole(mentor.getUserDetails().getUserRole());
		result.setTimeslot(mentor.getTimeSlot());
		result.setTimezone(mentor.getTimezoneId());
		result.setLinkedInURL(mentor.getLinkedInURL());
		result.setSkills(getSkills(mentorId));
		return result;
	}
	public List<Technology> getSkills(int mentorId) {
		return mentorRepo.findMentorSkills(mentorId);
	}
	public void updateSkills(MentorSkillModel mentorSkill) {
		int mentorId = mentorSkill.getMentorId();
		List<Technology> skills= mentorSkill.getSkills();
		MentorDetails mentor = mentorRepo.findById(mentorId).get();
		mentor.setSkills(skills);
		mentorRepo.save(mentor);
	}
	public List<MentorHistoryModel> viewHistory(int mentorId) {
		List<MentorHistoryModel> result= new ArrayList<MentorHistoryModel>();
		List<CourseDetails> courses = courseRepo.findByMentorId(mentorId);
		courses.forEach(course->{
			MentorHistoryModel resultItem = new MentorHistoryModel();
			resultItem.setCourseActive(course.getTraineeInProgress());
			resultItem.setCourseCompleted(course.getTraineeCompleted());
			resultItem.setCourseId(course.getCourseId());
			resultItem.setCourseRating(course.getAverageRating());
			resultItem.setTotalTraineeCount(course.getTotalTraineeCount());
			resultItem.setMentorEarned(course.getMentorEarned());
			resultItem.setRevenueEarned(course.getTotalRevenue());
			resultItem.setTechnology(course.getSkills().getSkillName());
			result.add(resultItem);
		});
		return result;
	}
	public List<MentorProgressModel> viewProgress(int mentorId) {
		List<UserProgress> courses = progressRepo.findTrainerCourses(mentorId);
		List<MentorProgressModel> result = new ArrayList<MentorProgressModel>();
		courses.forEach(course->{
			MentorProgressModel item = new MentorProgressModel();
			item.setCourseId(course.getCourseDetails().getCourseId());
			item.setCourseStatus(course.getCourseStatus());
			item.setTimestamp(course.getStartDate());
			item.setProgress(course.getProgress());
			item.setTimeSlot(course.getTimeslot());
			item.setUsername(course.getUserDetails().getUserName());
			item.setWithdrawCount(course.getWithdrawCount());
			item.setPaymentStatus(course.getPaymentStatus());
			if(item.getCourseStatus().equals("Rejected")) {
				System.out.println("Rejected Item");
			}else {
				result.add(item);
			}
		});
		List<UserCompleted> completedCourses = completedRepo.findTrainerCourses(mentorId);
		completedCourses.forEach(course->{
			MentorProgressModel item = new MentorProgressModel();
			item.setCourseId(course.getCourseDetails().getCourseId());
			item.setCourseStatus("Completed");
			item.setTimestamp(course.getStartDate());
			item.setProgress(100);
			item.setTimeSlot(course.getTimeslot());
			item.setUsername(course.getUserDetails().getUserName());
			item.setWithdrawCount(course.getWithdrawCount());
			result.add(item);
		});
		return result;
	}
	public void updateProgress(MentorProgressModel mentorCourse) {
		UserProgress progressCourse = progressRepo.findCourse(mentorCourse.getUsername(), mentorCourse.getCourseId()).orElse(null);
		if(progressCourse == null) {
			UserCompleted completedCourse = completedRepo.findCourse(mentorCourse.getUsername(), mentorCourse.getCourseId()).get();
			completedCourse.setWithdrawCount(mentorCourse.getWithdrawCount());
			completedRepo.save(completedCourse);
		}else {
			progressCourse.setCourseStatus(mentorCourse.getCourseStatus());
			progressCourse.setWithdrawCount(mentorCourse.getWithdrawCount());
			progressRepo.save(progressCourse);
		}
	}

	
	
	
}
