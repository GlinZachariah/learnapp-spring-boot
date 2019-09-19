package dev.glinzac.learnapp.microservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.glinzac.learnapp.entities.CardDetails;
import dev.glinzac.learnapp.entities.UserDetails;
import dev.glinzac.learnapp.models.CardDetailsModel;
import dev.glinzac.learnapp.models.CredentialsModel;
import dev.glinzac.learnapp.models.UserDetailsModel;

@Service
public class UserService {
	@Autowired
	UserDetailsRepository userDetails;
	@Autowired
	CardDetailsRepository cardDetails;
	
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
	
	public UserDetails getUserDetails(String id) {
		return userDetails.findById(id).get();
	}

	public void updateCard(CardDetailsModel cardDetail) {
		CardDetails card = cardDetails.findCourseByUsername("glinzac@gmail.com").orElse(null);
		card.setCardNo(cardDetail.getCardNo());
		card.setMM(cardDetail.getMM());
		card.setYY(cardDetail.getYY());
		card.setCV(cardDetail.getCV());
//		card.setUserDetails(userDetails.findById("glinzac@gmail.com").get());
		System.out.println("card Details : "+cardDetail.getCardNo()+" <=>"+card.getCardNo());
		cardDetails.save(card);
	}
	
}
