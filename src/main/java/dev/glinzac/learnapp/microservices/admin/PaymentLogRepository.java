package dev.glinzac.learnapp.microservices.admin;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dev.glinzac.learnapp.entities.PaymentLog;

public interface PaymentLogRepository extends CrudRepository<PaymentLog, Integer> {

	@Query(value = "select * from payment_log",nativeQuery = true)
	List<PaymentLog> getPayments();
	
	@Query(value = "select * from payment_log where mentor_id = :mentorId",nativeQuery = true)
	List<PaymentLog> getMentorCourse(@Param(value="mentorId") int mentorId);
}
