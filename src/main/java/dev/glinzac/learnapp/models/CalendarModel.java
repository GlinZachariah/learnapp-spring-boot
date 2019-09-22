package dev.glinzac.learnapp.models;

import java.sql.Date;

public class CalendarModel {
	private Date fromDate;
	private Date tillDate;
	private String timeSlot;
	private int Frequency;
	private String excepDays;
	private String status;
	private int mentorId;
	
	public CalendarModel() {
		
	}
	
	public CalendarModel(Date fromDate, Date tillDate, String timeSlot, int frequency, String excepDays, String status,
			int mentorId) {
		super();
		this.fromDate = fromDate;
		this.tillDate = tillDate;
		this.timeSlot = timeSlot;
		Frequency = frequency;
		this.excepDays = excepDays;
		this.status = status;
		this.mentorId = mentorId;
	}

	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	public int getFrequency() {
		return Frequency;
	}
	public void setFrequency(int frequency) {
		Frequency = frequency;
	}
	public String getExcepDays() {
		return excepDays;
	}
	public void setExcepDays(String excepDays) {
		this.excepDays = excepDays;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getMentorId() {
		return mentorId;
	}
	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}

	public Date getTillDate() {
		return tillDate;
	}

	public void setTillDate(Date tillDate) {
		this.tillDate = tillDate;
	}
	
	
}
