package dev.glinzac.learnapp.microservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.glinzac.learnapp.entities.UserDetails;
import dev.glinzac.learnapp.models.CredentialsModel;
import dev.glinzac.learnapp.models.UserDetailsModel;

@RestController
@RequestMapping("/users/")
public class UserController {
	
	@Autowired
	UserDetailsRepository userDetails;
	
	@RequestMapping(value="getUserCount",method = RequestMethod.GET)
	public int getUserCount() {
		return (int) userDetails.count();
	}
	
	@RequestMapping(value="performAuth",method = RequestMethod.POST)
	public ResponseEntity<UserDetailsModel> performAuth(@RequestBody CredentialsModel loginData) {
		UserDetails user = userDetails.findById(loginData.getUsername()).orElse(null);
		if(user !=null) {
			UserDetailsModel userDetailsModel = new UserDetailsModel();
			userDetailsModel.setAuth(true);
			userDetailsModel.setRole(user.getUserRole());
			userDetailsModel.setFullname(user.getFullName());
			return new ResponseEntity<UserDetailsModel>(userDetailsModel,HttpStatus.OK);
		}else if(user == null) {
			UserDetailsModel userDetailsModel = new UserDetailsModel();
			userDetailsModel.setAuth(false);
			userDetailsModel.setRole("");
			userDetailsModel.setFullname("");
			return new ResponseEntity<UserDetailsModel>(userDetailsModel,HttpStatus.OK);
		}
		return new ResponseEntity<UserDetailsModel>(HttpStatus.BAD_REQUEST);
	}
	
	
}
