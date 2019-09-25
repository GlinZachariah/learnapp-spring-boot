package dev.glinzac.learnapp.microservices.admin;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dev.glinzac.learnapp.entities.PaymentLog;

public interface PaymentLogRepository extends CrudRepository<PaymentLog, Integer> {

	@Query(value = "select * from payment_log",nativeQuery = true)
	List<PaymentLog> getPayments();
}
