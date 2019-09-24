package dev.glinzac.learnapp.models;

import java.util.List;

import dev.glinzac.learnapp.entities.Technology;

/**
 * @author glinzac
 *
 */
public class MentorSkillModel {
	private int mentorId;
	private List<Technology> skills;
	
	public MentorSkillModel() {
		
	}
	public MentorSkillModel(int mentorId, List<Technology> skills) {
		super();
		this.mentorId = mentorId;
		this.skills = skills;
	}
	public int getMentorId() {
		return mentorId;
	}
	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}
	public List<Technology> getSkills() {
		return skills;
	}
	public void setSkills(List<Technology> skills) {
		this.skills = skills;
	}
	
	
	
}
