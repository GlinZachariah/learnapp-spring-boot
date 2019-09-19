package dev.glinzac.learnapp.microservices.user;

import org.springframework.data.repository.CrudRepository;

import dev.glinzac.learnapp.entities.CardDetails;

public interface CardDetailsRepository extends CrudRepository<CardDetails, Integer> {

}
