package dev.glinzac.learnapp.microservices.user;

import org.springframework.data.repository.CrudRepository;

import dev.glinzac.learnapp.entities.UserDetails;

public interface UserDetailsRepository extends CrudRepository<UserDetails, String> {

}
