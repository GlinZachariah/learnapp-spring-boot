package dev.glinzac.learnapp.microservices.mentor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.glinzac.learnapp.entities.CourseDetails;
import dev.glinzac.learnapp.entities.MentorDetails;
import dev.glinzac.learnapp.entities.UserDetails;
import dev.glinzac.learnapp.microservices.user.UserDetailsRepository;
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

	public void signUp(SignUpModel signUp) {
		UserDetails user = new UserDetails();
		user.setUserName(signUp.getUserName());
		user.setAccountStatus(signUp.getAccountStatus());
		user.setFullName(signUp.getFullName());
		user.setUserPassword(signUp.getUserPassword());
		user.setUserRole(signUp.getUserRole());	
		userRepo.save(user);
		
		
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
	
}
