package dev.glinzac.learnapp.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mentor_history")
public class MentorHistory {
	@Id
	@GeneratedValue
	 private int historyId;
	 
	 private Date startDate;
	 private Date endDate;
	 
	 
	 @ManyToOne
	 @JoinColumn(name="user_name")
	 private UserDetails userName;
	 
	 @ManyToOne
	 @JoinColumn(name="mentor_id")
	 private MentorDetails mentorDetails;
	 
	 private String approvalStatus;
	 private String paymentStatus;
	 private String timeSlot;
	 private Double courseProgress;
	 private int withdrawCount;
	 
	 @OneToOne
	 @JoinColumn(name="course_id")
	 private CourseDetails courseId;
	 
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
	public UserDetails getUserName() {
		return userName;
	}
	public void setUserName(UserDetails userName) {
		this.userName = userName;
	}
	public MentorDetails getMentorDetails() {
		return mentorDetails;
	}
	public void setMentorDetails(MentorDetails mentorDetails) {
		this.mentorDetails = mentorDetails;
	}
	public Double getCourseProgress() {
		return courseProgress;
	}
	public void setCourseProgress(Double courseProgress) {
		this.courseProgress = courseProgress;
	}
	public CourseDetails getCourseId() {
		return courseId;
	}
	public void setCourseId(CourseDetails courseId) {
		this.courseId = courseId;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
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
	public int getWithdrawCount() {
		return withdrawCount;
	}
	public void setWithdrawCount(int withdrawCount) {
		this.withdrawCount = withdrawCount;
	}
	 
	 
	 
}
