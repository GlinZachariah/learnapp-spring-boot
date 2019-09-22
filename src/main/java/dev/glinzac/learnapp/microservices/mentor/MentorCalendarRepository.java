package dev.glinzac.learnapp.microservices.mentor;

import org.springframework.data.repository.CrudRepository;

import dev.glinzac.learnapp.entities.CalendarEntity;

public interface MentorCalendarRepository extends CrudRepository<CalendarEntity, Integer> {

}
