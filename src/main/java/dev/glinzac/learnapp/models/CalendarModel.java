package dev.glinzac.learnapp.models;

import java.sql.Date;

public class CalendarModel {
	private int calendarId;
	private Date fromDate;
	private Date tillDate;
	private int timeSlot;
	private String status;
	private int mentorId;
	
	public CalendarModel() {
		
	}
	
	public CalendarModel(int calendarId,Date fromDate, Date tillDate, int timeSlot, String status,
			int mentorId) {
		super();
		this.calendarId = calendarId;
		this.fromDate = fromDate;
		this.tillDate = tillDate;
		this.timeSlot = timeSlot;
		this.status = status;
		this.mentorId = mentorId;
	}
	
	public int getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}

	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public int getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
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
