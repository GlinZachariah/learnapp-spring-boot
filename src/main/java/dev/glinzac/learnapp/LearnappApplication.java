package dev.glinzac.learnapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import dev.glinzac.learnapp.microservices.user.UserService;

@SpringBootApplication
public class LearnappApplication {

	
	@Bean
	public UserService getUserService() {
		return new UserService();
	}
	

	public static void main(String[] args) {
		SpringApplication.run(LearnappApplication.class, args);
	}

}
