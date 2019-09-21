package dev.glinzac.learnapp.microservices.user;

import org.springframework.data.repository.CrudRepository;

import dev.glinzac.learnapp.entities.UserCompleted;

public interface UserCompletedRepository extends CrudRepository<UserCompleted, Integer> {

}
