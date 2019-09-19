package dev.glinzac.learnapp.microservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.glinzac.learnapp.entities.UserDetails;
import dev.glinzac.learnapp.models.CardDetailsModel;
import dev.glinzac.learnapp.models.CredentialsModel;
import dev.glinzac.learnapp.models.UserDetailsModel;




@Service
public class UserService {
	@Autowired
	UserDetailsRepository userDetails;
	
	public UserDetailsModel authenticate(CredentialsModel loginData){
		UserDetailsModel userDetailsModel = new UserDetailsModel();
		UserDetails user = userDetails.findById(loginData.getUsername()).orElse(null);
		if(user !=null) {
			
			userDetailsModel.setAuth(true);
			userDetailsModel.setRole(user.getUserRole());
			userDetailsModel.setFullname(user.getFullName());
			return userDetailsModel;
		}else {
			userDetailsModel.setAuth(false);
			userDetailsModel.setRole("");
			userDetailsModel.setFullname("");
			return userDetailsModel;
		}
	}

	public int getUserCount() {
		return (int) userDetails.count();
	}

	public void updateCard(CardDetailsModel cardDetails,String username) {
//		userDetails.findById(id);
		
	}
}
