package dev.glinzac.learnapp.models;

import java.sql.Date;

public class MentorProgressModel {
	private Date dateOfJoin;
	private String username;
	private String courseId;
	private String courseStatus;
	private String timeSlot;
	private Double progress;
	private int withdrawCount;
	
	public MentorProgressModel() {
		
	}

	public MentorProgressModel(Date dateOfJoin, String username, String courseId, String courseStatus, String timeSlot,
			Double progress, int withdrawCount) {
		super();
		this.dateOfJoin = dateOfJoin;
		this.username = username;
		this.courseId = courseId;
		this.courseStatus = courseStatus;
		this.timeSlot = timeSlot;
		this.progress = progress;
		this.withdrawCount = withdrawCount;
	}

	public Date getDateOfJoin() {
		return dateOfJoin;
	}

	public String getUsername() {
		return username;
	}

	public String getCourseId() {
		return courseId;
	}

	public String getCourseStatus() {
		return courseStatus;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public Double getProgress() {
		return progress;
	}

	public int getWithdrawCount() {
		return withdrawCount;
	}
	
	
}
