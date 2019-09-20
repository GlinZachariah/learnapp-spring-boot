package dev.glinzac.learnapp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import dev.glinzac.learnapp.entities.Technology;

public class TechnologyService {
	
	@Autowired
	TechnologyRepository technologyRepo;
	
//	get Technology List
	public List<Technology> getTechnologyList(){
		Iterable<Technology> techlist= technologyRepo.findAll();
		List<Technology> list = new ArrayList<Technology>();
		techlist.forEach(tech->list.add(tech));
		return list;
	}
//	add Technology
	public void addTechnology(String skillname) {
		Technology tech = new Technology();
		tech.setSkillName(skillname);
		technologyRepo.save(tech);
	}
	
//	delete Technology
	public void deleteTechnology(String skillname) {
		technologyRepo.deleteById(skillname);
	}
}
