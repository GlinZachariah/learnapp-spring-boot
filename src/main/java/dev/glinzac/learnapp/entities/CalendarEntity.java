package dev.glinzac.learnapp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CalendarEntity {
	@Id
	private int calendarId;
}