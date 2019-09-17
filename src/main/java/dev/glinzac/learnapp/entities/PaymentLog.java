package dev.glinzac.learnapp.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity 
public class PaymentLog {

		@Id 
		@GeneratedValue
		private int paymentId;
		private Date date;
		
		@OneToOne
		@JoinColumn(name="user_name")
		private UserDetails userDetails;
		
		@OneToOne
		@JoinColumn(name="course_id")
		private CourseDetails courseDetails;
		
		@OneToOne
		@JoinColumn(name="mentor_id")
		private MentorDetails mentorDetails;
		
		@Column(name="payment_amount")
		private Double paymentAmount;
		
		@Column(name="commission")
		private Double commission;
		
		public PaymentLog(){
			
		}

		public PaymentLog(Date date, UserDetails userDetails, CourseDetails courseDetails, MentorDetails mentorDetails,
				Double paymentAmount, Double commission) {
			super();
			this.date = date;
			this.userDetails = userDetails;
			this.courseDetails = courseDetails;
			this.mentorDetails = mentorDetails;
			this.paymentAmount = paymentAmount;
			this.commission = commission;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public UserDetails getUserDetails() {
			return userDetails;
		}

		public void setUserDetails(UserDetails userDetails) {
			this.userDetails = userDetails;
		}

		public CourseDetails getCourseDetails() {
			return courseDetails;
		}

		public void setCourseDetails(CourseDetails courseDetails) {
			this.courseDetails = courseDetails;
		}

		public MentorDetails getMentorDetails() {
			return mentorDetails;
		}

		public void setMentorDetails(MentorDetails mentorDetails) {
			this.mentorDetails = mentorDetails;
		}

		public Double getPaymentAmount() {
			return paymentAmount;
		}

		public void setPaymentAmount(Double paymentAmount) {
			this.paymentAmount = paymentAmount;
		}

		public Double getCommission() {
			return commission;
		}

		public void setCommission(Double commission) {
			this.commission = commission;
		}
		
		
	
	
}

