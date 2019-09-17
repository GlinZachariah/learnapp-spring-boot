package dev.glinzac.learnapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mentor_progress")
public class MentorProgress {
	@Id
	@GeneratedValue
	private int progressId;
	
	@ManyToOne
	@JoinColumn(name="mentor_id")
	private MentorDetails mentorDetails;
	
	@OneToOne
	@JoinColumn(name="technology")
	private Technology technology;
	
	@OneToOne
	@JoinColumn(name="courseId")
	private CourseDetails courseId;

	private Double revenueEarned;
	
	
	public MentorDetails getMentorDetails() {
		return mentorDetails;
	}
	public void setMentorDetails(MentorDetails mentorDetails) {
		this.mentorDetails = mentorDetails;
	}
	public Technology getTechnology() {
		return technology;
	}
	public void setTechnology(Technology technology) {
		this.technology = technology;
	}
	public CourseDetails getCourseId() {
		return courseId;
	}
	public void setCourseId(CourseDetails courseId) {
		this.courseId = courseId;
	}
	public Double getRevenueEarned() {
		return revenueEarned;
	}
	public void setRevenueEarned(Double revenueEarned) {
		this.revenueEarned = revenueEarned;
	}
	
	
	
}
