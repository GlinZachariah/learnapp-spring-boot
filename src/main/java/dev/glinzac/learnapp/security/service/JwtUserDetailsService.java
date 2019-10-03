package dev.glinzac.learnapp.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.glinzac.learnapp.microservices.user.UserDetailsRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UserDetailsRepository userRepo; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		dev.glinzac.learnapp.entities.UserDetails user = userRepo.findById(username).orElse(null);

		List<GrantedAuthority> allowedUsers= new ArrayList<>();
		allowedUsers.add(new SimpleGrantedAuthority("ROLE_"+user.getUserRole().toUpperCase()));
		return new User(user.getUserName(),user.getUserPassword(),allowedUsers);
	}
}
