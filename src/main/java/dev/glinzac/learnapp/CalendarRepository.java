package dev.glinzac.learnapp;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.glinzac.learnapp.entities.CalendarEntity;

@Repository
public interface CalendarRepository extends CrudRepository<CalendarEntity	, Integer> {
	
	@Query(value="select * from calendar_entity where mentor_id = :mentor",nativeQuery = true)
	Optional<List<CalendarEntity>> findMentorCalendar(@Param(value="mentor") int mentor);

	@Query(value="select * from calendar_entity where from_date = :fromDate && till_date = :tillDate && time_slot = :timeSlot && mentor_id = :mentor",nativeQuery = true)
	Optional<CalendarEntity> getMentorCalendar(@Param(value="fromDate") Date fromDate,@Param(value="tillDate") Date tillDate,@Param(value="timeSlot") int timeSlot,@Param(value="mentor") int mentor);

}
