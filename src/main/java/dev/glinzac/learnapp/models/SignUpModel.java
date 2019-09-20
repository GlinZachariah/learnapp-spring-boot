package dev.glinzac.learnapp.models;

import java.util.List;
import dev.glinzac.learnapp.entities.Technology;

public class SignUpModel extends UserModel {
	private List<Technology> skills;
	private String timezone;
	private int timeslot;
	private String linkedInURL;
	private int experience;
	
	private boolean CourseTypeBlog;
	private boolean CourseTypePPT;
	private boolean CourseTypeVideo;
	private boolean CourseTypeDemo;
	
	public SignUpModel() {
		
	}
	
	public SignUpModel(List<Technology> skills, String timezone, int timeslot, String linkedInURL, int experience,
			boolean courseTypeBlog, boolean courseTypePPT, boolean courseTypeVideo, boolean courseTypeDemo) {
		super();
		this.skills = skills;
		this.timezone = timezone;
		this.timeslot = timeslot;
		this.linkedInURL = linkedInURL;
		this.experience = experience;
		CourseTypeBlog = courseTypeBlog;
		CourseTypePPT = courseTypePPT;
		CourseTypeVideo = courseTypeVideo;
		CourseTypeDemo = courseTypeDemo;
	}
	public List<Technology> getSkills() {
		return skills;
	}
	public void setSkills(List<Technology> skills) {
		this.skills = skills;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public int getTimeslot() {
		return timeslot;
	}
	public void setTimeslot(int timeslot) {
		this.timeslot = timeslot;
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
	
	
}
