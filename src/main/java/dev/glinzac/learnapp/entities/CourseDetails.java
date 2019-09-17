package dev.glinzac.learnapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="course_details")
public class CourseDetails {
		@Id
		@Column(name="course_id",length = 32)
		private String courseId;
		
		@Column(name="course_name")
		private String courseName;
		
		@Column(name="course_charges")
		private Double charges;
		
		@Column(name="commission")
		private Double commission;
		
		@Column(name="total_hours")
		private int totalTime;
		
		@ManyToOne
		@JoinColumn(name="mentor_id")
		private MentorDetails mentorDetails;
		
		@OneToOne
		@JoinColumn(name="technology")
		private Technology skills;
		
		private int totalTraineeCount;
		private int traineeCompleted;
		private int traineeInProgress;
		private int averageRating;
		
		public CourseDetails(){
			
		}
		
		public CourseDetails(String courseId, String courseName, MentorDetails mentorDetails, Technology skills, Double charges,
				Double commission) {
			super();
			this.courseId = courseId;
			this.courseName = courseName;
			this.mentorDetails = mentorDetails;
			this.skills = skills;
			this.charges = charges;
			this.commission = commission;
		}
		
		public int getTotalTime() {
			return totalTime;
		}

		public void setTotalTime(int totalTime) {
			this.totalTime = totalTime;
		}

		public MentorDetails getMentorDetails() {
			return mentorDetails;
		}

		public void setMentorDetails(MentorDetails mentorDetails) {
			this.mentorDetails = mentorDetails;
		}

		public String getCourseId() {
			return courseId;
		}
		public void setCourseId(String courseId) {
			this.courseId = courseId;
		}
		public String getCourseName() {
			return courseName;
		}
		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}
		public Double getCharges() {
			return charges;
		}
		public void setCharges(Double charges) {
			this.charges = charges;
		}
		public Double getCommission() {
			return commission;
		}
		public void setCommission(Double commission) {
			this.commission = commission;
		}

		public Technology getSkills() {
			return skills;
		}

		public void setSkills(Technology skills) {
			this.skills = skills;
		}

		public int getTotalTraineeCount() {
			return totalTraineeCount;
		}

		public void setTotalTraineeCount(int totalTraineeCount) {
			this.totalTraineeCount = totalTraineeCount;
		}

		public int getTraineeCompleted() {
			return traineeCompleted;
		}

		public void setTraineeCompleted(int traineeCompleted) {
			this.traineeCompleted = traineeCompleted;
		}

		public int getTraineeInProgress() {
			return traineeInProgress;
		}

		public void setTraineeInProgress(int traineeInProgress) {
			this.traineeInProgress = traineeInProgress;
		}

		public int getAverageRating() {
			return averageRating;
		}

		public void setAverageRating(int averageRating) {
			this.averageRating = averageRating;
		}
		
}

