package dev.glinzac.learnapp.microservices.admin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.glinzac.learnapp.entities.AdminEntity;

@Repository
public interface AdminRepository extends CrudRepository<AdminEntity, String> {
}
