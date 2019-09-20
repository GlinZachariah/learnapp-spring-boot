package dev.glinzac.learnapp.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mentor_details")
public class MentorDetails {
	@Id 
	@GeneratedValue
	private int mentorId;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_name")
	private UserDetails userDetails;

    @ManyToMany
	private List<Technology> skills;
	private String timezoneId;
	private int timeSlot;
	private String linkedInURL;
	private int experience;

//	CourseTypes
	private boolean CourseTypeBlog;
	private boolean CourseTypePPT;
	private boolean CourseTypeVideo;
	private boolean CourseTypeDemo;
	
	
	public List<Technology> getSkills() {
		return skills;
	}

	public void setSkills(List<Technology> skills) {
		this.skills = skills;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public String getTimezoneId() {
		return timezoneId;
	}

	public void setTimezoneId(String timezoneId) {
		this.timezoneId = timezoneId;
	}

	public int getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
	}

	public boolean isCourseTypeBlog() {
		return CourseTypeBlog;
	}

	public void setCourseTypeBlog(boolean courseTypeBlog) {
		CourseTypeBlog = courseTypeBlog;
	}

	public boolean isCourseTypePPT() {
		return CourseTypePPT;
	}

	public void setCourseTypePPT(boolean courseTypePPT) {
		CourseTypePPT = courseTypePPT;
	}

	public boolean isCourseTypeVideo() {
		return CourseTypeVideo;
	}

	public void setCourseTypeVideo(boolean courseTypeVideo) {
		CourseTypeVideo = courseTypeVideo;
	}

	public boolean isCourseTypeDemo() {
		return CourseTypeDemo;
	}

	public void setCourseTypeDemo(boolean courseTypeDemo) {
		CourseTypeDemo = courseTypeDemo;
	}

	public String getLinkedInURL() {
		return linkedInURL;
	}

	public void setLinkedInURL(String linkedInURL) {
		this.linkedInURL = linkedInURL;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	
}
