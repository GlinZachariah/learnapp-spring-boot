package dev.glinzac.learnapp.microservices.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.glinzac.learnapp.entities.CardDetails;
import dev.glinzac.learnapp.entities.UserCompleted;
import dev.glinzac.learnapp.entities.UserDetails;
import dev.glinzac.learnapp.entities.UserProgress;
import dev.glinzac.learnapp.microservices.mentor.CourseDetailsRepository;
import dev.glinzac.learnapp.models.CardDetailsModel;
import dev.glinzac.learnapp.models.CredentialsModel;
import dev.glinzac.learnapp.models.UserCompletedTrainingModel;
import dev.glinzac.learnapp.models.UserDetailsModel;
import dev.glinzac.learnapp.models.UserProgressTrainingModel;

@Service
public class UserService {
	@Autowired
	UserDetailsRepository userDetails;
	@Autowired
	CardDetailsRepository cardDetails;
	@Autowired
	CourseDetailsRepository courseDetails;
	@Autowired
	UserCompletedRepository userCompletedDetails;
	@Autowired
	UserTrainingRepository userTrainingDetails;
	
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
		Iterable<UserCompleted> userIterable= userCompletedDetails.findAll(); 
		List<UserCompletedTrainingModel> userCompletedData = new ArrayList<UserCompletedTrainingModel>();
		userIterable.forEach(user->{
			UserCompletedTrainingModel newData = new UserCompletedTrainingModel();
			newData.setCourseId(user.getCourseDetails().getCourseId());
			newData.setUserName(user.getUserDetails().getUserName());
			newData.setTimeSlot(user.getTimeslot());
			newData.setStartDate(user.getStartDate());
			newData.setEndDate(user.getEndDate());
			newData.setRating(user.getRating());
			userCompletedData.add(newData);
		});
		
		return userCompletedData;
	}

	public void addToCompleted(UserCompletedTrainingModel userData) {
		UserCompleted user = new UserCompleted();
		user.setUserDetails(userDetails.findById(userData.getUserName()).get());
		user.setCourseDetails(courseDetails.findById(userData.getCourseId()).get());
		user.setEndDate(userData.getEndDate());
		user.setRating(userData.getRating());
		user.setStartDate(userData.getStartDate());
		user.setTimeslot(userData.getTimeSlot());
		userCompletedDetails.save(user);
	}

	public List<UserProgressTrainingModel> getCurrentTraining(String username) {
		List<UserProgress> data = userTrainingDetails.findTrainingInProgress(username);
		List<UserProgressTrainingModel> currentData = new ArrayList<UserProgressTrainingModel>();
		data.forEach(user->{
			UserProgressTrainingModel newUser = new UserProgressTrainingModel();
			newUser.setCourseId(user.getCourseDetails().getCourseId());
			newUser.setCourseStatus(user.getCourseStatus());
			newUser.setPaymentStatus(user.getPaymentStatus());
			newUser.setProgress(user.getProgress());
			newUser.setRating(user.getRating());
			newUser.setStartDate(user.getStartDate());
			newUser.setTimeSlot(user.getTimeslot());
			newUser.setUserName(user.getUserDetails().getUserName());
			currentData.add(newUser);
		});
		return currentData; 
	}

	public void updateProgressTraining(UserProgressTrainingModel data) {
		int count = userTrainingDetails.findProgressCourse(data.getUserName(),data.getCourseId()).orElse(0);
		UserProgress newData;
		if( count != 0) {
			newData = userTrainingDetails.findCourse(data.getUserName(), data.getCourseId()).get();
		}else {
			newData = new UserProgress(); 
		}
			newData.setCourseDetails(courseDetails.findById(data.getCourseId()).get());
			newData.setCourseStatus(data.getCourseStatus());
			newData.setPaymentStatus(data.getPaymentStatus());
			newData.setProgress(data.getProgress());
			newData.setRating(data.getRating());
			newData.setStartDate(data.getStartDate());
			newData.setTimeslot(data.getTimeSlot());
			newData.setUserDetails(userDetails.findById(data.getUserName()).get());
			userTrainingDetails.save(newData);
	}

	public void addUser(UserDetails user) {
		userDetails.save(user);
	}

	
	
}
