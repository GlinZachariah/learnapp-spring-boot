package dev.glinzac.learnapp.microservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.glinzac.learnapp.entities.UserDetails;
import dev.glinzac.learnapp.models.CardDetailsModel;
import dev.glinzac.learnapp.models.CredentialsModel;
import dev.glinzac.learnapp.models.UserDetailsModel;

@RestController
@RequestMapping("/users/")
public class UserController {
	
	
	@Autowired
	UserService userService;
		
//get users count
	@RequestMapping(value="getUserCount",method = RequestMethod.GET)
	public int getUserCount() {
		return userService.getUserCount();
	}

//perform authentication
	@RequestMapping(value="performAuth",method = RequestMethod.POST)
	public UserDetailsModel performAuth(@RequestBody CredentialsModel loginData) {
		return userService.authenticate(loginData);
	}
	
//	saveCardDetails | UpdateCardDetails
	@RequestMapping(value="updateCardDetails",method= RequestMethod.PUT)
	public void updateCardDetails(@RequestBody CardDetailsModel cardDetails , @RequestBody String Username) {
		userService.updateCard(cardDetails,Username);
	}
//	public 
//	getCardDetails
 

	
	
	
}
