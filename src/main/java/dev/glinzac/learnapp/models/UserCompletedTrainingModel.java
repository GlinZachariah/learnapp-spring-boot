package dev.glinzac.learnapp.models;

import java.sql.Date;

public class UserCompletedTrainingModel{
	private String courseId;
	private String userName;
	private String timeSlot;
	private Date startDate;
	private Date endDate;
	private int rating;
	public UserCompletedTrainingModel() {
		
	}
	public UserCompletedTrainingModel(String courseId, String userName, String timeSlot, Date startDate, Date endDate,
			int rating) {
		super();
		this.courseId = courseId;
		this.userName = userName;
		this.timeSlot = timeSlot;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rating = rating;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
