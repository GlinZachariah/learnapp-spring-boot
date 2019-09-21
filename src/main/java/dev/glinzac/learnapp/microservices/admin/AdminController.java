package dev.glinzac.learnapp.microservices.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.glinzac.learnapp.TechnologyService;
import dev.glinzac.learnapp.entities.Technology;
import dev.glinzac.learnapp.models.CredentialsModel;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;

	@Autowired
	TechnologyService technologyService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authenticate(@RequestBody CredentialsModel loginData) {
		
		boolean auth = adminService.authenticate(loginData.getUsername(),loginData.getPassword());
		if(auth) {
			return "Success !!";
		}
		return "Failed";
	}
	
	@RequestMapping(value="/getTechnologies",method = RequestMethod.GET)
	public List<Technology> getTechnologies(){
		return technologyService.getTechnologyList();
	}
	
	@RequestMapping(value="/addTechology/{technology}",method = RequestMethod.GET)
	public void addTech(@PathVariable(name = "technology") String technology){
		technologyService.addTechnology(technology);;
	}
	
	@RequestMapping(value="/deleteTechology/{technology}",method = RequestMethod.GET)
	public void deleteTech(@PathVariable(name = "technology") String technology){
		technologyService.deleteTechnology(technology);;
	}
}
