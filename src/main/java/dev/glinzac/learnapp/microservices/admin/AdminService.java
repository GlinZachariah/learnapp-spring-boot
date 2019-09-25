package dev.glinzac.learnapp.microservices.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.glinzac.learnapp.entities.AdminEntity;
import dev.glinzac.learnapp.entities.CourseDetails;
import dev.glinzac.learnapp.entities.PaymentLog;
import dev.glinzac.learnapp.microservices.mentor.CourseDetailsRepository;
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
	
}
