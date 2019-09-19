package dev.glinzac.learnapp;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import dev.glinzac.learnapp.microservices.user.UserService;

@SpringBootApplication
public class LearnappApplication   implements CommandLineRunner {
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Bean
	public UserService getUserService() {
		return new UserService();
	}

	public static void main(String[] args) {
		SpringApplication.run(LearnappApplication.class, args);
	}
	
	
	void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("glinzac@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }
	
	@Override
    public void run(String... args) throws IOException {

        System.out.println("Sending Email...");
//        sendEmail();
        System.out.println("Done");

    }
}
