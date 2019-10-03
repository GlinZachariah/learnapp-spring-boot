package dev.glinzac.learnapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import dev.glinzac.learnapp.entities.AdminEntity;
import dev.glinzac.learnapp.microservices.admin.AdminRepository;
import dev.glinzac.learnapp.microservices.admin.AdminService;
import dev.glinzac.learnapp.microservices.mentor.MentorService;
import dev.glinzac.learnapp.microservices.user.UserService;
import dev.glinzac.learnapp.models.CredentialsModel;

@SpringBootApplication
public class LearnappApplication {

	
	@Bean
	public UserService getUserService() {
		return new UserService();
	}
	
	@Bean
	public AdminService getAdminService() {
		return new AdminService();
	}
	
	@Bean
	public MentorService getMentorService() {
		return new MentorService();
	}
	
	@Bean 
	public TechnologyService getTechnologyService() {
		return new TechnologyService();
	}
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(LearnappApplication.class, args);
	}
	
}
