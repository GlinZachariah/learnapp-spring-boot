package dev.glinzac.learnapp.microservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.glinzac.learnapp.entities.CardDetails;
import dev.glinzac.learnapp.entities.UserDetails;
import dev.glinzac.learnapp.models.CardDetailsModel;
import dev.glinzac.learnapp.models.CredentialsModel;
import dev.glinzac.learnapp.models.UserCompletedTrainingModel;
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
		String username =cardDetail.getUsername();
		int count = cardDetails.checkCardDetails(username);
		if (count == 1) {
			int id = cardDetails.findCardId(username).get();
			CardDetails card  = cardDetails.findById(id).orElse(null);
			card.setCardNo(cardDetail.getCardNo());
			card.setMM(cardDetail.getmM());
			card.setYY(cardDetail.getyY());
			card.setCV(cardDetail.getcV());
			cardDetails.save(card);
		}else {
			CardDetails card = new CardDetails();
			card.setCardNo(cardDetail.getCardNo());
			card.setMM(cardDetail.getmM());
			card.setYY(cardDetail.getyY());
			card.setCV(cardDetail.getcV());
			card.setUserDetails(userDetails.findById(username).get());
			cardDetails.save(card);
		}
	}

	public CardDetailsModel getCardDetails(String username) {
		int id = cardDetails.findCardId(username).orElse(0);
		CardDetailsModel card = new CardDetailsModel();
		if(id != 0) {
			CardDetails cardData = cardDetails.findById(id).get();
			if(cardData != null) {
				card.setCardNo(cardData.getCardNo());
				card.setmM(cardData.getMM());
				card.setyY(cardData.getYY());
				card.setcV(cardData.getCV());
				card.setUsername(cardData.getUserDetails().getUserName());
				return card;
			}
		}
		card.setCardNo("");
		card.setUsername("");
		card.setcV(0);
		card.setmM(0);
		card.setyY(0);
		return card;
	}

	public List<UserCompletedTrainingModel> getTrainingCompleted(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
