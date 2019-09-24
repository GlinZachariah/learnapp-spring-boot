package dev.glinzac.learnapp.models;

public class MentorHistoryModel {
	private String courseId;
	private int totalTraineeCount;
	private int courseCompleted;
	private int courseActive;
	private int courseRating;
	
	public MentorHistoryModel() {
		
	}
	public MentorHistoryModel(String courseId, int totalTraineeCount, int courseCompleted, int courseActive,
			int courseRating) {
		super();
		this.courseId = courseId;
		this.totalTraineeCount = totalTraineeCount;
		this.courseCompleted = courseCompleted;
		this.courseActive = courseActive;
		this.courseRating = courseRating;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public int getTotalTraineeCount() {
		return totalTraineeCount;
	}
	public void setTotalTraineeCount(int totalTraineeCount) {
		this.totalTraineeCount = totalTraineeCount;
	}
	public int getCourseCompleted() {
		return courseCompleted;
	}
	public void setCourseCompleted(int courseCompleted) {
		this.courseCompleted = courseCompleted;
	}
	public int getCourseActive() {
		return courseActive;
	}
	public void setCourseActive(int courseActive) {
		this.courseActive = courseActive;
	}
	public int getCourseRating() {
		return courseRating;
	}
	public void setCourseRating(int courseRating) {
		this.courseRating = courseRating;
	}
	
}
