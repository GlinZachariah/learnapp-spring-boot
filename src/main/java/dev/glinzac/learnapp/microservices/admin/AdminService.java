package dev.glinzac.learnapp.microservices.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.glinzac.learnapp.entities.AdminEntity;
import dev.glinzac.learnapp.models.CredentialsModel;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository admindata;

	public boolean authenticate(String username, String password) {
		AdminEntity data = admindata.findById(username).orElse(null);
		if(data.getAdminPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
}
