package dev.glinzac.learnapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.glinzac.learnapp.entities.Technology;

@Repository
public interface TechnologyRepository extends CrudRepository<Technology, String> {

}
