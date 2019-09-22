package dev.glinzac.learnapp.models;

public class SearchCourseResponseModel {
	private String courseId;
	private String courseName;
	private String trainerName;
	private String technology;
	private boolean materialVideo;
	private boolean materialDemo;
	private boolean materialPPT;
	private boolean materialBlog;
	private int experience;
	private Double trainingCharges;
	private Double serviceCharges;
	private int totalTime;
	
	public SearchCourseResponseModel() {
		
	}
	public SearchCourseResponseModel(String courseId, String courseName, String trainerName, String technology,
			boolean materialVideo, boolean materialDemo, boolean materialPPT, boolean materialBlog, int experience,
			Double trainingCharges, Double serviceCharges, int totalTime) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.trainerName = trainerName;
		this.technology = technology;
		this.materialVideo = materialVideo;
		this.materialDemo = materialDemo;
		this.materialPPT = materialPPT;
		this.materialBlog = materialBlog;
		this.experience = experience;
		this.trainingCharges = trainingCharges;
		this.serviceCharges = serviceCharges;
		this.totalTime = totalTime;
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
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public boolean isMaterialVideo() {
		return materialVideo;
	}
	public void setMaterialVideo(boolean materialVideo) {
		this.materialVideo = materialVideo;
	}
	public boolean isMaterialDemo() {
		return materialDemo;
	}
	public void setMaterialDemo(boolean materialDemo) {
		this.materialDemo = materialDemo;
	}
	public boolean isMaterialPPT() {
		return materialPPT;
	}
	public void setMaterialPPT(boolean materialPPT) {
		this.materialPPT = materialPPT;
	}
	public boolean isMaterialBlog() {
		return materialBlog;
	}
	public void setMaterialBlog(boolean materialBlog) {
		this.materialBlog = materialBlog;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public Double getTrainingCharges() {
		return trainingCharges;
	}
	public void setTrainingCharges(Double trainingCharges) {
		this.trainingCharges = trainingCharges;
	}
	public Double getServiceCharges() {
		return serviceCharges;
	}
	public void setServiceCharges(Double serviceCharges) {
		this.serviceCharges = serviceCharges;
	}
	public int getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	
}
