package dev.glinzac.learnapp.microservices.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.glinzac.learnapp.TechnologyService;
import dev.glinzac.learnapp.entities.Technology;
import dev.glinzac.learnapp.models.CardDetailsModel;
import dev.glinzac.learnapp.models.CredentialsModel;
import dev.glinzac.learnapp.models.UserCompletedTrainingModel;
import dev.glinzac.learnapp.models.UserDetailsModel;
import dev.glinzac.learnapp.models.UserProgressTrainingModel;

@RestController
@RequestMapping("/users/")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	TechnologyService technologyService;
		
//get users count
	@RequestMapping(value="/getUserCount",method = RequestMethod.GET)
	public int getUserCount() {
		return userService.getUserCount();
	}

//perform authentication
	@RequestMapping(value="/performAuth",method = RequestMethod.POST)
	public UserDetailsModel performAuth(@RequestBody CredentialsModel loginData) {
		return userService.authenticate(loginData);
	}
	
//	saveCardDetails | UpdateCardDetails
	@RequestMapping(value="/updateCardDetails",method= RequestMethod.PUT)
	public void updateCardDetails(@RequestBody CardDetailsModel cardDetails) {
		userService.updateCard(cardDetails);
	}

//	getCardDetails
	@RequestMapping(value = "/getCardDetails/{username}",method = RequestMethod.GET)
	public CardDetailsModel getCardDetails(@PathVariable String username) {
		return userService.getCardDetails(username);
	}
	
//	getCompletedTrainingDetails
	@RequestMapping(value = "/getCompletedTrainingDetails/{username}",method = RequestMethod.GET)
	public List<UserCompletedTrainingModel> getCompletedTraining(@PathVariable String username){
		return userService.getTrainingCompleted(username);
	}
	
//	addToCompleted
	@RequestMapping(value = "/addCompletedTrainingDetails",method = RequestMethod.POST)
	public void addToCompleted(@RequestBody UserCompletedTrainingModel userData) {
		userService.addToCompleted(userData);
	}
	
//	getListofTechnologies
	@RequestMapping(value="/getTechnologies",method = RequestMethod.GET)
	public List<Technology> getTechnologies(){
		return technologyService.getTechnologyList();
	}
	
//	getProgressTrainingDetails
	@RequestMapping(value="/getProgressTraining/{username}",method = RequestMethod.GET)
	public List<UserProgressTrainingModel> getProgressTraining(@PathVariable String username) {
		return userService.getCurrentTraining(username);
	}
	
//	addProgressTrainingDetails | updateProgressTrainingDetails
//	signInUser
	
}
