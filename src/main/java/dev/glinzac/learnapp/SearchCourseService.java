package dev.glinzac.learnapp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.glinzac.learnapp.entities.CalendarEntity;
import dev.glinzac.learnapp.entities.CourseDetails;
import dev.glinzac.learnapp.microservices.mentor.CourseDetailsRepository;
import dev.glinzac.learnapp.models.SearchCourseRequestModel;
import dev.glinzac.learnapp.models.SearchCourseResponseModel;

@Service
public class SearchCourseService {
	
	@Autowired
	CourseDetailsRepository courseRepo;
	
	@Autowired
	CalendarRepository calendarRepo;

	public List<SearchCourseResponseModel> findAllCourses(SearchCourseRequestModel requestData) {
		Iterable<CourseDetails> courses = courseRepo.findTrainingInProgress(requestData.getTechnology());
		List<SearchCourseResponseModel> result = new ArrayList<SearchCourseResponseModel>();
		courses.forEach(course->{
			SearchCourseResponseModel newData = new SearchCourseResponseModel();
			List<CalendarEntity> calendarData = calendarRepo.findMentorCalendar(course.getMentorDetails().getMentorId()).orElse(null);
			if(calendarData != null) {
				calendarData.forEach(data->{
					boolean beforeDate = requestData.getStartDate().after(data.getFromDate());
					boolean afterDate = requestData.getStartDate().before(data.getTillDate());
					boolean timeslotAvailable = (requestData.getTimeSlot() == data.getTimeSlot());
							
					if(beforeDate && afterDate && timeslotAvailable) {
						SearchCourseResponseModel newDataItem = new SearchCourseResponseModel();
						newDataItem.setCourseId(course.getCourseId());
						newDataItem.setCourseName(course.getCourseName());
						newDataItem.setExperience(course.getMentorDetails().getExperience());
						newDataItem.setMaterialBlog(course.getMentorDetails().isCourseTypeBlog());
						newDataItem.setMaterialVideo(course.getMentorDetails().isCourseTypeVideo());
						newDataItem.setMaterialPPT(course.getMentorDetails().isCourseTypePPT());
						newDataItem.setMaterialDemo(course.getMentorDetails().isCourseTypeDemo());
//						calculate service charge correctly
						newDataItem.setServiceCharges(course.getCommission()*100);
						newDataItem.setTrainingCharges(course.getCharges());
						newDataItem.setTechnology(requestData.getTechnology());
						newDataItem.setTotalTime(course.getTotalTime());
						newDataItem.setTrainerName(course.getMentorDetails().getUserDetails().getFullName());
						result.add(newDataItem);
					}
				});
			}
		});
		return result;
	}
	
	
	
}
