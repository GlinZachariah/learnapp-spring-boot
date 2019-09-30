package dev.glinzac.learnapp.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_progress")
public class UserProgress {
	
	@Id
	@GeneratedValue
	private int progressId;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private CourseDetails courseDetails;
	
	@ManyToOne
	@JoinColumn(name="user_name")
	private UserDetails userDetails;
	
	private int rating;
	private int timeslot;
	private Date startDate;
	private String courseStatus;
	private String paymentStatus;
	private Double progress;
	private int withdrawCount;
	public UserProgress() {
		
	}
	public UserProgress(int progressId, CourseDetails courseDetails, UserDetails userDetails, int rating,
			int timeslot, Date startDate, String courseStatus, String paymentStatus, Double progress,
			int withdrawCount) {
		super();
		this.progressId = progressId;
		this.courseDetails = courseDetails;
		this.userDetails = userDetails;
		this.rating = rating;
		this.timeslot = timeslot;
		this.startDate = startDate;
		this.courseStatus = courseStatus;
		this.paymentStatus = paymentStatus;
		this.progress = progress;
		this.withdrawCount = withdrawCount;
	}
	public int getProgressId() {
		return progressId;
	}
	public void setProgressId(int progressId) {
		this.progressId = progressId;
	}
	public CourseDetails getCourseDetails() {
		return courseDetails;
	}
	public void setCourseDetails(CourseDetails courseDetails) {
		this.courseDetails = courseDetails;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getTimeslot() {
		return timeslot;
	}
	public void setTimeslot(int timeslot) {
		this.timeslot = timeslot;
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
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Double getProgress() {
		return progress;
	}
	public void setProgress(Double progress) {
		this.progress = progress;
	}
	public int getWithdrawCount() {
		return withdrawCount;
	}
	public void setWithdrawCount(int withdrawCount) {
		this.withdrawCount = withdrawCount;
	}
	
	
	
}

