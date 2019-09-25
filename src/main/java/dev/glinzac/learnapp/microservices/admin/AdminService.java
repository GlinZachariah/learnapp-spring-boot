package dev.glinzac.learnapp.microservices.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.glinzac.learnapp.entities.AdminEntity;
import dev.glinzac.learnapp.entities.CourseDetails;
import dev.glinzac.learnapp.entities.PaymentLog;
import dev.glinzac.learnapp.entities.UserDetails;
import dev.glinzac.learnapp.microservices.mentor.CourseDetailsRepository;
import dev.glinzac.learnapp.microservices.user.UserDetailsRepository;
import dev.glinzac.learnapp.models.CommissionModel;
import dev.glinzac.learnapp.models.PaymentModel;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository admindata;
	
	@Autowired
	CourseDetailsRepository coursedata;
	
	@Autowired
	PaymentLogRepository paymentdata;
	
	@Autowired
	UserDetailsRepository userdata;

	public boolean authenticate(String username, String password) {
		AdminEntity data = admindata.findById(username).orElse(null);
		if(data.getAdminPassword().equals(password)) {
			return true;
		}
		return false;
	}

	public List<CommissionModel> getCommissionList() {
		Iterable<CourseDetails> courseIterable = coursedata.findAll();
		List<CommissionModel> result =new ArrayList<CommissionModel>();
		courseIterable.forEach(item->{
			CommissionModel resultItem= new CommissionModel();
			resultItem.setCommission(item.getCommission());
			resultItem.setCourseCharge(item.getCharges());
			resultItem.setCourseId(item.getCourseId());
			resultItem.setMentorId(item.getMentorDetails().getMentorId());
			resultItem.setTrainerName(item.getMentorDetails().getUserDetails().getFullName());
			result.add(resultItem);
		});
		return result;
	}

	public void updateCommission(String courseId, double newComm) {
		CourseDetails course= coursedata.findById(courseId).get();
		course.setCommission(newComm);
		coursedata.save(course);
	}

	public List<PaymentModel> getPayments() {
		List<PaymentLog> payments= paymentdata.getPayments();
		List<PaymentModel> result = new ArrayList<PaymentModel>();
		payments.forEach(payment->{
			PaymentModel item = new PaymentModel();
			item.setCommissionAmount(payment.getPaymentAmount()-payment.getCourseDetails().getCharges());
			item.setCourseId(payment.getCourseDetails().getCourseId());
			item.setPaymentAmount(payment.getPaymentAmount());
			item.setTrainerName(payment.getMentorDetails().getUserDetails().getFullName());
			item.setUserName(payment.getUserDetails().getUserName());
			result.add(item);
		});
		return result;
	}

	public List<UserDetails> getUsers() {
		return userdata.getUsers();
	}

	public void updateUser(String username) {
		UserDetails user = userdata.findById(username).get();
		String status = user.getAccountStatus();
		if(status.equals("locked")) {
			user.setAccountStatus("unlocked");
		}else {
			user.setAccountStatus("locked");
		}
		userdata.save(user);
	}

	public List<PaymentModel> getMentorCourse(int mentorId) {
		List<PaymentModel> result = new ArrayList<PaymentModel>();
		List<PaymentLog> items = paymentdata.getMentorCourse(mentorId);
		items.forEach(item->{
			PaymentModel resultItem = new PaymentModel();
			resultItem.setCommissionAmount(item.getCommission());
			resultItem.setCourseId(item.getCourseDetails().getCourseId());
			resultItem.setPaymentAmount(item.getPaymentAmount());
			resultItem.setTrainerName(item.getMentorDetails().getUserDetails().getFullName());
			resultItem.setUserName(item.getUserDetails().getUserName());
			result.add(resultItem);
		});
		return result;
	}
	
}
