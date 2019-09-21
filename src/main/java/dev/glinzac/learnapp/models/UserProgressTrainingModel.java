package dev.glinzac.learnapp.models;

import java.sql.Date;

public class UserProgressTrainingModel {
	private String courseId;
	private String userName;
	private Double progress;
	private int rating;
	private String paymentStatus;
	private String courseStatus;
	private String timeSlot;
	private Date startDate;
	public UserProgressTrainingModel() {
		
	}
	
	public UserProgressTrainingModel(String courseId, String userName, Double progress, int rating,
			String paymentStatus, String courseStatus, String timeSlot, Date startDate) {
		super();
		this.courseId = courseId;
		this.userName = userName;
		this.progress = progress;
		this.rating = rating;
		this.paymentStatus = paymentStatus;
		this.courseStatus = courseStatus;
		this.timeSlot = timeSlot;
		this.startDate = startDate;
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
	public Double getProgress() {
		return progress;
	}
	public void setProgress(Double progress) {
		this.progress = progress;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
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

	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}
	
}
