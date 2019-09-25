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
import dev.glinzac.learnapp.entities.UserDetails;
import dev.glinzac.learnapp.models.CommissionModel;
import dev.glinzac.learnapp.models.CredentialsModel;
import dev.glinzac.learnapp.models.PaymentModel;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;

	@Autowired
	TechnologyService technologyService;
	
//	Authenticate
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authenticate(@RequestBody CredentialsModel loginData) {
		
		boolean auth = adminService.authenticate(loginData.getUsername(),loginData.getPassword());
		if(auth) {
			return "Success !!";
		}
		return "Failed";
	}
	
//	getTechnologyList
	@RequestMapping(value="/getTechnologies",method = RequestMethod.GET)
	public List<Technology> getTechnologies(){
		return technologyService.getTechnologyList();
	}
	
//	addTechnology
	@RequestMapping(value="/addTechology/{technology}",method = RequestMethod.GET)
	public void addTech(@PathVariable(name = "technology") String technology){
		technologyService.addTechnology(technology);;
	}
	
//	deleteTechnology
	@RequestMapping(value="/deleteTechology/{technology}",method = RequestMethod.GET)
	public void deleteTech(@PathVariable(name = "technology") String technology){
		technologyService.deleteTechnology(technology);;
	}
	
//	getCommissionList
	@RequestMapping(value="/getCommissionList",method = RequestMethod.GET)
	public List<CommissionModel> getCommissionList(){
		return adminService.getCommissionList();
	}
	
//	updateCommission
	@RequestMapping(value="/updateCommission/{courseid}/{newcomm}",method = RequestMethod.GET)
	public void updateCommission(@PathVariable(name = "courseid") String courseId , @PathVariable(name = "newcomm") String newComm){
		 adminService.updateCommission(courseId,Double.parseDouble(newComm));
	}
	
//	getPaymentLog
	@RequestMapping(value="/getPaymentLog",method = RequestMethod.GET)
	public List<PaymentModel> getPaymentLog(){
		 return adminService.getPayments();
	}
	
//	getUsersList
	@RequestMapping(value = "/getUsers",method = RequestMethod.GET)
	public List<UserDetails> getUserDetails(){
		return adminService.getUsers();
	}
//	blockUsers | unblockUsers
	@RequestMapping(value = "/updateUser/{username}",method = RequestMethod.GET)
	public void updateUserDetails(@PathVariable(name = "username") String username){
		adminService.updateUser(username);
	}
//	generateReport
	@RequestMapping(value = "/getReport/{mentorId}",method = RequestMethod.GET)
	public List<PaymentModel> getMentorCourses(@PathVariable(name = "mentorId") String mentorId){
		return adminService.getMentorCourse(Integer.parseInt(mentorId));
	}
	
}
