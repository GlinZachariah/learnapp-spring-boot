package dev.glinzac.learnapp.entities;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Technology {
	@Id
	@Column(length = 32)
	private String skillName;
	public Technology() {
		
	}

	public Technology(String skill) {
		super();
		this.skillName = skill;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skill) {
		this.skillName = skill;
	}
	
}